package sold;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicInteger;

class IDGenerator {
    private static AtomicInteger ID_SELLER_GENERATOR = new AtomicInteger();
    private static AtomicInteger ID_BUYER_GENERATOR = new AtomicInteger();
    private static AtomicInteger ID_BID_GENERATOR = new AtomicInteger();

    public static int getSellerID() {
        return ID_SELLER_GENERATOR.incrementAndGet();
    }

    public static int getBuyerID() {
        return ID_BUYER_GENERATOR.incrementAndGet();
    }

    public static int getBidID() {
        return ID_BID_GENERATOR.incrementAndGet();
    }
}
