import java.util.List;

public class ItemList implements ItemListInterface{
    String id;
    String name;
    List<Card> cards;

    public void deleteCard(Card card) {
        cards.removeIf(c -> c.id.equals(card.id));
    }

    public void createCard(Card card) {
        cards.add(card);
    }

    @Override
    public Card addCard(String name){
        Card newCard = new Card(name);
        cards.add(newCard);
        return newCard;
    }

    @Override
    public void removeCard(Card card) {
        cards.removeIf(c -> c.id.equals(card.id));
    }
}
