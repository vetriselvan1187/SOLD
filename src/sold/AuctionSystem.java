package sold;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *  Auction System class to store and process auctions.
 */
class AuctionSystem {

    private static Map<User, Auction> auctionMap = new ConcurrentHashMap<User, Auction>();
    private static AuctionSystem auctionSystem = new AuctionSystem();

    private AuctionSystem(){}

    public static AuctionSystem getInstance() {
        return auctionSystem;
    }

    public void createNewAction(User seller, Auction auction) {
        this.auctionMap.put(seller, auction);
    }

    public Auction getAuction(User seller) {
        return this.auctionMap.get(seller);
    }

    /**
     * action is closed
     * @param seller
     */
    public void closeAuction(User seller) {
        this.auctionMap.remove(seller);
    }

    public Bid getWinningBid(User seller){
        return auctionSystem.getAuction(seller).getWinningBid();
    }

    public boolean withDrawBid(User seller, Bid bid) {
        return auctionSystem.getAuction(seller).withDrawBid(bid);
    }
}
