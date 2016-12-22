/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.funciones.operaciones;

import java.math.BigDecimal;
import modelo.Calculadora;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author david
 */
public class FSQRTest {
    
    /**
     * Test of operar method, of class FSQR.
     */
    @Test
    public void testOperar() {
        System.out.println("operar");
        Calculadora calc = new Calculadora();
        calc.addOperand("4");
        calc.addOperand(new FSQR());
        BigDecimal expResult = new BigDecimal(16).stripTrailingZeros();
        BigDecimal result = calc.equal();
        assertEquals(expResult,result);
    }

    /**
     * Test of toString2 method, of class FSQR.
     */
    @Test
    public void testToString2() {
        System.out.println("toString2");
        FSQR instance = new FSQR();
        String expResult = " ^ ";
        String result = instance.toString2();
        assertEquals(expResult, result);
    }
    
}
