package avail.entity;

/**
 * Created by Black on 26.09.2017.
 */
public class Restriction {

    private String type;
    private Long id;

    public Restriction(String type, Long id) {
        this.type = type;
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
