/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sales;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author sandukuttan
 */

//singleton class
public class CustomerTable {
    static CustomerTable customerTable=new CustomerTable();
    static HashMap<Integer, Customer> custList;
    static CustomerTable getList(){
        return customerTable;
    }

    private CustomerTable(){
        custList=new HashMap<>();
    }
    public static void addCustomer(Customer cust){

        try{
        //System.out.println(cust.getId());
        custList.put(cust.getId(), cust);
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public static Customer getCustomer(Integer id){
        return custList.get(id);
    }
    
        public ArrayList<Customer> viewAllCustomers(){
        ArrayList<Customer> result= new ArrayList<>();
        for(Customer cust : custList.values())
            result.add(cust);
        return result;
    }
    public Customer removeItem(String itemID){
        
        Customer deletedItem=custList.remove(itemID);
        return deletedItem;
    }
    
    public static ArrayList<Customer> searchCustomer(String name){
        ArrayList<Customer> searchResult = new ArrayList<>();
        try{
            for (Customer item : custList.values()) {
                if(item.getCustName().toLowerCase().contains(name.toLowerCase())){
                    boolean add = searchResult.add(item);
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return searchResult;
    }
    
}
