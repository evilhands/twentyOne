package work.schwarzmaier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.StringJoiner;

public class TwentyOne {

    private Iterator<Suits> deck;
    private List<Suits> sam;
    private List<Suits> dealer;

    private int sum_sam;
    private int sum_dealer;

    private boolean wonSam;
    private boolean wonDealer;

    public TwentyOne() {

        deck = getShuffledDeck();
        sam = new ArrayList<Suits>();
        dealer = new ArrayList<Suits>();
    }

    public TwentyOne(List<Suits> deck) {

        this.deck = deck.iterator();
        sam = new ArrayList<Suits>();
        dealer = new ArrayList<Suits>();
    }

    private void init() {

        for (int i = 0; i < 2; i++) {
            drawSam();
            drawDealer();
        }

        if (sum_dealer == 21 && sum_sam == 21) {
            wonSam = true;
        } else if (sum_dealer == 21) {
            wonDealer = true;
        } else if (sum_sam == 21) {
            wonSam = true;
        } else if (sum_dealer > 21 && sum_sam > 21) {
            wonDealer = true;
        }
    }

    public void run() {
        init();
        roundSam();
        roundDealer();
        end();
    }

    private void drawSam() {
        Suits suit_Sam = deck.next();
        sam.add(suit_Sam);
        sum_sam = sum_sam + suit_Sam.value;

    }

    private void drawDealer() {
        Suits suit_Dealer = deck.next();
        dealer.add(suit_Dealer);
        sum_dealer = sum_dealer + suit_Dealer.value;
    }

    private void roundSam() {
        while (!wonDealer && !wonSam && sum_sam < 17) {
            drawSam();
            if (sum_sam > 21) {
                wonDealer = true;
                break;
            }
        }
    }

    private void roundDealer() {
        while (!wonDealer && !wonSam && sum_sam > sum_dealer) {
            drawDealer();
            if (sum_dealer > 21) {
                wonSam = true;
                break;
            }
        }

        if (sum_dealer > sum_sam && sum_dealer <= 21) {
            wonDealer = true;
        }
    }

    private void end() {
        if (wonDealer) {
            wonDealer();
        } else {
            wonSam();
        }
    }

    private void wonSam() {
        System.out.println("sam");
        printCards();
    }

    private void wonDealer() {
        System.out.println("dealer");
        printCards();
    }

    private void printCards() {
        printCards("sam", sam);
        printCards("dealer", dealer);
    }

    private void printCards(String name, List<Suits> suits) {
        System.out.print(name + ": ");
        StringJoiner cards = new StringJoiner(", ");
        for (Suits suit : suits) {
            if (suit != null) {
                cards.add(suit.name());
            }
        }
        System.out.println(cards.toString());
    }

    private Iterator<Suits> getShuffledDeck() {
        List<Suits> deck = Arrays.asList(Suits.values());
        Collections.shuffle(deck);
        return deck.iterator();
    }

    public boolean getWonDealer() {
        return wonDealer;
    }

    public boolean getWonSam() {
        return wonSam;
    }

    public int getSamCardCount(){
        return sam.size();
    }

    public int getDealerCardCount(){
        return dealer.size();
    }
}
