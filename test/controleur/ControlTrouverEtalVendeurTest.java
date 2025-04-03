package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {

	private Village village;
	private Chef abraracourcix;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
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
		
		
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
	}
	
	@Test
	void testControlTrouverEtalVendeur() {
		assertNotNull(controlTrouverEtalVendeur, "Constructeur ne renvoie pas null");
	}
	
	@Test
	void testTrouverEtalVendeur(){
		assertNull(controlTrouverEtalVendeur.trouverEtalVendeur("Zorro"));
		assertNull(controlTrouverEtalVendeur.trouverEtalVendeur("Asterix"));
		assertNotNull(controlTrouverEtalVendeur.trouverEtalVendeur("Bonemine"));
	}
	

}
