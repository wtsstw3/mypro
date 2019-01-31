package avail.entity;

/**
 * Created by Black on 26.09.2017.
 */
public class ResultAvailableRow {

    private String weark;
    private Long siteMaterialId;
    private Long available;
    private Long reserve;
    private Long suborder;

    public ResultAvailableRow(String weark, Long siteMaterialId, Long available, Long reserve, Long suborder) {
        this.weark = weark;
        this.siteMaterialId = siteMaterialId;
        this.available = available;
        this.reserve = reserve;
        this.suborder = suborder;
    }

    public String getWeark() {
        return weark;
    }

    public void setWeark(String weark) {
        this.weark = weark;
    }

    public Long getSiteMaterialId() {
        return siteMaterialId;
    }

    public void setSiteMaterialId(Long siteMaterialId) {
        this.siteMaterialId = siteMaterialId;
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

    public Long getSuborder() {
        return suborder;
    }

    public void setSuborder(Long suborder) {
        this.suborder = suborder;
    }
}
