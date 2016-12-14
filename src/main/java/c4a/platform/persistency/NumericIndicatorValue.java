/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4a.platform.persistency;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


/**
 *
 * @author EMantziou
 */
@Entity
@Table(name = "numeric_indicator_value", schema="city4age_sr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NumericIndicatorValue.findAll", query = "SELECT n FROM NumericIndicatorValue n"),
    @NamedQuery(name = "NumericIndicatorValue.findById", query = "SELECT n FROM NumericIndicatorValue n WHERE n.id = :id"),
    @NamedQuery(name = "NumericIndicatorValue.findByNuiValue", query = "SELECT n FROM NumericIndicatorValue n WHERE n.nuiValue = :nuiValue")})
public class NumericIndicatorValue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "nui_value")
    private BigDecimal nuiValue;
   
    @JoinColumn(name = "user_in_role_id", referencedColumnName = "id")
    @ManyToOne
    private UserInRole userInRoleId;
    @JoinColumn(name = "time_interval_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TimeInterval timeIntervalId;
    @JoinColumn(name = "nui_type_id", referencedColumnName = "id")
    @ManyToOne
    private CdDetectionVariable nuiTypeId;
    @JoinColumn(name = "data_source_type", referencedColumnName = "data_source_type")
    @ManyToOne
    private CdDataSourceType dataSourceType;

    public NumericIndicatorValue() {
    }

    public NumericIndicatorValue(Long id) {
        this.id = id;
    }

    public NumericIndicatorValue(Long id, BigDecimal nuiValue) {
        this.id = id;
        this.nuiValue = nuiValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getNuiValue() {
        return nuiValue;
    }

    public void setNuiValue(BigDecimal nuiValue) {
        this.nuiValue = nuiValue;
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

    public CdDetectionVariable getNuiTypeId() {
        return nuiTypeId;
    }

    public void setNuiTypeId(CdDetectionVariable nuiTypeId) {
        this.nuiTypeId = nuiTypeId;
    }

    public CdDataSourceType getDataSourceType() {
        return dataSourceType;
    }

    public void setDataSourceType(CdDataSourceType dataSourceType) {
        this.dataSourceType = dataSourceType;
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
        if (!(object instanceof NumericIndicatorValue)) {
            return false;
        }
        NumericIndicatorValue other = (NumericIndicatorValue) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.c4adashboardservices.NumericIndicatorValue[ id=" + id + " ]";
    }
    
}
