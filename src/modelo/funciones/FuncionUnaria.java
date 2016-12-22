/*//Iwnbb
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.funciones;

/**
 *
 * @author Javier Castro Vazquez
 * @author David Vega Guisasola
 */
public abstract class FuncionUnaria implements Funcion/**/ {

    @Override
    public boolean unSoloParametro() {
        return true;
    }
}
