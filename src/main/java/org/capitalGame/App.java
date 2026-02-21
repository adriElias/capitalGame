package org.capitalGame;

import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println( " --- Capital Game  --- " );
        CapitalGame game = new CapitalGame();
        game.loadFile("assets/countries.txt");

        System.out.print("Enter your name: ");
        String username = scanner.nextLine();



    }
}
