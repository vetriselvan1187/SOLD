package sold;

import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Comparator;

/**
 *  Auction System class to handle seller auction
 *
 */
class Auction {
    private User seller;
    private double low;
    private double high;
    private double actual;
    private List<Bid> bidList = new ArrayList<Bid>();

    public static Auction createNew(User seller, double low, double high, double actual) {
        Auction auction = new Auction();
        auction.setSeller(seller);
        auction.setHigh(high);
        auction.setLow(low);
        auction.setActual(actual);
        return auction;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public void setActual(double actual) {
        this.actual = actual;
    }

    public double getActual() {
        return this.actual;
    }

    public List<Bid> getBidList() {
        return bidList;
    }

    public void addNewBid(Bid bid) {
        this.bidList.add(bid);
    }

    public boolean withDrawBid(Bid bid) {
        return bidList.remove(bid);
    }

    // get winning bid
    public Bid getWinningBid() {
        Bid minByPrice = bidList
                .stream()
                .sorted(Comparator.comparing(Bid::getBuyerName).reversed())
                .sorted(Comparator.comparing(Bid::getPrice))
                .min(Comparator.comparing(Bid::getPrice))
                .orElseThrow(NoSuchElementException::new);
        return minByPrice;
    }

    // get total cost
    public double getTotalCost() {
        Bid bid = getWinningBid();
        double totalCost = bid.getPrice() + (20 * (bidList.size() * bid.getParticipationCost()) / 100);
        return totalCost;
    }

    // get profit or loss
    public String getProfitOrLoss() {
        Bid bid = getWinningBid();
        double percent = bid.getPrice() < actual ? ((actual-bid.getPrice())/actual) * 100 : ((bid.getPrice()-actual)/actual) * 100;
        StringBuilder sb = new StringBuilder();
        sb.append(percent).append(bid.getPrice() < actual ? " loss" : " profit");
        return sb.toString();
    }

    // getCommision cost
    public double getCommision() {
        return 80 * (bidList.size() * Bid.getParticipationCost()) / 100;
    }

    public void setBidList(List<Bid> bidList) {
        this.bidList = bidList;
    }

    @Override
    public String toString() {
        return "Auction{" +
                "seller=" + seller +
                ", low=" + low +
                ", high=" + high +
                ", bidList=" + bidList +
                '}';
    }
}
