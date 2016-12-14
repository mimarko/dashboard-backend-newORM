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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author EMantziou
 */
@Entity
@Table(name = "assessment_audience_role", schema="city4age_sr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AssessmentAudienceRole.findAll", query = "SELECT a FROM AssessmentAudienceRole a"),
    @NamedQuery(name = "AssessmentAudienceRole.findByAssessmentId", query = "SELECT a FROM AssessmentAudienceRole a WHERE a.assessmentAudienceRolePK.assessmentId = :assessmentId"),
    @NamedQuery(name = "AssessmentAudienceRole.findByRoleId", query = "SELECT a FROM AssessmentAudienceRole a WHERE a.assessmentAudienceRolePK.roleId = :roleId"),
    @NamedQuery(name = "AssessmentAudienceRole.findByAssigned", query = "SELECT a FROM AssessmentAudienceRole a WHERE a.assigned = :assigned")})
public class AssessmentAudienceRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AssessmentAudienceRolePK assessmentAudienceRolePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "assigned")
    @Temporal(TemporalType.TIMESTAMP)
    private Date assigned;
    @JoinColumn(name = "role_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CdRole cdRole;
    @JoinColumn(name = "assessment_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Assessment assessment;

    public AssessmentAudienceRole() {
    }

    public AssessmentAudienceRole(AssessmentAudienceRolePK assessmentAudienceRolePK) {
        this.assessmentAudienceRolePK = assessmentAudienceRolePK;
    }

    public AssessmentAudienceRole(AssessmentAudienceRolePK assessmentAudienceRolePK, Date assigned) {
        this.assessmentAudienceRolePK = assessmentAudienceRolePK;
        this.assigned = assigned;
    }

    public AssessmentAudienceRole(int assessmentId, short roleId) {
        this.assessmentAudienceRolePK = new AssessmentAudienceRolePK(assessmentId, roleId);
    }

    public AssessmentAudienceRolePK getAssessmentAudienceRolePK() {
        return assessmentAudienceRolePK;
    }

    public void setAssessmentAudienceRolePK(AssessmentAudienceRolePK assessmentAudienceRolePK) {
        this.assessmentAudienceRolePK = assessmentAudienceRolePK;
    }

    public Date getAssigned() {
        return assigned;
    }

    public void setAssigned(Date assigned) {
        this.assigned = assigned;
    }

    public CdRole getCdRole() {
        return cdRole;
    }

    public void setCdRole(CdRole cdRole) {
        this.cdRole = cdRole;
    }

    public Assessment getAssessment() {
        return assessment;
    }

    public void setAssessment(Assessment assessment) {
        this.assessment = assessment;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (assessmentAudienceRolePK != null ? assessmentAudienceRolePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AssessmentAudienceRole)) {
            return false;
        }
        AssessmentAudienceRole other = (AssessmentAudienceRole) object;
        if ((this.assessmentAudienceRolePK == null && other.assessmentAudienceRolePK != null) || (this.assessmentAudienceRolePK != null && !this.assessmentAudienceRolePK.equals(other.assessmentAudienceRolePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.c4adashboardservices.AssessmentAudienceRole[ assessmentAudienceRolePK=" + assessmentAudienceRolePK + " ]";
    }
    
}
