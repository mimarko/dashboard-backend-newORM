/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4a.platform.services;

import c4a.platform.persistency.CdDetectionVariable;
import c4a.platform.persistency.UserInRole;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author EMantziou
 */
public class testPers {

    @PersistenceContext(unitName = "c4AServicesPlatformPU")
    private EntityManager em;

    public void init() {
        EntityManagerFactory factory;
        factory = Persistence.createEntityManagerFactory("c4AServicesPlatformPU");
        em = factory.createEntityManager();
    }

    public UserInRole getUser() {

        UserInRole userInRole;

        if (em == null) {
            init();
        }

        userInRole = (UserInRole) em.find(UserInRole.class,new Long(2) );

        return userInRole;
    }

    public CdDetectionVariable getCdDetectionVariable() {

        CdDetectionVariable det;

        if (em == null) {
            init();
        }

        det = (CdDetectionVariable) em.find(CdDetectionVariable.class, 2);

        return det;
    }

    public static void main(String args[]) {
        testPers test = new testPers();
        CdDetectionVariable cd = test.getCdDetectionVariable();
        UserInRole user = test.getUser();
        System.out.println("begin " + cd.getDetectionVariableName());
        System.out.println("user " + user.getId()+ " username "+user.getUserInSystemId().getUsername());
    }

}
