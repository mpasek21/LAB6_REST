package com.company;

import org.json.JSONObject;

public class City {
    private int id;
    private String name;
    private String countryCode;
    private String district;
    private int population;

    public City(JSONObject json) {
        this.id = json.getInt("ID");
        this.name = json.getString("Name");
        this.countryCode = json.getString("CountryCode");
        this.district = json.getString("District");
        this.population = json.getInt("Population");
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public int getPopulation() {
        return population;
    }
}
