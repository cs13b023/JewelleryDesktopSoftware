/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sales;

/**
 *
 * @author sandukuttan
 */
public class Customer {
    String custName,address,city,pin,relation,relatedTo,phoneNo,panNo;
    Integer id;
    void Customer(){
        
    }

    public Customer(String custName, String address, String city, String pin, String relation, String relatedTo, String phoneNo, String panNo, Integer id) {
        this.custName = custName;
        this.address = address;
        this.city = city;
        this.pin = pin;
        this.relation = relation;
        this.relatedTo = relatedTo;
        this.phoneNo = phoneNo;
        this.panNo = panNo;
        this.id = id;
    }
    
    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getRelatedTo() {
        return relatedTo;
    }

    public void setRelatedTo(String relatedTo) {
        this.relatedTo = relatedTo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPanNo() {
        return panNo;
    }

    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
