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

    String nomEnclos;
    int capaciteMax;
    ArrayList<Animal> listeAnimaux;

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

    public void afficherAnimaux()
    {
        for (Animal animal : listeAnimaux)
        {
            System.out.println("Animal Name: " + animal.getNom());
        }
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
