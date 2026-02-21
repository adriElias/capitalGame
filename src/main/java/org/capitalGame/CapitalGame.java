package org.capitalGame;

import java.io.*;
import java.util.*;

public class CapitalGame {
    private final Map<String, String> countries = new HashMap<>();
    private final String username;
    private int score = 0;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public CapitalGame(String username) {
        this.username = username;
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

    private List<String> getRandomCountries() {
        List<String> countryList = new ArrayList<>(countries.keySet());
        Collections.shuffle(countryList);
        return countryList.subList(0, 10);
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        List<String> selectedCountries = getRandomCountries();

        for (int i = 0; i <= 9; i++) {
            String country = selectedCountries.get(i);
            String correctCapital = countries.get(country);

            System.out.println("\n Question " + (i + 1) + "/10: What is the capital of " + country + "?");
            System.out.print("Your answer: ");
            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase(correctCapital)) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("\n Wrong!. The capital of " + country + " is: " + correctCapital + " \n");
            }
        }
        System.out.println(username + ", your final score is: " + score + "/10\n");
    }

    public void saveScore() throws IOException {

        String file = "assets/classification.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(username + " - " + score + "/10");
            writer.newLine();
            //writer.close();
        }
        System.out.println("Score saved in " + file);


    }
}

