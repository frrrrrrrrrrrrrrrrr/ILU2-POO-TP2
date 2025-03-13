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
			System.out.println("Bonjour " + nomVendeur + ", je vais regarder si je peux vous trouover un �tal.");
			Boolean etalDisponible = controlPrendreEtal.resteEtals();
			
			if(etalDisponible) {
				installerVendeur(nomVendeur);
				System.out.println("C'est parfait, il me reste un �tal pour vous!");
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
					System.out.println("Le vendeur " + nomVendeur + "s'est install� � l'�tal n�" + numeroEtal);
				}
				
				

			}else {
				System.out.println("D�sol�e " + nomVendeur + " je n'ai plus d'�tal qui ne soit pas d�j� occup�.");
			}
		}else {
			System.out.println("Je suis d�sol�e " + nomVendeur + " mais il daut �tre habitant de notre village pour pouvoir commercer ici.");
			
		}
		
	}

	private void installerVendeur(String nomVendeur) {
		//TODO a completer
	}
}
