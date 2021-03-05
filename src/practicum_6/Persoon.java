package practicum_6;

import java.util.ArrayList;

public class Persoon {
    private String naam;
    private double budget;
    private ArrayList <Game> games = new ArrayList<Game>();

    Persoon(String naam, double budget){
        this.budget = budget;
        this.naam = naam;

    }

    public double getBudget() {
        return budget;
    }


    public boolean koop(Game g) {
        if (this.budget > g.huidigeWaarde()) {

            if (!games.contains(g)) {
                games.add(g);
                budget = budget - g.huidigeWaarde();

                return true;
            } else {
                return false;
            }

        }
        return false;
    }

    public boolean verkoop(Game g, Persoon koper){
        if (games.contains(g)){

            if (koper.koop(g)){

            this.budget = budget + g.huidigeWaarde();
            games.remove(g);

            return true;}
        }

        return false;
    }

    public String toString() {
        String s = naam + " heeft een budget van \u20AC" + String.format("%.2f", budget) +
                " en bezit de volgende games:";

        for (Game elke_game_in_bezit : games) {
            s = s + "\n" + elke_game_in_bezit;
        }

        return s;
    }


}
