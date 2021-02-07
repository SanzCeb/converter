package converter.json;

import org.junit.*;
import static org.junit.Assert.*;

public class JsonElementTest {

    @Test public void parseSimpleJsonElement() {
	String json = "{\"jdk\" : \"1.8.9\"}";
	String key = "jdk";
	String value = "1.8.9";
	parseJsonElement(json, key, value);
    }

    @Test public void parseEmptyJsonElement() {
	String json = "{ \"storage\" : null }";
	String key = "storage";
	String value = null;
	parseJsonElement(json, key, value);
    }

    @Test public void parseIntegerJsonElement() {
	String json = "{ \"number\" : 5 }";
	String key = "number";
	String value = "5";
	parseJsonElement(json, key, value);
    }

    private void parseJsonElement(String json, String key, String value) {
	JsonElement jsonElement = JsonElement.parseJsonElement(json);
	assertEquals(jsonElement.getKey(), key);
	assertEquals(jsonElement.getValue(), value);
    }
}
