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
public class FRestaTest {
    
    /**
     * Test of operar method, of class FResta.
     */
    @Test
    public void testOperar() {
        System.out.println("operar");
        Calculadora calc = new Calculadora();
	calc.addOperand("32");
        calc.addOperand(new FResta());
        calc.addOperand('5'+"");
        BigDecimal expResult = new BigDecimal(27).stripTrailingZeros();
        BigDecimal result = calc.equal();
        assertEquals(expResult,result);
    }

    /**
     * Test of toString2 method, of class FResta.
     */
    @Test
    public void testToString2() {
        System.out.println("toString2");
        FResta instance = new FResta();
        String expResult = " - ";
        String result = instance.toString2();
        assertEquals(expResult, result);
    }
    
}
