/* //iwnbb
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.funciones.memoria;

import java.math.BigDecimal;
import modelo.Calculadora;
import modelo.funciones.FuncionUnaria;

/**
 *
 * @author Javier Castro Vazquez
 * @author David Vega Guisasola
 */
public class FMemoryReCall extends FuncionUnaria {

    @Override
    public BigDecimal operar(Calculadora calc) {
        return calc.memory_stack.peek();
    }

    @Override
    public String toString2()/*toString() no funciona la obligacion de implementarlo por que object ya lo hace y no lo detecta*/ {
        return " MR ";
    }

}
