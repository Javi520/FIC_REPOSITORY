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
public class EsperandoSegundoOperandoUn implements CalculadoraEstados {

    //ATRIBUTES
    //Calculadora calcInterna;
    //String numero = "";//not so optimized to concat every number or comma here

    @Override
    public boolean addOperand(String operando, Calculadora calc) {
        if (!operando.equals("")) {
            try {
                System.out.println("Estado 2_Unario : addOperando( " + operando + " )");
                BigDecimal to_test = new BigDecimal(operando);
                calc.setPrimerOperando(to_test);
                calc.setEstado(new EsperandoPrimerOperando());
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
        if (operando.unSoloParametro()) {
            calc.setOperacion(operando);
        } else {
            calc.setOperacion(operando);
            calc.setEstado(new EsperandoSegundoOperandoBi());
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
        try
        {
            calc.setPrimerOperando(calc.getOperacion().operar(calc));
            calc.setTercerOperando(null);
            calc.setEstado(new EsperandoPrimerOperando());
            return calc.getPrimerOperando().stripTrailingZeros();
        }
        catch(Exception e)
        {
            //TODO nothing
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
            return calc.getPrimerOperando();
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
        /*
        if (calc.getTercerOperando() == null) {
            calc.setEstado(new EsperandoPrimerOperando());
        } else //calcInterna.setTercerOperando(BigDecimal.ZERO);
        {
            calc.setTercerOperando(null);
        }
        */
        calc.setEstado(new EsperandoPrimerOperando());
    }
    /*
    public EsperandoSegundoOperandoUn(Calculadora calc) {
        this.calcInterna = calc;
    }
*/

}
