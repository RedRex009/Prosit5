package Gestion;

import Entite.Produit;
import GestionEmployes.Caissier;
import GestionEmployes.Employe;
import GestionEmployes.Responsable;
import GestionEmployes.Vendeur;
import Exception.MagasinPlainException;

import java.sql.SQLOutput;

public class Magasin {

    private int id;

    private String adresse,nom;

    private final int CAPACITE = 2;


    private int comp;
    private Produit[] tabprod = new Produit[CAPACITE];
    private static int total;
    private final int CAPCITE_EMP=20;
    private Employe[] tabemp=new Employe[CAPCITE_EMP];

    private int compE;
    public Magasin(int id,String nom, String ad) {
        this.id = id;
        adresse = ad;
        this.nom=nom;
    }
    public Magasin(int id, String ad) {
        this.id = id;
        adresse = ad;
    }


    public void ajouter(Employe e)
    {
        if(compE<CAPCITE_EMP)
        {
            tabemp[compE]=e;
            compE++;
        }
        else {
            System.out.println("le magasin est plein");
        }
    }

    public void ajouter(Produit p) throws MagasinPlainException {
        if (comp < CAPACITE) {
            if(chercherProduit(p)==false) {
                tabprod[comp] = p;
                comp++;
                total++;
            }else {
                System.out.println("le produit existe déjà");
            }
        } else throw  new MagasinPlainException("Magasin plein" ) ;


    }



    public void afficherNomEmp()
    {
       for(int i=0;i<compE;i++)
       {
           System.out.println("Nom Emp :"+tabemp[i].getNom());
       }
    }

    public void afficherEmploye()
    {

        for (int i=0;i<compE;i++)
        {
            System.out.println(tabemp[i].toString());
        }
    }

    public void afficheSalaire(){
        for (int i=0;i<compE;i++)
        {
            System.out.println(tabemp[i]+" Salaire :"+tabemp[i].calculSalaire());
        }
    }

    public void afficherPrime()
    {
        for (int i=0;i<compE;i++) {
            if(tabemp[i] instanceof Responsable) {
                Responsable res = (Responsable) tabemp[i];
                System.out.println("prime :" + res.getPrime());
            }else {
                System.out.println("ce n'est pas un responsable");
            }
        }
    }

    public void afficherNbEmpPatType()
    {int nbV=0,nbC=0,nbR=0;
        for (int i=0;i<compE;i++)
        {
            if (tabemp[i] instanceof Responsable) {
                nbR++;
            }
            if (tabemp[i] instanceof Vendeur) {
                nbV++;
            }
            if (tabemp[i] instanceof Caissier) {
                nbC++;
            }

        }
        System.out.println("le nombre des vendeurs :"+nbV);
        System.out.println("le nombre des caissier :"+nbC);
        System.out.println("le nombre des responsable :"+nbR);
    }
    public static int getTotal(){
        return total;
    }
    public void afficherMarquePro() {
        for (int i = 0; i < comp; i++) {
            System.out.println("Marque :" + tabprod[i].getMarque());
        }

    }

    public String toString() {
        String str = "L'ensemble des produits\n";

        for (int i = 0; i < comp; i++) {
            str += tabprod[i] + "\n";
        }

        return "L'id :" + id + " l'adresse :" + adresse + "\n" + str;
    }

    public boolean chercherProduit(Produit p){
        for (int i=0;i<comp;i++)
        { if(Produit.comparer(p,tabprod[i]))
           // if(p.comparer(tabprod[i]))
                return true;
        }
        return false;
    }


    public Magasin plusProduit(Magasin m)
    {
        if(this.comp<m.comp)
            return m;
        else if (this.comp>m.comp) {
            return this;
        }
        else return null;
    }

    public static Magasin plusProduit(Magasin m1,Magasin m2)
    {
        if(m1.comp<m2.comp)
            return m2;
        else if (m1.comp>m2.comp) {
            return m1;
        }
        else return null;
    }


    public int chercherProduitIndice(Produit p)
    {
     for (int i=0;i<comp;i++)

     {
         if(Produit.comparer(p,tabprod[i]))

             return i;
     }
        return -1;
    }
    public boolean supprimer(Produit p)
    {
        int indice=chercherProduitIndice(p);

        if(indice!=-1)
        {

            for (int i=indice;i<=comp-1;i++)
            {
                tabprod[i]=tabprod[i+1];
            }
            tabprod[comp]=null;
            comp--;
            total--;
        }

        return false;
    }
}
