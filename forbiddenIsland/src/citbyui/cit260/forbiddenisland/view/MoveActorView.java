/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.forbiddenisland.view;

/**
 *
 * @author mcwis
 */
public class MoveActorView extends View {

    @Override
    public String[] getInputs() {
        String[] inputs = new String[2];

        this.console.println("Print instructions to move an actor ");
        
        inputs[0] = this.getInput("\nPlease choose a main menu item: ");
        
        inputs[1] = this.getInput("\nPlease choose a main menu item: ");
        
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
