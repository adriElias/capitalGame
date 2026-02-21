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
                String country = parts[0].trim().toLowerCase();
                String capital = parts[1].trim().toLowerCase();
                countries.put(country, capital);
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

    public void playGame(){
        Scanner scanner = new Scanner(System.in);
        List<String> selectedCountries = getRandomCountries();

        for(int i = 0; i <= 9; i++){
            String country = selectedCountries.get(i);
            String correctCapital = countries.get(country);

            System.out.println("\n Question " + (i + 1) + "/10: What is the capital of " + country + "?");
            System.out.print("Your answer: ");
            String answer = scanner.nextLine();

            if(answer.equalsIgnoreCase(correctCapital)){
                System.out.println("Correct!\n");
            }else {
                System.out.println("\n Wrong!. The capital of " + country + " is: " + correctCapital + " \n");
            }
        }
    }
}
