package Entite;

import java.util.Date;
import Exception.PrixNegatifException;
public class Produit {
    private int identifiant;
    private String marque,libelle;
    private Date dateexp;

   private float prix;


   public void setPrix(float prix) throws PrixNegatifException {
   if(prix>0)
       this.prix=prix;
   else throw new PrixNegatifException("Le prix doit être positif");
   }
   public float getPrix()
   {
       return prix;
   }

    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Date getDateexp() {
        return dateexp;
    }

    public void setDateexp(Date dateexp) {
        this.dateexp = dateexp;
    }

    public Produit(int id, String m, String l)
    {
      identifiant=id;
      marque=m;
      libelle=l;
    }
    public Produit(String l,String m,int id)
    {
        libelle=l;
        marque=m;
        identifiant=id;
    }

    public Produit(int identifiant,String m,String l,float p,Date d)
    {
        this.identifiant=identifiant;
        marque=m;
        libelle=l;
        prix=p;
        dateexp=d;
    }

    public Produit(){

    }
    public void afficher()
    {
        System.out.println("id :"+identifiant+" marque :"+marque+" libelle :"
                +libelle+" prix :"+this.prix);
    }


    public String toString()
    {
      return "id :"+identifiant+" marque :"+marque+" libelle :"
              +libelle+" prix :"+this.prix+" Date :"+dateexp;
    }

    public boolean comparer(Produit p)
    {
        if (identifiant==p.identifiant && this.marque==p.marque
                && p.libelle==libelle&&prix==p.prix)
            return true;
        return false;
    }

    public static boolean comparer(Produit p1,Produit p2)
    {
        if (p1.identifiant==p2.identifiant && p1.marque==p2.marque
                && p1.libelle==p2.libelle&&p1.prix==p2.prix)
            return true;
        return false;
    }


}
