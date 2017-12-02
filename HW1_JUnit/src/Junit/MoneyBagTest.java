package Junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import methods.IMoney;
import methods.Money;
import methods.MoneyBag;

public class MoneyBagTest {
	private Money m2ils, m4usd, m0eur, mMAXusd, mMINusd;
	private MoneyBag mb1;

	@Before
	public void setUp() throws Exception {
		m2ils = new Money(2, "ILS");
		m4usd = new Money(4, "USD");
		m0eur = new Money(0, "EUR");
		mMAXusd = new Money(Integer.MAX_VALUE, "USD");
		mMINusd = new Money(Integer.MIN_VALUE, "USD");
	}
	
	@Test
	//Test that checks if we negate a money bag with 2 positive currencies
	public void TestNegateWithPositiveNum() {
		MoneyBag mb = new MoneyBag(m4usd, m2ils);
		MoneyBag result=(MoneyBag) mb.negate();
		MoneyBag expected=new MoneyBag((Money)m4usd.negate(),(Money)m2ils.negate());
		assertTrue(expected.equals(result));
	}
	
	@Test
	//Test that checks if we negate a money bag with 2 negative currencies
	public void TestNegateWithNegativeNum() {
		MoneyBag mb = new MoneyBag((Money)m4usd.negate(),(Money)m2ils.negate());
		MoneyBag result=(MoneyBag) mb.negate();
		MoneyBag expected=new MoneyBag(m4usd, m2ils);
		assertTrue(expected.equals(result));
	}
	
	@Test
	//Test that checks if we negate a money bag with positive currencie and zero currncie
	//it check what happen when we do negate to money bag that include's zero
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
	
	@Test
	//This test checks Negate() with Integer.MAX_VALUE
	public void TestNegateMaxInt() {
		MoneyBag mb = new MoneyBag(mMAXusd,m0eur);
		MoneyBag result=(MoneyBag) mb.negate();
		MoneyBag expected=new MoneyBag((Money)mMAXusd.negate(),(Money)m0eur.negate());
		assertTrue(expected.equals(result));
	}
	
	@Test
	//This test checks Negate() with Integer.MIN_VALUE
	public void TestNegateMinInt() {
		MoneyBag mb = new MoneyBag(mMINusd,m0eur);
		MoneyBag result=(MoneyBag) mb.negate();
		MoneyBag expected=new MoneyBag((Money)mMINusd.negate(),(Money)m0eur.negate());
		assertTrue(expected.equals(result));
	}
}
