package net.basicfitdata.member;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.basicfitdata.utils.DateUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class Visit{

    private final String club;
    private final long time;

    public Visit(String club, long time){
        this.club = club;
        this.time = time;
    }

    public Visit(JsonObject jsonObject){
        this(jsonObject.get("club").getAsString(), DateUtils.getTimeByStringDate("yyyy-MM-ddHH:mm:ss",
                jsonObject.get("date").getAsString()+jsonObject.get("time").getAsString()));
    }

    public String getClub(){
        return club;
    }

    public long getTime(){
        return time;
    }

    public void describe(){
        System.out.println("Vous êtes allé au club "+club+" le "+DateFormat.getDateInstance(DateFormat.FULL).format(time)+" à "+DateFormat.getTimeInstance().format(time));
    }

    protected static List<Visit> visitsList(Iterator<JsonElement> jsonElementList){
        final List<Visit> visitsList = new ArrayList<>();
        jsonElementList.forEachRemaining(jsonElement -> visitsList.add(new Visit(jsonElement.getAsJsonObject())));
        return visitsList;
    }

}
