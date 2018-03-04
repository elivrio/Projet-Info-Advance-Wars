package src.modele.general;

import src.modele.AbstractUnite;
import src.modele.Joueur;
import src.modele.interfaces.combat.CombatCouteau;
import src.modele.interfaces.deplacement.DeplaceAPied;
import src.modele.interfaces.typeunite.Terrestre;

public class Nosaure extends General {

  public Nosaure (Joueur j, int x, int y) {
    super("Nosaure", 100, new CombatCouteau(), new DeplaceAPied(), 2, 7, 100, new Terrestre(), j, x, y, 3);
  }

  public void bonusPersonel() {}
}