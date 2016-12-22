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
public class FMemoryClear extends FuncionUnaria {

    //no tiene sentido esto, asi que, esta operacion sera implementada a machete
    @Override
    public BigDecimal operar(Calculadora calc) {
        calc.memory_stack.remove();
        return BigDecimal.ZERO;//que se ponga a si mismo como estaba
    }

    @Override
    public String toString2() {
        return " MC ";
    }

}
