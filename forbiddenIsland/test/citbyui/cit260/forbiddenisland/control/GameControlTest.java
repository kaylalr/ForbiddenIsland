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
        int player1Cards = 1;
        int player2Cards = 10;
        int expResult = 19;
        int result = GameControl.getCardsLeft(player1Cards, player2Cards);
        assertEquals(expResult, result);
        
        System.out.println("Test 2");
        player1Cards = -1;
        player2Cards = 10;
        expResult = -1;
        result = GameControl.getCardsLeft(player1Cards, player2Cards);
        assertEquals(expResult, result);
        
        System.out.println("Test 3");
        player1Cards = 31;
        player2Cards = 10;
        expResult = -1;
        result = GameControl.getCardsLeft(player1Cards, player2Cards);
        assertEquals(expResult, result);
        
        System.out.println("Test 4");
        player1Cards = 21;
        player2Cards = -2;
        expResult = -1;
        result = GameControl.getCardsLeft(player1Cards, player2Cards);
        assertEquals(expResult, result);
        
        System.out.println("Test 5");
        player1Cards = 11;
        player2Cards = 34;
        expResult = -1;
        result = GameControl.getCardsLeft(player1Cards, player2Cards);
        assertEquals(expResult, result);
        
        System.out.println("Test 6");
        player1Cards = 0;
        player2Cards = 10;
        expResult = 20;
        result = GameControl.getCardsLeft(player1Cards, player2Cards);
        assertEquals(expResult, result);
        
        System.out.println("Test 7");
        player1Cards = 11;
        player2Cards = 0;
        expResult = 19;
        result = GameControl.getCardsLeft(player1Cards, player2Cards);
        assertEquals(expResult, result);
        
        System.out.println("Test 8");
        player1Cards = 1;
        player2Cards = 29;
        expResult = 0;
        result = GameControl.getCardsLeft(player1Cards, player2Cards);
        assertEquals(expResult, result);
        
        System.out.println("Test 9");
        player1Cards = 29;
        player2Cards = 1;
        expResult = 0;
        result = GameControl.getCardsLeft(player1Cards, player2Cards);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
}