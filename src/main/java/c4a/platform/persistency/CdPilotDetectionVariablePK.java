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
public class CdPilotDetectionVariablePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "pilot_id")
    private int pilotId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "detection_variable_id")
    private short detectionVariableId;

    public CdPilotDetectionVariablePK() {
    }

    public CdPilotDetectionVariablePK(int pilotId, short detectionVariableId) {
        this.pilotId = pilotId;
        this.detectionVariableId = detectionVariableId;
    }

    public int getPilotId() {
        return pilotId;
    }

    public void setPilotId(int pilotId) {
        this.pilotId = pilotId;
    }

    public short getDetectionVariableId() {
        return detectionVariableId;
    }

    public void setDetectionVariableId(short detectionVariableId) {
        this.detectionVariableId = detectionVariableId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) pilotId;
        hash += (int) detectionVariableId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CdPilotDetectionVariablePK)) {
            return false;
        }
        CdPilotDetectionVariablePK other = (CdPilotDetectionVariablePK) object;
        if (this.pilotId != other.pilotId) {
            return false;
        }
        if (this.detectionVariableId != other.detectionVariableId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.c4adashboardservices.CdPilotDetectionVariablePK[ pilotId=" + pilotId + ", detectionVariableId=" + detectionVariableId + " ]";
    }
    
}
