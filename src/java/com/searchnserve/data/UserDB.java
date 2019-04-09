/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.searchnserve.data;

import com.searchnserve.model.UserAccount;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author stephen
 */
public class UserDB {

    /**
     * Returns the User with the given email address, otherwise returns null
     *
     * @param email
     * @return
     */
    public static UserAccount selectUserByEmail(String email) {
        String qString = "SELECT u FROM UserAccount u where u.emailAddress = :email";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("email", email);
        return GenericEntityDB.<UserAccount>selectOne(qString, params, UserAccount.class);
    }

    /**
     * Creates a new user account by inserting a record into the user object
     *
     * @param user
     */
    public static boolean createAccount(UserAccount user) {
        boolean accountCreated = true;

        try {
            GenericEntityDB.insert(user);
        } catch (Exception ex) {
            accountCreated = false;
        }
        return accountCreated;
    }

    /**
     * Returns user is login is successful, otherwise returns null
     *
     * @param user
     * @return
     */
    public static UserAccount login(UserAccount user) {
        String qString = "SELECT u FROM UserAccount u where u.emailAddress = :email "
                + " and u.passwordHash = :password";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("email", user.getEmailAddress());
        params.put("password", user.getPasswordHash());
        return GenericEntityDB.<UserAccount>selectOne(qString, params, UserAccount.class);
    }
}
