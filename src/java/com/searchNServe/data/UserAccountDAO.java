package com.searchNServe.data;

import com.searchNServe.model.UserAccountDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jjose
 */
public class UserAccountDAO {

    public static boolean login(UserAccountDTO userAccountDTO)
            throws ClassNotFoundException, SQLException {

        boolean loginSuccessful = false;
        
        Statement statement = DBUtil.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(
                "select u.fullname from useraccount as u "
                        + " where u.username='" + userAccountDTO.getUserName() 
                        + "' and u.password='" + userAccountDTO.getPassword() + "'");
        
        if (resultSet.next()){
            // login successful
            loginSuccessful = true;
            
            // set loggedIn user's fullname into DTO
            userAccountDTO.setFullName(resultSet.getString(1));
        }
            
        return loginSuccessful;
    }

    public static boolean register(UserAccountDTO userAccountDTO) {
        return true;
    }
}
