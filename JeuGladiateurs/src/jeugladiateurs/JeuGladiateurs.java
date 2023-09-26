package jeugladiateurs;

import personnages.Personnage;
import combat.CompteurDeTour;
import combat.AffichageEcran;
import mirmillon.mirmillon;
 
public class JeuGladiateurs {

    public static void main(String[] args) {

        // **************************************************************************
        // **************************************************************************
        // **************************************************************************
        // <editor-fold defaultstate="expanded" desc="Instanciation des objets">
        CompteurDeTour tour = new CompteurDeTour();
        AffichageEcran affichage = new AffichageEcran();
        Personnage Bob = new mirmillon("Bob le malchanceux", 15, 15, 70, 15);
        
        Personnage Igor = new Personnage("Igor l'empaleur", 25, 5, 100, 30);
        // </editor-fold>

        // **************************************************************************
        // **************************************************************************
        // **************************************************************************
        // <editor-fold defaultstate="collapsed" desc="Affichage pré-combat">
        // TODO : Afficher les infos de chaque personnage
        Bob.afficherInfosPersonnage();
        Igor.afficherInfosPersonnage();

        // TODO : Afficher le message du début du combat
        affichage.afficherDebutCombat();

        // </editor-fold>
        // **************************************************************************
        // **************************************************************************
        // **************************************************************************
        // <editor-fold defaultstate="collapsed" desc="Mécanique de combat">
        // TODO : La boucle contenant les étapes du combat

        do {
                    tour.afficheTour();

        for (int i = 0; i <= 100; i++) {
            if (Bob.getInitiative() == i) {
                Bob.frapperPersonnage(Igor);
            }
            if (Igor.getInitiative() == i) {
                Igor.frapperPersonnage(Bob);
            }

        }
        affichage.afficherSeparateurDeTour();
        Bob.afficherInfosPersonnage();
        Igor.afficherInfosPersonnage();
        Bob.setNewInitiativeRandom();
        Igor.setNewInitiativeRandom();
        tour.augmenteTour();
        tour.afficheTour();
            if (Bob.getPointDeVie() == 0) {
                break;
            }
            if (Igor.getPointDeVie() == 0) {
                break;
            }
        } while (Bob.getPointDeVie()!=0 && Igor.getPointDeVie()!=0);
        // TODO : Après la boucle, afficher le résultat du combat
       affichage.afficheVictoire(Bob, Igor);
        // </editor-fold>
    }
}
