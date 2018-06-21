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
public class UnfloodTileView extends View{
    
    @Override
    public String[] getInputs() {
        String[] inputs = new String[1];
        inputs[0] = this.getInput("Which tile would you like to unflood? ");  
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {
        
        return true;
    }
    
}
