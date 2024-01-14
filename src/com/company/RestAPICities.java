package com.company;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.json.JSONArray;
import org.json.JSONObject;

public class RestAPICities {
    int firstID = 1;

    public List<City> getCities(int limit) {
        List<City> cities = new ArrayList<>();

        try {
            for (int i = firstID; i <= limit; i++) {

                // String url = String.format("http://localhost/IS_LAB6_REST/cities/read/%d",limit);
                String url = String.format("http://localhost:8000/cities/read/%d", i);
                InputStream is = new URL(url).openStream();
                String source = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
                JSONObject json = new JSONObject(source);
                JSONArray receivedData = json.getJSONArray("cities");

                for (Object cityObj : receivedData) {
                    JSONObject cityJson = (JSONObject) cityObj;
                    City city = new City(cityJson);
                    cities.add(city);
                }
            } }catch(Exception e){
                e.printStackTrace();
            }

            return cities;
        }
    }
