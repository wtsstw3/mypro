package avail.entity;

import java.util.Set;

public class DeliveryRow {
    String shopId;
    Long goodId;
    Set<String> deliveryShops;
    Set<String> deliveryCities;

    public DeliveryRow(String shopId, Long goodId, Set<String> deliveryShops, Set<String> deliveryCities) {
        this.shopId = shopId;
        this.goodId = goodId;
        this.deliveryShops = deliveryShops;
        this.deliveryCities = deliveryCities;
    }


    public Set<String> getDeliveryCities() {
        return deliveryCities;
    }

    public void setDeliveryCities(Set<String> deliveryCities) {
        this.deliveryCities = deliveryCities;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public Long getGoodId() {
        return goodId;
    }

    public void setGoodId(Long goodId) {
        this.goodId = goodId;
    }

    public Set<String> getDeliveryShops() {
        return deliveryShops;
    }

    public void setDeliveryShops(Set<String> deliveryShops) {
        this.deliveryShops = deliveryShops;
    }
}
