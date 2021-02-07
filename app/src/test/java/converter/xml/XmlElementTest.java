package converter.xml;

import org.junit.*;
import static org.junit.Assert.assertEquals;

public class XmlElementTest {

    @Test public void converterParseSimpleXmlElement() {
	String xmlString = "<host>127.0.0.1</host>"; 
	converterParseXmlElementTest("host", "127.0.0.1", xmlString);
    }

    @Test public void converterParseEmptyXmlElement() {
	String xmlString = "<success/>";
	converterParseXmlElementTest("success", null, xmlString);
    }

    private void converterParseXmlElementTest(String name, String content, String xmlString) {
	XmlElement xmlElement = XmlElement.parseXmlElement(xmlString);
	assertEquals(xmlElement.getName(), name);
	assertEquals(xmlElement.getContent(), content);
    }
}
