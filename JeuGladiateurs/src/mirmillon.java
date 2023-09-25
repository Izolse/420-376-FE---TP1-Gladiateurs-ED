/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

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
         // TODO : Récupérer la valeur d'attaque pour ce tour, calculer les dégats  
        int valeurDeFrappe = 0;
        int defPerso = 0;
        int dommage =0;
        
         for(int i = 0;i <=2; i++){
             if (personnageCible.getPointDeVie() <= 0 ) {
                 System.out.println("Igor le rétiaire empale son adversaire");
                 break;
             }
            valeurDeFrappe = super.attaqueCalcul();
            defPerso = personnageCible.getValeurDefense();
            dommage= valeurDeFrappe - defPerso;
            //modifier les points de vie du personnage cible, afficher les détails
            if (dommage < 0) {
                dommage = 0;
            }
            personnageCible.setPointDeVie(personnageCible.getPointDeVie() - dommage)    ;
            // sur l'attaque, tel que montré dans l'énoncé.
            if (personnageCible.getPointDeVie() < 0) {
               personnageCible.setPointDeVie(0);
            }

            System.out.println("Bob le malchanceux attaque avec une puissance de :" + valeurDeFrappe);
            System.out.println("Igor l'empaleur a une defense de :" + personnageCible.getValeurDefense());
            System.out.println("Les dommages sont donc de :" + dommage);

            super.frapperPersonnage(personnageCible); 
         }
       
    }

    // ----------------------------------
}
