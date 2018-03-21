package src.modele;

import java.util.Random;
import java.util.LinkedList;

import src.modele.terrain.Eau;
import src.modele.terrain.Port;
import src.modele.terrain.Foret;
import src.modele.general.Ninja;
import src.modele.terrain.Usine;
import src.modele.terrain.Plaine;
import src.modele.general.General;
import src.modele.general.Nosaure;
import src.modele.terrain.Aeroport;
import src.modele.terrain.Montagne;
import src.modele.terrain.TrouNoir;
import src.modele.general.MadZombie;
import src.modele.general.MagicalGirl;
import src.modele.terrain.AbstractVille;


public class Plateau {
  private Joueur[] joueurs;
  private int largeur, hauteur;
  private AbstractUnite[][] unites;
  private AbstractTerrain[][] terrain;
  private LinkedList<AbstractVille> villes;

  /*
  1 --> Plaine
  3 --> MontagneUsine
  2 --> Eau
  0 --> Foret


  Route, Colline, Pont, etc.
  */

  /*public Plateau (int[][] carte, General[] generaux) {
    largeur = carte[0].length;
    hauteur = carte.length;
    terrain = new AbstractTerrain[hauteur][largeur];

    villes = new LinkedList<AbstractVille>();
    unites = new AbstractUnite[hauteur][largeur];
    joueurs = new Joueur[generaux.length];
    initJoueurs(generaux);

    for (int i=0; i<carte.length; i++)
    for (int j=0; j<carte[1].length; j++)
    //terrain[i][j] = new Terrain(carte[i][j]);
    switch (carte[i][j]) {
      case 0 : terrain[i][j] = new Foret(); break;
      case 1 : terrain[i][j] = new Plaine(); break;
      case 2 : terrain[i][j] = new Eau(); break;
      case 3 : terrain[i][j] = new Montagne(); break;
      case 4 : terrain[i][j] = new TrouNoir(); break;
      case 5 :
      Usine usine = new Usine(j, i);
      terrain[i][j] = usine;
      villes.add(usine);
      break;
      case 6 :
      Port port = new Port(j, i);
      terrain[i][j] = port;
      villes.add(port);
      break;
      case 7 :
      Aeroport aeroport = new Aeroport(j, i);
      terrain[i][j] = aeroport;
      villes.add(aeroport);
      break;
    }
  }*/ // constructeur obsolete

  public Plateau(int[][][] carte, int[][][] armees, General[] generaux, Joueur[] jou){
    hauteur = carte.length;
    largeur = carte[0].length;
    terrain = new AbstractTerrain[hauteur][largeur];
    villes = new LinkedList<AbstractVille>();
    unites = new AbstractUnite[hauteur][largeur];
    joueurs = jou;
    initJoueurs(generaux);
    for (int i = 0; i < hauteur; i++) {
      for (int j = 0; j < largeur; j++) {
        switch (carte[i][j][0]) { // creation des terrains
          case 0 : terrain[i][j] = new Foret(); break;
          case 1 : terrain[i][j] = new Plaine(); break;
          case 2 : terrain[i][j] = new Eau(); break;
          case 3 : terrain[i][j] = new Montagne(); break;
          case 4 : terrain[i][j] = new TrouNoir(); break;
          case 5 :
            Usine usine = new Usine(j, i);
            terrain[i][j] = usine;
            villes.add(usine);
            break;
          case 6 :
            Port port = new Port(j, i);
            terrain[i][j] = port;
            villes.add(port);
            break;
          case 7 :
            Aeroport aeroport = new Aeroport(j, i);
            terrain[i][j] = aeroport;
            villes.add(aeroport);
            break;
        }
        // futur emplacement pour le placement initial des armees
      }
    }
  }

  public void reset() {
    for (AbstractVille v : villes)
    v.setAchete(false);
  }

  public void initJoueurs (General[] generaux) {
    for (int i = 0; i < generaux.length; i++) {
      joueurs[i] = generaux[i].getJoueur();
      initUnite(joueurs[i], generaux[i]);
    }
  }

  public void initUnite (Joueur joueur, General general) {
    Random rand = new Random();
    int x = 0;
    while (x < 1) {
      int i = rand.nextInt(hauteur-2);
      int j = rand.nextInt(largeur-2);
      if (unites[i+1][j+1] == null) {
        general.setCase(j+1, i+1);
        addUnite(general, joueur, false);
        System.out.println(i + " " + j);
        x++;
      }
    }
  }

  public void addUnite (AbstractUnite unite, Joueur joueur, boolean b) {
    joueur.add(unite, b);
    int i = unite.getY();
    int j = unite.getX();
    unites[i][j] = unite;
  }

  public int getHauteur() { return hauteur; }
  public int getLargeur() { return largeur; }
  public AbstractUnite[][] getUnites() { return unites; }
  public AbstractTerrain[][] getTerrain() { return terrain; }
  public Joueur[] getJoueurs() { return joueurs; }
  public LinkedList<AbstractVille> getVilles() { return villes; }

  public void rmvUnite (AbstractUnite u) {
    unites[u.getY()][u.getX()] = null;
  }

  public void setUnites (int ancienX, int ancienY, int x, int y) {
    AbstractUnite u = unites[ancienY][ancienX];
    unites[ancienY][ancienX] = null;
    unites[y][x] = u;
  }

  public void debug(){
    for (int i = 0; i < hauteur; i++) {
      for (int j = 0; j < largeur; j++)
        System.out.print(terrain[i][j]);
      System.out.println("");
    }
    for (int i = 0; i < hauteur; i++) {
      for (int j = 0; j < largeur; j++)
        System.out.print(unites[i][j]);
      System.out.println("");
    }
  }

}
