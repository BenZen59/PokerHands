package fr.fs.Poker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Jeu {
	private String[] couleur = { "Coeur", "Carreau", "Trèfle", "Pique" };
	private String[] valeur = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "As" };
	private ArrayList<Card> coeurs = new ArrayList<>();
	private ArrayList<Card> carreaux = new ArrayList<>();
	private ArrayList<Card> trefles = new ArrayList<>();
	private ArrayList<Card> piques = new ArrayList<>();
	private ArrayList<Card> jeu52Cartes = new ArrayList<>();
	private ArrayList<Card> mainJoueur1 = new ArrayList<>();
	private ArrayList<Card> mainJoueur2 = new ArrayList<>();
	private ArrayList<Card> mainJoueur3 = new ArrayList<>();
	private ArrayList<Card> mainJoueur4 = new ArrayList<>();
	private int scoreJoueur1 = 0;
	private int scoreJoueur2 = 0;
	private int scoreJoueur3 = 0;
	private int scoreJoueur4 = 0;
	private int longueurCouleur = 13;

	public Jeu() {

	}

	public void creeJeu() {
		for (int i = 0; i < longueurCouleur; i++) {
			coeurs.add(new Card(valeur[i], couleur[0], i));
		}
		for (int i = 0; i < longueurCouleur; i++) {
			carreaux.add(new Card(valeur[i], couleur[1], i));
		}

		for (int i = 0; i < longueurCouleur; i++) {
			trefles.add(new Card(valeur[i], couleur[2], i));
		}

		for (int i = 0; i < longueurCouleur; i++) {
			piques.add(new Card(valeur[i], couleur[3], i));
		}
		distribuerJeu();
	}

	public void distribuerJeu() {
		jeu52Cartes.addAll(coeurs);
		jeu52Cartes.addAll(carreaux);
		jeu52Cartes.addAll(trefles);
		jeu52Cartes.addAll(piques);
		Collections.shuffle(jeu52Cartes);
		MainJoueur Joueur1 = new MainJoueur(mainJoueur1);
		for (int i = 0; i < 5; i++) {
			Joueur1.getMain().add(i, jeu52Cartes.get(0));
			jeu52Cartes.remove(0);
		}
		scoreJoueur1 = MainJoueur.comparerMain(Joueur1);

		MainJoueur Joueur2 = new MainJoueur(mainJoueur2);
		for (int i = 0; i < 5; i++) {
			Joueur2.getMain().add(i, jeu52Cartes.get(0));
			jeu52Cartes.remove(0);

		}
		scoreJoueur2 = MainJoueur.comparerMain(Joueur2);

		MainJoueur Joueur3 = new MainJoueur(mainJoueur3);
		for (int i = 0; i < 5; i++) {
			Joueur3.getMain().add(i, jeu52Cartes.get(0));
			jeu52Cartes.remove(0);
		}
		scoreJoueur3 = MainJoueur.comparerMain(Joueur3);

		MainJoueur Joueur4 = new MainJoueur(mainJoueur4);
		for (int i = 0; i < 5; i++) {
			Joueur4.getMain().add(i, jeu52Cartes.get(0));
			jeu52Cartes.remove(0);
		}
		scoreJoueur4 = MainJoueur.comparerMain(Joueur4);

		System.out.printf("%d - %d - %d - %d", scoreJoueur1, scoreJoueur2, scoreJoueur3, scoreJoueur4);
		System.out.println();
		System.out.println("Le joueur gagnant est le joueur " + compareScore(scoreJoueur1, scoreJoueur2, scoreJoueur3, scoreJoueur4));
		
	}

	public String compareScore(int scoreJoueur1, int scoreJoueur2, int scoreJoueur3, int scoreJoueur4) {
		if(scoreJoueur1 > scoreJoueur2 && scoreJoueur1 > scoreJoueur3 && scoreJoueur1 > scoreJoueur4) {
			return "1 avec le score : " + scoreJoueur1;
		}else if(scoreJoueur2 > scoreJoueur1 && scoreJoueur2 > scoreJoueur3 && scoreJoueur2 > scoreJoueur4) {
			return "2 avec le score : " + scoreJoueur2;
		}else if(scoreJoueur3 > scoreJoueur1 && scoreJoueur3 > scoreJoueur2 && scoreJoueur3 > scoreJoueur4) {
			return "3 avec le score : " + scoreJoueur3;
		}
		else if(scoreJoueur4 > scoreJoueur1 && scoreJoueur4 > scoreJoueur2 && scoreJoueur4 > scoreJoueur3) {
			return "4 avec le score : " + scoreJoueur4;
		}
		return "Il y a égalité !";
	}

}
