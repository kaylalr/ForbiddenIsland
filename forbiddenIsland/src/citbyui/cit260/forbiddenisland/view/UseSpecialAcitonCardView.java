/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.forbiddenisland.view;

import java.util.Scanner;

/**
 *
 * @author DD
 */
public class UseSpecialAcitonCardView extends View{

    @Override
    public String[] getInputs() {
        // test code
        int SpecialActionCardUnflood = (int)Math.round(Math.random() * 5);
        int SpecialActionCardHelicopter = (int)Math.round(Math.random() * 5);
        int total = SpecialActionCardUnflood + SpecialActionCardHelicopter;
        String[] inputs = new String[1];
                    if (total == 0) {
                        inputs[0] = this.getInput("You have no Special Action cards.\nWould you like to use a different player's Special Action card?\n"
                    + "Y - yes\n"
                    + "N - no\n"); 
//            System.out.println("You have no Special Action cards.\nWould you like to use a different player's Special Action card?\n"
//                    + "Y - yes\n"
//                    + "N - no\n");
            }
            else {
            inputs[0] = this.getInput("You have " + SpecialActionCardUnflood + " Unflood Tile card(s) and " + SpecialActionCardHelicopter + " Helicopter card(s)\n"
                    + "Which Speical Action card would you like to use?\n");
                if(SpecialActionCardUnflood == 0){
                    
                    inputs[0] = this.getInput("H - Helicopter\n"
                            + "D - Use different players Special Action card\n");
                }
                else if(SpecialActionCardHelicopter == 0) {
                    inputs[0] = this.getInput("U - Unflood Tile\n"
                            + "D - Use different players Special Action card\n");
                } 
                else {
                    inputs[0] = this.getInput("U - Unflood Tile\n"
                            + "H - Helicopter\n"
                            + "D - Use different players Special Action card\n");
                }
            }
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {
        
        if(inputs[0].length() > 1){
            System.out.println("ERROR: Please ReEnter a valid input...");
            return false;
        }
        switch(inputs[0]){
            case "U":
                System.out.println("use unflood tile card - call unfloodTilesView()");
                break;
            case "H":
                System.out.println("use helicopter card - call helicopterView()?");
                break;
            case "D":
            case "Y":
                System.out.println("use different player's Special Action card display other players cards");
                break;
            default:
                return true;
        }
        return true;
    }
    
}
