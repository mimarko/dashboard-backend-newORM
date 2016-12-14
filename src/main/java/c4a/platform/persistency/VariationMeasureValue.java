/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4a.platform.persistency;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author EMantziou
 */
@Entity
@Table(name = "variation_measure_value", schema="city4age_sr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VariationMeasureValue.findAll", query = "SELECT v FROM VariationMeasureValue v"),
    @NamedQuery(name = "VariationMeasureValue.findById", query = "SELECT v FROM VariationMeasureValue v WHERE v.id = :id"),
    @NamedQuery(name = "VariationMeasureValue.findByMeasureValue", query = "SELECT v FROM VariationMeasureValue v WHERE v.measureValue = :measureValue")})
public class VariationMeasureValue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "measure_value")
    private Float measureValue;
    @JoinColumn(name = "user_in_role_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UserInRole userInRoleId;
    @JoinColumn(name = "time_interval_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TimeInterval timeIntervalId;
    @JoinColumn(name = "measure_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CdDetectionVariable measureTypeId;
    @JoinColumn(name = "data_source_type", referencedColumnName = "data_source_type")
    @ManyToOne
    private CdDataSourceType dataSourceType;
    @JoinColumn(name = "activity_id", referencedColumnName = "id")
    @ManyToOne
    private Activity activityId;

    public VariationMeasureValue() {
    }

    public VariationMeasureValue(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getMeasureValue() {
        return measureValue;
    }

    public void setMeasureValue(Float measureValue) {
        this.measureValue = measureValue;
    }

    public UserInRole getUserInRoleId() {
        return userInRoleId;
    }

    public void setUserInRoleId(UserInRole userInRoleId) {
        this.userInRoleId = userInRoleId;
    }

    public TimeInterval getTimeIntervalId() {
        return timeIntervalId;
    }

    public void setTimeIntervalId(TimeInterval timeIntervalId) {
        this.timeIntervalId = timeIntervalId;
    }

    public CdDetectionVariable getMeasureTypeId() {
        return measureTypeId;
    }

    public void setMeasureTypeId(CdDetectionVariable measureTypeId) {
        this.measureTypeId = measureTypeId;
    }

    public CdDataSourceType getDataSourceType() {
        return dataSourceType;
    }

    public void setDataSourceType(CdDataSourceType dataSourceType) {
        this.dataSourceType = dataSourceType;
    }

    public Activity getActivityId() {
        return activityId;
    }

    public void setActivityId(Activity activityId) {
        this.activityId = activityId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VariationMeasureValue)) {
            return false;
        }
        VariationMeasureValue other = (VariationMeasureValue) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.c4adashboardservices.VariationMeasureValue[ id=" + id + " ]";
    }
    
}
