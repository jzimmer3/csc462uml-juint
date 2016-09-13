package edu.elon.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ATMTest {
    
    private ATM atm;

    @Before
    public void setUp() throws Exception {
        atm = new ATM(10);
    }

    @After
    public void tearDown() throws Exception {
        atm = null;
    }

    @Test
    public void testATMDouble() {
        assertEquals(10.0, atm.getBalance(),0);
    }

    @Test
    public void testDepositGood() {
        atm.deposit(5);
        assertEquals(15.0, atm.getBalance(),0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testDepositBad() {
        atm.deposit(-5);
    }

    @Test
    public void testGetBalance() {
        assertEquals(10.0, atm.getBalance(),0);
    }

    @Test
    public void testToString() {
        assertEquals("Amount balance is $10.00", atm.toString());
    }

    @Test
    public void testWithdrawGood() {
        atm.withdraw(5);
        assertEquals(5.0, atm.getBalance(), 0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawBad() {
        atm.withdraw(-5);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawOverdraft() {
        atm.withdraw(15);
    }

}
