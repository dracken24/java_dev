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
    private int maxId;

/***********************************************************************************/
/***                                 CONSTRUCTOR                                 ***/
/***********************************************************************************/

    public Utilitaire()
    {
        listeEnclos = new ArrayList<Enclos>();
        maxId = 0;

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
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(null, "Erreur lors de la lecture du fichier " + NOM_FICHIER_ANIMAUX);
        }
    }

    // Choix du type d'Animal
    void ajouterAnimal(String tab[])
    {
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
    void mountAnimal(Animal newAnimal, String tab[], TypeAnimaux type)
    {
        // Recuperer le id de l'animal
        int id = Integer.parseInt(tab[1]);
        newAnimal.setId(id);

        if (maxId < id)
        {
            maxId = id;
        }

        // Recuperer le nom de l'animal
        String nom = tab[2];
        newAnimal.setNom(nom);

        // Recuperer l'age de l'animal
        int age = Integer.parseInt(tab[3]);
        newAnimal.setAge(age);

        // Recuperer le poid de l'animal
        double poids = Double.parseDouble(tab[4]);
        newAnimal.setPoids(poids);

        // Recuperer la longeur de la trompe de l'elephant ou le nombre de criniere du lion ou l'espece du singe
        switch (type)
        {
            case TypeAnimaux.ELEPHANT:
                ((Elephant) newAnimal).setLongueurTrompe(Double.parseDouble(tab[5]));
                break;
            case TypeAnimaux.LION:
                ((Lion) newAnimal).setNombreCriniere(Integer.parseInt(tab[5]));
                break;
            case TypeAnimaux.SINGE:
                ((Singe) newAnimal).setEspece(tab[5]);
                break;
        
            default:
                break;
        }

        // Ajouter l'animal dans un enclos random
        Enclos enc = listeEnclos.get(0);
        enc.ajouterAnimal(newAnimal);
    }

    public String afficherAllAnimaux()
    {
        String str = "";
        // int i = 101;
        for (Enclos enclos : listeEnclos)
        {
            str += "-----------------------------------------------------------------------------------------------------------------------------\n";
            str += enclos.toString() + "\n";
            str += enclos.afficherAnimaux();
            str += "-----------------------------------------------------------------------------------------------------------------------------\n";
            // i += 100;
        }

        return str;
    }

    public void supprimerAnimal(Animal a)
    {
        for (Enclos enclos : listeEnclos)
        {
            enclos.supprimerAnimal(a);
        }
    }

/***********************************************************************************/
/***                                 GETTERS                                     ***/
/***********************************************************************************/

    public Enclos getListeEnclosByIndex(int index)
    {
        return listeEnclos.get(index);
    }

    public int getListeEnclosSize()
    {
        return listeEnclos.size();
    }

    public Animal getAnimalByName(String nom)
    {
        for (Enclos en : listeEnclos)
        {
            Animal a = en.rechercherAnimal(nom);

            if (a != null)
            {
                return a;
            }
        }

        return null;
    }

    public int getMaxId()
    {
        return this.maxId;
    }

/***********************************************************************************/
/***                                 SETTERS                                       */
/***********************************************************************************/

    public void setMaxId(int newMaxId)
    {
        this.maxId = newMaxId;
    }
}
