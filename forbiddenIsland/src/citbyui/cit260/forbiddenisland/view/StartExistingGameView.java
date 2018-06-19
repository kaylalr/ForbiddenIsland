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
public class StartExistingGameView extends View{

//    void displayStartExistingGameView() {
//        System.out.println("*** display displayStartExistingGameView() ***");
//    }
    
    @Override
    public String[] getInputs() {
        String[] inputs = new String[1];
        System.out.println("*** getInputs() called ***");
        return inputs;
    }
    
    @Override
    public boolean doAction(String[] inputs) {
        System.out.println("*** doAction() called ***");
        return true;
    }
}
