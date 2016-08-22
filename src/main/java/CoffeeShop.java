/**
 * Created by Ben on 8/22/16.
 */
public class CoffeeShop {
    private String name;
    private int rating;
    private int price;

    public CoffeeShop(String name, int rating, int price) {
        this.name = name;
        this.rating = rating;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
