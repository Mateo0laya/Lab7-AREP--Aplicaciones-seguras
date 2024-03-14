package com.edu.lab7.servers;

import static spark.Spark.*;

public class SparkServer {

    public static void main(String[] args) {

        staticFiles.location("/public");

        port(getPort());

        //API: secure(keystoreFilePath, keystorePassword, truststoreFilePath, truststorePassword);
        secure("certificados/ecikeystore.p12", "123456", null, null);

        get("/hello", (req, res) -> "Hello Heroku");
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000; //returns default port if heroku-port isn't set (i.e. on localhost)
    }

}