//package com.z.game.poker;
//
///**
// * @author zhaoxu
// * @date 2/23/2023 11:17 AM
// * @since
// */
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//public class DeckOfCards {
//    private List<Card> deck;
//
//    public DeckOfCards() {
//        deck = new ArrayList<>();
//        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
//        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
//
//        for (String suit : suits) {
//            for (String rank : ranks) {
//                deck.add(new Card(rank, suit));
//            }
//        }
//    }
//
//    public void shuffle() {
//        Collections.shuffle(deck);
//    }
//
//    public Card drawCard() {
//        if (deck.isEmpty()) {
//            return null;
//        }
//        return deck.remove(0);
//    }
//
//    public static void main(String[] args) {
//        DeckOfCards deck = new DeckOfCards();
//        deck.shuffle();
//
//        for (int i = 0; i < 5; i++) {
//            System.out.println(deck.drawCard());
//        }
//    }
//}
//
//class Card {
//    private String rank;
//    private String suit;
//
//    public Card(String rank, String suit) {
//        this.rank = rank;
//        this.suit = suit;
//    }
//
//    public String toString() {
//        return rank + " of " + suit;
//    }
//}