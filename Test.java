package GestionEmployes;

import Entite.Produit;
import Gestion.Magasin;
import Exception.*;

import java.time.temporal.Temporal;

public class Test {

    public static void main(String[] args) {
        Produit p1 = new Produit();


        Produit p2 = new Produit(1024, "Delice", "Lait");


        Magasin m1 = new Magasin(1, "ariana");



        try {
            m1.ajouter(p2);
            m1.ajouter(p1);
            m1.ajouter(p1);
            m1.ajouter(p1);

        } catch (MagasinPlainException e) {
            System.out.println(e.getMessage());
        }
        try {
            p1.setPrix(-22);
        } catch (PrixNegatifException e) {
            System.out.println(e.getMessage());
        }
    }

}
