package com.example.projekti;

public class Mieliala {
    private int summa;
    private int maara;


    public Mieliala(int summa, int maara){
        this.summa = summa;
        this.maara = maara;
    }

    public int getMaara(){
        return this.maara;
    }

    public double getKa(){
        double ka = (double) (this.summa)/(this.maara);
        return ka;
    }

    public String getStringKa(){
        double ka = (double) (this.summa)/(this.maara);
        String kaString = String.format("%.2f", ka);

        return kaString;
    }

    public void lisaaMaara(){
        this.maara++;
    }

    public void lisaaSumma(int luku){
        this.summa += luku;
    }

    public int getSumma(){
        return this.summa;
    }
}
