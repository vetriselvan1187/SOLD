package sold;

import java.util.List;
import java.util.ArrayList;

/**
 *  1. create a seller
 *  2. create a buyer
 *  3. auction creation by registered seller
 *  4. bid on auction by an registered buyer
 *  5. bid amount can be updated by buyer
 *  6. withdraw bid
 *  7. close an auction and return the winning bid
 *  8. profit/loss of any seller till now;
 */

public class AuctionSystemMain {

    private static double[] priceArr = { 19.0, 19.0, 17.0, 17.0, 13.0 };

    public static void main(String[] args) {

        //create a new seller
        User seller = UsersRepository.createUser(IDGenerator.getSellerID(), "Seller");
        AuctionSystem auctionSystem = AuctionSystem.getInstance();
        auctionSystem.createNewAction(seller, Auction.createNew(seller, 9.0, 25.0, 15.0));

        List<Bid> withDrawList = new ArrayList<>();
        for(int i=0; i<5; i++) {
            // create a new buyer
            int id = IDGenerator.getBuyerID();
            String buyerName = "Buyer"+id;
            User buyer = UsersRepository.createUser(id, buyerName);

            //add new bid
            int bidId = IDGenerator.getBidID();
            Bid bid = Bid.createNew(bidId, buyer, priceArr[i]);
            bid.setBuyer(buyer);
            auctionSystem.getAuction(seller).addNewBid(bid);

            // withdraw bid
            if(bid.getId() == 5)
                withDrawList.add(bid);
        }
        // get the winning bid
        System.out.println(auctionSystem.getWinningBid(seller));
        String profitOrLoss = auctionSystem.getAuction(seller).getProfitOrLoss();
        System.out.println(profitOrLoss);
        auctionSystem.withDrawBid(seller, withDrawList.get(0));
        System.out.println(auctionSystem.getWinningBid(seller));
    }
}
