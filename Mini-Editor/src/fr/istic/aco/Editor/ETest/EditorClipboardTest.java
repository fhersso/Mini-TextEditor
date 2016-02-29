package fr.istic.aco.Editor.ETest;

import static org.junit.Assert.*;
import fr.istic.aco.Editor.Core.*;
import org.junit.Before;
import org.junit.Test;
/**
 * MiniEditorClipboard test class
 * @author Vargas-Hoque
 *
 */
public class EditorClipboardTest {
	private MiniEditorClipboard clipboard;

	@Before
	public void setUp() throws Exception {
		clipboard = new EditorClipboard();
	}
	/**
	 * Write clipboard test
	 */
	@Test
	public void testClipboard() {
		String test = "test string";
		clipboard.writeClipboard(test);
		assertEquals(clipboard.readClipboard(),test);
		assertEquals(clipboard.getSize(),test.length());
	}

}
