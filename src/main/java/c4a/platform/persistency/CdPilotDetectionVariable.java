/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4a.platform.persistency;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author EMantziou
 */
@Entity
@Table(name = "cd_pilot_detection_variable", schema="city4age_sr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CdPilotDetectionVariable.findAll", query = "SELECT c FROM CdPilotDetectionVariable c"),
    @NamedQuery(name = "CdPilotDetectionVariable.findByPilotId", query = "SELECT c FROM CdPilotDetectionVariable c WHERE c.cdPilotDetectionVariablePK.pilotId = :pilotId"),
    @NamedQuery(name = "CdPilotDetectionVariable.findByDetectionVariableId", query = "SELECT c FROM CdPilotDetectionVariable c WHERE c.cdPilotDetectionVariablePK.detectionVariableId = :detectionVariableId"),
    @NamedQuery(name = "CdPilotDetectionVariable.findByDetectionVariableDescriptionFormula", query = "SELECT c FROM CdPilotDetectionVariable c WHERE c.detectionVariableDescriptionFormula = :detectionVariableDescriptionFormula")})
public class CdPilotDetectionVariable implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CdPilotDetectionVariablePK cdPilotDetectionVariablePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "detection_variable_description_formula")
    private String detectionVariableDescriptionFormula;
    @JoinColumn(name = "pilot_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pilot pilot;
    @JoinColumn(name = "detection_variable_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CdDetectionVariable cdDetectionVariable;

    public CdPilotDetectionVariable() {
    }

    public CdPilotDetectionVariable(CdPilotDetectionVariablePK cdPilotDetectionVariablePK) {
        this.cdPilotDetectionVariablePK = cdPilotDetectionVariablePK;
    }

    public CdPilotDetectionVariable(CdPilotDetectionVariablePK cdPilotDetectionVariablePK, String detectionVariableDescriptionFormula) {
        this.cdPilotDetectionVariablePK = cdPilotDetectionVariablePK;
        this.detectionVariableDescriptionFormula = detectionVariableDescriptionFormula;
    }

    public CdPilotDetectionVariable(int pilotId, short detectionVariableId) {
        this.cdPilotDetectionVariablePK = new CdPilotDetectionVariablePK(pilotId, detectionVariableId);
    }

    public CdPilotDetectionVariablePK getCdPilotDetectionVariablePK() {
        return cdPilotDetectionVariablePK;
    }

    public void setCdPilotDetectionVariablePK(CdPilotDetectionVariablePK cdPilotDetectionVariablePK) {
        this.cdPilotDetectionVariablePK = cdPilotDetectionVariablePK;
    }

    public String getDetectionVariableDescriptionFormula() {
        return detectionVariableDescriptionFormula;
    }

    public void setDetectionVariableDescriptionFormula(String detectionVariableDescriptionFormula) {
        this.detectionVariableDescriptionFormula = detectionVariableDescriptionFormula;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    public CdDetectionVariable getCdDetectionVariable() {
        return cdDetectionVariable;
    }

    public void setCdDetectionVariable(CdDetectionVariable cdDetectionVariable) {
        this.cdDetectionVariable = cdDetectionVariable;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdPilotDetectionVariablePK != null ? cdPilotDetectionVariablePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CdPilotDetectionVariable)) {
            return false;
        }
        CdPilotDetectionVariable other = (CdPilotDetectionVariable) object;
        if ((this.cdPilotDetectionVariablePK == null && other.cdPilotDetectionVariablePK != null) || (this.cdPilotDetectionVariablePK != null && !this.cdPilotDetectionVariablePK.equals(other.cdPilotDetectionVariablePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.c4adashboardservices.CdPilotDetectionVariable[ cdPilotDetectionVariablePK=" + cdPilotDetectionVariablePK + " ]";
    }
    
}
