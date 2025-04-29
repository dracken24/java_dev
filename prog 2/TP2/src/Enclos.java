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

import java.util.HashMap;

public class Enclos
{
/***********************************************************************************/
/***                                 VARIABLES                                   ***/
/***********************************************************************************/

    private String nomEnclos;
    private int capaciteMax;
    private HashMap<Integer, Animal> listeAnimaux;

/***********************************************************************************/
/***                                 CONSTRUCTOR                                 ***/
/***********************************************************************************/

    public Enclos()
    {
        listeAnimaux = new HashMap<Integer, Animal>();
    }

    public Enclos(String nomEnclos, int capaciteMax)
    {
        this.nomEnclos = nomEnclos;
        this.capaciteMax = capaciteMax;

        listeAnimaux = new HashMap<Integer, Animal>();
    }

/***********************************************************************************/
/***                                 FUNCTIONS                                   ***/
/***********************************************************************************/

    public void ajouterAnimal(Animal unAnimal)
    {
        listeAnimaux.put(unAnimal.getId(), unAnimal);
    }

    public String afficherAnimaux()
    {
        String str = "";

        // Afficher les animaux
        for (Animal animal : listeAnimaux.values())
        {
            if (animal instanceof Lion)
            {
                str += "Id: " + animal.getId() + ". " + ((Lion)animal).getType() + "\t: " + animal.toString() + "\n";
            }
            if (animal instanceof Singe)
            {
                str += "Id: " + animal.getId() + ". " + ((Singe)animal).getType() + "\t: " + animal.toString() + "\n";
            }
            if (animal instanceof Elephant)
            {
                str += "Id: " + animal.getId() + ". " + ((Elephant)animal).getType() + "\t: " + animal.toString() + "\n";
            }
        }

        if (str == "")
        {
            str = "--- Aucun animal dans cet enclos. ---\n";
        }

        return str;
    }

    public Animal rechercherAnimal(String nom)
    {
        for (Animal animal : listeAnimaux.values())
        {
            if (animal.getNom().equals(nom))
            {
                return animal;
            }
        }

        return null;
    }

    public void supprimerAnimal(Animal a)
    {
        if (a != null)
        {
            listeAnimaux.remove(a.getId());
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
