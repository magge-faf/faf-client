package com.faforever.client.os;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Path;
import java.util.Scanner;

import static com.faforever.client.preferences.PreferencesService.APP_DATA_SUB_FOLDER;

public class OsWindows implements OperatingSystem {
  @Override
  public boolean runsAsAdmin() {
    try {
      ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe");
      Process process = processBuilder.start();
      PrintStream printStream = new PrintStream(process.getOutputStream(), true);
      Scanner scanner = new Scanner(process.getInputStream());
      printStream.println("@echo off");
      printStream.println(">nul 2>&1 \"%SYSTEMROOT%\\system32\\cacls.exe\" \"%SYSTEMROOT%\\system32\\config\\system\"");
      printStream.println("echo %errorlevel%");

      boolean printedErrorlevel = false;
      while (true) {
        if (!scanner.hasNextLine()) {
          return false;
        }
        String nextLine = scanner.nextLine();
        if (printedErrorlevel) {
          int errorlevel = Integer.parseInt(nextLine);
          return errorlevel == 0;
        } else if (nextLine.equals("echo %errorlevel%")) {
          printedErrorlevel = true;
        }
      }
    } catch (IOException e) {
      return false;
    }
  }

  @Override
  public boolean supportsUpdateInstall() {
    return true;
  }

  @Override
  public @NotNull Path getPreferencesDirectory() {
    return Path.of(System.getenv("APPDATA")).resolve(APP_DATA_SUB_FOLDER);
  }

  @Override
  @NotNull
  public Path getUidExecutablePath() {
    String uidDir = System.getProperty("nativeDir", "natives");
    return Path.of(uidDir).resolve("faf-uid.exe");
  }

  @Override
  public @NotNull Path getJavaExecutablePath() {
    return Path.of(System.getProperty("java.home"))
        .resolve("bin")
        .resolve("java.exe");
  }

  @Override
  public @NotNull String getGithubAssetFileEnding() {
    return ".exe";
  }
}
