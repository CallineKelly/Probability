package probability.project;

import probability.project.Card;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Neoh,Tan
 * constructs entire deck and store in ArrayList(Card)
 */
public class Deck {
    private List<Card> cards;
    
    //construct deck
    public Deck(){
        cards = new ArrayList<>();
        String[] suits = {"heart","diamond","club","spade"};
        String[] ranks = {"ace","2","3","4","5","6","7","8","9","10","jack","queen","king"};
        
        for(String suit : suits){
            for(String rank : ranks){
                cards.add(new Card(suit,rank));
            }
        }
    }
    
    public boolean isValidCard(String cardString){
        // Parse the card string into suit and rank
        String[] parts = cardString.split(" ");
            if (parts.length != 2) { 
                return false; // Invalid format
            }

        String suit = parts[0].toLowerCase();
        String rank = parts[1].toLowerCase();

        // Create a Card object from the parsed values
        Card card = new Card(suit, rank);

        // Check if the card exists in the deck
        return cards.contains(card);
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
    
    public List<String> parseCards(String input){
        List<String> cards = new ArrayList<>();
            String[] cardArray = input.split(","); // Split input into individual cards
            for (String card : cardArray) {
                card = card.trim(); // Remove extra spaces
                if (isValidCard(card)) { // Check if card is valid
                    cards.add(card); // Add valid card to the list
                } else {
                    System.out.println("Invalid card input: " + card); // Warn if invalid
                }
            }
        return cards; // Return the list of valid cards
    }
    
    public boolean areEventsDisjoint(List<String> eventACards, List<String> eventBCards) {
            for (String cardA : eventACards) { // Loop through each card in Event A
                if (eventBCards.contains(cardA)) { // Check if Event B contains this card
                    return false; // If found, events are NOT disjoint
                }
            }
        return true; // No overlap found, events are disjoint
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
