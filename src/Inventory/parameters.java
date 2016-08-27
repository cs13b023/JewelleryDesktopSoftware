/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;



/**
 *
 * @author vinay
 */
public class parameters {
    static String id;
    public static void setvalue(String a){
        parameters.id=a;
    }
    public static String getvalue(){
       return parameters.id;
    }
}