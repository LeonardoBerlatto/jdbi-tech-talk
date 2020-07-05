package br.com.cwi.jdbi.techtalkdemo.domain;

public enum Gender {

    FEMALE("Female"),
    MALE("Male"),
    UNKNOWN("??");

    private final String genderName;

    Gender(String genderName) {
        this.genderName = genderName;
    }

    public String getGenderName() {
        return genderName;
    }
}
