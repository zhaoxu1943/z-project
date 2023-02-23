//package com.z.game.pokerA;
//
//
//import java.util.*;
//
///**
// * @author zhaoxu
// * @date 2/23/2023 11:16 AM
// * @since
// */
//public class BlackA {
//    private static final int NUM_PLAYERS = 4;
//    private static final int NUM_CARDS_PER_PLAYER = 13;
//
//    private List<Card> deck;
//    private List<Card> playedCards;
//    private List<Player> players;
//    private int currentPlayerIndex;
//    private boolean roundOver;
//
//    public BlackA() {
//        deck = new ArrayList<>();
//        playedCards = new ArrayList<>();
//        players = new ArrayList<>();
//        for (int i = 0; i < NUM_PLAYERS; i++) {
//            players.add(new Player("Player " + (i + 1)));
//        }
//        currentPlayerIndex = 0;
//        roundOver = false;
//        initializeDeck();
//    }
//
//    private void initializeDeck() {
//        String[] suits = {"Spades", "Hearts", "Clubs", "Diamonds"};
//        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
//
//        for (String suit : suits) {
//            for (String rank : ranks) {
//                deck.add(new Card(rank, suit));
//            }
//        }
//    }
//
//    public void play() {
//        shuffleDeck();
//        dealCards();
//        while (!roundOver) {
//            Player currentPlayer = players.get(currentPlayerIndex);
//            System.out.println("It is " + currentPlayer.getName() + "'s turn.");
//            System.out.println("Cards played:");
//            for (Card card : playedCards) {
//                System.out.println(card);
//            }
//            System.out.println("Your hand:");
//            for (Card card : currentPlayer.getHand()) {
//                System.out.println(card);
//            }
//            Card playedCard = currentPlayer.playCard();
//            System.out.println("You played: " + playedCard);
//            playedCards.add(playedCard);
//            if (playedCard.getRank().equals("A")) {
//                System.out.println("Black A! " + currentPlayer.getName() + " loses this round!");
//                currentPlayer.setScore(currentPlayer.getScore() + 1);
//                if (currentPlayer.getScore() == 3) {
//                    System.out.println("Game over! " + currentPlayer.getName() + " loses the game!");
//                    roundOver = true;
//                } else {
//                    startNewRound();
//                }
//            } else {
//                currentPlayerIndex = (currentPlayerIndex + 1) % NUM_PLAYERS;
//            }
//        }
//    }
//
//    private void shuffleDeck() {
//        Collections.shuffle(deck);
//    }
//
//    private void dealCards() {
//        for (int i = 0; i < NUM_CARDS_PER_PLAYER; i++) {
//            for (Player player : players) {
//                player.addToHand(deck.remove(0));
//            }
//        }
//    }
//
//    private void startNewRound() {
//        playedCards.clear();
//        for (Player player : players) {
//            player.clearHand();
//        }
//        initializeDeck();
//        shuffleDeck();
//        dealCards();
//        currentPlayerIndex = (currentPlayerIndex + 1) % NUM_PLAYERS;
//    }
//
//    public static void main(String[] args) {
//        BlackA game = new BlackA();
//        game.play();
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
//    public String getRank() {
//        return rank;
//    }
//
//    public String getSuit() {
//        return suit;
//    }
//
//    public String toString() {
//        return rank + " of " + suit;
//    }
//}
//
//class Player {
//    private String name;
//}
