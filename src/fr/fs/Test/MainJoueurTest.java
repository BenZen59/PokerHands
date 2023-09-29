package fr.fs.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import fr.fs.Poker.Card;
import fr.fs.Poker.MainJoueur;


class MainJoueurTest {
	MainJoueur Couleur = new MainJoueur(Arrays.asList(new Card("10", "Coeur", 8), new Card("Jack", "Coeur", 9),
			new Card("Queen", "Coeur", 10), new Card("King", "Coeur", 11), new Card("As", "Coeur", 12)));
	@Test
	void testVerificationCombinaison() {
		assertEquals("AAAJKLMN", MainJoueur.comparerMain(Couleur));

	}
}
