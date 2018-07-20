/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forbiddenisland;

import citbyui.cit260.forbiddenisland.exceptions.ForbiddenIslandException;
import citbyui.cit260.forbiddenisland.exceptions.GameControlException;
import citbyui.cit260.forbiddenisland.view.StartProgramView;
import citbyui.cit260.model.Actor;
import citbyui.cit260.model.Card;
import citbyui.cit260.model.Game;
import citbyui.cit260.model.Location;
import citbyui.cit260.model.Map;
import citbyui.cit260.model.Player;
import citbyui.cit260.model.Treasure;
import citbyui.cit260.model.TreasureLocation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mcwis
 */
public class ForbiddenIsland {

    /**
     * @param args the command line arguments
     */
    public Game game;
    private static Game currentGame = null;
    private static PrintWriter logFile = null;
    private static Player player = null;
    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;

    
    

    public static void main(String[] args) {
        // TODO code application logic here
        try {
            ForbiddenIsland.inFile = new BufferedReader(new InputStreamReader(System.in));
            ForbiddenIsland.outFile = new PrintWriter(System.out, true);
            ForbiddenIsland.logFile = new PrintWriter("logFile.txt");
            
            StartProgramView startProgramView = new StartProgramView();
            startProgramView.display();
        
        } catch (Throwable te) {
            System.out.println(te.getMessage());
            te.printStackTrace();
        }
        finally{
            try {
                if (ForbiddenIsland.inFile != null){
                    ForbiddenIsland.inFile.close();
                }
                if (ForbiddenIsland.outFile != null){
                 ForbiddenIsland.outFile.close();
                }
                if (logFile != null){
                    logFile.close();
                }
            } catch (IOException ex) {
                System.out.println("Error closing files");
                return;
            }
        }

    }

    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        ForbiddenIsland.logFile = logFile;
    }

    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        ForbiddenIsland.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        ForbiddenIsland.inFile = inFile;
    }
   

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        ForbiddenIsland.currentGame = currentGame;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        ForbiddenIsland.player = player;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
    
}
