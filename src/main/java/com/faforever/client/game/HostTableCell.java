package com.faforever.client.game;

import com.faforever.client.domain.GameBean;
import com.faforever.client.player.PlayerService;
import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.image.ImageView;

public class HostTableCell extends TableCell<GameBean, String> {

  private final PlayerService playerService;

  private final ImageView avatarImageView;
  private String currentHost;

  public HostTableCell(PlayerService playerService) {
    this.playerService = playerService;
    this.avatarImageView = createAvatarImageView();

    setContentDisplay(ContentDisplay.LEFT);
    setGraphicTextGap(3.0);
    setAlignment(Pos.BASELINE_CENTER);
  }

  private ImageView createAvatarImageView() {
    ImageView imageView = new ImageView();
    imageView.setFitHeight(14);
    imageView.setPickOnBounds(true);
    imageView.setPreserveRatio(true);
    return imageView;
  }

  @Override
  protected void updateItem(String item, boolean empty) {
    if (item == null || empty) {
      currentHost = null;
      setText(null);
      setGraphic(null);
    } else {
      if (!item.equals(currentHost)) {
        currentHost = item;
        setText(item);
        playerService.getCurrentAvatarByPlayerName(item).ifPresentOrElse(avatar -> {
          avatarImageView.setImage(avatar);
          setGraphic(avatarImageView);
        }, () -> setGraphic(null));
      }
    }
  }
}
