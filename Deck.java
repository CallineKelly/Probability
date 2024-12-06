package probability.project;

import probability.project.Card;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Neoh
 * constructs entire deck and store in ArrayList(Card)
 */
public class Deck {
    private List<Card> cards;
    
    //construct deck
    public Deck(){
        cards = new ArrayList<>();
        String[] suits = {"Heart","Diamond","Club","Spade"};
        String[] ranks = {"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
        
        for(String suit : suits){
            for(String rank : ranks){
                cards.add(new Card(suit,rank));
            }
        }
    }
    
    //store in array
    public List<Card> getCards(){
        return cards;
    }
    
    //count the number of cards that match with suit (Heart,etc)
    //stream() use to filter cards that match with specific suit
    //apply card.getSuit in filter() and filter() will apply in stream()
    public int countFavorableOutcomesBySuit(String suit){
        return(int)cards.stream().filter(card -> card.getSuit().equalsIgnoreCase(suit)).count();
    }
    
    public int countFavorableOutcomesByRank(String rank){
        return(int)cards.stream().filter(card -> card.getRank().equalsIgnoreCase(rank)).count();
    }
    
    public int countJointOutcomes(String suit, String rank){
        return(int)cards.stream()
                .filter(card -> card.getSuit().equalsIgnoreCase(suit)
                        &&card.getRank().equalsIgnoreCase(rank))
                .count();        
    }
    
    public int getTotalOutcomes(){
        return cards.size();
    }
    
    
    //appends card string from Card class & returns full deck as string
    @Override
    public String toString(){
        StringBuilder deckRepresentation = new StringBuilder();
        for (Card card :cards){
            deckRepresentation.append(card).append("\n");
        }
        return deckRepresentation.toString();
    }
}
