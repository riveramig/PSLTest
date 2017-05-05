package test;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import pslRefactor.ImpresorLCD;
import pslRefactor.LCDTester;

/**
 *
 * @author river
 */
public class TestLCD {
    
    private Throwable tw;
    private String rs="     -   -      \n" +
                      "  |   |   | | | \n" +
                      "     -   -   -  \n" +
                      "  | |     |   | \n" +
                      "     -   -      ";
    private ImpresorLCD impresorLCD;
    
    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    @Before
    public void creareStuff(){
        tw=null;
        impresorLCD = new ImpresorLCD();
        LCDTester test = new LCDTester();
    }
    
    @Test
    public void InputFail() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Cadena ingresada incorrecta");
        impresorLCD.procesar("2,12a34", 3);
        impresorLCD.procesar("11,123456", 4);
        impresorLCD.procesar("a,12345", 4);
        impresorLCD.procesar("2,12345,234", 2);
    }
    
    @Test
    public void InputWin() {
        assertEquals(true, impresorLCD.procesar("3,12345", 3));
        assertEquals(true, impresorLCD.procesar("10,2345553", 3));
        assertEquals(true, impresorLCD.procesar("1,1111", 2));
    }
    
}
