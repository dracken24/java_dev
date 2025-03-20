// import javax.swing.*;

public class Etudiant
{
    String nom;

    int note01;
    int note02;
    int note03;

    static int nombreEtutiants = 0;

    // -------------------------------- Constructors --------------------------------- //

    public Etudiant()
    { nombreEtutiants++; }

    public Etudiant(String nom, int note01, int note02, int note03)
    {
        setNom(nom);
        setNote01(note01);
        setNote02(note02);
        setNote03(note03);

        nombreEtutiants++;
    }

    // ------------------------------- MEMBER FUNCTIONS ------------------------------ //

    public int calculerMoy()
    {
        return ((note01 + note02 + note03) / 3);
    }

    public String message()
    {
        int moyenne = calculerMoy();

        if (moyenne >= 60)
        {
            return "succes";
        }

        return "echec";
    }

    public String toString()
    {
        String str = this.nom + "\t" + this.note01 + "\t" + this.note02 + "\t" + this.note03;

        return str;
    }

    // ------------------------------------- GET ------------------------------------- //

    public String getNom()
    {
        return this.nom;
    }

    public int getnote01()
    {
        return this.note01;
    }

    public int getnote02()
    {
        return this.note02;
    }

    public int getnote03()
    {
        return this.note03;
    }

    public static int getnombreEtutiants()
    {
        return nombreEtutiants;
    }

    // ------------------------------------- SET ------------------------------------- //

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public void setNote01(int note)
    {
        if (note > 100 || note < 0)
            note = 0;
        this.note01 = note;
    }

    public void setNote02(int note)
    {
        if (note > 100 || note < 0)
            note = 0;
        this.note02 = note;
    }

    public void setNote03(int note)
    {
        if (note > 100 || note < 0)
            note = 0;
        this.note03 = note;
    }

    public void setnombreEtutiants(int nombreEtutiants)
    {
        this.nombreEtutiants = nombreEtutiants;
    }
}

// public class App
// {
//     // public String name = "Chuck Norris";

//     public static void main(String[] args) throws Exception
//     public static void main(String[] args) throws Exception
    // {
    //     JTextArea affichage = new JTextArea();

    //     affichage.append("Banane");

    //     JOptionPane.showMessageDialog(null, affichage,
    //         "Création de carrés", JOptionPane.PLAIN_MESSAGE);

    //     System.exit(0);
    // }
// }

