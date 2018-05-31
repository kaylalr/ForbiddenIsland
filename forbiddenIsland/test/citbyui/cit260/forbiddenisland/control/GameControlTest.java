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
     * Test of getCardsLeft method, of class GameControl.
     */
    @Test
    public void testGetCardsLeft() {
        System.out.println("getCardsLeft");
        
        System.out.println("Test 1");
        int player1Cards = 0;
        int player2Cards = 0;
        int expResult = 0;
        int result = GameControl.getCardsLeft(player1Cards, player2Cards);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
