import java.awt.*;

public class ToJail extends Card{

    /**
     * the constructor for the card Class
     * @param name the name of that card
     * @param cost the cost of the card
     * @param position the position of the card
     * @param color the color of the card
     * @param cardType the card type of the card
     */
    public ToJail(String name, int cost, int position, Color color, CardType cardType) {
        super(name, cost, position, color, cardType, 0, 0);
    }
}
