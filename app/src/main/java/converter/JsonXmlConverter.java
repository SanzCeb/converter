package converter;

import converter.json.JsonElement;
import converter.xml.XmlElement;

public class JsonXmlConverter {

    public static JsonElement xmlToJson(String xml) {
        XmlElement xmlElement = XmlElement.parseXmlElement(xml);
        String name = xmlElement.getName();
        String value = xmlElement.getContent();
        return new JsonElement(name, value);
    }

    public static XmlElement jsonToXml(String json) {
        JsonElement jsonElement = JsonElement.parseJsonElement(json);
        String key = jsonElement.getKey();
        String value = jsonElement.getValue();
        return new XmlElement(key, value);
    }
}
