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
public interface CalculadoraEstados {

    public boolean addOperand(String operando, Calculadora calc);
    //public boolean addOperand(BigDecimal operando);

    //ESTAS FUNCIONES CAMBIAN DE ESTADO
    public boolean addOperand(Funcion operando, Calculadora calc);

    public BigDecimal equal(Calculadora calc);

    public void allClear(Calculadora calc);

    //FIN DE ESTAS FUNCIONES CAMBIAN DE ESTADO
    public void clear(Calculadora calc);

    public BigDecimal getOperand(Calculadora calc);

}
