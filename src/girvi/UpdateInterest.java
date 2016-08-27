/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package girvi;

import java.sql.SQLException;
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vinod
 */
public class UpdateInterest {
    public static void Update() {
        try {
            SqlLogin.executeQueryTiles("select * from invoice");
        } catch (SQLException ex) {
            Logger.getLogger(UpdateInterest.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i=0;i<SqlLogin.data.size();++i){
            LocalDate StartDate = LocalDate.parse((CharSequence) SqlLogin.data.get(i).get(4));
            LocalDate PresentDate = LocalDate.now();
            int ID = Integer.parseInt((String)SqlLogin.data.get(i).get(0));
            int p = Integer.parseInt((String)SqlLogin.data.get(i).get(10));
            //int interest_add = Integer.parseInt((String)SqlLogin.data.get(i).get(5));
            float r = Float.parseFloat((String)SqlLogin.data.get(i).get(3));
            LocalDate LastAddedDate = LocalDate.parse((CharSequence) SqlLogin.data.get(i).get(11));
            LocalDate LastPaidDate = LocalDate.parse((CharSequence) SqlLogin.data.get(i).get(9));
            LocalDate CheckDate = LocalDate.parse("0001-01-01");
            int previnterest = Integer.parseInt((String)SqlLogin.data.get(i).get(7));
            double interest = 0;
            double balance = 0;
            if(LastPaidDate.isEqual(CheckDate)){
                long daysBetween = DAYS.between(StartDate, PresentDate);
                    float n = (float)(daysBetween/30.0);
                    interest = Operations.calculateSimpleInterest(p, n, r);
                    balance = p + interest;
                try {
                    SqlLogin.executeUpdate("UPDATE INVOICE SET INTEREST = " + interest + ", PAYABLE = " + balance + "WHERE ID = " + ID);
                } catch (SQLException ex) {
                    Logger.getLogger(UpdateInterest.class.getName()).log(Level.SEVERE, null, ex);
                };
            }
            else{
                long daysBetween = DAYS.between(LastPaidDate, PresentDate);
                    float n = (float)(daysBetween/30.0);
                    interest = Operations.calculateSimpleInterest(p, n, r) + previnterest;
                    balance = p +interest;
                try {
                    SqlLogin.executeUpdate("UPDATE INVOICE SET INTEREST = " + interest + ", PAYABLE = " + balance + "WHERE ID = " + ID);
                } catch (SQLException ex) {
                    Logger.getLogger(UpdateInterest.class.getName()).log(Level.SEVERE, null, ex);
                };
            }
        }
    }
}
