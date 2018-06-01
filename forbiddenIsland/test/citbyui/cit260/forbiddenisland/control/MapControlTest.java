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
public class MapControlTest {
    
    public MapControlTest() {
    }

    /**
     * Test of getTurnsLeft method, of class MapControl.
     */
    @Test
    public void testGetTurnsLeft() {
        System.out.println("getTurnsLeft");
        
        System.out.println("Test 1");
        int player1Turns = 11;
        int player2Turns = 10;
        int expResult = 19;
        int result = MapControl.getTurnsLeft(player1Turns, player2Turns);
        assertEquals(expResult, result);
        
        System.out.println("Test 2");
        player1Turns = 23;
        player2Turns = 10;
        expResult = -1;
        result = MapControl.getTurnsLeft(player1Turns, player2Turns);
        assertEquals(expResult, result);
        
        System.out.println("Test 3");
        player1Turns = -1;
        player2Turns = 10;
        expResult = -1;
        result = MapControl.getTurnsLeft(player1Turns, player2Turns);
        assertEquals(expResult, result); 
        
        System.out.println("Test 4");
        player1Turns = 11;
        player2Turns = 30;
        expResult = -1;
        result = MapControl.getTurnsLeft(player1Turns, player2Turns);
        assertEquals(expResult, result);
        
        System.out.println("Test 5");
        player1Turns = 11;
        player2Turns = -1;
        expResult = -1;
        result = MapControl.getTurnsLeft(player1Turns, player2Turns);
        assertEquals(expResult, result);
        
        System.out.println("Test 6");
        player1Turns = 0;
        player2Turns = 10;
        expResult = 30;
        result = MapControl.getTurnsLeft(player1Turns, player2Turns);
        assertEquals(expResult, result);
        
        System.out.println("Test 7");
        player1Turns = 19;
        player2Turns = 0;
        expResult = 21;
        result = MapControl.getTurnsLeft(player1Turns, player2Turns);
        assertEquals(expResult, result);
        
        System.out.println("Test 8");
        player1Turns = 10;
        player2Turns = 20;
        expResult = 10;
        result = MapControl.getTurnsLeft(player1Turns, player2Turns);
        assertEquals(expResult, result);
        
        System.out.println("Test 9");
        player1Turns = 20;
        player2Turns = 10;
        expResult = 10;
        result = MapControl.getTurnsLeft(player1Turns, player2Turns);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }
    
}
