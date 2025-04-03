package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlLibererEtalTest {

	private Village village;
	private Chef abraracourcix;
	private ControlLibererEtal controlLibererEtal;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private Gaulois bonemine;
	private Gaulois asterix;

	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irr�ductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		bonemine = new Gaulois("Bonemine", 2);
		village.ajouterHabitant(bonemine);
		village.installerVendeur(bonemine, "fleurs", 10);
		asterix = new Gaulois("Asterix", 2);
		village.ajouterHabitant(asterix);
		
		
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
	}
	
	@Test
	void testControlLibererEtal() {
		assertNotNull(controlLibererEtal, "Constructeur ne renvoie pas null");
	}
	
	@Test
	void testIsVendeur() {
		// Le villageois n'existe pas
		assertFalse(controlLibererEtal.isVendeur("Zorro"));
		
		// Le villageois est dans le village mais n'a pas d'étal
		assertFalse(controlLibererEtal.isVendeur("Asterix"));
		
		// Le villageois est un vendeur
		assertTrue(controlLibererEtal.isVendeur("Bonemine"));
		
	}
	
	@Test
	void testLibererEtal() {
		String[] donneesEtal;
		
		donneesEtal = controlLibererEtal.libererEtal("Bonemine");
		assertEquals(donneesEtal[1], "Bonemine");
		assertEquals(donneesEtal[2], "fleurs");
		assertEquals(Integer.parseInt(donneesEtal[3]), 10);
		assertEquals(Integer.parseInt(donneesEtal[4]), 0);
		
		
	}

}
