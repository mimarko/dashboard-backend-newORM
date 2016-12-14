/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4a.platform.persistency;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author EMantziou
 */
@Embeddable
public class AssessmentAudienceRolePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "assessment_id")
    private int assessmentId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "role_id")
    private short roleId;

    public AssessmentAudienceRolePK() {
    }

    public AssessmentAudienceRolePK(int assessmentId, short roleId) {
        this.assessmentId = assessmentId;
        this.roleId = roleId;
    }

    public int getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(int assessmentId) {
        this.assessmentId = assessmentId;
    }

    public short getRoleId() {
        return roleId;
    }

    public void setRoleId(short roleId) {
        this.roleId = roleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) assessmentId;
        hash += (int) roleId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AssessmentAudienceRolePK)) {
            return false;
        }
        AssessmentAudienceRolePK other = (AssessmentAudienceRolePK) object;
        if (this.assessmentId != other.assessmentId) {
            return false;
        }
        if (this.roleId != other.roleId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.c4adashboardservices.AssessmentAudienceRolePK[ assessmentId=" + assessmentId + ", roleId=" + roleId + " ]";
    }
    
}
