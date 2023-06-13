package com.tekwill.Lesson45;

public class Driver {

    long id;

    String first_name;

    String last_name;

    int experience;


    public Driver( String first_name,String last_name, int experience){
        this.first_name = first_name;
        this.last_name = last_name;
        this.experience = experience;
    }

    public Driver(long id, String first_name, String last_name, int experience) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.experience = experience;
    }

    public Driver(){

    }

    public long getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public int getExperience() {
        return experience;
    }


    @Override
    public String toString() {
        return "Id: " + id + "\n" +
                "First name: " + first_name + "\n" +
                "Last name: " + last_name + "\n" +
                "Experience: " + experience + "\n";
    }
}
