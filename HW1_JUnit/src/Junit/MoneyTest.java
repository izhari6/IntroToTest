package Junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import methods.*;

public class MoneyTest {
	@Test
	//This test checks Negate() with positive number
	public void TestNegateWithPositiveNum() {
		Money Positive=new Money(5,"USD") ;
		Money result=(Money) Positive.negate();
		Money expected=new Money(-5,"USD");
		assertTrue(expected.equals(result));
	}
	
	@Test
	//This test checks Negate() with Negative number
	public void TestNegateWithNegativeNum() {
		Money negative=new Money(-5,"USD") ;
		Money result=(Money) negative.negate();
		Money expected=new Money(5,"USD");
		assertTrue(expected.equals(result));
	}
	
	@Test
	//This test checks Negate() with Zero
	public void TestNegateWithZero() {
		Money zero=new Money(0,"USD") ;
		Money result=(Money) zero.negate();
		Money expected=new Money(0,"USD");
		assertTrue(expected.equals(result));
	}
	
	@Test
	//This test checks Negate() with null
	public void testNegatewithNull() {
		try 
		{
			Money nullM=new Money((Integer) null,"USD") ;
			Money result=(Money)nullM.negate();
			fail("Sholdnt be here! code is not good");
		}
		catch(NullPointerException e)
		{
			assertTrue(true);
		}		
		 
	}

}
