package test;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Calculator.Calculator;

public class CalculatorTest implements TestCalculator {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("TestCalculator.CalculatorTest");
    }

	/* (non-Javadoc)
	 * @see test.TestCalculator#testEmptyString()
	 */
	@Override
	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	/* (non-Javadoc)
	 * @see test.TestCalculator#testOneNumber()
	 */
	@Override
	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	/* (non-Javadoc)
	 * @see test.TestCalculator#testTwoNumbers()
	 */
	@Override
	@Test
	public void testTwoNumbers(){
		assertEquals(3, Calculator.add("1,2"));
	}

	/* (non-Javadoc)
	 * @see test.TestCalculator#testThreeNumbers()
	 */
	@Override
	@Test
    public void testThreeNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }

    /* (non-Javadoc)
	 * @see test.TestCalculator#testNewLine()
	 */
    @Override
	@Test
    public void testNewLine(){
    	assertEquals(6, Calculator.add("1\n2,3"));
    }

    /* (non-Javadoc)
	 * @see test.TestCalculator#testNegativeNumver()
	 */
    @Override
	@Test
    public void testNegativeNumver(){
    	try {
			Calculator.add("-1,2");
		}
		catch (IllegalArgumentException e){
			assertEquals(e.getMessage(), "Negatives not allowed: -1");
		}

		try {
			Calculator.add("2,-4,3,-5");
		}
		catch (IllegalArgumentException e){
			assertEquals(e.getMessage(), "Negatives not allowed: -4,-5");
		}
    }

    /* (non-Javadoc)
	 * @see test.TestCalculator#testOverThousand()
	 */
    @Override
	@Test
    public void testOverThousand(){
    	assertEquals(2, Calculator.add("1000,2"));
    }

    /* (non-Javadoc)
	 * @see test.TestCalculator#testOtherDelimiter()
	 */
    @Override
	@Test
    public void testOtherDelimiter(){
    	assertEquals(3, Calculator.add("//;\n1;2"));
    }
}