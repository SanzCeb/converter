package converter;

import org.junit.*;
import static org.junit.Assert.*;
import converter.json.JsonElement;
import converter.xml.XmlElement;

public class JsonXmlConverterTest {
    
    @Test public void convertJsonElementToXml() {
	String json = "{\"jdk\" : \"1.8.9\"}";
	XmlElement xmlElement = JsonXmlConverter.jsonToXml(json);
	JsonElement jsonElement = JsonElement.parseJsonElement(json);
	checkElements(jsonElement, xmlElement);
    }

    @Test public void convertXmlElementToJson() {
	String xml = "<host>127.0.0.1</host>";
	JsonElement jsonElement = JsonXmlConverter.xmlToJson(xml);
	XmlElement xmlElement = XmlElement.parseXmlElement(xml);
	checkElements(jsonElement, xmlElement);
    }

    private void checkElements (JsonElement jsonElement, XmlElement xmlElement) {
	assertEquals(jsonElement.getKey(), xmlElement.getName());
	assertEquals(jsonElement.getValue(), xmlElement.getContent());
    }
}
