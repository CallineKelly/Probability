package probability.project;

import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Neoh
 * get suit and rank from Deck class
 */
public class Card {
    private String suit;
    private String rank;
    
    public Card(String suit, String rank){
        this.suit = suit;
        this.rank = rank;
    }
    
    public String getSuit(){
        return suit;
    }
    
    public String getRank(){
        return rank;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Card card = (Card) obj;
        return suit.equals(card.suit) && rank.equals(card.rank);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(suit, rank);
    }
    
    //help to return string like "Ace of Hearts", "2 of Hearts"
    @Override
    public String toString(){
        return rank + " of " +suit;
    }
}
