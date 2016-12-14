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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


/**
 *
 * @author EMantziou
 */
@Entity
@Table(name = "geriatric_factor_value", schema="city4age_sr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GeriatricFactorValue.findAll", query = "SELECT g FROM GeriatricFactorValue g"),
    @NamedQuery(name = "GeriatricFactorValue.findById", query = "SELECT g FROM GeriatricFactorValue g WHERE g.id = :id"),
    @NamedQuery(name = "GeriatricFactorValue.findByGefValue", query = "SELECT g FROM GeriatricFactorValue g WHERE g.gefValue = :gefValue"),
    @NamedQuery(name = "GeriatricFactorValue.findByDerivationWeight", query = "SELECT g FROM GeriatricFactorValue g WHERE g.derivationWeight = :derivationWeight")})
public class GeriatricFactorValue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "gef_value")
    private BigDecimal gefValue;
    @Column(name = "derivation_weight")
    private BigDecimal derivationWeight;
    
    @JoinColumn(name = "user_in_role_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UserInRole userInRoleId;
    @JoinColumn(name = "time_interval_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TimeInterval timeIntervalId;
    @JoinColumn(name = "gef_type_id", referencedColumnName = "id")
    @ManyToOne
    private CdDetectionVariable gefTypeId;
    @JoinColumn(name = "data_source_type", referencedColumnName = "data_source_type")
    @ManyToOne
    private CdDataSourceType dataSourceType;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "geriatricFactorValue")
    private SourceEvidence sourceEvidence;

    public GeriatricFactorValue() {
    }

    public GeriatricFactorValue(Long id) {
        this.id = id;
    }

    public GeriatricFactorValue(Long id, BigDecimal gefValue) {
        this.id = id;
        this.gefValue = gefValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getGefValue() {
        return gefValue;
    }

    public void setGefValue(BigDecimal gefValue) {
        this.gefValue = gefValue;
    }

    public BigDecimal getDerivationWeight() {
        return derivationWeight;
    }

    public void setDerivationWeight(BigDecimal derivationWeight) {
        this.derivationWeight = derivationWeight;
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

    public CdDetectionVariable getGefTypeId() {
        return gefTypeId;
    }

    public void setGefTypeId(CdDetectionVariable gefTypeId) {
        this.gefTypeId = gefTypeId;
    }

    public CdDataSourceType getDataSourceType() {
        return dataSourceType;
    }

    public void setDataSourceType(CdDataSourceType dataSourceType) {
        this.dataSourceType = dataSourceType;
    }

    public SourceEvidence getSourceEvidence() {
        return sourceEvidence;
    }

    public void setSourceEvidence(SourceEvidence sourceEvidence) {
        this.sourceEvidence = sourceEvidence;
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
        if (!(object instanceof GeriatricFactorValue)) {
            return false;
        }
        GeriatricFactorValue other = (GeriatricFactorValue) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.c4adashboardservices.GeriatricFactorValue[ id=" + id + " ]";
    }
    
}
