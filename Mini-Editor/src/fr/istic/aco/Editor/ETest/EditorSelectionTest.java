package fr.istic.aco.Editor.ETest;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import fr.istic.aco.Editor.Core.*;
/**
 * MiniEditorSelection test class
 * @author Vargas-hoque
 *
 */
public class EditorSelectionTest {
	private MiniEditorSelection selection; 
	
	@Before
	public void setUp() throws Exception {
		selection = new EditorSelection();
	}
	/**
	 * Initialization test
	 */
	@Test
	public void testInit() {
		assertEquals(selection.getBegin(),0);
		assertEquals(selection.getEnd(),0);
	}
	
	@Test
	/**
	 * Selection setup test
	 */
	public void  testSetUp() {
		selection.setBegin(5);
		selection.setEnd(10);
		assertEquals(selection.getBegin(),5);
		assertEquals(selection.getEnd(),10);
		assertEquals(selection.getLenght(),10-5);
	}

}
