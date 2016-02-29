package fr.istic.aco.Editor.ETest;

import static org.junit.Assert.*;
import fr.istic.aco.Editor.Core.*;
import org.junit.Before;
import org.junit.Test;
/**
 * MiniEditorBuffer test class
 * @author Vargas-Hoque
 *
 */
public class EditorBufferTest {
	private MiniEditorBuffer buffer;
	String testA = "Test Text String A";
	@Before
	public void setUp() throws Exception {
		buffer = new EditorBuffer();
		buffer.writeBuffer(0, 0, testA);
	}
	/**
	 * Read Buffer test
	 */
	@Test
	public void testReadBuffer() {
		assertEquals(buffer.readBuffer(0,buffer.getSize()),testA);
	}
	/**
	 * Write buffer test
	 */
	@Test
	public void testWriteBuffer() {
		String sub="textB";
		int start=5;
		int stop=10;
		buffer.writeBuffer(start, stop, sub);
		testA = testA.substring(0, start)+sub+testA.substring(stop);
		assertEquals(buffer.readBuffer(0,buffer.getSize()),testA);
	}
	/**
	 * Buffer length test
	 */
	@Test
	public void testLengthBuffer() {
		assertEquals(buffer.getSize(),testA.length());
	}
}
