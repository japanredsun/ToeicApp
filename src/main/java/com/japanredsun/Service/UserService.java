package com.japanredsun.Service;

import com.japanredsun.Dao.DataProviderImp;
import javafx.scene.control.Label;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {

    public void test(){
        DataProviderImp dataProviderImp = new DataProviderImp();
        Label label = new Label();
        try {
            String sql = "SELECT username, password From users";
            ResultSet rs = dataProviderImp.executeReader(sql);
            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                String username = rs.getString("username");
                String password = rs.getString("password");

                //Display values
                System.out.print("User: " + username);
                System.out.println(", Pass: " + password);


                label.setText(username);
            }
            //STEP 6: Clean-up environment
            rs.close();
            dataProviderImp.closeDB();

        }catch (SQLException ex){
            ex.printStackTrace();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally{
            //finally block used to close resources
            dataProviderImp.finalyCheck();
        }//end try
    }
}
