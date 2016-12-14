/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4a.platform.persistency;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author EMantziou
 */
@Entity
@Table(name = "frailty_status_timeline", schema="city4age_sr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FrailtyStatusTimeline.findAll", query = "SELECT f FROM FrailtyStatusTimeline f"),
    @NamedQuery(name = "FrailtyStatusTimeline.findByTimeIntervalId", query = "SELECT f FROM FrailtyStatusTimeline f WHERE f.frailtyStatusTimelinePK.timeIntervalId = :timeIntervalId"),
    @NamedQuery(name = "FrailtyStatusTimeline.findByChanged", query = "SELECT f FROM FrailtyStatusTimeline f WHERE f.frailtyStatusTimelinePK.changed = :changed"),
    @NamedQuery(name = "FrailtyStatusTimeline.findByUserInRoleId", query = "SELECT f FROM FrailtyStatusTimeline f WHERE f.frailtyStatusTimelinePK.userInRoleId = :userInRoleId"),
    @NamedQuery(name = "FrailtyStatusTimeline.findByFrailtyNotice", query = "SELECT f FROM FrailtyStatusTimeline f WHERE f.frailtyNotice = :frailtyNotice")})
public class FrailtyStatusTimeline implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FrailtyStatusTimelinePK frailtyStatusTimelinePK;
    @Size(max = 200)
    @Column(name = "frailty_notice")
    private String frailtyNotice;
    @JoinColumn(name = "changed_by", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UserInRole changedBy;
    @JoinColumn(name = "time_interval_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TimeInterval timeInterval;
    @JoinColumn(name = "frailty_status", referencedColumnName = "frailty_status")
    @ManyToOne(optional = false)
    private CdFrailtyStatus frailtyStatus;

    public FrailtyStatusTimeline() {
    }

    public FrailtyStatusTimeline(FrailtyStatusTimelinePK frailtyStatusTimelinePK) {
        this.frailtyStatusTimelinePK = frailtyStatusTimelinePK;
    }

    public FrailtyStatusTimeline(long timeIntervalId, Date changed, long userInRoleId) {
        this.frailtyStatusTimelinePK = new FrailtyStatusTimelinePK(timeIntervalId, changed, userInRoleId);
    }

    public FrailtyStatusTimelinePK getFrailtyStatusTimelinePK() {
        return frailtyStatusTimelinePK;
    }

    public void setFrailtyStatusTimelinePK(FrailtyStatusTimelinePK frailtyStatusTimelinePK) {
        this.frailtyStatusTimelinePK = frailtyStatusTimelinePK;
    }

    public String getFrailtyNotice() {
        return frailtyNotice;
    }

    public void setFrailtyNotice(String frailtyNotice) {
        this.frailtyNotice = frailtyNotice;
    }

    public UserInRole getChangedBy() {
        return changedBy;
    }

    public void setChangedBy(UserInRole changedBy) {
        this.changedBy = changedBy;
    }

    public TimeInterval getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(TimeInterval timeInterval) {
        this.timeInterval = timeInterval;
    }

    public CdFrailtyStatus getFrailtyStatus() {
        return frailtyStatus;
    }

    public void setFrailtyStatus(CdFrailtyStatus frailtyStatus) {
        this.frailtyStatus = frailtyStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (frailtyStatusTimelinePK != null ? frailtyStatusTimelinePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FrailtyStatusTimeline)) {
            return false;
        }
        FrailtyStatusTimeline other = (FrailtyStatusTimeline) object;
        if ((this.frailtyStatusTimelinePK == null && other.frailtyStatusTimelinePK != null) || (this.frailtyStatusTimelinePK != null && !this.frailtyStatusTimelinePK.equals(other.frailtyStatusTimelinePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.c4adashboardservices.FrailtyStatusTimeline[ frailtyStatusTimelinePK=" + frailtyStatusTimelinePK + " ]";
    }
    
}
