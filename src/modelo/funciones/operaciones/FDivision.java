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
import modelo.funciones.FuncionBinaria;

/**
 *
 * @author Javier Castro Vazquez
 * @author David Vega Guisasola
 */
public class FDivision extends FuncionBinaria {

    @Override
    public BigDecimal operar(Calculadora calc) {
        return calc.getPrimerOperando().divide(calc.getTercerOperando(), 10, RoundingMode.HALF_UP);
    }

    @Override
    public String toString2() {
        return " / ";
    }

}
