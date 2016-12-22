/*//iwnbb
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.math.BigDecimal;
import java.util.Stack;

/**
 *
 * @author Javier Castro Vazquez
 * @author David Vega Guisasola
 */
public class AStack /*extends Stack<BigDecimal>*/ {

    private Stack<BigDecimal> compuesto = new Stack();

    public synchronized BigDecimal peek() {
        try {
            return compuesto.peek();
        } catch (Exception e) {
            return BigDecimal.ZERO;
        }
    }

    public synchronized BigDecimal pop() {
        try {
            return compuesto.pop();
        } catch (Exception e) {
            return BigDecimal.ZERO;
        }
    }

    public BigDecimal push(BigDecimal e) {
        return compuesto.push(e);
    }

    public void remove() {
        compuesto.clear();
    }

}
