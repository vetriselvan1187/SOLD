package sold;

/**
 *  Bid class to create new bid
 */
class Bid {
    private int id;
    private User buyer;
    private String buyerName;
    private double price;
    private static final double PARTICIPATION_COST = 1.00;

    public static Bid createNew(int id, User buyer, double price) {
        return new Bid(id, buyer, price);
    }

    public Bid(int id, User buyer, double price) {
        this.id = id;
        this.buyer = buyer;
        this.buyerName = buyer.getName();
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static double getParticipationCost() {
        return PARTICIPATION_COST;
    }

    public User getUser() {
        return this.buyer;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public String getBuyerName() {
        return this.buyerName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Bid{" +
                "buyer=" + buyer +
                ", price=" + price +
                '}';
    }
}
