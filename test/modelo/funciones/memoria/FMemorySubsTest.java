/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.funciones.memoria;

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
public class FMemorySubsTest {
    
    /**
     * Test of operar method, of class FMemorySubs.
     */
    @Test
    public void testOperar() {
        System.out.println("operar");
        Calculadora calc = new Calculadora();
        calc.addOperand("8");
        calc.addOperand(new FMemoryStore());
        calc.equal();
        calc.addOperand("3");
        calc.addOperand(new FMemorySubs());
        BigDecimal expResult = new BigDecimal(5);
        BigDecimal result = calc.equal();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of toString2 method, of class FMemorySubs.
     */
    @Test
    public void testToString2() {
        System.out.println("toString2");
        FMemorySubs instance = new FMemorySubs();
        String expResult = " M- ";
        String result = instance.toString2();
        assertEquals(expResult, result);
        
    }
    
}
