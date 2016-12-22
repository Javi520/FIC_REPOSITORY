/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.math.BigDecimal;
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
public class AStackTest {

    /**
     * Test of peek method, of class AStack.
     */
    @Test
    public void testPeek() {
        System.out.println("peek");
        AStack instance = new AStack();
        instance.push(new BigDecimal(8));
        instance.push(new BigDecimal(5));
        BigDecimal expResult = new BigDecimal(5);
        BigDecimal result = instance.peek();
        assertEquals(expResult, result);
    }

    /**
     * Test of pop method, of class AStack.
     */
    @Test
    public void testPop() {
        System.out.println("pop");
        AStack instance = new AStack();
        BigDecimal result = instance.pop();
        BigDecimal expResult = BigDecimal.ZERO;
        assertEquals(expResult, result);

        instance.push(new BigDecimal(8));
        instance.push(new BigDecimal(5));
        expResult = new BigDecimal(5);
        result = instance.pop();
        assertEquals(expResult, result);
    }

    /**
     * Test of push method, of class AStack.
     */
    @Test
    public void testPush() {
        System.out.println("push");
        BigDecimal e = new BigDecimal(5);
        AStack instance = new AStack();
        BigDecimal expResult = new BigDecimal(5);
        BigDecimal result = instance.push(e);
        assertEquals(expResult, result);
    }

    /**
     * Test of remove method, of class AStack.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        AStack instance = new AStack();
        instance.push(new BigDecimal(8));
        instance.push(new BigDecimal(5));
        BigDecimal expResult = new BigDecimal(0);
        instance.remove();
        BigDecimal result = instance.peek();
        assertEquals(expResult, result);

    }

}
