/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.forbiddenisland.exceptions;

/**
 *
 * @author mcwis
 */
public class ForbiddenIslandException extends Exception{

    public ForbiddenIslandException() {
    }

    public ForbiddenIslandException(String string) {
        super(string);
    }

    public ForbiddenIslandException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public ForbiddenIslandException(Throwable thrwbl) {
        super(thrwbl);
    }

    public ForbiddenIslandException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
    
}
