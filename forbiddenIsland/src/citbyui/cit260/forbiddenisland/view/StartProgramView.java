/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.forbiddenisland.view;
import java.util.Scanner;
/**
 *
 * @author mcwis
 */
public class StartProgramView {

    public StartProgramView() {
    }
    
    public void displayStartProgramView(){
      //DISPLAYS BANNER PAGE
        System.out.println("***************************************************************************");
        System.out.println("*  You are stuck on an island and the only way off is to collect all      *\n"
                + "*  the treasure and fly away.  But it’s not as easy as it sounds.  As     *\n"
                + "*  you are collecting the treasure, the island is being flooded!  You     *\n"
                + "*  need to hurry! Collect all the treasure as fast as you can and leave   *\n"
                + "*  before you become stuck, with no escape.                               *");
        System.out.println("***************************************************************************");
        System.out.println("\n");
        System.out.println("\n");
        
      //CALLING FOR NAME OF PLAYER
        Scanner inFile;
        inFile = new Scanner(System.in);
        System.out.println("What is your name: ");
        String name = inFile.nextLine();
        
      //CHECKS FOR VALID INPUT NAME
        while (name.length() < 3 || name.length() > 12){
            System.out.println("Error: Please re-enter a valid name: ");
            name = inFile.nextLine();
        } 
        System.out.println("Hello " + name + "! Enjoy the game!");
        
    }   
    
        
//  private String[] getInputs(){
//        System.out.println("Choose a Start option: ");
//        System.out.println("N - Start new game");
//        System.out.println("R - Restart current game");
//        System.out.println("I - View instructions");
//        System.out.println("E - Exit");
//            
//        String[] inputs = new String[1];
//        inputs[0] = "testInput";
//            
//        return inputs;
// }
//        
}
