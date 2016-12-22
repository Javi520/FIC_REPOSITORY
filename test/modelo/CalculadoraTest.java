/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.math.BigDecimal;
import modelo.funciones.Funcion;
import modelo.funciones.operaciones.FCambioSigno;
import modelo.funciones.operaciones.FDivision;
import modelo.funciones.operaciones.FInversa;
import modelo.funciones.operaciones.FMultiplicacion;
import modelo.funciones.operaciones.FSQRT;
import modelo.funciones.operaciones.FSuma;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author david
 */
public class CalculadoraTest {

    /**
     * Test of getPrimerOperando method, of class Calculadora.
     */
    @Test
    public void testGetPrimerOperando() {
        System.out.println("getPrimerOperando");
        Calculadora instance = new Calculadora();
        instance.addOperand("2");
        BigDecimal expResult = new BigDecimal(2);
        BigDecimal result = instance.getPrimerOperando();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTercerOperando method, of class Calculadora.
     */
    @Test
    public void testGetTercerOperando() {
        System.out.println("getTercerOperando");
        Calculadora instance = new Calculadora();
        instance.addOperand("4");
        instance.addOperand(new FSuma());
        instance.addOperand("2");
        BigDecimal expResult = new BigDecimal(2);
        BigDecimal result = instance.getTercerOperando();
        assertEquals(expResult, result);

    }

    /**
     * Test of getOperacion method, of class Calculadora.
     */
    @Test
    public void testGetOperacion() {
        System.out.println("getOperacion");
        Calculadora instance = new Calculadora();
        instance.addOperand(new FSuma());
        String expResult = new FSuma().toString2();
        String result = instance.getOperacion().toString2();
        assertEquals(expResult, result);

    }

    /**
     * Test of getEstado method, of class Calculadora.
     *
     * @Test public void testGetEstado() { System.out.println("getEstado");
     * Calculadora instance = new Calculadora(); CalculadoraEstados expResult =
     * new EsperandoPrimerOperando(instance); CalculadoraEstados result =
     * instance.getEstado(); assertEquals(expResult, result); }
     */
    /**
     * Test of getOperando method, of class Calculadora.
     */
    @Test
    public void testGetOperando() {
        System.out.println("getOperando");
        Calculadora instance = new Calculadora();
        BigDecimal expResult;
        BigDecimal result;
        
        /*ESTADO 1*/
        instance.addOperand("8");
        expResult = new BigDecimal(8);
        result = instance.getOperando();
        assertEquals(expResult, result);
        
        /*TRANSICION*/
        instance.addOperand(new FSQRT());
        
        /*ESTADO UNARIO*/
        expResult = new BigDecimal(8);
        result = instance.getOperando();
        assertEquals(expResult, result);
        
        /*TRANSICION*/
        instance.addOperand(new FSuma());
        
        /*ESTADO BINARIO*/
            
            /*AUN NO METI TERCER OPERANDO*/
                expResult = new BigDecimal(8);
                result = instance.getOperando();
                assertEquals(expResult, result);
                
            /*AHORA SI*/
                instance.addOperand("12");
                expResult = new BigDecimal(12);
                result = instance.getOperando();
                assertEquals(expResult, result);     
                
    }

    /**
     * Test of setPrimerOperando method, of class Calculadora.
     */
    @Test
    public void testSetPrimerOperando() {
        System.out.println("setPrimerOperando");
        BigDecimal operando = new BigDecimal(8);
        Calculadora instance = new Calculadora();
        instance.setPrimerOperando(operando);
        BigDecimal expResult = new BigDecimal(8);
        BigDecimal result = instance.getPrimerOperando();
        assertEquals(expResult, result);

    }

    /**
     * Test of setOperacion method, of class Calculadora.
     */
    @Test
    public void testSetOperacion() {
        System.out.println("setOperacion");
        Funcion operando = new FSuma();
        Calculadora instance = new Calculadora();
        instance.setOperacion(operando);
        String expResult = new FSuma().toString2();
        String result = instance.getOperacion().toString2();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTercerOperando method, of class Calculadora.
     */
    @Test
    public void testSetTercerOperando() {
        System.out.println("setTercerOperando");
        BigDecimal operando = new BigDecimal(9);
        Calculadora instance = new Calculadora();
        instance.setTercerOperando(operando);
        BigDecimal expResult = new BigDecimal(9);
        BigDecimal result = instance.getTercerOperando();
        assertEquals(expResult, result);

    }

    /**
     * Test of addOperand method, of class Calculadora.
     */
    @Test
    public void testAddOperand_String() {
        System.out.println("addOperand(String ");
        Calculadora instance = new Calculadora();
        String expResult;
        String result;
        
        /*STRING QUE PROVOCA ERROR*/
        expResult = "E";
        result = instance.addOperand((String) null);//para evitar ambigüedad
        assertEquals(expResult, result);
        result = instance.addOperand((String) "7812..1231..123");//o cualquier otra string no numerica
        assertEquals(expResult, result);
        result = instance.addOperand((String) "dasdasd");//o cualquier otra string no numerica
        assertEquals(expResult, result);
        
        /*STRING QUE NO LO PROVOCA*/
        expResult;
        resultz
        
        /*_-__-__----__--___---___--___*/
        assertEquals(expResult, result);//para mirar si devuelve lo esperado
        assertTrue(true);//mirar si provoca algo nuevo el addoperand(string)
    }

    /**
     * Test of addOperand method, of class Calculadora.
     */
    @Test
    public void testAddOperand_Funcion() {
        System.out.println("addOperand");
        Calculadora instance = new Calculadora();
        String expResult;
        String result;
        Funcion operando;
        
        /*ESTADO BINARIO*/
            
            /*BUENA FUNCION*/
                operando = new FSuma();
                result = instance.addOperand(operando);
                expResult = "basurilla";
                assertEquals(expResult, result);
                assertTrue(instance.getOperacion().getClass()==FSuma.class);
            
            /*OTRA FUNCION*/
                operando = new FMultiplicacion();
                result = instance.addOperand(operando);
                expResult = "basurilla";
                assertEquals(expResult, result);
                assertTrue(instance.getOperacion().getClass()==FMultiplicacion.class);
            
            /*MALA FUNCION*/
//                /*OTRA FUNCION*/
//                    operando = new FMultiplicacion();
                operando = null;
                expResult = "E";
                result = instance.addOperand(operando);
                assertEquals(expResult, result);
                assertTrue(instance.getOperacion().getClass()==FMultiplicacion.class);
                
            /*FUNCION CUANDO YA HAY TERCER OPERANDO*/
                //tenemos en cuenta lo anterior
                instance.addOperand("2453");
                assertEquals(BigDecimal.ZERO, instance.equal());//0*2453
                instance.addOperand(new FDivision());
                instance.addOperand("2453");//lo vuelvo a hacer porque cambia de estado y se me vacia el tercer operando
                assertTrue(instance.getOperacion().getClass()==FDivision.class);
        
        /*TRANSICION A UNARIO*/
                instance.addOperand(new FSQRT());
                assertTrue(instance.getOperacion().getClass()==FSQRT.class);
                instance.addOperand(new FCambioSigno());
                assertTrue(instance.getOperacion().getClass()==FCambioSigno.class);
    }

    /**
     * Test of equal method, of class Calculadora.
     */
    @Test
    public void testEqual() {
        System.out.println("equal");
        Calculadora instance = new Calculadora();
        BigDecimal expResult;
        BigDecimal result;
        
        /*EQUAL EN EL ESTADO BINARIO*/
        
            /*OPERACIONES PROPENSAS A EXCEPCIONES*/
            instance.addOperand("8");
            instance.addOperand(new FDivision());
            instance.addOperand("0");
            assertTrue(instance.equal()==null);
            
            /*RESET*/
            instance.allClear();
        
            /*EL SEGUNDO OPERANDO ES 5*/
            instance.addOperand("8");
            instance.addOperand(new FSuma());
            instance.addOperand("5");
            expResult = new BigDecimal(13);
            result = instance.equal();
            assertEquals(expResult, result);
            
            /*EL SEGUNDO OPERANDO ES ""*/
            instance.addOperand("8");
            instance.addOperand(new FSuma());
            instance.addOperand("");
            expResult = new BigDecimal(16);//8+getPrimerOperando()
            result = instance.equal();
            assertEquals(expResult, result);
        
        /*EQUAL EN EL ESTADO UNARIO*/
            
            /*OPERACIONES PROPENSAS A EXCEPCIONES*/
            instance.addOperand("0");
            instance.addOperand(new FInversa());
            assertTrue(instance.equal()==null);
            
            /*CUALQUIER OTRO USO*/
            instance.addOperand("8");
            instance.addOperand(new FCambioSigno());
            expResult = new BigDecimal(-8);
            result = instance.equal();
            assertEquals(expResult, result);
        
        /*RESET*/
        instance.allClear();
        
        /*EQUAL EN EL ESTADO PRIMERO*/
        instance.addOperand("8");
        expResult = new BigDecimal(8);
        result = instance.equal();
        assertEquals(expResult, result);

    }

    /**
     * Test of clear method, of class Calculadora.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        
        /*ESTADO 1*/
            Calculadora instance = new Calculadora();
            instance.addOperand("8");
            instance.clear();
            BigDecimal result = instance.equal();
            BigDecimal expResult = BigDecimal.ZERO;
            assertEquals(expResult, result);
        
        /*ESTADO BINARIO*/
        
            /*CLEARING MIENTRAS SOLO HAY FUNCION Y NO TERCER OPERANDO*/
            instance.addOperand("8");
            instance.addOperand(new FSuma());
            instance.clear();
            result = instance.equal();
            expResult = instance.getPrimerOperando();
            assertEquals(expResult, result);
        
            /*CLEARING CUANDO HAY TERCER OPERANDO*/
            instance.addOperand("8");
            instance.addOperand(new FSuma());
            instance.addOperand("9");
            instance.clear();
            result = instance.equal();
            expResult = new BigDecimal(8+0);
            assertEquals(expResult, result);
            
        /*ESTADO UNARIO*/
            instance.addOperand("8");
            instance.addOperand(new FSQRT());
            instance.clear();
            result = instance.equal();
            expResult = instance.getPrimerOperando();
            assertEquals(expResult, result);
    }

    /**
     * Test of allClear method, of class Calculadora.
     */
    @Test
    public void testAllClear() {
        System.out.println("allClear");
        Calculadora instance = new Calculadora();
        BigDecimal result;
        BigDecimal expResult;
        
        /*PRIMER ESTADO*/
            instance.addOperand("8");
            instance.allClear();
            result = instance.equal();
            expResult = (BigDecimal.ZERO);
            assertEquals(expResult, result);
        
        /*TRANSICION*/
            instance.addOperand(new FInversa());
            
        /*ESTADO UNARIO*/
            instance.allClear();
            result = instance.equal();
            expResult = (BigDecimal.ZERO);
            assertEquals(expResult, result);
            
        /*TRANSICION*/
            instance.addOperand(new FSuma());
        
        /*ESTADO BINARIO*/
            instance.allClear();
            result = instance.equal();
            expResult = (BigDecimal.ZERO);
            assertEquals(expResult, result);          
                       
    }

    /**
     * Test of getEstado method, of class Calculadora.
     */
    @Test
    public void testOfgetEstado() {
        System.out.println("getEstado");
        CalculadoraEstados expResult;
        CalculadoraEstados result;
        Calculadora instance = new Calculadora();
        
        /*ESTADO_INICIAL*/
        expResult = new EsperandoPrimerOperando();
        result = instance.getEstado();
        assertTrue(expResult.getClass()==result.getClass());
        
        /*FUERZO CAMBIO DE ESTADO*/
        instance.addOperand(new FSuma());
        
        /*ESTADO_2_SI_FUNCION_BINARIA*/
        expResult = new EsperandoSegundoOperandoBi();
        result = instance.getEstado();
        assertTrue(expResult.getClass()==result.getClass());
        
        /*FUERZO CAMBIO DE ESTADO*/
        instance.addOperand(new FSQRT());
        
        /*ESTADO_2_SI_FUNCION_UNARIA*/
        expResult = new EsperandoSegundoOperandoUn();
        result = instance.getEstado();
        assertTrue(expResult.getClass()==result.getClass());
        
        /*FUERZO CAMBIO DE ESTADO*/
        instance.addOperand(new FSuma());
        
        /*ESTADO_2_SI_FUNCION_BINARIA*/
        expResult = new EsperandoSegundoOperandoBi();
        result = instance.getEstado();
        assertTrue(expResult.getClass()==result.getClass());
    }
}
