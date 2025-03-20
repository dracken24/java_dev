/* =============================================================================== */
/* ---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~--- */
/*               -------------------------------------------------                 */
/*                PROJET: Java Dev          PAR: Dracken24                         */
/*               -------------------------------------------------                 */
/*                CREATED: 10-3rd-2025                                             */
/*                MODIFIED BY: Dracken24                                           */
/*                LAST MODIFIED: 10-3rd-2025                                       */
/*               -------------------------------------------------                 */
/*                FILE: TestEtudiant.java                                          */
/*               -------------------------------------------------                 */
/* ---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~--- */
/* =============================================================================== */

import javax.swing.*;

public class TestEtudiant
{
    public static void main(String[] args) throws Exception
    {
        JTextArea affichage = new JTextArea();
        affichage.append("nom\texamen 1\texamen 2\texamen 3\tmoyenne\tmessage\n");

        Etudiant etudiant01 = new Etudiant();
        etudiant01.setNom("Sylvie");
        etudiant01.setNote01(85);
        etudiant01.setNote02(80);
        etudiant01.setNote03(75);

        Etudiant etudiant02 = new Etudiant("Jean", 55, 50, 45);
        
        affichage.append(etudiant01.toString() + '\t' + etudiant01.calculerMoy() + '\t' + etudiant01.message() + '\n');
        affichage.append(etudiant02.toString() + '\t' + etudiant02.calculerMoy() + '\t' + etudiant02.message() + '\n');

        affichage.append("\n\t" + "Le nombre d'etudiants est " + etudiant01.getnombreEtutiants());

        JOptionPane.showMessageDialog(null, affichage,
            "Resultat de TestEtudiant", JOptionPane.PLAIN_MESSAGE);

        System.exit(0);
    }
}
