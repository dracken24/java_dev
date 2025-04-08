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
// import java.util.ArrayList;

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
        // utils.ChargementDonneesAnimaux();
        // listeEnclos = new ArrayList<Enclos>();

        // listeEnclos.add(new Enclos("Enclos Principal", 10));

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
        prompt += "5. Quitter";
    }

    private static void userChoice()
    {
        String choice = JOptionPane.showInputDialog(prompt);

        // check if is an integer
        if (!choice.matches("\\d+"))
        {
            errorGestion();
            return;
        }

        switch (choice)
        {
            case "1":
                ajouterAnimal();
                break;
            case "2":
                JOptionPane.showMessageDialog(
                    null, 
                    utils.afficherAllAnimaux(), 
                    "Animaux affiche par enclos",
                    JOptionPane.INFORMATION_MESSAGE
                );
                break;
            case "3":
                break;
            case "4":
                break;
            case "5":
                exitCounter = true;
                break;

            default:
                break;
        }
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
            errorGestion();
            return;
        }

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
                break;
        }
    }

    private static void mountAnimal(Animal newAnimal, TypeAnimaux type)
    {
        String choice = JOptionPane.showInputDialog("Donnez un nom a votre animal.");
        newAnimal.setNom(choice);

        choice = JOptionPane.showInputDialog("Quel age a votre animal?");
        while (!choice.matches("\\d+"))
        {
            errorGestion();
            choice = JOptionPane.showInputDialog("Quel age a votre animal?");
        }
        newAnimal.setAge(Integer.parseInt(choice));

        choice = JOptionPane.showInputDialog("Quel poid a votre animal?");
        while (!choice.matches("\\+?\\d+(\\.\\d+)?"))
        {
            errorGestion();
            choice = JOptionPane.showInputDialog("Quel poid a votre animal?");
        }
        newAnimal.setPoids(Double.parseDouble(choice));

        switch (type)
        {
            case TypeAnimaux.ELEPHANT:
                String p = "Quel est la longeur de la trompe de votre Elephant?";
                choice = JOptionPane.showInputDialog(p);
                while (!choice.matches("\\+?\\d+(\\.\\d+)?"))
                {
                    errorGestion();
                    choice = JOptionPane.showInputDialog(p);
                }
                ((Elephant) newAnimal).setLongueurTrompe(Double.parseDouble(choice));
                break;
            case TypeAnimaux.LION:
                p = "Quel est le nombre de criniere de votre Lion?";
                choice = JOptionPane.showInputDialog(p);
                while (!choice.matches("\\d+"))
                {
                    errorGestion();
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
    }

    private static void errorGestion()
    {
        JOptionPane.showMessageDialog(
            null, 
            "Choix invalide. Doit etre numeric.", 
            "Erreur",
            JOptionPane.ERROR_MESSAGE
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

// affichage.setText("titre \t\t Artiste \t\t Genre \t Durée \t Année\t\n");
//         affichage.append("-----------------------------------------------------------------------------------------------------------------------------------------\n");
//         for (Musique musique : tabMusiques)
//         {
//             affichage.append(musique.toString() + "\n");
//         }

//         affichage.append("\nNombre de musiques: " + tabMusiques.size());

//         JOptionPane.showMessageDialog(null, affichage, "Liste des musiques", JOptionPane.INFORMATION_MESSAGE, null);
