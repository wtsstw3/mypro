package avail.entity;

/**
 * Created by Black on 26.09.2017.
 */
public class AvailableRow {

    private String shopId;
    private Long goodId;
    private Long sapGoodId;
    private Long sapMaterialTypeId;
    private Long availableCount;
    private Long reserveCount;

    public AvailableRow(String shopId, Long goodId, Long sapGoodId, Long sapMaterialTypeId, Long availableCount, Long reserveCount) {
        this.shopId = shopId;
        this.goodId = goodId;
        this.sapGoodId = sapGoodId;
        this.sapMaterialTypeId = sapMaterialTypeId;
        this.availableCount = availableCount;
        this.reserveCount = reserveCount;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public Long getSapGoodId() {
        return sapGoodId;
    }

    public void setSapGoodId(Long sapGoodId) {
        this.sapGoodId = sapGoodId;
    }

    public Long getGoodId() {
        return goodId;
    }

    public void setGoodId(Long goodId) {
        this.goodId = goodId;
    }

    public Long getSapMaterialTypeId() {
        return sapMaterialTypeId;
    }

    public void setSapMaterialTypeId(Long sapMaterialTypeId) {
        this.sapMaterialTypeId = sapMaterialTypeId;
    }

    public Long getAvailableCount() {
        return availableCount;
    }

    public void setAvailableCount(Long availableCount) {
        this.availableCount = availableCount;
    }

    public Long getReserveCount() {
        return reserveCount;
    }

    public void setReserveCount(Long reserveCount) {
        this.reserveCount = reserveCount;
    }


}
