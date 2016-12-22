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
public class Calculadora {

    private final BigDecimal[] operandos;
    private Funcion Foperando;
    private CalculadoraEstados estado;
    public AStack memory_stack;//modifico la clase stack para fines de uso

    //METHODS
    //GETTERS
    public BigDecimal getPrimerOperando() {
        return operandos[0];
    }

    public BigDecimal getTercerOperando() {
        return operandos[1];
    }

    public Funcion getOperacion() {
        return Foperando;
    }

    public CalculadoraEstados getEstado() {
        return this.estado;
    }

    public BigDecimal getOperando() {
        return estado.getOperand(this);
    }

    //SETTERS
    protected void setPrimerOperando(BigDecimal operando) {
        this.operandos[0] = operando;
    }

    protected void setOperacion(Funcion operando) {
        this.Foperando = operando;
    }

    protected void setTercerOperando(BigDecimal operando) {
        this.operandos[1] = operando;
    }

    protected void setEstado(CalculadoraEstados estadoEnElQueQuieroEstar) {
        this.estado = estadoEnElQueQuieroEstar;
    }

    public String addOperand(String operando) {
        if (estado.addOperand(operando,this)) {
            return operando + "";
        } else {
            return "E";
        }
    }

    public String addOperand(Funcion operando) {
        if(!(operando == null))
        {
            if (estado.addOperand(operando,this)) //return operando+"";
            {
                return "basurilla";
            }
            else
                //nunca va a llegar aqui 
                return "E";
        }
        else
            return "E";
    }

    //GETTER ENMASCARADO
    public BigDecimal equal() {
        return estado.equal(this);
    }

    //SETTERS CON ASPIRACIONES
    public void clear() {
        estado.clear(this);
    }

    public void allClear() {
        estado.allClear(this);
    }

    //CONSTRUCTORES
    public Calculadora() {
        this.operandos = new BigDecimal[2];
        this.operandos[0] = BigDecimal.ZERO;
        this.operandos[1] = null;
        this.estado = new EsperandoPrimerOperando();
        this.memory_stack = new AStack();
    }

}
