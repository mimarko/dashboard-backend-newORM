/*
 * City4Age Project
 * Horizon 2020  * 
 */
package c4a.platform.bl;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mnou2
 */
public class Item {
    
    private Long id;
    private Float value;
    private Integer gefTypeId;
    

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the value
     */
    public Float getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(Float value) {
        this.value = value;
    }

    /**
     * @return the gefTypeId
     */
    public Integer getGefTypeId() {
        return gefTypeId;
    }

    /**
     * @param gefTypeId the gefTypeId to set
     */
    public void setGefTypeId(Integer gefTypeId) {
        this.gefTypeId = gefTypeId;
    }
    
    
    
}
