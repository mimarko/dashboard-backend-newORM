/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4a.platform.services;

import c4a.platform.persistency.CareProfile;
import c4a.platform.persistency.CrProfile;
import c4a.platform.persistency.CdDetectionVariable;
import c4a.platform.persistency.GeriatricFactorValue;
import c4a.platform.persistency.UserInRole;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import c4a.platform.bl.C4ACareReceiverListResponse;
import c4a.platform.bl.C4ACareReceiversResponse;
import c4a.platform.bl.C4AGroupsResponse;
import c4a.platform.bl.C4ALoginResponse;
import c4a.platform.bl.C4ServiceGetOverallScoreListResponse;
import c4a.platform.bl.DataSet;
import c4a.platform.bl.Group;
import c4a.platform.bl.Item;
import c4a.platform.bl.Serie;
import c4a.platform.persistency.FrailtyStatusTimeline;
import c4a.platform.persistency.TimeInterval;
import c4a.platform.persistency.UserInSystem;
import java.util.Arrays;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import org.joda.time.LocalDate;
import org.joda.time.Years;

/**
 *
 * @author EMantziou
 */
@Stateless
@Path("careReceiversData")
public class wsServices {

    @PersistenceContext(unitName = "c4AServicesPlatformPU")
    private EntityManager em;

//    public void init() {
//        EntityManagerFactory factory;
//        factory = Persistence.createEntityManagerFactory("c4AServicesPlatformPU");
//        em = factory.createEntityManager();
//    }

    public wsServices() {

    }

    @GET
    @Path("getGroups")
    @Produces("application/json")
    public C4AGroupsResponse getJson(@QueryParam("careReceiverId") String careReceiverId, @QueryParam("parentFactorId") String parentFactorId) throws IOException {
        /**
         * ****************Variables*************
         */
        C4AGroupsResponse response = new C4AGroupsResponse();
        TypedQuery query;

        TypedQuery query_groups;

        List<GeriatricFactorValue> gereatricfactparamsList;
        List<CdDetectionVariable> detectionvarsparamsList;
        ArrayList<C4ServiceGetOverallScoreListResponse> itemList;

        /**
         * ****************Action*************
         */
//        if (em == null) {
//            init();
//        }

        if (Integer.parseInt(parentFactorId) == -1) {
            List<String> parentFactors = Arrays.asList("OVL", "GFG");
            query_groups = (TypedQuery) em.createQuery("SELECT c FROM CdDetectionVariable c WHERE c.detectionVariableType.detectionVariableType IN :gefType ");
            query_groups.setParameter("gefType", parentFactors);
            detectionvarsparamsList = query_groups.getResultList();
        } else {

            query_groups = (TypedQuery) em.createQuery("SELECT c FROM CdDetectionVariable c WHERE c.detectionVariableType.detectionVariableType= :gefType");
            query_groups.setParameter("gefType", "GEF");
            detectionvarsparamsList = query_groups.getResultList();
        }

        if (detectionvarsparamsList.isEmpty()) {
            response.setMessage("No detection variables found");
            response.setResponseCode(0);
            return response;
        } else {
            itemList = new ArrayList<C4ServiceGetOverallScoreListResponse>();
            for (CdDetectionVariable types : detectionvarsparamsList) {

//                System.out.println("id " + types.getId()
//                        + " name " + types.getDetectionVariableName());
                query = (TypedQuery) em.createQuery("SELECT g FROM GeriatricFactorValue g WHERE g.gefTypeId.id = :varId "
                        + "and g.userInRoleId.id = :userId order by g.timeIntervalId.intervalStart asc");
                query.setParameter("varId", types.getId());
                query.setParameter("userId", Integer.parseInt(careReceiverId));

                //we use list to avoid "not found" exception
                gereatricfactparamsList = query.getResultList();
                //
                if (gereatricfactparamsList.isEmpty()) {
                    response.setMessage("No factors for this group");
                    response.setResponseCode(0);
                    response.setCareReceiverName("");
                    response.setItemList(null);
                } else {

//                    for (GeriatricFactorValue factors : gereatricfactparamsList) {
//                        System.out.println("id "+factors.getId()+" variable type " + factors.getGefTypeId().getDetectionVariableName()
//                                + " of group " + factors.getGefTypeId().getDerivedDetectionVariableId().getDetectionVariableName()
//                                + " value " + factors.getGefValue()+
//                                " time "+factors.getTimeIntervalId().getIntervalStart());
//                    }
//                    System.out.println("size " + gereatricfactparamsList.size());
                    response.setMessage("success");
                    response.setResponseCode(10);

                    //response.setCareReceiverName(gereatricfactparamsList.get(0).getUserInRoleId().getUserInSystemId().getUsername());
                    itemList.add(new C4ServiceGetOverallScoreListResponse(gereatricfactparamsList));

//                     C4ACareReceiverGroupsResponse res = new C4ACareReceiverGroupsResponse(gereatricfactparamsList.get(0).getDetectionVariableId().getParentFactorId().getDetectionVariableName(),itemList);
                }

            }//detectionVariables loop        
            response.setItemList(itemList);
        }//end detectionVariables is empty

        return response;

    }//end method

    @GET
    @Path("getCareReceivers")
    @Produces("application/json")
    public C4ACareReceiversResponse getJson() throws IOException {
        /**
         * ****************Variables*************
         */
        System.out.println("******************start*****************");
        C4ACareReceiversResponse response = new C4ACareReceiversResponse();
        TypedQuery query;
        TypedQuery query_crProfile;
        TypedQuery query_users;
        TypedQuery query_frailty;

        List<UserInRole> userinroleparamsList;
        List<CrProfile> crprofileparamsList;
        List<CareProfile> careprofileparamsList;
        List<FrailtyStatusTimeline> frailtyparamsList;
        ArrayList<C4ACareReceiverListResponse> itemList;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        /**
         * ****************Action*************
         */
//        if (em == null) {
//            init();
//        }

        query_users = (TypedQuery) em.createQuery("SELECT u FROM UserInRole u Where u.roleId.id =1");

        userinroleparamsList = query_users.getResultList();

        if (userinroleparamsList.isEmpty()) {
            response.setMessage("No users found");
            response.setResponseCode(0);
            return response;
        } else {
            itemList = new ArrayList<C4ACareReceiverListResponse>();
            for (UserInRole users : userinroleparamsList) {
                response.setMessage("success");
                response.setResponseCode(10);
                System.out.println("id " + users.getId()
                        + "name " + users.getUserInSystemId().getUsername());

                query_crProfile = (TypedQuery) em.createQuery("SELECT c FROM CrProfile c Where c.userInRoleId.id = :userId ");
                query_crProfile.setParameter("userId", users.getId());

                //we use list to avoid "not found" exception
                crprofileparamsList = query_crProfile.getResultList();
                int age = 0;
                if (!crprofileparamsList.isEmpty()) {

                    LocalDate birthDate = new LocalDate(crprofileparamsList.get(0).getBirthDate());
                    Years age2 = Years.yearsBetween(birthDate, new LocalDate());
                    age = age2.getYears();
//                    System.out.println("age2 " + age2.getYears());
//                    System.out.println("user name " + crprofileparamsList.get(0).getUserInRoleId().getId()
//                            + " birthDate " + birthDate);
                }

                query = (TypedQuery) em.createQuery("SELECT c FROM CareProfile c WHERE c.userInRole.id = :userId ");
                query.setParameter("userId", users.getId());
                //we use list to avoid "not found" exception
                careprofileparamsList = query.getResultList();
                //**************************************
                String frailtyStatus = null;
                String frailtyNotice = null;
                char attention = 0;
                String textline = null;
                char interventionstatus = 0;
                String interventionDate = null;
                String detectionStatus = null;
                String detectionDate = null;
                if (!careprofileparamsList.isEmpty()) {
//                    frailtyStatus = careprofileparamsList.get(0).getFrailtyStatus();
//                    frailtyNotice = careprofileparamsList.get(0).getFrailtyNotice();
                    attention = careprofileparamsList.get(0).getAttentionStatus();
                    textline = careprofileparamsList.get(0).getIndividualSummary();
                    interventionstatus = careprofileparamsList.get(0).getInterventionStatus();
                    interventionDate = sdf.format(careprofileparamsList.get(0).getLastInterventionDate());
//                    detectionStatus = careprofileparamsList.get(0).getDetectionStatus();
//                    detectionDate = sdf.format(new Date(careprofileparamsList.get(0).getLastDetection() * 1000));
//                    System.out.println("user id " + careprofileparamsList.get(0).getUserInRoleId()
//                            + " frailty status " + careprofileparamsList.get(0).getFrailtyStatus());
                }

                query_frailty = (TypedQuery) em.createQuery("SELECT f FROM FrailtyStatusTimeline f WHERE f.frailtyStatusTimelinePK.userInRoleId = :userId ");
                query_frailty.setParameter("userId", users.getId());
                //we use list to avoid "not found" exception
                frailtyparamsList = query_frailty.getResultList();
                if (!frailtyparamsList.isEmpty()) {
                    frailtyStatus = frailtyparamsList.get(0).getFrailtyStatus().getFrailtyStatus();
                    frailtyNotice = frailtyparamsList.get(0).getFrailtyNotice();

//                    System.out.println("user id " + frailtyparamsList.get(0).getFrailtyStatusTimelinePK().getUserInRoleId()
//                            + " frailty status " + frailtyparamsList.get(0).getFrailtyStatus().getFrailtyStatus());
                }

                itemList.add(new C4ACareReceiverListResponse(users.getId(), age, frailtyStatus, frailtyNotice, attention, textline,
                        interventionstatus, interventionDate, detectionStatus, detectionDate));
            }//detectionVariables loop    
            response.setItemList(itemList);

        }//end detectionVariables is empty

        return response;

    }//end method

    @GET
    @Path("login")
    @Produces("application/json")
    public C4ALoginResponse login(@QueryParam("username") String username, @QueryParam("password") String password) throws IOException {
        /**
         * ****************Variables*************
         */
        TypedQuery query;
        List<UserInSystem> userparamList;
        UserInSystem user;
        C4ALoginResponse response = new C4ALoginResponse();
        /**
         * ****************Action*************
         */
        try {

//            if (em == null) {
//                init();
//            }

            query = (TypedQuery) em.createQuery("SELECT u FROM UserInSystem u Where u.username = :username and u.password=:password");
            query.setParameter("username", username);
            query.setParameter("password", password);
            userparamList = query.getResultList();

            if (userparamList.isEmpty()) {
                response.setMessage("wrong credentials");
                response.setResponseCode(0);
                response.setDisplayName("");
                return response;
            } else {
                user = (UserInSystem) query.getSingleResult();
                query = (TypedQuery) em.createQuery("SELECT u FROM UserInRole u Where u.userInSystemId.id = :userId");
                query.setParameter("userId", user.getId());
                UserInRole userInRole = (UserInRole) query.getSingleResult();
                if (userInRole.getRoleId().getId() == 8) {
                    System.out.println("username " + user.getUsername() + " display name " + user.getDisplayName());
                    response.setMessage("success");
                    response.setResponseCode(10);
                    if (user.getDisplayName() != null) {
                        response.setDisplayName(user.getDisplayName());
                    } else {

                        response.setDisplayName("");
                    }
                    return response;
                } else {
                    response.setMessage("you don't have the right permissions");
                    response.setResponseCode(0);
                    response.setDisplayName("");
                    return response;
                }

            }

        } catch (Exception e) {
            response.setMessage("something went terrible wrong");
            response.setResponseCode(2);
            response.setDisplayName("");
            return response;
        }

    }

    @GET
    @Path("getDiagramData")
    @Produces("application/json")
    public C4AGroupsResponse getDiagramData(@QueryParam("careReceiverId") String careReceiverId, @QueryParam("parentFactorId") Integer parentFactorId) throws IOException {
        DataSet response = new DataSet();
        TypedQuery query;
        List<GeriatricFactorValue> gfvList;
        ArrayList<C4ServiceGetOverallScoreListResponse> itemList = new ArrayList<C4ServiceGetOverallScoreListResponse>();
        query = (TypedQuery) em.createQuery("SELECT g FROM GeriatricFactorValue g  "
                + "JOIN g.gefTypeId detvar WHERE detvar.derivedDetectionVariableId.id = :varId "
                + "and g.userInRoleId.id = :userId order by g.timeIntervalId.intervalStart asc");
        query.setParameter("varId", parentFactorId);
        query.setParameter("userId", Integer.parseInt(careReceiverId));

        //we use list to avoid "not found" exception
        gfvList = query.getResultList();
        //
        if (gfvList.isEmpty()) {
            response.setMessage("No factors for this group");
            response.setResponseCode(0);
        } else {
            response.setMessage("success");
            response.setResponseCode(10);
            
            for (GeriatricFactorValue gfv : gfvList) {
                Group g = findOrCreateGroup(response, gfv.getTimeIntervalId());
                if(g==null){
                    g = new Group();
                    g.setId(gfv.getTimeIntervalId().getId());
                    SimpleDateFormat sdf = new SimpleDateFormat("MMM yyyy");
                    g.setName( sdf.format( gfv.getTimeIntervalId().getIntervalStart()));
                    response.getGroups().add(g);
                }
                Serie s = findOrCreateSerie(response,gfv.getGefTypeId());
                if(s==null){
                    s = new Serie();
                    s.setName(gfv.getGefTypeId().getDetectionVariableName());
                    response.getSeries().add(s);
                }
                
                Item i = findOrCreateItem(response,gfv);
                if(i==null){
                    i = new Item();
                    i.setId(gfv.getId());
                    i.setValue(gfv.getGefValue().floatValue());
                    i.setGefTypeId(gfv.getGefTypeId().getId());
                    s.getItems().add(i);
                }
                
            }

        }
        response.setItemList(itemList);
        return response;
    }//end method

    private Group findOrCreateGroup(DataSet ds, TimeInterval ti) {
        
        for (Group g : ds.getGroups()) {
            if(g.getId().equals(ti.getId())) return g;
        }
        return null;
    }

    private Serie findOrCreateSerie(DataSet ds, CdDetectionVariable gefTypeId) {
        for (Serie s : ds.getSeries()) {
            if(s.getName().equals(gefTypeId.getDetectionVariableName())){
                return s;
            }
        }
        return null;
    }

    private Item findOrCreateItem(DataSet ds, GeriatricFactorValue gfv) {
        for (Serie s : ds.getSeries()) {
            for (Item i : s.getItems()) {
                if(i.getId().equals(gfv.getId()))
                    return i;
            }
        }
        return null;
    }
}//end class

