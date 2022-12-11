package com.example.projekti;

public class Mieliala {
    private int summa;
    private int maara;

    public Mieliala(){
        this.summa = 0;
        this.maara = 0;
    }

    public int getMaara(){
        return this.maara;
    }

    public double getKa(){
        double ka = (double) (this.summa)/(this.maara);
        return ka;
    }

    public void lisaaMaara(){
        this.maara++;
    }

    public void lisaaSumma(int luku){
        this.summa += luku;
    }
}
