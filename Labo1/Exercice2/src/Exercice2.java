// Ce programme permet de calculer et d'afficher le coût de l'achat
// d'un client (il y a plusieurs clients à traiter, mais on suppose 
// qu'un client n'effectue qu'un seul achat, 
// et qui va afficher (après avoir traité tous les clients de la journée) 
// la quantité totale vendue pour chaque produit.


import java.io.*;
import java.text.*;
import javax.swing.*;

public class Exercice2
{
    public static DecimalFormat cash = new DecimalFormat("0.00 $");
    public static BufferedReader bufLire;
    public static final String NOM_FICHIER = "Exercice2/src/donnees/produits.txt";

    static Produit[] tabProduits;

    public static void chargerDonneesEnInventaire() throws IOException
    {
        bufLire = new BufferedReader(new FileReader(NOM_FICHIER));
        int i = 0; // Indice des tabeaux
        while (bufLire.readLine() != null)
        {
            i++;
        }
        bufLire.close();

        tabProduits = new Produit[i];

        bufLire = new BufferedReader(new FileReader(NOM_FICHIER));
        String ligneLue;
        i = 0; // Indice des tabeaux
        String tab[] = new String[2];
        while ((ligneLue = bufLire.readLine()) != null)
        {
            tab = ligneLue.split(";");
            int num = Integer.parseInt(tab[0]);
            double prix = Double.parseDouble(tab[1]);
            tabProduits[i] = new Produit(num, prix);
            i++;
        }
        bufLire.close();
    }

    static void traiterLesClients(int tabQteTotale[], int nbProd) 
    {
        int numero, qte,
        posiProd; // position du numéro dans le tableau tabNoProd
        double cout;
        char reponse;
        do
        {
            numero = Integer.parseInt(JOptionPane.showInputDialog(null,"Entrez le numéro du produit à acheter :","SAISIE DES DONNÉES",JOptionPane.PLAIN_MESSAGE));
            posiProd = rechercher(nbProd, numero);
            if (posiProd != -1)
            {
                qte = Integer.parseInt(JOptionPane.showInputDialog( null,"Entrez la quantité désirée :","SAISIE DES DONNÉES",JOptionPane.PLAIN_MESSAGE));
                cout = qte * tabProduits[posiProd].getPrix();
                tabQteTotale[posiProd] += qte;
                JOptionPane.showMessageDialog(null, "Le coût de cet achat est de " + cash.format(cout),"UNE VENTE",JOptionPane.PLAIN_MESSAGE);
            }
            else 
            {
                JOptionPane.showMessageDialog(null, "No de produit erroné", "MESSAGES",JOptionPane.PLAIN_MESSAGE);
            }
            reponse = JOptionPane.showInputDialog(null,"Avez-vous un autre client à traiter O-Oui et autre pour terminer?","CONTINUER TRAITEMENT",JOptionPane.PLAIN_MESSAGE).charAt(0);
            reponse = Character.toUpperCase(reponse);
        }
        while (reponse == 'O');
    } // fin de la méthode traiterLesClients


    static int rechercher(int nbEl, int valeurCherchee)
    {
        int posi = -1;
        boolean trouve = false;
        for (int i = 0; i < nbEl && !trouve; i++) 
        {
            // System.out.println("I: " + i);
            if (tabProduits[i].getNumero() == valeurCherchee) 
            {
                posi = i;
                trouve = true;
            }
        }
        return posi;
    } // fin de la méthode rechercher

    static void afficherResultats(int tabQteTotale[] ,int nbProd) 
    {
        double cout, grandTotal = 0.0;
        JTextArea jta = new JTextArea();
        jta.append("\nNuméro du\tPrix du\tQuantité\tMontant");
        jta.append("\nproduit\tproduit\tvendue\ttotal");
        for (int i = 0; i < nbProd; i++) 
        {
            cout = tabProduits[i].getPrix() * tabQteTotale[i];
            grandTotal += cout;
            jta.append("\n" + tabProduits[i].getNumero() + "\t" + cash.format(tabProduits[i].getPrix()) + "\t" + tabQteTotale[i] + "\t" + cash.format(cout));
        }
        jta.append("\n\nGrand total des ventes : " + cash.format(grandTotal));
        JOptionPane.showMessageDialog(null, jta, "RÉSULTATS DE LA JOURNÉE", JOptionPane.PLAIN_MESSAGE);
    } // fin de la méthode afficherResultats

    public static void main(String[] args) throws Exception 
    {
        final int NB_PROD = 8;
        // Produit[] tabProduits = new Produit[8];

        chargerDonneesEnInventaire();
        
        int tabQteTotale[] =   {0,    0,   0,   0,    0,   0,    0,     0};
        traiterLesClients(tabQteTotale, NB_PROD);
        afficherResultats(tabQteTotale, NB_PROD);
        System.exit(0);
    } // fin de la méthode main

} // fin de la classe