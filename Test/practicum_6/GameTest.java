package practicum_6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game1JrOud;
    private int ditJaar;

    @BeforeEach
    public void init(){
        ditJaar = LocalDate.now().getYear();
        game1JrOud = new Game("Mario Kart", ditJaar-1, 50.0);
    }

    //region Tests met huidigeWaarde()
    @Test
    public void testHuidigeWaardeNwPrijsNa0Jr(){
        Game game0JrOud = new Game("Mario Kart", ditJaar, 50.0);
        assertEquals(50.0, Math.round(game0JrOud.huidigeWaarde() * 100)/100d, "Huidige waarde na 0 jr niet correct.");
    }

    @Test
    public void testHuidigeWaardeNwPrijsNa1Jr(){
        assertEquals(35.0, Math.round(game1JrOud.huidigeWaarde() * 100)/100d, "Huidige waarde na 1 jr niet correct.");
    }

    @Test
    public void testHuidigeWaardeNwPrijsNa5Jr(){
        Game game5JrOud = new Game("Mario Kart", ditJaar-5, 50.0);
        assertEquals(8.4, Math.round(game5JrOud.huidigeWaarde() * 100)/100d, "Huidige waarde na 5 jr niet correct.");
    }

    @Test
    public void testHuidigeWaardeGratisGameNa0Jr(){
        Game gratisGame0JrOud = new Game("Mario Kart Free", ditJaar, 0.0);
        assertEquals(0.0, Math.round(gratisGame0JrOud.huidigeWaarde() * 100)/100d, "Huidige waarde gratis game na 0 jr niet correct.");
    }

    @Test
    public void testHuidigeWaardeGratisGameNa5Jr(){
        Game gratisGame5JrOud = new Game("Mario Kart Free", ditJaar-5, 0.0);
        assertEquals(0.0, Math.round(gratisGame5JrOud.huidigeWaarde() * 100)/100d, "Huidige waarde gratis game na 5 jr niet correct.");
    }

    //endregion

    //region Tests met equals()
    @Test
    public void testGameEqualsZelfdeGame() {
        Game zelfdeGame1JrOud = new Game("Mario Kart", ditJaar-1, 50.0);
        assertTrue(game1JrOud.equals(zelfdeGame1JrOud), "equals() geeft false bij vgl. met zelfde game");
    }

    @Test
    public void testGameEqualsSelf() {
        assertTrue(game1JrOud.equals(game1JrOud), "equals() geeft false bij vgl. met zichzelf");
    }

    @Test
    public void testGameNotEqualsString() {
        assertFalse(game1JrOud.equals("testString"), "equals() geeft true bij vgl. tussen game en String");
    }

    @Test
    public void testGameNotEqualsGameAndereNaam() {
        Game otherGame1JrOud = new Game("Zelda", ditJaar-1, 35.0);
        assertFalse(game1JrOud.equals(otherGame1JrOud), "equals() geeft true bij vgl. met game met andere naam");
    }

    @Test
    public void testGameNotEqualsGameAnderJaar() {
        Game game5JrOud = new Game("Mario Kart", ditJaar-5, 50.0);
        assertFalse(game1JrOud.equals(game5JrOud), "equals() geeft true bij vgl. met game met ander releaseJaar");
    }

    @Test
    public void testGameEqualsGameAndereNwPrijs() {
        Game duurdereGame1JrOud = new Game("Mario Kart", ditJaar-1, 59.95);
        assertTrue(game1JrOud.equals(duurdereGame1JrOud), "equals() geeft false bij vgl. met zelfde game met andere nieuwprijs");
    }

    @Test
    public void testGameNotEqualsGameHeelAndereGame() {
        Game heelAndereGame = new Game("Zelda", ditJaar-2, 41.95);
        assertFalse(game1JrOud.equals(heelAndereGame), "equals() geeft true bij vgl. met heel andere game");
    }
    //endregion

    @Test
    public void testToString(){
        assertEquals("Mario Kart, uitgegeven in " + (ditJaar-1) + "; nieuwprijs: €50,00 nu voor: €35,00",
                game1JrOud.toString(), "toString() geeft niet de juiste tekst terug.");
    }

}