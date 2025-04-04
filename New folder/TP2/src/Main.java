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
import java.util.ArrayList;

public class Main
{
    static JTextArea affichage = new JTextArea();
    static boolean exitCounter = false;
    static String prompt;

    static ArrayList<Enclos> listeEnclos;

    public static void main(String[] args) throws Exception
    {
        listeEnclos = new ArrayList<Enclos>();

        listeEnclos.add(new Enclos("Enclos Principal", 10));

        while (!exitCounter)
        {
            showPrompt();
            userChoice();
        }
    }

    static void showPrompt()
    {
        prompt = "====== MENU DU ZOO ======\n";
        prompt += "1. Ajouter un animal\n";
        prompt += "2. Afficher tous les animaux\n";
        prompt += "3. Rechercher un animal\n";
        prompt += "4. Supprimer un animal\n";
        prompt += "5. Quitter";
    }

    static void userChoice()
    {
        int choice = Integer.parseInt(JOptionPane.showInputDialog(prompt));

        switch (choice)
        {
            case 1:
                ajouterAnimal();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
            exitCounter = true;
                break;

            default:
                break;
        }
    }

    static void ajouterAnimal()
    {

    }
}

// affichage.setText("titre \t\t Artiste \t\t Genre \t Durée \t Année\t\n");
//         affichage.append("-----------------------------------------------------------------------------------------------------------------------------------------\n");
//         for (Musique musique : tabMusiques)
//         {
//             affichage.append(musique.toString() + "\n");
//         }

//         affichage.append("\nNombre de musiques: " + tabMusiques.size());

//         JOptionPane.showMessageDialog(null, affichage, "Liste des musiques", JOptionPane.INFORMATION_MESSAGE, null);
