package org.capitalGame;

import java.io.IOException;
import java.util.Scanner;

public class App
{
    public static void main( String[] args ) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println( " --- Capital Game  --- " );

        System.out.print("Enter your name: ");
        String username = scanner.nextLine();

        CapitalGame game = new CapitalGame(username);
        game.loadFile("assets/countries.txt");

        game.playGame();
        game.saveScore();

    }
}
