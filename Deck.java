package probability.project;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Deck {
    private final List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        String[] suits = {"heart", "diamond", "club", "spade"};
        String[] ranks = {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};
        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    public int getTotalOutcomes() {
        return cards.size();
    }

    public int countFavorableOutcomesBySuit(String suit) {
        return (int) cards.stream().filter(card -> card.getSuit().equalsIgnoreCase(suit)).count();
    }

    public int countFavorableOutcomesByRank(String rank) {
        return (int) cards.stream().filter(card -> card.getRank().equalsIgnoreCase(rank)).count();
    }

    public int countJointOutcomes(String suit, String rank) {
        return (int) cards.stream()
                .filter(card -> card.getSuit().equalsIgnoreCase(suit) && card.getRank().equalsIgnoreCase(rank))
                .count();
    }

    public List<String> parseCards(String input) {
        String[] cardStrings = input.split(",");
        List<String> parsedCards = new ArrayList<>();
        for (String card : cardStrings) {
            parsedCards.add(card.trim().toLowerCase());
        }
        return parsedCards;
    }

    public int countIntersection(List<String> eventA, List<String> eventB) {
        Set<String> eventASet = new HashSet<>(eventA);
        Set<String> eventBSet = new HashSet<>(eventB);
        eventASet.retainAll(eventBSet);
        return eventASet.size();
    }

    public boolean areEventsDisjoint(List<String> eventA, List<String> eventB) {
        Set<String> eventASet = new HashSet<>(eventA);
        Set<String> eventBSet = new HashSet<>(eventB);
        eventASet.retainAll(eventBSet);
        return eventASet.isEmpty();
    }
}
