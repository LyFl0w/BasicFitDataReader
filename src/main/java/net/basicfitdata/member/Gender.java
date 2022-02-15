package net.basicfitdata.member;

public enum Gender{

    MALE("homme"), FEMALE("femme");

    private final String gender;

    Gender(String gender){
        this.gender = gender;
    }

    public String getGender(){
        return gender;
    }
}
