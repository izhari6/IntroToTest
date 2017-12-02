package Junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import methods.*;

public class MoneyTest {
	private Money	positive, negative, zero, nullM, mMAXusd, mMINusd, expected, result;
	
	@Before
	public void setUp() throws Exception {
		positive=new Money(5,"USD");
		negative=new Money(-5,"EUR");
		zero=new Money(0,"ILS");
		nullM=null;
		mMAXusd = new Money(Integer.MAX_VALUE, "USD");
		mMINusd = new Money(Integer.MIN_VALUE, "EUR");
	}
	
	@Test
	//This test checks Negate() with positive number
	public void TestNegateWithPositiveNum() {
		result=(Money)(positive.negate());
		expected=new Money(-5,"USD");
		assertTrue(expected.equals(result));
	}
	
	@Test
	//This test checks Negate() with Negative number
	public void TestNegateWithNegativeNum() {
		result=(Money)(negative.negate());
		expected=new Money(5,"EUR");
		assertTrue(expected.equals(result));
	}
	
	@Test
	//This test checks Negate() with Zero
	public void TestNegateWithZero() {
		result=(Money)(zero.negate());
		expected=new Money(0,"ILS");
		assertTrue(expected.equals(result));
	}
	
	@Test
	//This test checks Negate() with null
	public void testNegatewithNull() {
		try 
		{
			result=(Money)nullM.negate();
			fail("Should'nt be here! code is not good");
		}
		catch(NullPointerException e)
		{
			assertTrue(true);
		}		
	}

	@Test
	//This test checks Negate() with Integer.MAX_VALUE
	public void TestNegateMaxInt() {
		result=(Money)(mMAXusd.negate());
		expected=new Money(-1*Integer.MAX_VALUE,"USD");
		assertTrue(expected.equals(result));
	}
	
	@Test
	//This test checks Negate() with Integer.MIN_VALUE
	public void TestNegateMinInt() {
		result=(Money)(mMINusd.negate());
		expected=new Money(-1*Integer.MIN_VALUE,"EUR");
		assertTrue(expected.equals(result));
	}
}
