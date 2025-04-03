package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {

	private Village village;
	private Chef abraracourcix;
	private Gaulois bonemine;
	private Gaulois asterix;
	private ControlVerifierIdentite controlVerifierIdentite;

	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irr�ductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		bonemine = new Gaulois("Bonemine", 2);
		village.ajouterHabitant(bonemine);
		asterix = new Gaulois("Asterix", 2);
		village.ajouterHabitant(asterix);
		
		
		controlVerifierIdentite = new ControlVerifierIdentite(village);
	}
	
	@Test
	void testControlVerifierIdentite() {
		assertNotNull(controlVerifierIdentite, "Constructeur ne renvoie pas null");
	}
	
	@Test
	void testVerifierIdentite() {
		assertFalse(controlVerifierIdentite.verifierIdentite("Zorro"));
		assertTrue(controlVerifierIdentite.verifierIdentite("Bonemine"));
	}
	

}
