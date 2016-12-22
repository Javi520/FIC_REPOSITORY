/* //iwnbb
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.funciones.operaciones;

import java.math.BigDecimal;
import java.math.MathContext;
import modelo.Calculadora;
import modelo.funciones.FuncionBinaria;

/**
 *
 * @author Javier Castro Vazquez
 * @author David Vega Guisasola
 */
public class FSuma extends FuncionBinaria {

    @Override
    public BigDecimal operar(Calculadora calc) {
        return (calc.getPrimerOperando().add(calc.getTercerOperando(), MathContext.UNLIMITED));
    }

    @Override
    public String toString2()/*toString() no funciona la obligacion de implementarlo por que object ya lo hace y no lo detecta*/ {
        return " + ";
    }

}
