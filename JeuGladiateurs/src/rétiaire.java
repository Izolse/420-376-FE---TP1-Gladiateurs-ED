/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import personnages.Personnage;
import java.util.Random;
/**
 *
 * @author 202130275
 */
public class rétiaire extends Personnage{
    // ----------------------------------
    // TODO : Mettre les attributs ici ...
    private int filet = 1;
    

    // ----------------------------------
    // TODO : Mettre les constructeurs et initialisateurs ici ...
    public rétiaire(String nom, int attaqueMax, int defense, int pvs, int ini) {
        super(nom, attaqueMax, defense, pvs, ini);
     }
    // ----------------------------------
    // TODO : Mettre les getters et setters ici ...

    public int getFilet() {
        return filet;
    }

    public void setFilet(int filet) {
        this.filet = filet;
    }
      
    
    
    
    // ----------------------------------
    // TODO : Mettre les autres méthodes ici ...
 @Override
    public void setNewInitiativeRandom() {
         Random rand = new Random();
        int iniMin = 0;
        int iniMax = 30;
        int  iniAleatoire = rand.nextInt(iniMax - iniMin) + iniMin;
        super.setInitiative(iniAleatoire); 
    }
    // ----------------------------------
    @Override
public void frapperPersonnage(Personnage personnageCible) {
        // TODO : Récupérer la valeur d'attaque pour ce tour, calculer les dégats,
        int valeurDeFrappe = attaqueCalcul();
        int defPerso = personnageCible.getValeurDefense();
        int dommage= valeurDeFrappe - defPerso;
        //modifier les points de vie du personnage cible, afficher les détails
        if (dommage < 0) {
            dommage = 0;
        }
        personnageCible.setPointDeVie(personnageCible.getPointDeVie()-dommage);
        // sur l'attaque, tel que montré dans l'énoncé.
if (personnageCible.getPointDeVie() < 0) {
           personnageCible.setPointDeVie(0);
        }

System.out.println( personnageCible.getNom() + "attaque avec une puissance de :" + valeurDeFrappe);
System.out.println(personnageCible.getNom() + " a une defense de :" + personnageCible.getValeurDefense());
System.out.println("Les dommages sont donc de :" + dommage);
    }

}

