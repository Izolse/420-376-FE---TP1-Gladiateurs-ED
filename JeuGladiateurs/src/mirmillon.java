/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mirmillon;
import java.util.Random;
import personnages.Personnage;
/**
 *
 * @author 202130275
 */
public class mirmillon extends Personnage {

    public mirmillon(String nom, int attaqueMax, int defense, int pvs, int ini) {
        super(nom, attaqueMax, defense, pvs, ini);
    }

    // ----------------------------------
    // TODO : Mettre les attributs ici ...
  
    // ----------------------------------
    // TODO : Mettre les constructeurs et initialisateurs ici ...

    // ----------------------------------
    // TODO : Mettre les getters et setters ici ...

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
    
    

    @Override
    public void frapperPersonnage(Personnage personnageCible) {
        
        int valeurDeFrappe = 0;
        int defPerso = 0;
        int dommage =0;
        
         for(int i = 0;i != 2; i++){   
             
             if (i != 0) {
                 System.out.println("Vous attaquez de nouveau");
             }
             
            valeurDeFrappe = super.attaqueCalcul();
            defPerso = personnageCible.getValeurDefense();
            dommage= valeurDeFrappe - defPerso;
            
            if (dommage < 0) {
                dommage = 0;
            }
            
            personnageCible.setPointDeVie(personnageCible.getPointDeVie() - dommage);
             
            if (personnageCible.getPointDeVie() < 0) {
               personnageCible.setPointDeVie(0);
            }

            System.out.println("Bob le malchanceux attaque avec une puissance de :" + valeurDeFrappe);
            System.out.println("Igor l'empaleur a une defense de :" + personnageCible.getValeurDefense());
            System.out.println("Les dommages sont donc de :" + dommage);

            if (personnageCible.getPointDeVie() <= 0 ) {
                 System.out.println(super.getNom()+" empale son adversaire");
                 break; 
            } 
            
            System.out.println("\n");
         }
       
    }

    // ----------------------------------
}
