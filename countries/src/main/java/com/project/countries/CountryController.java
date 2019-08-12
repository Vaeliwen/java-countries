package com.project.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/data")
public class CountryController {

    //localhost:5000/data/names/all
    @GetMapping(value = "/names/all",
                produces = {"application/json"})
    public ResponseEntity<?> getAllNames(){
        ArrayList<Country> tempArray = CountriesApplication.ourCountryList.countryList;
        ArrayList<String> rtnCountries = new ArrayList<String>();
        for (Country c: tempArray){
            rtnCountries.add(c.getName());
        }
        rtnCountries.sort((c1, c2) -> (c1.compareToIgnoreCase(c2)));
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }

    //localhost:5000/data/names/start/{letter}
    @GetMapping(value = "names/start/{letter}",
                produces = {"application/json"})
    public ResponseEntity<?> getCountriesByLetter(@PathVariable char letter){
        ArrayList<Country> tempArray = CountriesApplication.ourCountryList.findCountries(c -> c.getName().toUpperCase().charAt(0) == Character.toUpperCase(letter));
        ArrayList<String> rtnCountries = new ArrayList<String>();
        for (Country c: tempArray) {
            rtnCountries.add(c.getName());
        }
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }

    //localhost:5000/data/names/size/{number}
    @GetMapping(value = "names/size/{number}",
                produces = {"application/json"})
    public ResponseEntity<?> getCountriesBySize(@PathVariable int number){
        ArrayList<Country> tempArray = CountriesApplication.ourCountryList.findCountries(c -> c.getName().length() >= number);
        ArrayList<String> rtnCountries = new ArrayList<String>();
        for (Country c: tempArray) {
            rtnCountries.add(c.getName());
        }
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }

    //localhost:5000/data/population/size/{people}
    @GetMapping(value = "population/size/{people}",
                produces = {"application/json"})
    public ResponseEntity<?> getCountriesByPop(@PathVariable int people){
        ArrayList<Country> tempArray = CountriesApplication.ourCountryList.findCountries(c -> c.getPopulation() >= people);
        ArrayList<String> rtnCountries = new ArrayList<String>();
        for (Country c: tempArray){
            rtnCountries.add(c.toString());
        }
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }

    //localhost:5000/data/population/min
    @GetMapping(value = "population/min",
                produces = {"application/json"})
    public ResponseEntity<?> getSmallestCountry(){
        ArrayList<Country> tempArray = CountriesApplication.ourCountryList.countryList;
        tempArray.sort((c1, c2) -> c1.getPopulation() - c2.getPopulation());
        Country rtnCountry = tempArray.get(0);
        return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
    }

    //localhost:5000/data/population/max
    @GetMapping(value = "population/max",
            produces = {"application/json"})
    public ResponseEntity<?> getLargestCountry(){
        ArrayList<Country> tempArray = CountriesApplication.ourCountryList.countryList;
        tempArray.sort((c1, c2) -> c2.getPopulation() - c1.getPopulation());
        Country rtnCountry = tempArray.get(0);
        return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
    }

    //localhost:5000/data/age/age/{age}
    @GetMapping(value = "age/age/{age}",
                produces = {"application/json"})
    public ResponseEntity<?> getCountryMedianAges(@PathVariable int age){
        ArrayList<Country> rtnCountries = CountriesApplication.ourCountryList.findCountries(c -> c.getMedianAge() >= age);
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }

    //localhost:5000/data/age/min
    @GetMapping(value = "age/min",
                produces = {"application/json"})
    public ResponseEntity<?> getYoungestCountry(){
        ArrayList<Country> tempArray = CountriesApplication.ourCountryList.countryList;
        tempArray.sort((c1, c2) -> c1.getMedianAge() - c2.getMedianAge());
        Country rtnCountry = tempArray.get(0);
        return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
    }

    //localhost:5000/data/age/max
    @GetMapping(value = "age/max",
            produces = {"application/json"})
    public ResponseEntity<?> getOldestCountry(){
        ArrayList<Country> tempArray = CountriesApplication.ourCountryList.countryList;
        tempArray.sort((c1, c2) -> c2.getMedianAge() - c1.getMedianAge());
        Country rtnCountry = tempArray.get(0);
        return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
    }
}
