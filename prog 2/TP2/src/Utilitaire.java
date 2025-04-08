/* =============================================================================== */
/* ---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~--- */
/*               -------------------------------------------------                 */
/*                PROJET: TP2                PAR: Nadia Desjardins                 */
/*               -------------------------------------------------                 */
/*                CREATED: 04-4th-2025                                             */
/*                MODIFIED BY: Nadia Desjardins                                    */
/*                LAST MODIFIED: 04-4th-2025                                       */
/*               -------------------------------------------------                 */
/*                FILE: Utilitaire.java                                            */
/*               -------------------------------------------------                 */
/* ---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~--- */
/* =============================================================================== */

import java.util.ArrayList;
import java.io.*;
import java.text.*;
import javax.swing.*;

public class Utilitaire
{
/***********************************************************************************/
/***                                 VARIABLES                                   ***/
/***********************************************************************************/

    private static ArrayList<Enclos> listeEnclos;

    private static BufferedReader bufLire;
    private static final String NOM_FICHIER_ENCLOS = "donnees/enclos.txt";
    private static final String NOM_FICHIER_ANIMAUX = "donnees/animaux.txt";

/***********************************************************************************/
/***                                 CONSTRUCTOR                                 ***/
/***********************************************************************************/

    public Utilitaire()
    {
        listeEnclos = new ArrayList<Enclos>();

        ChargementDonneesEnclos();
        ChargementDonneesAnimaux();
    }

/***********************************************************************************/
/***                                 FUNCTIONS                                   ***/
/***********************************************************************************/

    // Charger les donnees du fichier NOM_FICHIER_ENCLOS
    public void ChargementDonneesEnclos()
    {
        try
        {
            bufLire = new BufferedReader(new FileReader(NOM_FICHIER_ENCLOS)); // open en read
            String line = bufLire.readLine();

            // tab[0] = Enclos nom, tab[1] = capaciteMax
            while (line != null)
            {
                String tab[] = line.split(";");
                Enclos newEnclos = new Enclos(tab[0], Integer.parseInt(tab[1]));
                listeEnclos.add(newEnclos);
                
                line = bufLire.readLine();
            }

            bufLire.close(); // close file
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(null, "Erreur lors de la lecture du fichier " + NOM_FICHIER_ENCLOS);
        }

        // for (Enclos enclos : listeEnclos)
        // {
        //     System.out.println(enclos.getNomEnclos() + " " + enclos.getCapaciteMax());
        //     System.out.println(enclos.toString());
        // }
    }

    // Charger les donnees du fichier NOM_FICHIER_ANIMAUX
    public void ChargementDonneesAnimaux()
    {
        try
        {
            bufLire = new BufferedReader(new FileReader(NOM_FICHIER_ANIMAUX)); // open en read
            String line = bufLire.readLine();

            while (line != null)
            {
                String tab[] = line.split(";");
                ajouterAnimal(tab);

                line = bufLire.readLine();
            }

            bufLire.close(); // close file

            // for (Enclos enclos : listeEnclos)
            // {
            //     System.out.println("--------------------------------");
            //     System.out.println("Enclos: " + enclos.toString());
            //     enclos.afficherAnimaux();
            //     System.out.println("--------------------------------");
            // }
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(null, "Erreur lors de la lecture du fichier " + NOM_FICHIER_ANIMAUX);
        }
    }

    // Choix du type d'Animal
    static void ajouterAnimal(String tab[])
    {
        // System.out.println("tab: " + tab[1]);
        switch (tab[0])
        {
            case "Elephant":
                mountAnimal(new Elephant(), tab, TypeAnimaux.ELEPHANT);
                break;
            case "Lion":
                mountAnimal(new Lion(), tab, TypeAnimaux.LION);
                break;
            case "Singe":
                mountAnimal(new Singe(), tab, TypeAnimaux.SINGE);
                break;

            default:
                break;
        }
    }

    // Monter un animal avec les infos du ficher.txt et le mettre dans un renclos rendom
    static void mountAnimal(Animal newAnimal, String tab[], TypeAnimaux type)
    {
        // System.out.println("tab: " + tab[1]);
        String nom = tab[1];
        newAnimal.setNom(nom);

        int age = Integer.parseInt(tab[2]);
        newAnimal.setAge(age);

        double poids = Double.parseDouble(tab[3]);
        newAnimal.setPoids(poids);

        switch (type)
        {
            case TypeAnimaux.ELEPHANT:
                ((Elephant) newAnimal).setLongueurTrompe(Double.parseDouble(tab[4]));
                break;
            case TypeAnimaux.LION:
                ((Lion) newAnimal).setNombreCriniere(Integer.parseInt(tab[4]));
                break;
            case TypeAnimaux.SINGE:
                ((Singe) newAnimal).setEspece(tab[4]);
                break;
        
            default:
                break;
        }

        // Ajouter dans un enclos rendom
        int randNbr = (int)(Math.random() * listeEnclos.size());

        Enclos enc = listeEnclos.get(randNbr);
        enc.ajouterAnimal(newAnimal);
    }

    public String afficherAllAnimaux()
    {
        String str = "";

        for (Enclos enclos : listeEnclos)
        {
            str += "--------------------------------------------------------------------------------------\n";
            str += enclos.toString();
            str += enclos.afficherAnimaux();
            str += "--------------------------------------------------------------------------------------\n";
        }

        return str;
    }

/***********************************************************************************/
/***                                 GETTERS                                     ***/
/***********************************************************************************/

/***********************************************************************************/
/***                                 SETTERS                                       */
/***********************************************************************************/

}
