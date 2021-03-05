package practicum_6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PersoonTest {
    private int ditJaar;
    private Persoon koper;
    private Persoon koperArm;
    private Persoon verkoper;
    private Game game1;
    private Game game2;
    private String toStringTekstGame1;
    private String toStringTekstGame2;
    private String toStringTekstKoper0Games;
    private String toStringTekstKoperHeeftGame1;
    private String toStringTekstKoperHeeftGame2;
    private String toStringTekstKoper2Games;
    private String toStringTekstKoperArm;
    private String toStringTekstKoperArm1Game;
    private String toStringTekstVerkoper0Games;
    private String toStringTekstVerkoperHeeftGame1;
    private String toStringTekstVerkoperHeeftGame2;

    @BeforeEach
    public void init(){
        ditJaar = LocalDate.now().getYear();
        koper = new Persoon("Eric de Koper",200.0);
        koperArm = new Persoon("Hans",36.0);
        verkoper = new Persoon("Jos de Verkoper", 60.0);
        toStringTekstKoper0Games = "Eric de Koper heeft een budget van €200,00 en bezit de volgende games:";
        //game 1 is nieuw
        game1 = new Game("Mario Kart", ditJaar, 50.0 );
        toStringTekstGame1 = "Mario Kart, uitgegeven in " + ditJaar + "; nieuwprijs: €50,00 nu voor: €50,00";
        toStringTekstKoperHeeftGame1 = "Eric de Koper heeft een budget van €150,00 en bezit de volgende games:";
        //game2 is 1 jaar oud
        game2 = new Game("Zelda", ditJaar-1, 50.0 );
        toStringTekstGame2 = "Zelda, uitgegeven in " + (ditJaar-1) + "; nieuwprijs: €50,00 nu voor: €35,00";
        toStringTekstKoperHeeftGame2 = "Eric de Koper heeft een budget van €165,00 en bezit de volgende games:";
        toStringTekstKoper2Games = "Eric de Koper heeft een budget van €115,00 en bezit de volgende games:";
        toStringTekstKoperArm = "Hans heeft een budget van €36,00 en bezit de volgende games:";
        toStringTekstKoperArm1Game = "Hans heeft een budget van €1,00 en bezit de volgende games:";
        toStringTekstVerkoper0Games = "Jos de Verkoper heeft een budget van €60,00 en bezit de volgende games:";
        toStringTekstVerkoperHeeftGame1 = "Jos de Verkoper heeft een budget van €10,00 en bezit de volgende games:";
        toStringTekstVerkoperHeeftGame2 = "Jos de Verkoper heeft een budget van €25,00 en bezit de volgende games:";
    }


    //region tests toString()
    @Test
    public void testToStringGeenGames(){
        assertEquals(toStringTekstKoper0Games,
                koper.toString(),
                "toString() levert niet de juiste string op.");
    }

    @Test
    public void testToString1Game(){
        koper.koop(game1);
        assertEquals(toStringTekstKoperHeeftGame1 +
                        "\n" + toStringTekstGame1,
                koper.toString(),
                "toString() levert niet de juiste string op.");
    }

    @Test
    public void testToString2Games(){
        koper.koop(game1);
        koper.koop(game2);
        assertEquals(toStringTekstKoper2Games +
                        "\n" + toStringTekstGame1 +
                        "\n" + toStringTekstGame2,
                koper.toString(),
                "toString() levert niet de juiste string op.");
    }
    //endregion

    //region tests koop()
    @Test
    public void testResultKoopGameNieuwVoldoendeBudget(){
        boolean gelukt = koper.koop(game1);
        assertEquals(true, gelukt, "koop() geeft ten onrechte terug dat de koop niet gelukt is.");
    }

    @Test
    public void testBudgetKoopGameNieuwVoldoendeBudget(){
        boolean gelukt = koper.koop(game1);
        assertEquals(150.0, Math.round(koper.getBudget() * 100)/100d, "koop() levert niet het goede budget op.");
    }

    @Test
    public void testGameListKoopGameNieuwVoldoendeBudget(){
        boolean gelukt = koper.koop(game1);
        assertEquals(toStringTekstKoperHeeftGame1 + "\n" + toStringTekstGame1, koper.toString(),
                "koop() moet gelukt zijn, maar levert een fout op in, waarschijnlijk, de lijst met Games.");
    }

    @Test
    public void testResultKoopGameNieuwOnvoldoendeBudget(){
        boolean gelukt = koperArm.koop(game1);
        assertEquals(false, gelukt, "koop() geeft ten onrechte terug dat de koop gelukt is.");
    }

    @Test
    public void testBudgetKoopGameNieuwOnvoldoendeBudget(){
        boolean gelukt = koperArm.koop(game1);
        assertEquals(36.0, Math.round(koperArm.getBudget() * 100)/100d, "koop() levert niet het goede budget op.");
    }

    @Test
    public void testGameListKoopGameNieuwOnvoldoendeBudget(){
        boolean gelukt = koperArm.koop(game1);
        assertEquals(toStringTekstKoperArm, koperArm.toString(),
                "koop() mag niet gelukt zijn, maar levert een fout op in, waarschijnlijk, de lijst met Games.");
    }

    @Test
    public void testResultKoopDubbeleGameVoldoendeBudget(){
        boolean gelukt = koper.koop(game1);
        gelukt = koper.koop(game1);
        assertEquals(false, gelukt, "Game is al in bezit, maar koop() geeft ten onrechte terug dat de koop gelukt is.");
    }

    @Test
    public void testBudgetKoopDubbeleGameVoldoendeBudget(){
        boolean gelukt = koper.koop(game1);
        gelukt = koper.koop(game1);
        assertEquals(150.0, Math.round(koper.getBudget() * 100)/100d, "koop() levert niet het goede budget op (game is al in bezit)");
    }

    @Test
    public void testGameListKoopDubbeleGameVoldoendeBudget(){
        boolean gelukt = koper.koop(game1);
        gelukt = koper.koop(game1);
        assertEquals(toStringTekstKoperHeeftGame1 + "\n" + toStringTekstGame1, koper.toString(),
                "koop() mag niet gelukt zijn (game is al in bezit), maar levert een fout op in, waarschijnlijk, de lijst met Games.");
    }

    @Test
    public void testResultKoopDubbeleGameOnvoldoendeBudget(){
        boolean gelukt = koperArm.koop(game2);
        gelukt = koperArm.koop(game2);
        assertEquals(false, gelukt, "Game is al in bezit en er is te weinig budget, maar koop() geeft ten onrechte terug dat de koop gelukt is.");
    }

    @Test
    public void testBudgetKoopDubbeleGameOnvoldoendeBudget(){
        boolean gelukt = koperArm.koop(game2);
        gelukt = koperArm.koop(game2);
        assertEquals(1.00, Math.round(koperArm.getBudget() * 100)/100d, "koop() levert niet het goede budget op (game is al in bezit).");
    }

    @Test
    public void testGameListKoopDubbeleGameOnvoldoendeBudget(){
        boolean gelukt = koperArm.koop(game2);
        gelukt = koperArm.koop(game2);
        assertEquals(toStringTekstKoperArm1Game + "\n" + toStringTekstGame2, koperArm.toString(),
                "koop() mag niet gelukt zijn, maar levert een fout op in, waarschijnlijk, de lijst met Games.");
    }
    //endregion

    //region tests verkoop()
    @Test
    public void testResultVerkoopGeenBezitVerkoper(){
        boolean gelukt = verkoper.verkoop(game1, koper);
        assertFalse(gelukt, "verkoop() geeft ten onrechte terug dat verkoop gelukt is.");
    }

    @Test
    public void testBudgetVerkoopGeenBezitVerkoper(){
        boolean gelukt = verkoper.verkoop(game1, koper);
        assertEquals(60, Math.round(verkoper.getBudget() * 100)/100d,"verkoop() levert niet het goede budget van de verkoper op (Game is niet in bezit verkoper).");
        assertEquals(200, Math.round(koper.getBudget() * 100)/100d,"verkoop() levert niet het goede budget van de koper op (Game is niet in bezit verkoper).");
    }

    @Test
    public void testGameListVerkoopGeenBezitVerkoper(){
        boolean gelukt = verkoper.verkoop(game1, koper);
        assertEquals(toStringTekstVerkoper0Games, verkoper.toString(),
                "verkoop() mag niet gelukt zijn (Game is niet in bezit verkoper), maar levert een fout op in, waarschijnlijk, de lijst met Games (verkoper).");
        assertEquals(toStringTekstKoper0Games, koper.toString(),
                "verkoop() mag niet gelukt zijn (Game is niet in bezit verkoper), maar levert een fout op in, waarschijnlijk, de lijst met Games (koper).");
    }

    @Test
    public void testResultVerkoopKoperOnvoldoendeBudget(){
        verkoper.koop(game1);
        boolean gelukt = verkoper.verkoop(game1, koperArm);
        assertFalse(gelukt, "verkoop() geeft ten onrechte terug dat verkoop gelukt is.");
    }

    @Test
    public void testBudgetVerkoopKoperOnvoldoendeBudget(){
        verkoper.koop(game1);
        boolean gelukt = verkoper.verkoop(game1, koperArm);
        assertEquals(10, Math.round(verkoper.getBudget() * 100)/100d,"verkoop() levert niet het goede budget van de verkoper op (game is niet verkocht).");
        assertEquals(36, Math.round(koperArm.getBudget() * 100)/100d,"verkoop() levert niet het goede budget van de koper op (game is niet verkocht).");
    }

    @Test
    public void testGameListVerkoopKoperOnvoldoendeBudget(){
        verkoper.koop(game1);
        boolean gelukt = verkoper.verkoop(game1, koperArm);
        assertEquals(toStringTekstVerkoperHeeftGame1 + "\n" + toStringTekstGame1, verkoper.toString(),
                "verkoop() mag niet gelukt zijn (koper onvoldoende budget), maar levert een fout op in, waarschijnlijk, de lijst met Games (verkoper).");
        assertEquals(toStringTekstKoper0Games, koper.toString(),
                "verkoop() mag niet gelukt zijn (koper onvoldoende budget), maar levert een fout op in, waarschijnlijk, de lijst met Games (koper).");
    }

    @Test
    public void testResultVerkoopKoperDubbeleGame(){
        verkoper.koop(game2);
        koper.koop(game2);
        boolean gelukt = verkoper.verkoop(game2, koper);
        assertFalse(gelukt, "verkoop() geeft ten onrechte terug dat verkoop gelukt is.");
    }

    @Test
    public void testBudgetVerkoopKoperDubbeleGame(){
        verkoper.koop(game2);
        koper.koop(game2);
        assertEquals(25, Math.round(verkoper.getBudget() * 100)/100d,"verkoop() levert niet het goede budget van de verkoper op (game is niet verkocht).");
        assertEquals(165, Math.round(koper.getBudget() * 100)/100d,"verkoop() levert niet het goede budget van de koper op (game is niet verkocht).");
    }

    @Test
    public void testGameListVerkoopKoperDubbeleGame(){
        verkoper.koop(game2);
        koper.koop(game2);
        assertEquals(toStringTekstVerkoperHeeftGame2 + "\n" + toStringTekstGame2, verkoper.toString(),
                "verkoop() mag niet gelukt zijn (koper heeft game al), maar levert een fout op in, waarschijnlijk, de lijst met Games (verkoper).");
        assertEquals(toStringTekstKoperHeeftGame2 + "\n" + toStringTekstGame2, koper.toString(),
                "verkoop() mag niet gelukt zijn (koper heeft game al), maar levert een fout op in, waarschijnlijk, de lijst met Games (koper).");
    }

    @Test
    public void testResultVerkoopVoorwaardenOK(){
        verkoper.koop(game2);
        boolean gelukt = verkoper.verkoop(game2, koper);
        assertTrue(gelukt, "verkoop() geeft ten onrechte terug dat verkoop niet gelukt is.");
    }

    @Test
    public void testBudgetVerkoopVoorwaardenOK(){
        verkoper.koop(game2);
        boolean gelukt = verkoper.verkoop(game2, koper);
        assertEquals(60, Math.round(verkoper.getBudget() * 100)/100d,"verkoop() levert niet het goede budget van de verkoper op (game is verkocht).");
        assertEquals(165, Math.round(koper.getBudget() * 100)/100d,"verkoop() levert niet het goede budget van de koper op (game is verkocht).");
    }

    @Test
    public void testGameListVerkoopVoorwaardenOK(){
        verkoper.koop(game2);
        boolean gelukt = verkoper.verkoop(game2, koper);
        assertEquals(toStringTekstVerkoper0Games, verkoper.toString(),
                "verkoop() moet gelukt zijn, maar levert een fout op in, waarschijnlijk, de lijst met Games (verkoper).");
        assertEquals(toStringTekstKoperHeeftGame2 + "\n" + toStringTekstGame2, koper.toString(),
                "verkoop() moet gelukt zijn, maar levert een fout op in, waarschijnlijk, de lijst met Games (koper).");
    }
    //endregion

}