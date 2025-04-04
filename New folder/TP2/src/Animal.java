/* =============================================================================== */
/* ---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~--- */
/*               -------------------------------------------------                 */
/*                PROJET: TP2                PAR: Nadia Desjardins                 */
/*               -------------------------------------------------                 */
/*                CREATED: 04-4th-2025                                             */
/*                MODIFIED BY: Nadia Desjardins                                    */
/*                LAST MODIFIED: 04-4th-2025                                       */
/*               -------------------------------------------------                 */
/*                FILE: Animal.java                                                */
/*               -------------------------------------------------                 */
/* ---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~--- */
/* =============================================================================== */

public abstract class Animal
{
/***********************************************************************************/
/***                                 VARIABLES                                   ***/
/***********************************************************************************/

    private String nom;
    private int age;
    private double poids;

/***********************************************************************************/
/***                                 CONSTRUCTOR                                 ***/
/***********************************************************************************/

    public Animal() { }

    public Animal(String nom, int age, double poids)
    {
        this.nom = nom;
        this.age = age;
        this.poids = poids;
    }

/***********************************************************************************/
/***                                 FUNCTIONS                                   ***/
/***********************************************************************************/

    public String toString()
    {
        return "Nom: " + nom + ", Age: " + age + ", Poids: " + poids;
    }

    public abstract void faireDuBruit();

/***********************************************************************************/
/***                                 GETTERS                                     ***/
/***********************************************************************************/

    public String getNom()
    {
        return nom;
    }

    public int getAge()
    {
        return age;
    }

    public double getPoids()
    {
        return poids;
    }

/***********************************************************************************/
/***                                 SETTERS                                       */
/***********************************************************************************/

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public void setPoids(double poids)
    {
        this.poids = poids;
    }
}
