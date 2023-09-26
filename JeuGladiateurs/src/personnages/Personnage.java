package personnages;
import java.util.Random;
public class Personnage {

    // **************************************************************************
    // **************************************************************************
    // **************************************************************************
    // <editor-fold defaultstate="collapsed" desc="Attributs">
    // TODO : Mettre vos attributs ici
    // </editor-fold>
String nom;
int PointDeVie;
int ValeurMaxAttaque;
int ValeurDefense;
int initiative;

    // **************************************************************************
    // **************************************************************************
    // **************************************************************************
    // <editor-fold defaultstate="collapsed" desc="Constructeurs et initialisation">
    public Personnage(String nom, int attaqueMax, int defense, int pvs, int ini) {
        // TODO : Constructeur AVEC paramètres
        this.nom = nom;
        this.PointDeVie = pvs;
        this.ValeurMaxAttaque = attaqueMax;
        this.ValeurDefense = defense;
        this.initiative = ini;
    }

    public Personnage() {
        // TODO : Constructeur SANS paramètres qui initialise à ZÉRO ou à ""
        this.nom = "0";
        this.PointDeVie = 0;
        this.ValeurMaxAttaque =0;
        this.ValeurDefense =0;
        this.initiative =0;
    }
    // </editor-fold>
    public String getNom() {
        return nom;
        // TODO : Afficher les infos du personnage, tel que montré dans l'énoncé
    }

    public int getPointDeVie() {
        return PointDeVie;
    }

    public int getValeurMaxAttaque() {
        return ValeurMaxAttaque;
    }

    public int getValeurDefense() {
        return ValeurDefense;
    }

    // **************************************************************************
    // **************************************************************************
    // **************************************************************************
    // <editor-fold defaultstate="collapsed" desc="Getters et setters">
    // TODO : Les getters
    public int getInitiative() {    
        return initiative;
    }
    public void setNom(String nom) {
        this.nom = nom;
        // TODO : Afficher les infos du personnage, tel que montré dans l'énoncé
    }

    public void setPointDeVie(int PointDeVie) {
        this.PointDeVie = PointDeVie;
    }

    public void setValeurMaxAttaque(int ValeurMaxAttaque) {
        this.ValeurMaxAttaque = ValeurMaxAttaque;
    }

    public void setValeurDefense(int ValeurDefense) {
        this.ValeurDefense = ValeurDefense;
    }

    // TODO : Les setters
    public void setInitiative(int initiative) {    
        this.initiative = initiative;
    }

    // </editor-fold>
    // **************************************************************************
    // **************************************************************************
    // **************************************************************************
    // <editor-fold defaultstate="collapsed" desc="Mécanique de jeu">
    public void afficherInfosPersonnage() {
        // TODO : Afficher les infos du personnage, tel que montré dans l'énoncé
        System.out.println("");
        System.out.println(nom);
        System.out.println("Attaque :" + ValeurMaxAttaque);
        System.out.println("Defense :" + ValeurDefense);
        System.out.println("Point de vie :" +PointDeVie);
        System.out.println("initiative :"+ initiative);
        
        if (PointDeVie>0) {
            System.out.println("Statut : Vivant");
        }
        else{
            System.out.println("Statut : Mort");
        }
    }

    public int attaqueCalcul() {
        // TODO : Retourner la valeur de l'attaque du personnage.
       Random rand = new Random();
        int attaqueMin = 0;
        int attaqueMax = ValeurMaxAttaque;
        int  attaqueAleatoire = rand.nextInt(attaqueMax - attaqueMin) + attaqueMin; 
            
        // Cette valeur est trouvée aléatoirement et doit se situer entre ZÉRO et valeurMaxAttaque.
        return attaqueAleatoire;
    }

    public void frapperPersonnage(Personnage personnageCible) {
        // TODO : Récupérer la valeur d'attaque pour ce tour, calculer les dégats,
        int valeurDeFrappe = attaqueCalcul();
        int defPerso = personnageCible.ValeurDefense;
        int dommage= valeurDeFrappe - defPerso;
        //modifier les points de vie du personnage cible, afficher les détails
        if (dommage < 0) {
            dommage = 0;
        }
        personnageCible.PointDeVie = personnageCible.PointDeVie - dommage;
        // sur l'attaque, tel que montré dans l'énoncé.
if (personnageCible.PointDeVie < 0) {
           personnageCible.PointDeVie =0;
        }

System.out.println( getNom() + "attaque avec une puissance de :" + valeurDeFrappe);
System.out.println(personnageCible.getNom() + " a une defense de :" + personnageCible.ValeurDefense);
System.out.println("Les dommages sont donc de :" + dommage);
    }
   

    public void setNewInitiativeRandom() {
        // TODO : Modifier de façon aléatoire la valeur INI du personnage.
      Random rand = new Random();
        int iniMin = 0;
        int iniMax = 100;
        int  iniAleatoire = rand.nextInt(iniMax - iniMin) + iniMin;
        this.initiative = iniAleatoire;
    }   
    // </editor-fold>
}
