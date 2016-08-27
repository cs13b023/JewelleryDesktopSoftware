/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

import java.util.HashMap;

/**
 *
 * @author rgsankar121
 */
public class parameters {
    
    private static int proglist_index;
    
    public static HashMap<String, Boolean> attendance;
    
    private static String empId;

    /**
     * @return the empId
     */
    public static String getEmpId() {
        return empId;
    }

    /**
     * @param aEmpId the empId to set
     */
    public static void setEmpId(String aEmpId) {
        empId = aEmpId;
    }

    /**
     * @return the proglist_index
     */
    public static int getProglist_index() {
        return proglist_index;
    }

    /**
     * @param proglist_index the proglist_index to set
     */
    public static void setProglist_index(int proglist_index) {
        parameters.proglist_index = proglist_index;
    }
    
    
    
}
