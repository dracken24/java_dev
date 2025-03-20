/* =============================================================================== */
/* ---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~--- */
/*               -------------------------------------------------                 */
/*                PROJET: Produits           PAR: Nadia Desjardins                 */
/*               -------------------------------------------------                 */
/*                CREATED: 11-3rd-2025                                             */
/*                MODIFIED BY: Nadia Desjardins                                    */
/*                LAST MODIFIED: 11-3rd-2025                                       */
/*               -------------------------------------------------                 */
/*                FILE: Produit.java                                               */
/*               -------------------------------------------------                 */
/* ---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~--- */
/* =============================================================================== */

import java.text.*;

public class Produit
{
// ********************************** Variables ********************************** //

    int num;
    double prix;

// ******************************** Constructors ******************************** //

    public Produit()
    {
        this.num = 0;
        this.prix = 0;
    }

    public Produit(int num, double prix)
    {
        this.num = num;
        this.prix = prix;
    }

// ********************************* Functions ********************************* //

    public String afficher()
    {
        java.text.DecimalFormat decimalformat = new java.text.DecimalFormat("0.00");
        
        return "Il y a " + this.num + " produits au prix unitaire de "
                    + decimalformat.format(this.prix);
    }

// ************************************ GET ************************************ //

    public int getNumero()
    {
        return this.num;
    }

    public double getPrix()
    {
        return this.prix;
    }

// ************************************ SET ************************************ //

    public void setNumero(int numero)
    {
        this.num = numero;
    }

    public void setPrix(double prix)
    {
        this.prix = prix;
    }
}
