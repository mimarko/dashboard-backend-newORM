/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4a.platform.persistency;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author EMantziou
 */
@Entity
@Table(name = "time_interval", schema="city4age_sr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TimeInterval.findAll", query = "SELECT t FROM TimeInterval t"),
    @NamedQuery(name = "TimeInterval.findById", query = "SELECT t FROM TimeInterval t WHERE t.id = :id"),
    @NamedQuery(name = "TimeInterval.findByIntervalStart", query = "SELECT t FROM TimeInterval t WHERE t.intervalStart = :intervalStart"),
    @NamedQuery(name = "TimeInterval.findByIntervalEnd", query = "SELECT t FROM TimeInterval t WHERE t.intervalEnd = :intervalEnd")})
public class TimeInterval implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "interval_start")
    @Temporal(TemporalType.TIMESTAMP)
    private Date intervalStart;
    @Column(name = "interval_end")
    @Temporal(TemporalType.TIMESTAMP)
    private Date intervalEnd;
   
    @JoinColumn(name = "typical_period", referencedColumnName = "typical_period")
    @ManyToOne
    private CdTypicalPeriod typicalPeriod;
    

    public TimeInterval() {
    }

    public TimeInterval(Long id) {
        this.id = id;
    }

    public TimeInterval(Long id, Date intervalStart) {
        this.id = id;
        this.intervalStart = intervalStart;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getIntervalStart() {
        return intervalStart;
    }

    public void setIntervalStart(Date intervalStart) {
        this.intervalStart = intervalStart;
    }

    public Date getIntervalEnd() {
        return intervalEnd;
    }

    public void setIntervalEnd(Date intervalEnd) {
        this.intervalEnd = intervalEnd;
    }

    public CdTypicalPeriod getTypicalPeriod() {
        return typicalPeriod;
    }

    public void setTypicalPeriod(CdTypicalPeriod typicalPeriod) {
        this.typicalPeriod = typicalPeriod;
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
        if (!(object instanceof TimeInterval)) {
            return false;
        }
        TimeInterval other = (TimeInterval) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.c4adashboardservices.TimeInterval[ id=" + id + " ]";
    }
    
}
