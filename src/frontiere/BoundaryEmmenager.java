package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					System.out.println("Bienvenue villageois " + nomVisiteur);
					StringBuilder questionForce = new StringBuilder();
					questionForce.append("Quelle est votre force ?\n");
					int choixForce = -1;
					choixForce = Clavier.entrerEntier(questionForce.toString());
					
					controlEmmenager.ajouterGaulois(nomVisiteur, choixForce);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) { 
		System.out.println("Bienvenue druide " + nomVisiteur);
		StringBuilder questionForce = new StringBuilder();
		questionForce.append("Quelle est votre force ?\n");
		int forceDruide = -1;
		forceDruide = Clavier.entrerEntier(questionForce.toString());
		
		int effetPotionMax = -2, effetPotionMin = -1;
		
		StringBuilder questionMin = new StringBuilder();
		questionMin.append("Quelle la force de la potion la plus faible que vous produisez?\n");
		StringBuilder questionMax = new StringBuilder();
		questionMax.append("Quelle la force de la potion la plus forte que vous produisez?\n");
		
		while(effetPotionMax < effetPotionMin){
			effetPotionMin = Clavier.entrerEntier(questionMin.toString()); 
			effetPotionMax = Clavier.entrerEntier(questionMax.toString()); 
			if(effetPotionMax < effetPotionMin) {
				System.out.println("Attention druide, vous vous �tes tromp� entre le minimum et le maximum");
			}
		}
		
		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetPotionMin, effetPotionMax);
		
	}
}
