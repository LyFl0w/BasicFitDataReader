package net.basicfitdata;

import com.google.gson.*;
import net.basicfitdata.member.Member;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URISyntaxException;


public class BasicFitData{

    public static void main(String[] args) throws URISyntaxException, FileNotFoundException{
        final File file = new File(BasicFitData.class.getClassLoader().getResource("my-basic-fit-data.json").toURI());
        final JsonObject data = JsonParser.parseReader(new FileReader(file)).getAsJsonObject();

        final Member member = new Member(data.getAsJsonObject("member"), data.getAsJsonObject("transactions").getAsJsonArray("payments"),
                data.getAsJsonArray("visits"));
        member.describe();
    }

}
