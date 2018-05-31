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
        // TODO review the generated test code and remove the default call to fail.

    }
    
}
