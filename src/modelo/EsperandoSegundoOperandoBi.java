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
public class EsperandoSegundoOperandoBi implements CalculadoraEstados {

    //ATRIBUTES
    //Calculadora calcInterna;
    
    //String numero = "";//not so optimized to concat every number or comma here
    StringBuffer numero = new StringBuffer("");

    @Override
    public boolean addOperand(String operando, Calculadora calc) {
        if (!operando.equals("")) {
            try {
                System.out.println("Estado 2 : addOperando( " + operando + " )");
                BigDecimal to_test = new BigDecimal(operando);
                calc.setTercerOperando(to_test);
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
        calcInterna.setTercerOperando(operando);
        return true;
    }
     */
    @Override
    public boolean addOperand(Funcion operando, Calculadora calc) {
        if (calc.getTercerOperando() == null) {
            if (!operando.unSoloParametro()) {
                calc.setOperacion(operando);
            } else {
                calc.setOperacion(operando);
                calc.setEstado(new EsperandoSegundoOperandoUn());
            }
            calc.setOperacion(operando);
        } else {
            calc.setPrimerOperando(calc.getOperacion().operar(calc));
            System.out.println(calc.getOperando()+"para probar");
            calc.setOperacion(operando);
            calc.setTercerOperando(null);
            if (!operando.unSoloParametro()) {
                calc.setEstado(new EsperandoSegundoOperandoBi());
            } else {
                calc.setEstado(new EsperandoSegundoOperandoUn());
            }
        }
        return true;
    }

    /**
     * como hace la calculadora de windows 10 (no es mi modelo a seguir, es la
     * que tenia a mano en este momento)
     *
     * @param calc
     * @return String
     */
    @Override
    public BigDecimal equal(Calculadora calc) {
    try{
        if (calc.getTercerOperando() == null) {
            calc.setTercerOperando(calc.getPrimerOperando());
        }
        calc.setPrimerOperando(calc.getOperacion().operar(calc));
        calc.setTercerOperando(null);
        calc.setEstado(new EsperandoPrimerOperando());
        return calc.getPrimerOperando().stripTrailingZeros();
    }
    catch(Exception e)
    {
        //TODO still nothing
    }
    return null;
    }

    /**
     * como hace la calculadora de windows 10 (no es mi modelo a seguir, es la
     * que tenia a mano en este momento)
     *
     * @param calc
     * @return BigDecimal
     */
    @Override
    public BigDecimal getOperand(Calculadora calc) {
        if (calc.getTercerOperando() == null) {
            return calc.getPrimerOperando();
        } else {
            return calc.getTercerOperando();
        }
    }

    @Override
    public void allClear(Calculadora calc) {
        System.out.println("borro todo");
        calc.setPrimerOperando(BigDecimal.ZERO);
        calc.setTercerOperando(null);
        calc.setEstado(new EsperandoPrimerOperando());
    }

    @Override
    public void clear(Calculadora calc) {
        if (calc.getTercerOperando() == null) {
            calc.setEstado(new EsperandoPrimerOperando());
        } else {
            calc.setTercerOperando(BigDecimal.ZERO);
        }
    }
/*
    public EsperandoSegundoOperandoBi(Calculadora calc) {
        this.calcInterna = calc;
    }
*/

}
