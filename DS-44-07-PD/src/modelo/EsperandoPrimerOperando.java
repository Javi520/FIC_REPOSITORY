/*//iwnbb
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.funciones.Funcion;
import java.math.BigDecimal;

/**
 *
 * @author Javier Castro Vazquez
 * @author David Vega Guisasola
 */
public class EsperandoPrimerOperando implements CalculadoraEstados {

    //ATRIBUTES
    //Calculadora calcInterna;
    //OVERRIDE FUNCTIONS
    @Override
    public boolean addOperand(String operando, Calculadora calc) {
        if (!operando.equals("")) {
            try {
                System.out.println("Estado 1 : addOperando( " + operando + " )");
                calc.setPrimerOperando(new BigDecimal(operando));
            } catch (Exception e) {
                return false;
            }
            return true;
        }
        return true;
    }

    /* 
     @Override
     public boolean addOperand(BigDecimal operando) {
     calcInterna.setPrimerOperando(operando);
     return true;
     } 
     */
    @Override
    public boolean addOperand(Funcion operando, Calculadora calc) {
        calc.setOperacion(operando);
        if (!operando.unSoloParametro()) {
            calc.setEstado(new EsperandoSegundoOperandoBi());
        } else {
            calc.setEstado(new EsperandoSegundoOperandoUn());
        }
        return true;
    }

    @Override
    public BigDecimal getOperand(Calculadora calc) {
        return calc.getPrimerOperando();
    }

    @Override
    public BigDecimal equal(Calculadora calc) {
        return calc.getPrimerOperando().stripTrailingZeros();
    }

    @Override
    public void allClear(Calculadora calc) {
        calc.setPrimerOperando(BigDecimal.ZERO);
    }

    @Override
    public void clear(Calculadora calc) {
        calc.setPrimerOperando(BigDecimal.ZERO);
    }
    /*
     //CONSTRUCTOR
     public EsperandoPrimerOperando(Calculadora calc) {
     this.calcInterna = calc;
     }
     */
    
}
