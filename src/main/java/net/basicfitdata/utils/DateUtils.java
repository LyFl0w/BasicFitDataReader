package net.basicfitdata.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtils{

    public static long getTimeByStringDate(String pattern, String date){
        try{
            return new SimpleDateFormat(pattern).parse(date).getTime();
        }catch(ParseException e){
            e.printStackTrace();
        }
        return 0L;
    }

}
