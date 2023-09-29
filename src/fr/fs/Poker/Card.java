package fr.fs.Poker;

public class Card {
	private String valeur;
	private String couleur;
	private int valeurForce;

	public Card(String valeur, String couleur, int valeurForce) {
		super();
		this.valeur = valeur;
		this.couleur = couleur;
		this.valeurForce = valeurForce;
	}

	@Override
	public String toString() {
		return "[ " + valeur + " de " + couleur +" ]";
	} 

	public String getCouleur() {
		return couleur;
	}

	public String getValeur() {
		return valeur;
	}

	public int getValeurForce() {
		return valeurForce;
	}

	public static String comparerDeuxCartes(Card card1, Card card2) {
		if (card1.getValeurForce() > card2.getValeurForce()) {
			System.out.println();
			return "Carte " + card1.getValeur() + " de " + card1.getCouleur() + " gagnante du joueur 1";
		} else if (card2.getValeurForce() > card1.getValeurForce()) {
			System.out.println();
			return "Carte " + card2.getValeur() + " de " + card2.getCouleur() + " gagnante du joueur 2";
		}
		System.out.println();
		return "Les deux cartes sont à égalité";

	}
}
