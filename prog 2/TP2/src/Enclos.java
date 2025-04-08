 /* =============================================================================== */
/* ---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~--- */
/*               -------------------------------------------------                 */
/*                PROJET: TP2                PAR: Nadia Desjardins                 */
/*               -------------------------------------------------                 */
/*                CREATED: 04-4th-2025                                             */
/*                MODIFIED BY: Nadia Desjardins                                    */
/*                LAST MODIFIED: 04-4th-2025                                       */
/*               -------------------------------------------------                 */
/*                FILE: Enclos.java                                                */
/*               -------------------------------------------------                 */
/* ---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~--- */
/* =============================================================================== */

import java.util.ArrayList;

public class Enclos
{
/***********************************************************************************/
/***                                 VARIABLES                                   ***/
/***********************************************************************************/

    private String nomEnclos;
    private int capaciteMax;
    private ArrayList<Animal> listeAnimaux;

/***********************************************************************************/
/***                                 CONSTRUCTOR                                 ***/
/***********************************************************************************/

    public Enclos()
    {
        listeAnimaux = new ArrayList<Animal>();
    }

    public Enclos(String nomEnclos, int capaciteMax)
    {
        this.nomEnclos = nomEnclos;
        this.capaciteMax = capaciteMax;

        listeAnimaux = new ArrayList<Animal>();
    }

/***********************************************************************************/
/***                                 FUNCTIONS                                   ***/
/***********************************************************************************/

    public void ajouterAnimal(Animal unAnimal)
    {
        listeAnimaux.add(unAnimal);
    }

    public String afficherAnimaux()
    {
        String str = "";
        for (Animal animal : listeAnimaux)
        {
            str += "Animal Name: " + animal.toString() + "\n";
        }

        if (str == "")
        {
            str = "-- Aucun animal dans cet enclos. --\n";
        }

        return str;
    }

    public Animal rechercherAnimal(String nom)
    {
        for (Animal animal : listeAnimaux)
        {
            if (animal.getNom() == nom)
            {
                System.out.println("Animal avec le nom: " + animal.getNom() + " est present dans l'enclos");
                return animal;
            }
        }

        System.out.println("Animal avec le nom: " + nom + " est manquant");
        return null;
    }

    public void supprimerAnimal(String nom)
    {
        Animal animal = rechercherAnimal(nom);

        if (animal != null)
        {
            listeAnimaux.remove(animal);
        }
    }

    public String toString()
    {
        return "Enclos: " + nomEnclos + " avec une capacite de " + capaciteMax + " animaux\n";
    }

/***********************************************************************************/
/***                                 GETTERS                                     ***/
/***********************************************************************************/

    public String getNomEnclos()
    {
        return nomEnclos;
    }

    public int getCapaciteMax()
    {
        return capaciteMax;
    }

/***********************************************************************************/
/***                                 SETTERS                                       */
/***********************************************************************************/

    public void setNomEnclos(String nomEnclos)
    {
        this.nomEnclos = nomEnclos;
    }

    public void setCapaciteMax(int capaciteMax)
    {
        this.capaciteMax = capaciteMax;
    }
}
