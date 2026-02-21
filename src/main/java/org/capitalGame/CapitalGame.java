package org.capitalGame;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CapitalGame {
    private Map<String, String> countries = new HashMap<>();

    public CapitalGame() {

    }

    public void loadFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                String country = parts[0].trim();
                String capital = parts[1].trim();
                countries.put(country, capital).toLowerCase();
            }
            reader.close();

            System.out.println("Loaded file.");
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    private List<String> getRandomCountries(){
        List<String> countryList = new ArrayList<>(countries.keySet());
        Collections.shuffle(countryList);
        return  countryList.subList(0,10);
    }

}
