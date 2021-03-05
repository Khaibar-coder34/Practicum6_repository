package practicum_6;

import java.time.LocalDate;

public class Main_6 {
    public static void main(String[] args) {
        int releaseJaar1 = LocalDate.now().getYear() - 1; // 1 jaar geleden

        Game g1 = new Game("Just Cause 3", releaseJaar1, 49.98);
        Game g2 = new Game("Need for Speed: Rivals", releaseJaar1, 45.99);
        Game g3 = new Game("Need for Speed: Rivals", releaseJaar1, 45.99);

        Persoon p1 = new Persoon("Eric", 200);
        Persoon p2 = new Persoon("Hans", 55);

        System.out.println("p1 koopt g1:" + (p1.koop(g1) ? "" : " niet") + " gelukt");
        System.out.println("p1 koopt g2:" + (p1.koop(g2) ? "" : " niet") + " gelukt");
        System.out.println("p1 koopt g3:" + (p1.koop(g3) ? "" : " niet") + " gelukt");
        System.out.println("\np1: " +p1+ "\n\np2: " +p2+ "\n");

        System.out.println("p1 verkoopt g2 aan p2:"+(p1.verkoop(g2, p2) ? "" : " niet")+" gelukt");
        System.out.println("p1 verkoopt g1 aan p2:"+(p1.verkoop(g1, p2) ? "" : " niet")+" gelukt");
        System.out.println("\np1: " +p1+ "\n\np2: " +p2+ "\n");
    }
}

/*
p1 koopt g1: gelukt
p1 koopt g2: gelukt
p1 koopt g3: niet gelukt

p1: Eric heeft een budget van €132,82 en bezit de volgende games:
Just Cause 3, uitgegeven in 2020; nieuwprijs: €49,98 nu voor: €34,99
Need for Speed: Rivals, uitgegeven in 2020; nieuwprijs: €45,99 nu voor: €32,19

p2: Hans heeft een budget van €55,00 en bezit de volgende games:

p1 verkoopt g2 aan p2: gelukt
p1 verkoopt g1 aan p2: niet gelukt

p1: Eric heeft een budget van €165,01 en bezit de volgende games:
Just Cause 3, uitgegeven in 2020; nieuwprijs: €49,98 nu voor: €34,99

p2: Hans heeft een budget van €22,81 en bezit de volgende games:
Need for Speed: Rivals, uitgegeven in 2020; nieuwprijs: €45,99 nu voor: €32,19

 */