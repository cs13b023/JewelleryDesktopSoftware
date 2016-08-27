/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sales;

/**
 *
 * @author vinay
 */
public class InvStringClass {
    static String mat_name;
    public static void setvalue(String a){
        InvStringClass.mat_name=a;
    }
    public static String getvalue(){
       return InvStringClass.mat_name;
    }
}
