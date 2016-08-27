/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package girvi;

import java.sql.SQLException;

/**
 *
 * @author Vinod
 */
public class Operations {
    
    public static double calculateSimpleInterest( int p,float n, float r){
        float interest;
        interest = (float) (1.0*(p*n*r/100));
        return interest;
    }
    
    public static float calculateCompundInterest(int p, float n, float r) {
        float amount;
        amount = (float) (p * Math.pow(1 + (12*r /100), n/12 ));
        float interest;
        interest = amount - p;
        return interest;
    }
    
     public static float calculateEMI(int p, float r, int n) {
                float R = (float) (1.0*(r) / 100);
                float e = (float) (p * R * (Math.pow((1 + R), n)) / ((Math.pow((1 + R), n)) - 1));

                return e;
        }

    public static int calculatePresentPrice(int cost, float weight) {
        return (int) (cost * weight);
    }
    
    public static float analyseCapacity(String CustomerName) throws SQLException{
        float capacity;
        int pledgingspaid = SqlLogin.returnCount("select count(*) from item where customer='" + CustomerName + "' and returned_or_not='Yes'");
        int totalpledgings = SqlLogin.returnCount("select count(*) from item where customer='" + CustomerName + "'");
        capacity = (float)((1.0*pledgingspaid)/totalpledgings);
        return capacity;
    }
    
    public static int numberOfPledgings(String CustomerName) throws SQLException{
        int totalpledgings = SqlLogin.returnCount("select count(*) from item where customer='" + CustomerName + "'");
        return totalpledgings;
    }
}
