package com.faforever.client.preferences;

import com.faforever.commons.lobby.Faction;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import static javafx.collections.FXCollections.observableArrayList;

@FieldDefaults(makeFinal=true, level= AccessLevel.PRIVATE)
public class MatchmakerPrefs {

  ListProperty<Faction> factions = new SimpleListProperty<>(observableArrayList(Faction.AEON, Faction.CYBRAN, Faction.UEF, Faction.SERAPHIM));

  public ObservableList<Faction> getFactions() {
    return factions.get();
  }

  public ListProperty<Faction> factionsProperty() {
    return factions;
  }

}
