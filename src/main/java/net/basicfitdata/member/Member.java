package net.basicfitdata.member;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.basicfitdata.utils.DateUtils;

import java.text.DateFormat;
import java.util.List;

public class Member{

    private final String email, firstName, middleName, lastName, homeClub;
    private final long birthDate, cardNumber, memberNumber;
    private final Gender gender;
    private final Location location;
    private final List<Payement> payementList;
    private final List<Visit> visitList;

    public Member(String email, String firstName, String middleName, String lastName,
                  String homeClub, long birthDate, long cardNumber, long memberNumber, Gender gender, Location location, List<Payement> payementList, List<Visit> visitList){
        this.email = email;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.homeClub = homeClub;
        this.birthDate = birthDate;
        this.cardNumber = cardNumber;
        this.memberNumber = memberNumber;
        this.gender = gender;
        this.location = location;
        this.payementList = payementList;
        this.visitList = visitList;
    }

    public Member(JsonObject dataMember, JsonArray dataPayement, JsonArray dataVisit){
        this(dataMember.get("email").getAsString(), dataMember.get("first_name").getAsString(), dataMember.get("middle_name").getAsString(),
                dataMember.get("last_name").getAsString(), dataMember.get("home_club").getAsString(),
                DateUtils.getTimeByStringDate("yyyy-MM-dd", dataMember.get("birth_date").getAsString().substring(0, 10)),
                dataMember.get("card_number_s").getAsLong(), dataMember.get("membership_number_s").getAsLong(),
                Gender.valueOf(dataMember.get("gender_s").getAsString().toUpperCase()), new Location(dataMember), Payement.payementList(dataPayement.iterator()),
                Visit.visitsList(dataVisit.iterator()));
    }

    public void describe(){
        System.out.println("\n"+"-".repeat(20)+"\n");

        System.out.println("Mon nom est "+firstName+((hasMiddleName()) ? middleName+" "+lastName : lastName));
        System.out.println("Je suis née le "+DateFormat.getDateInstance().format(birthDate));
        System.out.println("Je suis un"+((gender == Gender.MALE) ? " " : "e ")+gender.getGender());
        System.out.println("Mon email est le suivant : "+email);
        System.out.println("Mon numéro de client est le "+memberNumber+" et mon numéro de carte est le "+cardNumber);
        System.out.println("J'habite en "+location.getCountry()+" dans le lieu suivant : "+location.getPostalCode());

        System.out.println("\n"+"-".repeat(20)+"\n");

        System.out.println("Mes transactions sont les suivantes : \n");
        payementList.forEach(payement -> {
            System.out.println("-".repeat(20));
            payement.describe();
        });
        System.out.println("-".repeat(20));

        System.out.println("\n"+"-".repeat(20)+"\n");

        System.out.println("Mes visits : \n");
        visitList.forEach(visit -> {
            System.out.println("-".repeat(20));
            visit.describe();
        });
        System.out.println("-".repeat(20));

    }

    public String getEmail(){
        return email;
    }

    public String getFirstName(){
        return firstName;
    }

    public boolean hasMiddleName(){
        return getMiddleName().isEmpty() || getMiddleName().isBlank();
    }

    public String getMiddleName(){
        return middleName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getHomeClub(){
        return homeClub;
    }

    public long getBirthDate(){
        return birthDate;
    }

    public long getCardNumber(){
        return cardNumber;
    }

    public long getMemberNumber(){
        return memberNumber;
    }

    public Gender getGenre(){
        return gender;
    }

    public Location getLocation(){
        return location;
    }
}
