package org.capitalGame;

import java.io.IOException;

public class App
{
    public static void main( String[] args ) throws IOException {
        System.out.println( " --- Capital Game  --- " );

        String username = KeyboardReader.readLettersOnly("Enter your name: ");

        CapitalGame game = new CapitalGame(username);
        game.loadFile("assets/countries.txt");

        game.playGame();
        game.saveScore();

        KeyboardReader.close();
    }
}
