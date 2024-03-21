package com.edu.lab7.servers;

import static spark.Spark.*;

public class SparkServer {

    public static void main(String[] args) {

        port(getPort());

        String user = "root";
        String pswd = "12345";

        // API: secure(keystoreFilePath, keystorePassword, truststoreFilePath,
        // truststorePassword);
        secure("certificados/ecikeystore.p12", "123456", null, null);

        get("/hello", (req, res) -> {
            String userReq, pswdReq;
            try {
                userReq = req.queryParams("user");
                pswdReq = req.queryParams("pswd");
            } catch (Exception e) {
                userReq = "a";
                pswdReq = "a";
            }
            return (user.equals(userReq) && pswd.equals(pswdReq))
                    ? "TopSecret password: °!#as$%2a&/q&fa/()=?¡¨asd[]"
                    : "Acceso no autorizado";
        });
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000; // returns default port if heroku-port isn't set (i.e. on localhost)
    }

}