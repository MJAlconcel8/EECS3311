package unittesting;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyTimeTest {

	@Test
	public void test1() {
		MyTime mt1 = new MyTime(12, 0, MyTime.PM);
		MyTime mt2 = new MyTime(12, 40, MyTime.PM);
		int minExpected = 40;
		int minElapsed = mt1.minutesElapsed(mt2);
		assertEquals(minExpected,minElapsed);
	}
	
	@Test
	public void test2() {
		MyTime mt1 = new MyTime(9, 57, MyTime.PM);
		MyTime mt2 = new MyTime(11, 40, MyTime.PM);
		int minExpected = 103;
		int minElapsed = mt1.minutesElapsed(mt2);
		assertEquals(minExpected,minElapsed);
	}
	
	@Test
	public void test3() {
		MyTime mt1 = new MyTime(5, 0, MyTime.PM);
		MyTime mt2 = new MyTime(4, 0, MyTime.AM);
		int minExpected = 660;
		int minElapsed = mt1.minutesElapsed(mt2);
		assertEquals(minExpected,minElapsed);
	}
	
	// add more tests to guarantee branch coverage
	// how many more tests?

}
