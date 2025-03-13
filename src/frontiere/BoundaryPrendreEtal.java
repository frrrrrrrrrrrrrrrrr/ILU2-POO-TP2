package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		Boolean nomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		
		if(nomVendeurConnu) {
			System.out.println("Bonjour " + nomVendeur + ", je vais regarder si je peux vous trouover un étal.");
			Boolean etalDisponible = controlPrendreEtal.resteEtals();
			
			if(etalDisponible) {
				installerVendeur(nomVendeur);
				System.out.println("C'est parfait, il me reste un étal pour vous!");
				System.out.println("Il me faudrait quelques renseignements :");
				
				StringBuilder questionProduit = new StringBuilder();
				questionProduit.append("Quel produit souhaitez vous vendre?\n");
				
				String produit;
				produit = Clavier.entrerChaine(questionProduit.toString());
				
				StringBuilder questionNbProduit = new StringBuilder();
				questionNbProduit.append("Combien souhaitez vous en vendre?\n");
				
				int nbProduit;
				nbProduit = Clavier.entrerEntier(questionNbProduit.toString());
				
				int numeroEtal;
				numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
				
				if(numeroEtal != -1) {
					System.out.println("Le vendeur " + nomVendeur + "s'est installé à l'étal n°" + numeroEtal);
				}
				
				

			}else {
				System.out.println("Désolée " + nomVendeur + " je n'ai plus d'étal qui ne soit pas déjà occupé.");
			}
		}else {
			System.out.println("Je suis désolée " + nomVendeur + " mais il daut être habitant de notre village pour pouvoir commercer ici.");
			
		}
		
	}

	private void installerVendeur(String nomVendeur) {
		//TODO a completer
	}
}
