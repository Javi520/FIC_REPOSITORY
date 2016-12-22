/*//iwnbb
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.funciones.operaciones;

import modelo.funciones.Funcion;
import java.math.BigDecimal;
import java.math.RoundingMode;
import modelo.Calculadora;
import modelo.funciones.FuncionUnaria;

/**
 *
 * @author Javier Castro Vazquez
 * @author David Vega Guisasola
 */
public class FInversa extends FuncionUnaria {

    @Override
    public BigDecimal operar(Calculadora calc) {
        return BigDecimal.ONE.divide(calc.getPrimerOperando(), 10/*meanwhile*/, RoundingMode.HALF_UP);
    }

    @Override
    public String toString2() {
        return " 1/x ";
    }

}
