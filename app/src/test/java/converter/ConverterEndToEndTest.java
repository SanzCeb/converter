package converter;

import java.io.*;
import org.junit.*;

public class ConverterEndToEndTest {

    @Test public void convertSingleElement() {
	String xml = "<host>127.0.0.1</host>" + System.lineSeparator();
	String json = "{\"host\":\"127.0.0.1\"}" + System.lineSeparator();
	endToEndTest(xml, json);
	endToEndTest(json, xml);
    }

    @Test public void convertNullElement() {
	String json = "{\"host\":null}" + System.lineSeparator();
	String xml = "<host/>" + System.lineSeparator();
	endToEndTest(xml, json);
	endToEndTest(json, xml);
    }
	
    private void endToEndTest(String input, String output) {
	try (var mockStdIn = mockSystemIn(input);
		var testOut = new ByteArrayOutputStream(); 
		var mockStdOut = mockSystemOut(testOut)) {
	    System.setIn(mockStdIn);
	    System.setOut(mockStdOut);
	    Main.main(null);
	    var outputReceived = testOut.toString();
	    Assert.assertEquals(output, outputReceived);
	} catch (IOException ignored) {
	    throw new AssertionError();
	}	
    }


    @AfterClass 
    public static void restore() {
	System.setOut(System.out);
	System.setIn(System.in);
    }

    private static InputStream mockSystemIn(String input) {
	return new ByteArrayInputStream(input.getBytes());
    }
    
    private static PrintStream mockSystemOut(OutputStream os) {
	return new PrintStream(os);
    }
}
