/*//Iwnbb
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.funciones;

import java.math.BigDecimal;
import modelo.Calculadora;

/**
 *
 * @author Javier Castro Vazquez
 * @author David Vega Guisasola
 */
public interface Funcion {

    public boolean unSoloParametro();

    public BigDecimal operar(Calculadora calc);

    public String toString2();//fuerzo a reimplementarlo
}
