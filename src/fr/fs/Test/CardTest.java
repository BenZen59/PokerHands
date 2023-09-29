package fr.fs.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import fr.fs.Poker.Card;


class CardTest {
	Card deuxPique = new Card("Pique","2",0);
	Card asPique = new Card("Pique","A",12);
	
	@Test
	void testComparerDeuxCartes() {
		assertEquals("Carte A de Pique gagnante", Card.comparerDeuxCartes(deuxPique, asPique));
		assertEquals("Carte A de Pique gagnante", Card.comparerDeuxCartes(asPique, deuxPique));
		assertEquals("Les deux cartes sont à égalité", Card.comparerDeuxCartes(asPique, asPique));
	}

}
