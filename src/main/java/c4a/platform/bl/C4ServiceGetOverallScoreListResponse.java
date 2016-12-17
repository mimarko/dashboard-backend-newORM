/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4a.platform.bl;

import c4a.platform.persistency.GeriatricFactorValue;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author EMantziou
 */
public class C4ServiceGetOverallScoreListResponse {

    private final List<C4AServiceGetGereatricFactorsResponse> items;
    private final List<Long> idList ;
    private final List<Float> ItemList ;
    private final List<String> dateList ;
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM");

    private String groupName;
    private Integer gefTypeId;

    private String parentGroupName;

    public C4ServiceGetOverallScoreListResponse(List<GeriatricFactorValue> gereatricfactparamsList) {
//         groupName = gereatricfactparamsList.get(0).getDetectionVariableId().getDetectionVariableName();
        items = new ArrayList<C4AServiceGetGereatricFactorsResponse>();
        ItemList = new ArrayList<Float>();
        dateList = new ArrayList<String>();
        idList = new ArrayList<Long>();
        for (GeriatricFactorValue factors : gereatricfactparamsList) {
           
            ItemList.add(factors.getGefValue().floatValue());
            idList.add(factors.getId());
            String date = sdf.format(factors.getTimeIntervalId().getIntervalStart());
            gefTypeId = factors.getGefTypeId() !=null ? factors.getGefTypeId().getId() : null;
            dateList.add(date);
            groupName = factors.getGefTypeId().getDetectionVariableName();

        }
        if (gereatricfactparamsList.get(0).getGefTypeId().getDerivedDetectionVariableId()!= null) {
            parentGroupName = gereatricfactparamsList.get(0).getGefTypeId().getDerivedDetectionVariableId().getDetectionVariableName();
        } else {
            parentGroupName = "";
        }
        items.add(new C4AServiceGetGereatricFactorsResponse(groupName,idList, ItemList, dateList));

    }

    public List<C4AServiceGetGereatricFactorsResponse> getItems() {
        return items;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getParentGroupName() {
        return parentGroupName;
    }

    public void setParentGroupName(String parentGroupName) {
        this.parentGroupName = parentGroupName;
    }

    /**
     * @return the gefTypeId
     */
    public Integer getGefTypeId() {
        return gefTypeId;
    }

    /**
     * @param gefTypeId the gefTypeId to set
     */
    public void setGefTypeId(Integer gefTypeId) {
        this.gefTypeId = gefTypeId;
    }

    

}//end class
