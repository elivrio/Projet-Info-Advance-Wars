package src.modele.chairacanon.terrestre;

import src.modele.Joueur;
import src.modele.AbstractUnite;
import src.modele.interfaces.typeunite.Terrestre;
import src.modele.interfaces.deplacement.DeplaceAChenilles;

public class VTB extends AbstractUnite {

  // ********************************************
  // *************** Constructeur ***************
  // ********************************************

  /**
   * @param j Le joueur auquel appartient l'unite.
   * @param x La position de l'unite en abscisse.
   * @param y La position de l'unite en ordonnee.
   */
  public VTB (Joueur j, int x, int y) {
    super("VTB", 99, null, new DeplaceAChenilles(), 6, 0, 1, 70, 5000, new Terrestre(), j, x, y, 11);
  }
}
