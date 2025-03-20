/* =============================================================================== */
/* ---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~--- */
/*               -------------------------------------------------                 */
/*                PROJET: Vin               PAR: Nadia Desjardins                  */
/*               -------------------------------------------------                 */
/*                CREATED: 11-3rd-2025                                             */
/*                MODIFIED BY: Dracken24                                           */
/*                LAST MODIFIED: 11-3rd-2025                                       */
/*               -------------------------------------------------                 */
/*                FILE: Produit.java                                               */
/*               -------------------------------------------------                 */
/* ---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~--- */
/* =============================================================================== */

import javax.swing.*;

public class TestVin
{
    public static void main(String[] args) throws Exception
    {
        JTextArea affichage = new JTextArea();

        Vin vin01 = new Vin("MiamMiam", Vin.BLANC, "Espagne", 8.95f);
        Vin vin02 = new Vin("Delicieux", "France", 14.5f);
        Vin vin03 = new Vin("Mystere", Vin.ROSE, "Californie", 10.0f);

        String afficheString = "Voici les " + Vin.getNbVin() + " vins\n";

        affichage.append(afficheString);

        java.text.DecimalFormat decimalformat = new java.text.DecimalFormat("0.00");
        afficheString = "Le prix total des vins est de " +
            decimalformat.format(Vin.getPrixTotalVin()) + " $\n";

        affichage.append(afficheString);
        affichage.append("\t" + vin01.toString() + "\n");
        affichage.append("\t" + vin02.toString() + "\n");
        affichage.append("\t" + vin03.toString() + "\n\n");

        vin01.setPrix(vin01.getPrix() + 2);

        vin02.setPrix(23);
        vin02.setOrigine("Italie");

        vin03.setNom("Vino Verde");
        vin03.setType(Vin.BLANC);
        vin03.setOrigine(vin01.getOrigine());

        Vin vin04 = new Vin("L'erabliere", "Quebec", 15.0f);

        afficheString = "Voici les " + Vin.getNbVin() + " vins\n";
        affichage.append(afficheString);

        afficheString = "Le prix total des vins est de " +
            decimalformat.format(Vin.getPrixTotalVin()) + " $\n";

        affichage.append(afficheString);

        affichage.append("\t" + vin01.toString() + "\n");
        affichage.append("\t" + vin02.toString() + "\n");
        affichage.append("\t" + vin03.toString() + "\n");
        affichage.append("\t" + vin04.toString());

        JOptionPane.showMessageDialog(null, affichage,
            "Resultat de TestEtudiant", JOptionPane.PLAIN_MESSAGE);

        System.exit(0);
    }
}
