import java.awt.*;

/**
 * @author Andre, Jack, Cassidy, Hussein
 * This class represents the Cards/Properties in Monopoly
 *
 */
public class Card {
    private String name;
    private int cost;
    private Color color;
    private boolean isOwned;
    private Player owner;
    private int position;

    private int houses;
    private int hotels;

    private int houseCost;
    private int hotelCost;

    private CardType cardType;

    public static enum CardType {
        go,
        jail,
        property,
        railroad,
        ultility
    }


    /**
     * The constructor for the Card class
     * @param name the String for the name of the card
     * @param cost the int for the cost of the property
     * @param position the position of the card
     */
    public Card(String name, int cost, int position) {
        this(name, cost, position, null, null, 0, 0);
    }

    /**
     * the constructor for the card Class
     * @param name the name of that card
     * @param cost the cost of the card
     * @param position the position of the card
     * @param color the color of the card
     */
    public Card(String name, int cost, int position, Color color) {
        this(name,cost, position, color, null, 0, 0);
    }

    /**
     * the constructor for the card Class
     * @param name the name of that card
     * @param cost the cost of the card
     * @param position the position of the card
     * @param color the color of the card
     * @param cardType the card type of the card
     * @param houseCost the price of the house on the card
     * @param hotelCost the price of the hotel on the card
     */
    public Card(String name, int cost, int position, Color color, CardType cardType, int houseCost, int hotelCost) {
        this.name = name;
        this.cost = cost;
        this.position = position;
        this.color = color;
        this.cardType = cardType;
        this.houseCost = houseCost;
        this.hotelCost = hotelCost;
        this.isOwned = false;
    }

    /**
     * getter to see if the card is owned
     * @return returns a boolean true or false if the card is owned or not
     */
    public boolean isOwned() { return isOwned; }

    /**
     * sets if the property is owned or not
     * this method is mainly used to set a property to the not owned state
     * @param owned a boolean to set the owned status
     */
    public void setOwned(boolean owned){
        isOwned = owned;
        this.owner = null;
    }

    /**
     * This method give a player the ownership of a property
     * @param owner the Player that owns the card
     */
    public void setOwned(Player owner) {
        isOwned = true;
        this.owner = owner;
    }

    /**
     * getter for the owner of the card
     * @return Player owner
     */
    public Player getOwner(){
        return owner;
    }

    /**
     * getter for the name of the card
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * getter for the cost of the card
     * @return int the cost
     */
    public int getCost() {
        return cost;
    }

    /**
     * getter for the position of the card
     * @return the int position of the card
     */
    public int getPosition() {
        return position;
    }

    /**
     * returns the rent of the card
     * @return an int amount of the rent
     */
    public int getRent() {
        if (cardType == CardType.property) return (int) (cost * 0.1);
        else if (cardType == CardType.railroad){
            int rent = 25;
            if (this.getOwner() != null){
                for (Card card : this.getOwner().getProperties()) {
                    if (card.cardType == CardType.railroad){
                        rent = rent*2;
                    }
                }
                return rent/2;
            }
            else return rent;
        }
        else{
            if(this.getOwner() == null){
                return 0;
            }
            else if(this.getOwner().getNumUtils() == 1){
                return (this.getOwner().getPosition() - this.getOwner().getPrevPosition())*4;
            }else{
                return (this.getOwner().getPosition() - this.getOwner().getPrevPosition())*10;
            }

        }
    }

    /**
     * getter for the card type
     * @return the CardType enum
     */
    public CardType getCardType() {
        return cardType;
    }

    /**
     * getter for the number of hotels
     * @return the int number of hotels
     */
    public int getHotels() {
        return hotels;
    }

    /**
     * getter for the number of houses
     * @return the int number of houses
     */
    public int getHouses() {
        return houses;
    }

    /**
     * getter for the house cost
     * @return the int house cost
     */
    public int getHouseCost() {
        return houseCost;
    }

    /**
     * getter for the hotel host
     * @return the int hotel cost
     */
    public int getHotelCost() {
        return hotelCost;
    }

    /**
     * The getter for color of the card
     * @return the Color of the card tile
     */
    public Color getColor() {
        return this.color;
    }


    /**
     * Setter for the houses
     * @param houses the int of the number of house
     */
    public void setHouses(int houses) {
        this.houses = houses;
    }

    /**
     * Setter for the hotels
     * @param hotels the int for the number of hotels
     */
    public void setHotels(int hotels) {
        this.hotels = hotels;
    }

    /**
     * Setter for the value of the tile
     * @param cost the int for the price of the tile
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * Checks if the property is owned by a player
     * @param p the player on the card
     * @return the int of whether the card has an owner, no owner, or if the owner is p
     */
    public int functionality(Player p){
        if(getCardType().equals(CardType.jail)){
            System.out.println("Function 3");
            return 3;
        }
        if (this.owner == null){
            return 0;
        }
        else{
            if (this.owner.getName().equals(p.getName())){
                return 1;
            }
            return 2;
        }
        // if owner
        // no owner
        // is owned
    }
}
