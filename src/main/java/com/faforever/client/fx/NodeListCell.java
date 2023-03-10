package com.faforever.client.fx;

import javafx.scene.Node;
import javafx.scene.control.ListCell;

import java.util.function.Function;

public class NodeListCell<T> extends ListCell<T> {

  private final Function<T, ? extends Node> function;

  public NodeListCell(Function<T, ? extends Node> function, String... cssClasses) {
    this.function = function;
    getStyleClass().addAll(cssClasses);
  }

  @Override
  protected void updateItem(T item, boolean empty) {
    super.updateItem(item, empty);

    JavaFxUtil.assertApplicationThread();

    if (empty || item == null) {
      setText(null);
      setGraphic(null);
    } else {
      setGraphic(function.apply(item));
    }
  }
}
