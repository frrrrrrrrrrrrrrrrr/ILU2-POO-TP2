package frontiere;

import java.util.Iterator;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		if(infosMarche.length == 0) {
			System.out.println("Le march� est vide, revenez plus tard.");
		}else {
			System.out.println(nomAcheteur + ", vous trouverez au march� :");
			
			for (int i = 0; i < infosMarche.length; i++) {
				String vendeur = infosMarche[i];
				i++;
				String quantite = infosMarche[i];
				i++;
				String produit = infosMarche[i];
				System.out.println("- " + vendeur + " qui vend " + quantite + " " + produit);
			}
		}
	}
}
