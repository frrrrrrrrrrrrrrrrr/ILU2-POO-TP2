package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	private Chef abraracourcix;
	private ControlAcheterProduit controlAcheterProduit;
	private ControlVerifierIdentite controlVerifierIdentite;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private Village village;
	private Gaulois bonemine;
	

	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		bonemine = new Gaulois("Bonemine", 2);
		village.ajouterHabitant(bonemine);
		village.installerVendeur(bonemine, "fleurs", 10);
		
		
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
	}
	
	@Test
	void testControlAcheterProduit() {
		assertNotNull(controlAcheterProduit, "Constructeur ne renvoie pas null");
	}
	
	@Test
	void testAcheterProduit() {
		
		// Acheter un produit est possible et retire le bon nombre de produits de l'étal
		assertEquals(controlAcheterProduit.acheterProduit("Bonemine", 3), 3);
		assertEquals(controlTrouverEtalVendeur.trouverEtalVendeur("Bonemine").getQuantite(), 7);
		
		// Vouloir acheter plus de produit qu'il n'y en a sur l'étal se produit comme prévu
		assertEquals(controlAcheterProduit.acheterProduit("Bonemine", 15), 7);
		assertEquals(controlTrouverEtalVendeur.trouverEtalVendeur("Bonemine").getQuantite(), 0);
	}
	
	@Test
	void testVerifierNom() {
		assertTrue(controlAcheterProduit.verifierNom("Bonemine"));
		assertFalse(controlAcheterProduit.verifierNom("Astérix"));
	}
	
	@Test
	void testRechercherVendeursProduit() {
		
		// test pas de vendeurs correspondants
		assertNull(controlAcheterProduit.rechercherVendeursProduit("plante"));
		
		// Test un vendeur correspondant
		String[] nomVendeursAttendus = new String[1];
		nomVendeursAttendus[0] = "Bonemine";
		
		assertEquals(controlAcheterProduit.rechercherVendeursProduit("fleurs"), nomVendeursAttendus);
	}

}
