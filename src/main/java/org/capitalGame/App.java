package org.capitalGame;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( " --- Capital Game  --- " );
        CapitalGame game = new CapitalGame();
        game.loadFile("assets/countries.txt");

    }
}
