package net.basicfitdata.member;

import com.google.gson.JsonObject;

public class Location{

    private final String country, mailingCity, mailingStreet;
    private final int mailingHouse;

    public Location(String country, String mailingCity, String mailingStreet, int mailingHouse){
        this.country = country;
        this.mailingCity = mailingCity;
        this.mailingStreet = mailingStreet;
        this.mailingHouse = mailingHouse;
    }

    public Location(JsonObject jsonObject){
        this(jsonObject.get("mailing_country").getAsString(), jsonObject.get("mailing_city").getAsString(),
                jsonObject.get("mailing_street").getAsString(), jsonObject.get("mailing_house_number").getAsInt());
    }

    public String getCountry(){
        return country;
    }

    public String getMailingCity(){
        return mailingCity;
    }

    public String getMailingStreet(){
        return mailingStreet;
    }

    public int getMailingHouse(){
        return mailingHouse;
    }

    public String getPostalCode(){
        return mailingHouse+" "+mailingStreet;
    }
}
