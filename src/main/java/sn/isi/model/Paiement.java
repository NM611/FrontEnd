package sn.isi.model;


import java.time.LocalDate;

public class Paiement {


    private int id;


    private String numeroTrans;

    private LocalDate date;


    private int montant;


    private String moyenPaiement;

    private boolean etat;

    private Demande demande=new Demande();

    public Paiement(){

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroTrans() {
        return numeroTrans;
    }

    public void setNumeroTrans(String numeroTrans) {
        this.numeroTrans = numeroTrans;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public String getMoyenPaiement() {
        return moyenPaiement;
    }

    public void setMoyenPaiement(String moyenPaiement) {
        this.moyenPaiement = moyenPaiement;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }



}
