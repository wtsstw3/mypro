package avail.entity;

import java.util.ArrayList;

/**
 * Created by Vasilii Minenko on 9/26/17.
 */
public class DeliveryRow {
    int shopId;
    int goodId;
    ArrayList<String> deliveryShops;
    ArrayList<String> deliveryCities;

    public ArrayList<String> getDeliveryCities() {
        return deliveryCities;
    }

    public void setDeliveryCities(ArrayList<String> deliveryCities) {
        this.deliveryCities = deliveryCities;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public ArrayList<String> getDeliveryShops() {
        return deliveryShops;
    }

    public void setDeliveryShops(ArrayList<String> deliveryShops) {
        this.deliveryShops = deliveryShops;
    }
}
