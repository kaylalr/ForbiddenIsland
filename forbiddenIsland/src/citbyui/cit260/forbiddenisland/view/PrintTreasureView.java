/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.forbiddenisland.view;

/**
 *
 * @author DD
 */
public class PrintTreasureView extends View{
    
    @Override
    public String[] getInputs() {
        String[] inputs = new String[1];
        inputs[0] = this.getInput("\nWhat list would you like to print?\n"
                + "L - Location of Treasures\n"
                + "S - Status of Treasures");
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {
        if (inputs[0].length() > 1) {
            ErrorView.display(this.getClass().getName(), "Error: Invalid value.");
            return false;
        }
        switch (inputs[0]) {
            case "L":
                //this.printLocation();
                PrintTreasureLocationView printTreasureLocationView = new PrintTreasureLocationView();
                printTreasureLocationView.display();
                break;
            case "S":
                //this.printStatus();
                PrintTreasureStatusView printTreasureStatusView = new PrintTreasureStatusView();
                printTreasureStatusView.display();
                break;
            default:
                ErrorView.display(this.getClass().getName(), "Invaid input");
                return false;
        }
        return false;
    }

//    private void printLocation() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    private void printStatus() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
}
