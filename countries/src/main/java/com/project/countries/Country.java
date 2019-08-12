package com.project.countries;

public class Country {

    private String name;
    private int population;
    private int landMass;
    private int medianAge;

    public Country(String name, int pop, int mass, int age){
        setName(name);
        setPopulation(pop);
        setLandMass(mass);
        setMedianAge(age);
    }
    public Country(Country toClone){
        this.name = toClone.getName();
        this.population = toClone.getPopulation();
        this.landMass = toClone.getLandMass();
        this.medianAge = toClone.getMedianAge();
    }

    // Getters
    public String getName(){
        return name;
    }
    public int getPopulation(){
        return population;
    }
    public int getLandMass(){
        return landMass;
    }
    public int getMedianAge(){
        return medianAge;
    }

    // Setters
    public void setName(String name){
        this.name = name;
    }
    public void setPopulation(int pop){
        this.population = pop;
    }
    public void setLandMass(int mass){
        this.landMass = mass;
    }
    public void setMedianAge(int age){
        this.medianAge = age;
    }

    @Override
    public String toString(){
        return "Country{" + "name=" + name + ", population=" + population + ", landMass=" + landMass + ", medianAge=" + medianAge + "}";
    }
}
