package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherVillageTest {

	private Village village;
	private Chef abraracourcix;
	private ControlAfficherVillage controlAfficherVillage;
	private Gaulois bonemine;
	private Gaulois asterix;

	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		bonemine = new Gaulois("Bonemine", 2);
		village.ajouterHabitant(bonemine);
		village.installerVendeur(bonemine, "fleurs", 10);
		asterix = new Gaulois("Asterix", 2);
		village.ajouterHabitant(asterix);
		
		
		controlAfficherVillage = new ControlAfficherVillage(village);
	}
	
	@Test
	void testControlAfficherVillage() {
		assertNotNull(controlAfficherVillage, "Constructeur ne renvoie pas null");
	}
	
	@Test
	void testDonnerNbEtals(){
		assertEquals(controlAfficherVillage.donnerNbEtals(), 5);
	}
	
	@Test
	void testDonnerNomVillage() {
		assertEquals(controlAfficherVillage.donnerNomVillage(), "le village des irréductibles");
	}
	
	@Test 
	void testDonnerNomsVillageois() {
		String[] nomsAttendus = new String[2];
		nomsAttendus[0] = "Bonemine";
		nomsAttendus[1] = "Asterix";
		assertEquals(controlAfficherVillage.donnerNomsVillageois(), nomsAttendus);
	}

}
