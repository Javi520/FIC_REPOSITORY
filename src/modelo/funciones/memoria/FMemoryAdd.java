/*//iwnbb
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.funciones.memoria;

import java.math.BigDecimal;
import java.math.MathContext;
import modelo.Calculadora;
import modelo.funciones.Funcion;
import modelo.funciones.FuncionUnaria;

/**
 *
 * @author Javier Castro Vazquez
 * @author David Vega Guisasola
 */
public class FMemoryAdd extends FuncionUnaria {

    @Override
    public BigDecimal operar(Calculadora calc) {
        /*
        BigDecimal tempAux = calc.getEstado().getOperand();
        calc.memory_stack.push(calc.memory_stack.pop().add(tempAux, MathContext.UNLIMITED));
        return tempAux;
         */
        return calc.memory_stack.push(calc.memory_stack.pop().add(calc.getOperando(), MathContext.UNLIMITED));
    }

    @Override
    public String toString2() {
        return " M+ ";
    }

}
