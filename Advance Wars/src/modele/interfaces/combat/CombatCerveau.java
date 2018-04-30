package src.modele.interfaces.combat;

import src.modele.interfaces.combat.Combat;

public class CombatCerveau implements Combat {

  // ****************************************************
  // *************** Variables d'instance ***************
  // ****************************************************

  // Le nombre de degâts infliges par coup.
  protected int degats = 100;

  // ****************************************************
  // *************** Fonctions d'instance ***************
  // ****************************************************

  /**
   * Description du type de combat.
   * @return Retourne l'arme utilisee.
   */
  public String combat() {
    return "Mange les cerveaux";
  }

  /**
   * Points de degâts infliges.
   * @return Retourne le nombre de points de degâts infliges par coup.
   */
  public int getDegats() {
    return degats;
  }

}