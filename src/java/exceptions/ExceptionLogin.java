/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author Honza
 */
public class ExceptionLogin extends Exception {

    /**
     * Creates a new instance of <code>ExceptionLogin</code> without detail
     * message.
     */
    public ExceptionLogin() {
    }

    /**
     * Constructs an instance of <code>ExceptionLogin</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public ExceptionLogin(String msg) {
        super(msg);
    }
}
