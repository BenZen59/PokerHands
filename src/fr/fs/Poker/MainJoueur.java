package fr.fs.Poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MainJoueur {
	private static List<Card> main = new ArrayList<>();
	private static char quinteFlushRoyale;
	private static char quinteFlush;
	private static char carre;
	private static char couleur;
	private static char brelan;
	private static char doublePaire;
	private static char paire;
	private static char carteHaute;
	private static int puissanceMain;

	public MainJoueur(List<Card> main) {
		super();
		MainJoueur.main = main;
	}

	public List<Card> getMain() {
		return main;
	}

	public static int comparerMain(MainJoueur mainJoueur) {
		ArrayList<Card> mapMainJoueur = new ArrayList<>();
		HashMap<Integer, Integer> hash = new HashMap<>();
		StringBuilder resultat = new StringBuilder();
		puissanceMain = 0;
		String valeurCarte = "BCDEFGHIJKLMN";
		for (int i = 0; i < 5; i++) {
			mapMainJoueur.add(mainJoueur.getMain().get(i));
		}
		initialiserQuote();
		verificationCombinaison(hash, main, resultat, valeurCarte);
		System.out.println(mapMainJoueur);
		System.out.println("Resultat : " + resultat.toString());
		return puissanceMain;
	}

	public static void initialiserQuote() {
		quinteFlushRoyale = 'A';
		quinteFlush = 'A';
		carre = 'A';
		couleur = 'A';
		brelan = 'A';
		doublePaire = 'A';
		paire = 'A';
		carteHaute = 'A';
	}

	public static void verificationCombinaison(HashMap<Integer, Integer> hash, List<Card> mapMainJoueur,
			StringBuilder resultat, String valeurCarte) {
		hash.put(mapMainJoueur.indexOf(mapMainJoueur.get(0)), mapMainJoueur.get(0).getValeurForce());
		hash.put(mapMainJoueur.indexOf(mapMainJoueur.get(1)), mapMainJoueur.get(1).getValeurForce());
		hash.put(mapMainJoueur.indexOf(mapMainJoueur.get(2)), mapMainJoueur.get(2).getValeurForce());
		hash.put(mapMainJoueur.indexOf(mapMainJoueur.get(3)), mapMainJoueur.get(3).getValeurForce());
		hash.put(mapMainJoueur.indexOf(mapMainJoueur.get(4)), mapMainJoueur.get(4).getValeurForce());
		hasPaire(mapMainJoueur, resultat);
		hasDoublePaire(mapMainJoueur, resultat);
		hasBrelan(mapMainJoueur, resultat);
		hasCouleur(resultat);
		hasCarre(mapMainJoueur, resultat);
		hasQuinte(mapMainJoueur, resultat);
		hasQuinteFlush(resultat);
		hasCarteHaute(resultat);
		for(int i = 0; i < 5; i++) {
			puissanceMain = puissanceMain +  mapMainJoueur.get(i).getValeurForce();
		}
		resultat.append(valeurCarte.charAt((hash.get(0))));
		resultat.append(valeurCarte.charAt((hash.get(1))));
		resultat.append(valeurCarte.charAt((hash.get(2))));
		resultat.append(valeurCarte.charAt((hash.get(3))));
		resultat.append(valeurCarte.charAt((hash.get(4))));

	}

	public static void hasQuinteFlushRoyale(StringBuilder resultat) {
		int countCard = 0;
		for (int i = 0; i < 5; i++) {
			if (detectionCouleur(main)[0] == 5 || detectionCouleur(main)[1] == 5 || detectionCouleur(main)[2] == 5
					|| detectionCouleur(main)[3] == 5 && (detectionValue(main)[8] == 1 && detectionValue(main)[9] == 1
							&& detectionValue(main)[10] == 1 && detectionValue(main)[11] == 1
							&& detectionValue(main)[12] == 1)) {
				countCard++;
			}
		}
		if (countCard == 5) {
			puissanceMain = puissanceMain + 10;
			resultat.append(quinteFlushRoyale);
		}

	}

	public static void hasQuinteFlush(StringBuilder resultat) {
		int countCard = 0;
		for (int i = 0; i < 5; i++) {

			if (detectionCouleur(main)[0] == 5 || detectionCouleur(main)[1] == 5 || detectionCouleur(main)[2] == 5
					|| detectionCouleur(main)[3] == 5) {
				countCard++;
			}
		}
		if (countCard == 5) {
			puissanceMain = puissanceMain + 9;
			hasQuinte(main, resultat);
		}

	}

	public static void hasQuinte(List<Card> mapMainJoueur, StringBuilder resultat) {
		ArrayList<Integer> sortHand = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			sortHand.add(mapMainJoueur.get(i).getValeurForce());
		}
		Collections.sort(sortHand);
		if (sortHand.get(4) - 1 == sortHand.get(3) && sortHand.get(4) - 2 == sortHand.get(2)
				&& sortHand.get(4) - 3 == sortHand.get(1) && sortHand.get(4) - 4 == sortHand.get(0)) {
			puissanceMain = puissanceMain + 5;
			resultat.append(quinteFlush);
		}
	}

	public static void hasCarre(List<Card> mapMainJoueur, StringBuilder resultat) {
		ArrayList<Integer> sortCarre = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			sortCarre.add(mapMainJoueur.get(i).getValeurForce());
		}
		Collections.sort(sortCarre);
		int countCarre = 1;
		for (int i = 1; i < 4; i++) {
			if (sortCarre.get(0).equals(sortCarre.get(i))) {

				countCarre++;

			} else if (countCarre < 4) {
				countCarre = 1;
				for (int j = 2; j < 5; j++) {
					if (sortCarre.get(1).equals(sortCarre.get(j))) {
						countCarre++;
					}

				}
			}

		}
		if (countCarre == 4) {
			puissanceMain = puissanceMain + 8;
			resultat.append(carre);
		}

	}

	public static void hasBrelan(List<Card> mapMainJoueur, StringBuilder resultat) {
		ArrayList<Integer> sortBrelan = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			sortBrelan.add(mapMainJoueur.get(i).getValeurForce());
		}
		Collections.sort(sortBrelan);
		int countBrelan = 1;
		for (int i = 1; i < 3; i++) {
			if (sortBrelan.get(0).equals(sortBrelan.get(i))) {

				countBrelan++;

			} else if (countBrelan < 3) {
				countBrelan = 1;
				for (int j = 2; j < 4; j++) {
					if (sortBrelan.get(1).equals(sortBrelan.get(j))) {
						countBrelan++;
					}

				}
			} else if (countBrelan < 3) {
				countBrelan = 1;
				for (int k = 3; k < 5; k++) {
					if (sortBrelan.get(2).equals(sortBrelan.get(k))) {
						countBrelan++;
					}

				}
			}

		}
		if (countBrelan == 3) {
			puissanceMain = puissanceMain + 4;
			resultat.append(brelan);
		}

	}

	public static void hasCouleur(StringBuilder resultat) {
		int countCard = 0;
		for (int i = 0; i < 5; i++) {
			if (detectionCouleur(main)[0] == 5 || detectionCouleur(main)[1] == 5 || detectionCouleur(main)[2] == 5
					|| detectionCouleur(main)[3] == 5) {
				countCard++;
			}
		}
		if (countCard == 5) {
			puissanceMain = puissanceMain + 6;
			resultat.append(couleur);
		}

	}

	public static void hasPaire(List<Card> mapMainJoueur, StringBuilder resultat) {

		ArrayList<Integer> sortPaire = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			sortPaire.add(mapMainJoueur.get(i).getValeurForce());
		}
		Collections.sort(sortPaire);

		int countPaire = 1;
		for (int i = 1; i < 2; i++) {
			if (sortPaire.get(0).equals(sortPaire.get(i))) {

				countPaire++;

			} else if (countPaire < 2) {
				countPaire = 1;
				for (int j = 2; j < 3; j++) {
					if (sortPaire.get(1).equals(sortPaire.get(j))) {
						countPaire++;
					}

				}
			} else if (countPaire < 2) {
				countPaire = 1;
				for (int k = 3; k < 4; k++) {
					if (sortPaire.get(2).equals(sortPaire.get(k))) {
						countPaire++;
					}

				}
			} else if (countPaire < 2) {
				countPaire = 1;
				for (int l = 4; l < 5; l++) {
					if (sortPaire.get(3).equals(sortPaire.get(l))) {
						countPaire++;
					}

				}
			}

		}
		if (countPaire == 2) {
			puissanceMain = puissanceMain + 2;
			resultat.append(paire);
		}
	}

	public static void hasDoublePaire(List<Card> mapMainJoueur, StringBuilder resultat) {
		ArrayList<Integer> sortDoublePaire = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			sortDoublePaire.add(mapMainJoueur.get(i).getValeurForce());
		}
		Collections.sort(sortDoublePaire);

		if ((sortDoublePaire.get(0) == sortDoublePaire.get(1) && sortDoublePaire.get(2) == sortDoublePaire.get(3))
				|| (sortDoublePaire.get(0) == sortDoublePaire.get(1)
						&& sortDoublePaire.get(3) == sortDoublePaire.get(4))
				|| (sortDoublePaire.get(1) == sortDoublePaire.get(2)
						&& sortDoublePaire.get(3) == sortDoublePaire.get(4))) {
			puissanceMain = puissanceMain + 3;
			resultat.append(doublePaire);
		}
	}

	public static void hasCarteHaute(StringBuilder resultat) {
		if (resultat.length() == 0) {
			puissanceMain++;
			resultat.append(carteHaute);
		}

	}

	public static int[] detectionCouleur(List<Card> mapMainJoueur) {

		int hasCoeur = 0;
		int hasCarreau = 0;
		int hasTrefle = 0;
		int hasPique = 0;
		for (int i = 0; i < 5; i++) {
			switch (mapMainJoueur.get(i).getCouleur()) {
			case "Coeur" -> hasCoeur++;
			case "Carreau" -> hasCarreau++;
			case "Trèfle" -> hasTrefle++;
			case "Pique" -> hasPique++;
			}
		}
		int[] tabHasCouleur = { hasCoeur, hasCarreau, hasTrefle, hasPique };
		return tabHasCouleur;
	}

	public static int[] detectionValue(List<Card> mapMainJoueur) {
		int has2 = 0;
		int has3 = 0;
		int has4 = 0;
		int has5 = 0;
		int has6 = 0;
		int has7 = 0;
		int has8 = 0;
		int has9 = 0;
		int has10 = 0;
		int hasJ = 0;
		int hasQ = 0;
		int hasK = 0;
		int hasA = 0;
		for (int i = 0; i < 5; i++) {
			switch (mapMainJoueur.get(i).getValeur()) {
			case "2" -> has2++;
			case "3" -> has3++;
			case "4" -> has4++;
			case "5" -> has5++;
			case "6" -> has6++;
			case "7" -> has7++;
			case "8" -> has8++;
			case "9" -> has9++;
			case "10" -> has10++;
			case "Jack" -> hasJ++;
			case "Queen" -> hasQ++;
			case "King" -> hasK++;
			case "As" -> hasA++;
			}
		}
		int[] tabHasValeur = { has2, has3, has4, has5, has6, has7, has8, has9, has10, hasJ, hasQ, hasK, hasA };
		return tabHasValeur;
	}

}
