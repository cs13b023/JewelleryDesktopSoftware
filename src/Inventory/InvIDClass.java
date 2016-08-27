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
public class InvIDClass {
    static int id;
    public static void setvalue(int a){
        InvIDClass.id=a;
    }
    public static int getvalue(){
       return InvIDClass.id;
    }
}