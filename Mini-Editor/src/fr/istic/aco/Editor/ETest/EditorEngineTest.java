package fr.istic.aco.Editor.ETest;

import static org.junit.Assert.*;
import fr.istic.aco.Editor.Core.*;
import org.junit.Before;
import org.junit.Test;
/**
 * MiniEditorEngine test class
 * @author Fhersso
 *
 */
public class EditorEngineTest {
	
	private MiniEditorEngine engine;
	String testA = "Test Text String A";
	int start=0;
	int stop=0;
	@Before
	public void setUp() throws Exception {
		engine = new EditorEngine();
	}
	/**
	 * Initialization test
	 */
	@Test
	public void testInitEngine() {
		assertEquals(engine.getBuffer(),"");
		assertEquals(engine.getSelection(),"");
		assertEquals(engine.getClipboard(),"");

	}
	/**
	 * String insertion test
	 */
	@Test
	public void testEditorInsert() {
		engine.editorInsert(testA);
		assertEquals(engine.getBuffer(),testA);
		assertEquals(engine.getSelection(),"");
		assertEquals(engine.getClipboard(),"");
		//insert on the right
		engine.editorInsert("More Text");
		assertEquals(engine.getBuffer(),testA+"More Text");
		assertEquals(engine.getSelection(),"");
		assertEquals(engine.getClipboard(),"");
		//insert on the left
		engine.editorSelect(0, 0);
		engine.editorInsert("More Text");
		assertEquals(engine.getBuffer(),"More Text"+testA+"More Text");
		assertEquals(engine.getSelection(),"");
		assertEquals(engine.getClipboard(),"");
	}
	/***
	 * Selection test
	 */
	@Test
	public void testEditorSelect() {
		engine.editorInsert(testA);
		start=3;
		stop=8;
		engine.editorSelect(start, stop);
		assertEquals(engine.getBuffer(),testA);
		assertEquals(engine.getSelection(),testA.substring(start, stop));
		assertEquals(engine.getClipboard(),"");
	}
	/**
	 * Copy substring test
	 */
	@Test
	public void testEditorCopy() {
		engine.editorInsert(testA);
		start=3;
		stop=8;
		engine.editorSelect(start, stop);
		engine.editorCopy();
		assertEquals(engine.getBuffer(),testA);
		assertEquals(engine.getSelection(),testA.substring(start, stop));
		assertEquals(engine.getClipboard(),testA.substring(start, stop));
	}
	/**
	 * Cut test
	 */
	@Test
	public void testEditorCut() {
		engine.editorInsert(testA);
		start=3;
		stop=8;
		String clip = testA.substring(start, stop);
		testA = testA.substring(0, start)+testA.substring(stop);
		engine.editorSelect(start, stop);
		engine.editorCut();
		assertEquals(engine.getBuffer(),testA);
		assertEquals(engine.getSelection(),"");
		assertEquals(engine.getClipboard(),clip);
	}
	/**
	 * Paste string test
	 */
	@Test
	public void testEditorPaste() {
		engine.editorInsert(testA);
		start=3;
		stop=8;
		String clip = testA.substring(start, stop);
		testA = testA.substring(0, start)+testA.substring(stop);
		engine.editorSelect(start, stop);
		engine.editorCut();
		engine.editorSelect(0, 0);
		engine.editorPaste();
		assertEquals(engine.getBuffer(),clip+testA);
		assertEquals(engine.getSelection(),"");
		assertEquals(engine.getClipboard(),clip);
	}

}
