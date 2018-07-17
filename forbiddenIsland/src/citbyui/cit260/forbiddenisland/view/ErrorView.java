/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.forbiddenisland.view;

import forbiddenisland.ForbiddenIsland;
import java.io.PrintWriter;

/**
 *
 * @author mcwis
 */
public class ErrorView {

    private static PrintWriter console = ForbiddenIsland.getOutFile();
    private static PrintWriter log = ForbiddenIsland.getLogFile();

    public static void display(String className, String errorMessage) {

        console.println("\n---- ERROR ----------------------------------------------"
                + "\n" + errorMessage
                + "\n---------------------------------------------------------");
        log.printf("%n%n%s", className + " - " + errorMessage);
    }
}
