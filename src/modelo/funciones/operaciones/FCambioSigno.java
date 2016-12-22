/*//iwnbb
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.funciones.operaciones;

import modelo.funciones.Funcion;
import java.math.BigDecimal;
import modelo.Calculadora;
import modelo.funciones.FuncionUnaria;

/**
 *
 * @author Javier Castro Vazquez
 * @author David Vega Guisasola
 */
public class FCambioSigno extends FuncionUnaria {

    @Override
    public BigDecimal operar(Calculadora calc) {
        return calc.getPrimerOperando().negate();
    }

    @Override
    public String toString2() {
        return " +/- ";
    }

}
