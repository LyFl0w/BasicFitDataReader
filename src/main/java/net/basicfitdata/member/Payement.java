package net.basicfitdata.member;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.basicfitdata.utils.DateUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Payement{

    private final long date;
    private final String description, code, moneyType;
    private final double price;

    public Payement(long date, String description, String code, String moneyType, double price){
        this.date = date;
        this.description = description;
        this.code = code;
        this.price = price;
        this.moneyType = moneyType;
    }

    public Payement(JsonObject jsonObject){
        this(DateUtils.getTimeByStringDate("yyyy-MM-dd", jsonObject.get("date").getAsString().substring(0,10)),
                jsonObject.get("description").getAsString(), jsonObject.get("code").getAsString(),
                jsonObject.get("amount").getAsString().substring(0, 1),
                Double.parseDouble(jsonObject.get("amount").getAsString().substring(2, 7).replace(",", ".")));
    }

    protected static List<Payement> payementList(Iterator<JsonElement> jsonElementList){
        final List<Payement> payementList = new ArrayList<>();
        jsonElementList.forEachRemaining(jsonElement -> payementList.add(new Payement(jsonElement.getAsJsonObject())));
        return payementList;
    }

    public void describe(){
        System.out.println("La transaction a été effectué avec le code "+code+" le "+SimpleDateFormat.getDateInstance().format(date));
        System.out.println(description);
        System.out.println("Prix : "+price+moneyType);
    }

    public long getDate(){
        return date;
    }

    public String getDescription(){
        return description;
    }

    public String getCode(){
        return code;
    }

    public String getMoneyType(){
        return moneyType;
    }

    public double getPrice(){
        return price;
    }

}
