package src.modele;

import src.modele.interfaces.combat.Combat;
import src.modele.interfaces.typeunite.TypeUnite;
import src.modele.interfaces.deplacement.Deplacement;

public abstract class AbstractUnite implements Combat, TypeUnite, Deplacement {
  protected final String nom;
  protected int pvMax, pv;
  protected Combat typeCombat;
  protected Deplacement deplacement;
  protected int deplace, distance, portee, vision, essence, cout;
  protected TypeUnite type;
  protected Joueur joueur;
  protected int x, y, indice;

  public AbstractUnite (String n, int pM, Combat c, Deplacement d, int dis, int por, int vis, int ess, int cout, TypeUnite t, Joueur j, int x, int y, int i) {
    nom = n;
    pvMax = pM;
    pv = pM;
    typeCombat = c;
    deplacement = d;
    distance = dis;
    deplace = 0;
    portee = por;
    vision = vis;
    essence = ess;
    type = t;
    joueur = j;
    this.x = x;
    this.y = y;
    indice = i;
  }

  public Joueur getJoueur() { return joueur; }
  public int getDistance() { return distance; }
  public int getVision() { return vision; }
  public String getNom() { return nom; }
  public int getIndice() { return indice; }
  public int getPV() { return pv; }
  public int getPVMax() { return pvMax; }
  public int getX() { return x; }
  public int getY() { return y; }
  public int getDeplace() { return deplace; }
  public int getPortee() { return portee; }
  public TypeUnite getType() { return type; }
  public Combat getCombat() { return typeCombat; }
  public Deplacement getDeplacement() { return deplacement; }

  public void setCase (int x, int y) {
    this.x = x;
    this.y = y;
  }

  public void resetDeplace() {
    deplace = 0;
  }

  public void setDeplace (int i) {
    deplace += i;
  }

  public String combat(){
    return typeCombat.combat();
  }

  public String deplacement() {
    return deplacement.deplacement();
  }

  public String type() {
    return type.type();
  }

}
