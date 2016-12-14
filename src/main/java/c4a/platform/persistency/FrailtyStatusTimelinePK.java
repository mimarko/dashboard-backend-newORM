/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4a.platform.persistency;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author EMantziou
 */
@Embeddable
public class FrailtyStatusTimelinePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "time_interval_id")
    private long timeIntervalId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "changed")
    @Temporal(TemporalType.TIMESTAMP)
    private Date changed;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_in_role_id")
    
    private long userInRoleId;

    public FrailtyStatusTimelinePK() {
    }

    public FrailtyStatusTimelinePK(long timeIntervalId, Date changed, long userInRoleId) {
        this.timeIntervalId = timeIntervalId;
        this.changed = changed;
        this.userInRoleId = userInRoleId;
    }

    public long getTimeIntervalId() {
        return timeIntervalId;
    }

    public void setTimeIntervalId(long timeIntervalId) {
        this.timeIntervalId = timeIntervalId;
    }

    public Date getChanged() {
        return changed;
    }

    public void setChanged(Date changed) {
        this.changed = changed;
    }

    public long getUserInRoleId() {
        return userInRoleId;
    }

    public void setUserInRoleId(long userInRoleId) {
        this.userInRoleId = userInRoleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) timeIntervalId;
        hash += (changed != null ? changed.hashCode() : 0);
        hash += (int) userInRoleId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FrailtyStatusTimelinePK)) {
            return false;
        }
        FrailtyStatusTimelinePK other = (FrailtyStatusTimelinePK) object;
        if (this.timeIntervalId != other.timeIntervalId) {
            return false;
        }
        if ((this.changed == null && other.changed != null) || (this.changed != null && !this.changed.equals(other.changed))) {
            return false;
        }
        if (this.userInRoleId != other.userInRoleId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.c4adashboardservices.FrailtyStatusTimelinePK[ timeIntervalId=" + timeIntervalId + ", changed=" + changed + ", userInRoleId=" + userInRoleId + " ]";
    }
    
}
