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

import com.heroku.sdk.jdbc.DatabaseUrl;

public class Main {

  private static ArrayList<CoffeeShop> shops = new ArrayList<>();

  public static void main(String[] args) {
      before((request, response) -> {
          response.header("Access-Control-Allow-Origin", "*");
      });


    port(Integer.valueOf(System.getenv("PORT")));
    staticFileLocation("/public");

    get("/hello", (req, res) -> "Hello World");

    get("/", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Hello World!");

            return new ModelAndView(attributes, "index.ftl");
        }, new FreeMarkerEngine());

    get("/coffee-shops", (req, res) -> {
        shops.add(new CoffeeShop("Not Just Coffee", 5, 3));

        Gson gson = new Gson();

        return gson.toJson(shops);
    });

  }

}
