/* package com.company;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;
import org.json.JSONArray;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        try {
//Test działania lokalnego REST API
            String temp_url = "http://localhost/IS_LAB6_REST/cities/read/10";
            URL url = new URL(temp_url);
            System.out.println("Wysyłanie zapytania...");
            InputStream is = url.openStream();
            System.out.println("Pobieranie odpowiedzi...");
            String source = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
            System.out.println("Przetwarzanie danych...");
            JSONObject json = new JSONObject(source);
            JSONArray recieveddata = (JSONArray) json.get("cities");
           // System.out.println("City name: " + recieveddata.getJSONObject(0).get("Name"));
            System.out.println("Nazwy miast w tablicy:");

            System.out.println("Nazwy miast w tablicy:");
            for (Object cityObj : recieveddata) {
                JSONObject city = (JSONObject) cityObj;
                String cityName = city.getString("Name");
                System.out.println(cityName);
            }
            System.out.println("Dane miast w tablicy:");
            for (Object cityObj : recieveddata) {
                JSONObject city = (JSONObject) cityObj;
                System.out.println("ID: " + city.getInt("ID"));
                System.out.println("Name: " + city.getString("Name"));
                System.out.println("CountryCode: " + city.getString("countryCode"));
                System.out.println("District: " + city.getString("district"));
                System.out.println("Population: " + city.getInt("population"));
                System.out.println();
            }
        } catch (Exception e) {
            System.err.println("Wystąpił nieoczekiwany błąd!!! ");
            e.printStackTrace(System.err);
        }
    }
}

*/

package com.company;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        RestAPICities api = new RestAPICities();
        List<City> cities = api.getCities(12);

        System.out.println("Nazwy miast w tablicy:");
        for (City city : cities) {
            System.out.println(city.getName());
        }

        System.out.println("Dane miast w tablicy:");
        for (City city : cities) {
            System.out.println("ID: " + city.getId());
            System.out.println("Name: " + city.getName());
            System.out.println("CountryCode: " + city.getCountryCode());
            System.out.println("District: " + city.getDistrict());
            System.out.println("Population: " + city.getPopulation());
            System.out.println();
        }
    }
}
