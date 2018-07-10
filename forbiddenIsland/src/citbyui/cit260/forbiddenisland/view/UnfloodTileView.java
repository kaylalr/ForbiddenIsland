/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.forbiddenisland.view;

import citbyui.cit260.forbiddenisland.exceptions.MapControlException;
import static java.lang.Integer.parseInt;
import java.util.Scanner;

/**
 *
 * @author DD
 */
public class UnfloodTileView extends View {

    @Override
    public String[] getInputs() {
        String[] inputs = new String[2];
        System.out.println("Which tile would you like to unflood? ");
        inputs[0] = this.getInput("Row:");
        inputs[1] = this.getInput("Column:");
        

        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {
        int row = parseInt(inputs[0]);
        int column = parseInt(inputs[1]);
        if (row < 1 || row > 5 || column < 1 || column > 5){
            System.out.println("Error: invalid input.");
           return false;
        }
        System.out.println("You have chosen Row - " + inputs[0] + ", and Column - " + inputs[1]);
        return true;
    }

}
