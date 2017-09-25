package avail.entity;

/**
 * Created by Black on 26.09.2017.
 */
public class AvailableRow {

    public String weark;
    public Long materialId;
    public Long siteMaterialId;
    public Long materialTypeId;
    public Long available;
    public Long reserve;

    public AvailableRow(String weark, Long materialId, Long siteMaterialId, Long materialTypeId, Long available, Long reserve) {
        this.weark = weark;
        this.materialId = materialId;
        this.siteMaterialId = siteMaterialId;
        this.materialTypeId = materialTypeId;
        this.available = available;
        this.reserve = reserve;
    }

    public String getWeark() {
        return weark;
    }

    public void setWeark(String weark) {
        this.weark = weark;
    }

    public Long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }

    public Long getSiteMaterialId() {
        return siteMaterialId;
    }

    public void setSiteMaterialId(Long siteMaterialId) {
        this.siteMaterialId = siteMaterialId;
    }

    public Long getMaterialTypeId() {
        return materialTypeId;
    }

    public void setMaterialTypeId(Long materialTypeId) {
        this.materialTypeId = materialTypeId;
    }

    public Long getAvailable() {
        return available;
    }

    public void setAvailable(Long available) {
        this.available = available;
    }

    public Long getReserve() {
        return reserve;
    }

    public void setReserve(Long reserve) {
        this.reserve = reserve;
    }


}
