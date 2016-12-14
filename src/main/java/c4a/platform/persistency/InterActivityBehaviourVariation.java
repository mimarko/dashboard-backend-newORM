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
@Table(name = "inter_activity_behaviour_variation", schema="city4age_sr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InterActivityBehaviourVariation.findAll", query = "SELECT i FROM InterActivityBehaviourVariation i"),
    @NamedQuery(name = "InterActivityBehaviourVariation.findById", query = "SELECT i FROM InterActivityBehaviourVariation i WHERE i.id = :id"),
    @NamedQuery(name = "InterActivityBehaviourVariation.findByDeviation", query = "SELECT i FROM InterActivityBehaviourVariation i WHERE i.deviation = :deviation")})
public class InterActivityBehaviourVariation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "deviation")
    private Float deviation;
    @JoinColumn(name = "numeric_indicator_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private NumericIndicatorValue numericIndicatorId;
    @JoinColumn(name = "real_activity_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Activity realActivityId;
    @JoinColumn(name = "expected_activity_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Activity expectedActivityId;

    public InterActivityBehaviourVariation() {
    }

    public InterActivityBehaviourVariation(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getDeviation() {
        return deviation;
    }

    public void setDeviation(Float deviation) {
        this.deviation = deviation;
    }

    public NumericIndicatorValue getNumericIndicatorId() {
        return numericIndicatorId;
    }

    public void setNumericIndicatorId(NumericIndicatorValue numericIndicatorId) {
        this.numericIndicatorId = numericIndicatorId;
    }

    public Activity getRealActivityId() {
        return realActivityId;
    }

    public void setRealActivityId(Activity realActivityId) {
        this.realActivityId = realActivityId;
    }

    public Activity getExpectedActivityId() {
        return expectedActivityId;
    }

    public void setExpectedActivityId(Activity expectedActivityId) {
        this.expectedActivityId = expectedActivityId;
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
        if (!(object instanceof InterActivityBehaviourVariation)) {
            return false;
        }
        InterActivityBehaviourVariation other = (InterActivityBehaviourVariation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.c4adashboardservices.InterActivityBehaviourVariation[ id=" + id + " ]";
    }
    
}
