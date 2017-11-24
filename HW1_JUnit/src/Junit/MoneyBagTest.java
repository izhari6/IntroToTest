package Junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import methods.IMoney;
import methods.Money;
import methods.MoneyBag;

public class MoneyBagTest {
	private Money m2ils, m4usd, m0eur;
	private MoneyBag mb1;

	@Before
	public void setUp() throws Exception {
		m2ils = new Money(2, "ILS");
		m4usd = new Money(4, "USD");
		m0eur = new Money(0, "EUR");
	}
	
	@Test
	public void TestNegateWithPositiveNum() {
		MoneyBag mb = new MoneyBag(m4usd, m2ils);
		MoneyBag result=(MoneyBag) mb.negate();
		MoneyBag expected=new MoneyBag((Money)m4usd.negate(),(Money)m2ils.negate());
		assertTrue(expected.equals(result));
	}
	
	@Test
	//This test checks Negate() with Negative number
	public void TestNegateWithNegativeNum() {
		MoneyBag mb = new MoneyBag((Money)m4usd.negate(),(Money)m2ils.negate());
		MoneyBag result=(MoneyBag) mb.negate();
		MoneyBag expected=new MoneyBag(m4usd, m2ils);
		assertTrue(expected.equals(result));
	}
	
	@Test
	//This test checks Negate() with Zero
	public void TestNegateWithZero() {
		MoneyBag mb = new MoneyBag(m0eur,m2ils);
		MoneyBag result=(MoneyBag) mb.negate();
		MoneyBag expected=new MoneyBag(m0eur, (Money)m2ils.negate());
		assertTrue(expected.equals(result));
	}
	
	@Test
	//This test checks Negate() with null
	public void testNegatewithNull() {
		try 
		{
			MoneyBag mb = new MoneyBag(null,m2ils);
			MoneyBag result=(MoneyBag) mb.negate();
			fail("Sholdnt be here! code is not good");
		}
		catch(NullPointerException e)
		{
			assertTrue(true);
		}		
		 
	}

	@Test
	//This test checks Negate() with Zero
	public void TestNegateWithPosAndNeg() {
		MoneyBag mb = new MoneyBag((Money)m4usd.negate(),m2ils);
		MoneyBag result=(MoneyBag) mb.negate();
		MoneyBag expected=new MoneyBag(m4usd, (Money)m2ils.negate());
		assertTrue(expected.equals(result));
	}
	
	@Test
	//This test checks Negate() with Zero
	public void TestNegateEmptyMB() {
		MoneyBag mb = new MoneyBag();
		MoneyBag result=(MoneyBag) mb.negate();
		MoneyBag expected=new MoneyBag();
		assertTrue(expected.equals(result));
	}
}
