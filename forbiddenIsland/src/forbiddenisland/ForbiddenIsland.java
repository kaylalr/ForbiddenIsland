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
    private static Player player = null;

    public static void main(String[] args) {
        // TODO code application logic here
        try {
            StartProgramView startProgramView = new StartProgramView();
            startProgramView.display();
        } catch (Exception ex) {
            //   Logger.getLogger(ForbiddenIsland.class.getName()).log(Level.SEVERE, null, gce);
            System.out.println(ex.getMessage());
        } catch (Throwable te) {
            System.out.println(te.getMessage());
            te.printStackTrace();
        }

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
