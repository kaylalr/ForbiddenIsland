/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.forbiddenisland.view;

import citbyui.cit260.model.Actor;
import citbyui.cit260.model.Card;
import forbiddenisland.ForbiddenIsland;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Kayla
 */
public class GiveTreasureCardView extends View {

    @Override
    public String[] getInputs() {
        String[] inputs = new String[2];

        int earth = 0;
        int fire = 0;
        int water = 0;
        int wind = 0;
        ArrayList<Actor> currActors = ForbiddenIsland.getPlayer().getActors();
        Actor currActor = currActors.get(0);
        ArrayList<Card> actorCards = currActor.getCards();

        for (Card card : actorCards) {
            if (card.getHand() == 1) {
                if (card.getName().equals("earth")) {
                    earth++;
                }
                if (card.getName().equals("fire")) {
                    fire++;
                }
                if (card.getName().equals("water")) {
                    water++;
                }
                if (card.getName().equals("wind")) {
                    wind++;
                }
            }
        }

        inputs[0] = this.getInput("Which card(s) would you like to give?\n"
                + "E - Earth Stone: " + earth + "\n"
                + "S - Statue of the Wind: " + wind + "\n"
                + "C - Crystal of Fire: " + fire + "\n"
                + "O - Ocean's Chalice: " + water + "\n");
        inputs[1] = this.getInput("\nHow many would you like to give?");
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {

        ArrayList<Actor> currActors = ForbiddenIsland.getPlayer().getActors();
        Actor currActor = currActors.get(0);
        Actor actorTwo = currActors.get(1);
        ArrayList<Card> actorCards = currActor.getCards();
              
        int numOfCards = parseInt(inputs[1]);
        int earth = 0;
        int fire = 0;
        int water = 0;
        int wind = 0;
        for (Card card : actorCards) {
            if (card.getHand() == 1) {
                if (card.getName().equals("earth")) {
                    earth++;
                }
                if (card.getName().equals("fire")) {
                    fire++;
                }
                if (card.getName().equals("water")) {
                    water++;
                }
                if (card.getName().equals("wind")) {
                    wind++;
                }
            }
        }

        boolean valid = false;

        switch (inputs[0]) {
            case "E":
                if (numOfCards > earth) {
                    return false;
                }
                this.console.println("You have chosen to give the Earth Stone.");
                int y = 0;
                int k = 0;
                do {
                    if (actorCards.get(y).getName().equals("earth") && actorCards.get(y).getHand() == 1) {
                        actorTwo.getCards().add(actorCards.get(y));
                        actorCards.get(y).setHand(0);
                        this.console.println(actorTwo.getCards());
                        k++;
                        if (k == numOfCards) {
                            valid = true;
                        }
                    }
                    y++;
                } while (valid == false);
                break;
            case "S":
                if (numOfCards > wind) {
                    return false;
                }
                this.console.println("You have chosen to give the Statue of the Wind.");
                y = 0;
                k = 0;
                do {

                    if (actorCards.get(y).getName().equals("wind") && actorCards.get(y).getHand() == 1) {
                        actorCards.get(y).setHand(0);
                        actorTwo.getCards().add(actorCards.get(y));
                        this.console.println(actorTwo.getCards());
                        k++;
                        if (k == numOfCards) {
                            valid = true;
                        }
                    }
                    y++;
                } while (valid == false);
                break;
            case "C":
                if (numOfCards > fire) {
                    return false;
                }
                this.console.println("You have chosen to give the Crystal of Fire.");
                y = 0;
                k = 0;
                do {

                    if (actorCards.get(y).getName().equals("fire") && actorCards.get(y).getHand() == 1) {
                        actorCards.get(y).setHand(0);
                        actorTwo.getCards().add(actorCards.get(y));
                        this.console.println(actorTwo.getCards());
                        k++;
                        if (k == numOfCards) {
                            valid = true;
                        }
                    }
                    y++;
                } while (valid == false);
                break;
            case "O":
                if (numOfCards > water) {
                    System.out.println("*****************************************"
                            + "You do not have that many cards to give"
                            + "*****************************************");
                    return false;
                }
                this.console.println("You have chosen to give the Ocean's Chalice.");
                y = 0;
                k = 0;
                do {

                    if (actorCards.get(y).getName().equals("water") && actorCards.get(y).getHand() == 1) {
                        actorCards.get(y).setHand(0);
                        actorTwo.getCards().add(actorCards.get(y));
                        this.console.println(actorTwo.getCards());
                        k++;
                        if (k == numOfCards) {
                            valid = true;
                        }
                    }
                    y++;
                } while (valid == false);
                break;
            default:
                ErrorView.display(this.getClass().getName(), "Invalid input");
                break;
        }
        if (inputs[0].length() > 1) {
            ErrorView.display(this.getClass().getName(), "Error: Invalid value.");
            return false;
        }
        return true;
    }

}
