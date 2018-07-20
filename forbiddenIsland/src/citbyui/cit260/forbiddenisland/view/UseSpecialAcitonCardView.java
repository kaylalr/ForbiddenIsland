/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.forbiddenisland.view;

import citbyui.cit260.model.Actor;
import citbyui.cit260.model.Card;
import forbiddenisland.ForbiddenIsland;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DD
 */
public class UseSpecialAcitonCardView extends View {

    @Override
    public String[] getInputs() {
        // test code
//        int SpecialActionCardUnflood = (int) Math.round(Math.random() * 5);
//        int SpecialActionCardHelicopter = (int) Math.round(Math.random() * 5);
        int SpecialActionCardUnflood = 0;
        int SpecialActionCardHelicopter = 0;
        ArrayList<Actor> currActors = ForbiddenIsland.getPlayer().getActors();
        Actor currActor = currActors.get(0);
        ArrayList<Card> actorCards = currActor.getCards();
        
        for (Card card : actorCards) {
            if (card.getHand() == 1) {
                if (card.getName().equals("helicopter")) {
                    SpecialActionCardUnflood++;
                    System.out.println(SpecialActionCardUnflood);
                }
                if (card.getName().equals("unfloodTile")) {
                    SpecialActionCardHelicopter++;
                    System.out.println(SpecialActionCardHelicopter);
                }
            }
        }
        int total = SpecialActionCardUnflood + SpecialActionCardHelicopter;
        String[] inputs = new String[1];
        if (total == 0) {
            inputs[0] = this.getInput("You have no Special Action cards.\nWould you like to use a different player's Special Action card?\n"
                    + "Y - yes\n"
                    + "N - no\n");
        } else {
            if (SpecialActionCardUnflood == 0) {
                inputs[0] = this.getInput("You have " + SpecialActionCardUnflood + " Unflood Tile card(s) and " + SpecialActionCardHelicopter + " Helicopter card(s)\n"
                    + "Which Speical Action card would you like to use?\n"
                        + "H - Helicopter\n"
                        + "D - Use different players Special Action card\n");
            } else if (SpecialActionCardHelicopter == 0) {
                inputs[0] = this.getInput("You have " + SpecialActionCardUnflood + " Unflood Tile card(s) and " + SpecialActionCardHelicopter + " Helicopter card(s)\n"
                    + "Which Speical Action card would you like to use?\n"
                        + "U - Unflood Tile\n"
                        + "D - Use different players Special Action card\n");
            } else {
                inputs[0] = this.getInput("You have " + SpecialActionCardUnflood + " Unflood Tile card(s) and " + SpecialActionCardHelicopter + " Helicopter card(s)\n"
                    + "Which Speical Action card would you like to use?\n"
                        + "U - Unflood Tile\n"
                        + "H - Helicopter\n"
                        + "D - Use different players Special Action card\n");
            }
        }
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {

        if (inputs[0].length() > 1) {
            ErrorView.display(this.getClass().getName(), "ERROR: Invalid input.");
            return false;
        }
        
        ArrayList<Actor> currActors = ForbiddenIsland.getPlayer().getActors();
        Actor currActor = currActors.get(0);
        ArrayList<Card> actorCards = currActor.getCards();
        
//        for (Card card : actorCards) {
//            if (card.getHand() == 1) {
//                if (card.getName().equals("helicopter")) {
//                    SpecialActionCardUnflood++;
//                    System.out.println(SpecialActionCardUnflood);
//                }
//                if (card.getName().equals("unfloodTile")) {
//                    SpecialActionCardHelicopter++;
//                    System.out.println(SpecialActionCardHelicopter);
//                }
//            }
//        }
        
        boolean valid = false;
        
        switch (inputs[0]) {
            case "U":
                //System.out.println("use unflood tile card - call unfloodTilesView()");
                int y = 0;
                do {
                    
                    if (actorCards.get(y).getName().equals("helicopter") && actorCards.get(y).getHand() == 1) {
                        actorCards.get(y).setHand(0);
                        valid = true;
                    }
                    y++;
                } while (valid == false);
                
                UnfloodTileView unfloodTileView = new UnfloodTileView();
                unfloodTileView.display();
                
                break;
            case "H":
                //System.out.println("use helicopter card - call helicopterView()?");
                y = 0;
                do {
                    
                    if (actorCards.get(y).getName().equals("unfloodTile") && actorCards.get(y).getHand() == 1) {
                        actorCards.get(y).setHand(0);
                        valid = true;
                    }
                    y++;
                } while (valid == false);
                
                FlyView flyView = new FlyView();
                flyView.display();
                break;
            case "D":
            case "Y":
                this.console.println("Use different player's Special Action card display other players cards");
                break;
            default:
                return true;
        }
        return true;
    }

}
