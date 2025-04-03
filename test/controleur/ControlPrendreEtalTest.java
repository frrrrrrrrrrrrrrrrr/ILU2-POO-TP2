package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {

	private Village village;
	private Chef abraracourcix;
	private ControlVerifierIdentite controlVerifierIdentite;
	private ControlPrendreEtal controlPrendreEtal;
	private Gaulois bonemine;
	private Gaulois asterix;

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
		controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
	}
	
	@Test
	public void testControlPrendreEtal(){
		assertNotNull(controlPrendreEtal, "Constructeur ne renvoie pas null");
	}
	
	@Test
	public void testResteEtals() {
		assertTrue(controlPrendreEtal.resteEtals());
	}
	
	@Test
	public void testPrendreEtals(){
		assertEquals(controlPrendreEtal.prendreEtal("Bonemine", "fleurs", 10), 0);
	}
	
	@Test
	public void testVerifierIdentite(){
		assertTrue(controlPrendreEtal.verifierIdentite("Bonemine"));
	}
}
