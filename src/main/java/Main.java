import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

import java.net.URI;
import java.net.URISyntaxException;

import static spark.Spark.*;

import com.google.gson.Gson;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;


public class Main {

    private static ArrayList<CoffeeShop> shops = new ArrayList<>();
    private static Gson gson = new Gson();

    public static void main(String[] args) {
        String test = System.getenv("PORT");

        if (test != null) {
            port(Integer.valueOf(test));
        } else {
            port(5000);
        }
        staticFileLocation("/public");

        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));

        get("/hello", (req, res) -> "Hello World");

        get("/", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Hello World!");

            return new ModelAndView(attributes, "index.ftl");
        }, new FreeMarkerEngine());

        get("/coffee-shops", (req, res) -> gson.toJson(shops));

        post("/coffee-shops", (req, res) -> {
            shops.add(gson.fromJson(req.body(), CoffeeShop.class));

            return 200;
        });
    }

}
