package practicum_6B;

import java.time.LocalDate;


public class Game {
    private String naam;
    private int releaseJaar;
    private double nieuwPrijs;

    public Game(String naam, int releaseJaar, double nieuwPrijs){
        this.naam = naam;
        this.releaseJaar = releaseJaar;
        this.nieuwPrijs = nieuwPrijs;
    }


    public double huidigeWaarde(){
        int verschilTussen_Nu_En_ReleaseJaar = LocalDate.now().getYear() - releaseJaar;

        return this.nieuwPrijs * Math.pow(0.70, verschilTussen_Nu_En_ReleaseJaar); // Math.pow(a, b) geeft a als
                                                                                   // een grondgetal en b als een exponent.
    }


    public boolean equals(Object andereObject){

        if (andereObject instanceof Game){
            Game andereGame = (Game) andereObject;

            return this.naam.equals(andereGame.naam) && this.releaseJaar == andereGame.releaseJaar;
        }

        return false;
    }


    public String toString(){
        return naam + ", uitgegeven in " + releaseJaar + "; nieuwprijs: \u20AC" +
                String.format("%.2f", nieuwPrijs) + " nu voor: \u20AC" + String.format("%.2f", huidigeWaarde());
    }

}
