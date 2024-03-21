package com.edu.lab7.service;

import java.util.Hashtable;

public class UserService {

    private static Hashtable<String, String> users;

    public static void exec() {
        users = new Hashtable<String, String>();
        addUser("Mateo", "123456");
        addUser("Andres", "654321");
    }

    private static void addUser(String usr, String pswd) {
        String cryptedPswd = org.apache.commons.codec.digest.DigestUtils.sha256Hex(pswd);
        users.put(usr, cryptedPswd);
    }

    public static boolean validateUser(String usr, String pswd) {
        String cryptedPswd = org.apache.commons.codec.digest.DigestUtils.sha256Hex(pswd);
        if (users.containsKey(usr)) {
            return (users.get(usr).equals(cryptedPswd)) ? true : false;
        }
        return false;
    }

}
