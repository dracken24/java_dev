/* =============================================================================== */
/* ---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~--- */
/*               -------------------------------------------------                 */
/*                PROJET: TP2                PAR: Nadia Desjardins                 */
/*               -------------------------------------------------                 */
/*                CREATED: 04-4th-2025                                             */
/*                MODIFIED BY: Nadia Desjardins                                    */
/*                LAST MODIFIED: 04-4th-2025                                       */
/*               -------------------------------------------------                 */
/*                FILE: Main.java                                                  */
/*               -------------------------------------------------                 */
/* ---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~--- */
/* =============================================================================== */

import javax.swing.JTextArea;
import javax.swing.JOptionPane;

public class Main
{
/***********************************************************************************/
/***                                 VARIABLES                                   ***/
/***********************************************************************************/

	static JTextArea affichage = new JTextArea();
	static boolean exitCounter = false;
	static String prompt;
	static Utilitaire utils = new Utilitaire();

/***********************************************************************************/
/***                                 FUNCTIONS                                   ***/
/***********************************************************************************/

	public static void main(String[] args) throws Exception
	{
		mountPrompt();

		while (!exitCounter)
		{
			userChoice();
		}
	}

	private static void mountPrompt()
	{
		prompt = "====== MENU DU ZOO ======\n";
		prompt += "1. Ajouter un animal\n";
		prompt += "2. Afficher tous les animaux\n";
		prompt += "3. Rechercher un animal\n";
		prompt += "4. Supprimer un animal\n";
		prompt += "5. Sauvegarder\n";
		prompt += "6. Quitter";
	}

	// Gerer les choix de l'utilisateur
	private static void userChoice()
	{
		String choice = JOptionPane.showInputDialog(prompt);

		if (choice == null)
		{
			exitCounter = true;
			return;
		}
		else if (!choice.matches("\\d+")) // check if is an integer
		{
			errorGestion("Choix invalide. Doit etre numeric.");
			return;
		}

		switch (choice)
		{
			case "1":
				ajouterAnimal();
				break;
			case "2":
				affichage.setText(utils.afficherAllAnimaux());
				JOptionPane.showMessageDialog(
					null, 
					affichage, 
					"Animaux affiche par enclos",
					JOptionPane.INFORMATION_MESSAGE
				);
				break;
			case "3":
				rechercherAnimal();
				break;
			case "4":
				supprimerUnAnimal();
				break;
			case "5":
			sauvegarder();
				break;
			case "6":
				exitCounter = true;
				break;

			default:
				break;
		}
	}

	private static void sauvegarder()
	{
		
	}

	private static void ajouterAnimal()
	{
		String msg = "Quel type d'animal voulez-vous ajouter?\n";
		msg += "1. Elephant\n";
		msg += "2. Lion\n";
		msg += "3. Singe\n";

		String choice = JOptionPane.showInputDialog(msg);
		
		// check if is an integer
		if (!choice.matches("\\d+"))
		{
			errorGestion("Choix invalide. Doit etre numeric.");
			return;
		}

		// Monter le bon type d'animal
		switch (choice)
		{
			case "1":
				mountAnimal(new Elephant(), TypeAnimaux.ELEPHANT);
				break;
			case "2":
				mountAnimal(new Lion(), TypeAnimaux.LION);
				break;
			case "3":
				mountAnimal(new Singe(), TypeAnimaux.SINGE);
				break;

			default:
				errorGestion("Choix invalide.");
				break;
		}
	}

	private static void mountAnimal(Animal newAnimal, TypeAnimaux type)
	{
		// Demander le nom de l'animal
		String choice = JOptionPane.showInputDialog("Donnez un nom a votre animal.");
		newAnimal.setNom(choice);

		// Demander l'age de l'animal
		choice = JOptionPane.showInputDialog("Quel age a votre animal?");
		while (!choice.matches("\\d+"))
		{
			errorGestion("Choix invalide. Doit etre numeric.");
			choice = JOptionPane.showInputDialog("Quel age a votre animal?");
		}
		newAnimal.setAge(Integer.parseInt(choice));

		// Demander le poid de l'animal
		choice = JOptionPane.showInputDialog("Quel poid a votre animal?");
		while (!choice.matches("\\+?\\d+(\\.\\d+)?"))
		{
			errorGestion("Choix invalide. Doit etre numeric.");
			choice = JOptionPane.showInputDialog("Quel poid a votre animal?");
		}
		newAnimal.setPoids(Double.parseDouble(choice));

		// Demander la longeur de la trompe de l'elephant ou le nombre de criniere du lion ou l'espece du singe
		switch (type)
		{
			case TypeAnimaux.ELEPHANT:
				String p = "Quel est la longeur de la trompe de votre Elephant?";
				choice = JOptionPane.showInputDialog(p);
				while (!choice.matches("\\+?\\d+(\\.\\d+)?"))
				{
					errorGestion("Choix invalide. Doit etre numeric.");
					choice = JOptionPane.showInputDialog(p);
				}
				((Elephant) newAnimal).setLongueurTrompe(Double.parseDouble(choice));
				break;
			case TypeAnimaux.LION:
				p = "Quel est le nombre de criniere de votre Lion?";
				choice = JOptionPane.showInputDialog(p);
				while (!choice.matches("\\d+"))
				{
					errorGestion("Choix invalide. Doit etre numeric.");
					choice = JOptionPane.showInputDialog(p);
				}
				((Lion) newAnimal).setNombreCriniere(Integer.parseInt(choice));
				break;
			case TypeAnimaux.SINGE:
				p = "Quel est l'espece de votre Singe?";
				choice = JOptionPane.showInputDialog(p);
				((Singe) newAnimal).setEspece(choice);
				break;
		
			default:
				break;
		}

		// Set le animal id
		int id = utils.getMaxId();
		newAnimal.setId(++id);
		utils.setMaxId(id);

		// Demander dans quel enclos ajouter l'animal
		String p = "Dans quel enclos voulez-vous ajouter un animal?\n";
		for (int i = 0; i < utils.getListeEnclosSize(); i++)
		{
			p += (i + 1) + ". " + utils.getListeEnclosByIndex(i).getNomEnclos() + "\n";
		}

		choice = JOptionPane.showInputDialog(p);
		while (!choice.matches("\\d+"))
		{
			errorGestion("Choix invalide. Doit etre numeric.");
			choice = JOptionPane.showInputDialog(p);
		}

		int ch = Integer.parseInt(choice);

		for (int i = 0; i < utils.getListeEnclosSize(); i++)
		{
			if (i + 1 == ch)
			{
				utils.getListeEnclosByIndex(i).ajouterAnimal(newAnimal);
			}
		}
	}

	// Gerer les erreurs
	private static void errorGestion(String message)
	{
		JOptionPane.showMessageDialog(
			null, 
			message, 
			"Erreur",
			JOptionPane.ERROR_MESSAGE
		);
	}

	// Rechercher un animal
	private static void rechercherAnimal()
	{
		// Afficher tous les animaux et demander le nom de l'animal recherché
		affichage.setText(utils.afficherAllAnimaux() + "\n\nEntrez le nom de l'animal recherché");
		String choice = JOptionPane.showInputDialog(
			null, 
			affichage, 
			"Rechercher un animal",
			JOptionPane.INFORMATION_MESSAGE
		);

		// Rechercher l'animal
		Animal a = utils.getAnimalByName(choice);

		if (a != null)
		{
			String str = "";
			affichage.setText("Voici l'animal recherché:\n\n");
			if (a instanceof Lion)
			{
				str += ((Lion)a).getType();
			}
			if (a instanceof Singe)
			{
				str += ((Singe)a).getType();
			}
			if (a instanceof Elephant)
			{
				str += ((Elephant)a).getType();
			}

			affichage.setText("Type: " + str + "\t" +a.toString());
		}
		else
		{
			affichage.setText("--- Animal inexistant ---");
		}

		// Afficher le resultat
		JOptionPane.showMessageDialog(
			null, 
			affichage, 
			"Rechercher un animal",
			JOptionPane.INFORMATION_MESSAGE
		);
	}

	// Supprimer un animal
	private static void supprimerUnAnimal()
	{
		// Afficher tous les animaux et demander le nom de l'animal a supprimer
		affichage.setText(utils.afficherAllAnimaux() + "\n\nEntrez le nom de l'animal a supprimer");
		String choice = JOptionPane.showInputDialog(
			null, 
			affichage, 
			"Animaux affiche par enclos",
			JOptionPane.INFORMATION_MESSAGE
		);

		Animal a = utils.getAnimalByName(choice);

		// Supprimer l'animal
		if (a != null)
		{
			affichage.setText("--- Animal supprimer avec succes ---\n\n");
			utils.supprimerAnimal(a);
		}
		else
		{
			affichage.setText("--- Animal inexistant ---");
		}

		// Afficher le resultat
		JOptionPane.showMessageDialog(
			null, 
			affichage, 
			"Animaux affiche par enclos",
			JOptionPane.INFORMATION_MESSAGE
		);
	}
}


/***********************************************************************************/
/***                                   ENUMS                                     ***/
/***********************************************************************************/

enum TypeAnimaux
{
	ELEPHANT,
	LION,
	SINGE
}
