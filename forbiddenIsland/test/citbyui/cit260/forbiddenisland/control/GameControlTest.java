/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.forbiddenisland.control;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mcwis
 */
public class GameControlTest {
    
    public GameControlTest() {
    }

    
    /**
     * Test of getTurnsLeft method, of class GameControl.
     */
    @Test
    public void testGetTurnsLeft() {
        System.out.println("getTurnsLeft");
        
        System.out.println("Test 1");
        int player1Turns = 11;
        int player2Turns = 10;
        int expResult = 19;
        int result = GameControl.getTurnsLeft(player1Turns, player2Turns);
        assertEquals(expResult, result);
        
        System.out.println("Test 2");
        player1Turns = 23;
        player2Turns = 10;
        expResult = -1;
        result = GameControl.getTurnsLeft(player1Turns, player2Turns);
        assertEquals(expResult, result);
        
        System.out.println("Test 3");
        player1Turns = -1;
        player2Turns = 10;
        expResult = -1;
        result = GameControl.getTurnsLeft(player1Turns, player2Turns);
        assertEquals(expResult, result); 
        
        System.out.println("Test 4");
        player1Turns = 11;
        player2Turns = 30;
        expResult = -1;
        result = GameControl.getTurnsLeft(player1Turns, player2Turns);
        assertEquals(expResult, result);
        
        System.out.println("Test 5");
        player1Turns = 11;
        player2Turns = -1;
        expResult = -1;
        result = GameControl.getTurnsLeft(player1Turns, player2Turns);
        assertEquals(expResult, result);
        
        System.out.println("Test 6");
        player1Turns = 0;
        player2Turns = 10;
        expResult = 30;
        result = GameControl.getTurnsLeft(player1Turns, player2Turns);
        assertEquals(expResult, result);
        
        System.out.println("Test 7");
        player1Turns = 19;
        player2Turns = 0;
        expResult = 21;
        result = GameControl.getTurnsLeft(player1Turns, player2Turns);
        assertEquals(expResult, result);
        
        System.out.println("Test 8");
        player1Turns = 10;
        player2Turns = 20;
        expResult = 10;
        result = GameControl.getTurnsLeft(player1Turns, player2Turns);
        assertEquals(expResult, result);
        
        System.out.println("Test 9");
        player1Turns = 20;
        player2Turns = 10;
        expResult = 10;
        result = GameControl.getTurnsLeft(player1Turns, player2Turns);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of actionsLeft method, of class GameControl.
     */
    @Test
    public void testGetActionsLeft() {
        System.out.println("getActionsLeft");
        
        System.out.println("Test 1");
        int playerTurns = 17;
        int expResult = 9;
        int result = GameControl.getActionsLeft(playerTurns);
        assertEquals(expResult, result);
        
        System.out.println("Test 2");
        playerTurns = 22;
        expResult = -1;
        result = GameControl.getActionsLeft(playerTurns);
        assertEquals(expResult, result);
        
        System.out.println("Test 3");
        playerTurns = 12;
        expResult = -1;
        result = GameControl.getActionsLeft(playerTurns);
        assertEquals(expResult, result);
        
        System.out.println("Test 4");
        playerTurns = 15;
        expResult = 15;
        result = GameControl.getActionsLeft(playerTurns);
        assertEquals(expResult, result);
        
        System.out.println("Test 5");
        playerTurns = 20;
        expResult = 0;
        result = GameControl.getActionsLeft(playerTurns);
        assertEquals(expResult, result);
        
    }
    
}