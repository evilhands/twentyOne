package work.schwarzmaier;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class AppTest {

    private TwentyOne twentyOne;

    @Test
    public void initDealerWin() {
        twentyOne = new TwentyOne(Arrays.asList(Suits.HQ,Suits.HA,Suits.H6,Suits.DK));
        twentyOne.run();
        assertTrue(twentyOne.getWonDealer());
        assertFalse(twentyOne.getWonSam());
    }

    @Test
    public void initSamWin() {
        twentyOne = new TwentyOne(Arrays.asList(Suits.HA,Suits.HQ,Suits.DK,Suits.H6));
        twentyOne.run();
        assertFalse(twentyOne.getWonDealer());
        assertTrue(twentyOne.getWonSam());
    }

    @Test
    public void initSamWin_bothBJ() {
        twentyOne = new TwentyOne(Arrays.asList(Suits.HQ,Suits.SQ,Suits.HA,Suits.SA));
        twentyOne.run();
        assertFalse(twentyOne.getWonDealer());
        assertTrue(twentyOne.getWonSam());
    }

    @Test
    public void initDealerWin_bothBust() {
        twentyOne = new TwentyOne(Arrays.asList(Suits.CA,Suits.DA,Suits.HA,Suits.SA));
        twentyOne.run();
        assertTrue(twentyOne.getWonDealer());
        assertFalse(twentyOne.getWonSam());
    }

    // @Test
    // public void initNoWinner() {
    //     twentyOne = new TwentyOne(Arrays.asList(Suits.C2,Suits.D2,Suits.H2,Suits.S2));
    //     twentyOne.run();
    //     assertFalse(twentyOne.getWonDealer());
    //     assertFalse(twentyOne.getWonSam());
    // }

    @Test
    public void dealerWin_SamNotCards1() {
        twentyOne = new TwentyOne(Arrays.asList(Suits.HQ,Suits.HA,Suits.H7,Suits.DK));
        twentyOne.run();
        assertTrue(twentyOne.getWonDealer());
        assertFalse(twentyOne.getWonSam());
        assertTrue(twentyOne.getSamCardCount() == 2);
    }

    @Test
    public void dealerWin_SamNotCards2() {
        twentyOne = new TwentyOne(Arrays.asList(Suits.HQ,Suits.HA,Suits.H8,Suits.DK));
        twentyOne.run();
        assertTrue(twentyOne.getWonDealer());
        assertFalse(twentyOne.getWonSam());
        assertTrue(twentyOne.getSamCardCount() == 2);
    }

    @Test
    public void dealerWin_samhigher() {
        twentyOne = new TwentyOne(Arrays.asList(Suits.HQ,Suits.HA,Suits.H6,Suits.D5, Suits.C10));
        twentyOne.run();
        assertTrue(twentyOne.getWonDealer());
        assertFalse(twentyOne.getWonSam());
        assertTrue(twentyOne.getSamCardCount() == 3);
    }

    @Test
    public void samWin_dealerHigher() {
        twentyOne = new TwentyOne(Arrays.asList(Suits.HQ,Suits.HA,Suits.H6,Suits.D5, Suits.C4, Suits.C6));
        twentyOne.run();
        assertFalse(twentyOne.getWonDealer());
        assertTrue(twentyOne.getWonSam());
        assertTrue(twentyOne.getSamCardCount() == 3);
    }

    @Test
    public void dealerWin_dealerBJ() {
        twentyOne = new TwentyOne(Arrays.asList(Suits.HQ,Suits.HA,Suits.H6,Suits.D5, Suits.C4, Suits.C5));
        twentyOne.run();
        assertTrue(twentyOne.getWonDealer());
        assertFalse(twentyOne.getWonSam());
        assertTrue(twentyOne.getSamCardCount() == 3);
        assertTrue(twentyOne.getDealerCardCount() == 3);
    }
}
