package com.faforever.client.preferences;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.jetbrains.annotations.Nullable;

import java.util.Locale;

@FieldDefaults(makeFinal=true, level= AccessLevel.PRIVATE)
public class LocalizationPrefs {
  ObjectProperty<Locale> language = new SimpleObjectProperty<>();
  ObjectProperty<DateInfo> dateFormat = new SimpleObjectProperty<>(DateInfo.AUTO);

  @Nullable
  public Locale getLanguage() {
    return language.get();
  }

  public void setLanguage(Locale language) {
    this.language.set(language);
  }

  public ObjectProperty<Locale> languageProperty() {
    return language;
  }

  public DateInfo getDateFormat() {
    return dateFormat.get();
  }

  public void setDateFormat(DateInfo date) {
    this.dateFormat.set(date);
  }
}
