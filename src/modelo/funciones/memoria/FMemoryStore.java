/*//iwnbb
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
public class FMemoryStore extends FuncionUnaria {

    @Override
    public BigDecimal operar(Calculadora calc) {
        BigDecimal aux = calc.getOperando();
        calc.memory_stack.push(aux);
        return aux;
    }

    @Override
    public String toString2() {
        return " MS ";
    }

}
