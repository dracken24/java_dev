/* =============================================================================== */
/* ---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~--- */
/*               -------------------------------------------------                 */
/*                PROJET: Vin               PAR: Nadia Desjardins                  */
/*               -------------------------------------------------                 */
/*                CREATED: 11-3rd-2025                                             */
/*                MODIFIED BY: Dracken24                                           */
/*                LAST MODIFIED: 11-3rd-2025                                       */
/*               -------------------------------------------------                 */
/*                FILE: Exercice1.java                                             */
/*               -------------------------------------------------                 */
/* ---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~--- */
/* =============================================================================== */

import java.text.*;

public class Vin
{
	public static final int ROUGE = 1;
	public static final int BLANC = 2;
	public static final int ROSE = 3;

// ********************************** Variables ********************************** //

	private static int nbVins = 0;
	private static double prixTotalVin = 0;

	private String nom;
	private int type;
	private String origine;
	private double prix;

// ******************************** Constructors ******************************** //

	public Vin(String nom, String origine, double prix)
	{
		this.nom = nom;
		this.origine = origine;
		this.prix = prix;
		this.type = ROUGE;

		adjustPrixQuantite();
	}

	public Vin(String nom, int type, String origine, double prix)
	{
		this.nom = nom;
		this.origine = origine;
		this.prix = prix;
		this.type = type;

		adjustPrixQuantite();
	}

// ********************************* Functions ********************************* //

	void adjustPrixQuantite()
	{
		nbVins++;
		prixTotalVin += this.prix;
	}

	String typeToString()
	{
		switch (this.type)
		{
			case ROUGE:
				return "rouge";
			case BLANC:
				return "blanc";
			case ROSE:
				return "rose";
			default:
				return null;
		}
	}

	public String toString()
	{
		java.text.DecimalFormat decimalformat = new java.text.DecimalFormat("0.00");

		String returnString = this.nom;
		returnString += " est un vin ";
		returnString += typeToString();
		returnString += " de ";
		returnString += this.origine;
		returnString += " et son prix est de ";
		returnString += decimalformat.format(this.prix);
		returnString += " $";

		return returnString;
	}

// ************************************ GET ************************************ //

	public String getNom()
	{
		return this.nom;
	}

	public String getOrigine()
	{
		return this.origine;
	}

	public double getPrix()
	{
		return this.prix;
	}

	public int getType()
	{
		return this.type;
	}

	public static int getNbVin()
	{
		return nbVins;
	}

	public static double getPrixTotalVin()
	{
		return prixTotalVin;
	}

// ************************************ SET ************************************ //

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public void setOrigine(String origine)
	{
		this.origine = origine;
	}

	public void setPrix(double prix)
	{
		prixTotalVin += prix - this.prix;

		this.prix = prix;
	}

	public void setType(int type)
	{
		this.type = type;
	}
}
