package com.assignment.examples;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MathsOperationTest {

    private MathsOperation mathsOperation;

    @Before
    public void init(){
        mathsOperation = new MathsOperation();
    }

    @Test
    public void testAddition(){
        assertEquals(7,mathsOperation.add(3,4));
    }

    @Test
    public void testAddition2(){
        assertEquals(74,mathsOperation.add(34,40));
    }

    @Test
    public void tsetAddition3(){
        assertEquals(93,mathsOperation.add(3,90));
    }

    @Test
    public void testDivision(){
        assertEquals(Double.valueOf(5), Double.valueOf(mathsOperation.division(10,2)));
    }

    @Test(expected = ArithmeticException.class)
    public void testDivision2(){
        assertEquals(Double.valueOf(5), Double.valueOf(mathsOperation.division(10,0)));
    }




}