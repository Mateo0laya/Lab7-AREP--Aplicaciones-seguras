package com.edu.lab7.servers;

import static spark.Spark.*;

import com.edu.lab7.SecureURLReader;
import com.edu.lab7.service.UserService;

public class LoginService {
    
    public static void main(String[] args) {

        UserService.exec();
        
        staticFiles.location("/public");

        secure("certificados/ecikeystore.p12", "123456", null, null);

        get("/login", (req, res) -> {
            String user = req.queryParams("user");
            String pswd = req.queryParams("pswd");
            boolean access = UserService.validateUser(user, pswd);
            return (access)?SecureURLReader.invoke():"Acceso denegado";
        });

    }

}
