package converter.json;

public class JsonElement {

    private final String key;
    private final String value;

    public JsonElement(String key, String value) {
	this.key = key;
	this.value = value;
    }

    public static JsonElement parseJsonElement(String jsonStr) {
	String key = extractQuotes(jsonStr);
	int valueBeginIndex = jsonStr.indexOf(':') + 1;
	int valueEndIndex = jsonStr.lastIndexOf('}');
	String value = jsonStr.substring(valueBeginIndex, valueEndIndex);
	
	if (value.contains("null")) {
	    value = null;
	} else if (value.contains("\"")) {
	    value = extractQuotes(value);
	} else {
	    value = value.trim();
	}

	return new JsonElement(key, value);
    }

    public String getKey () { return key; }

    public String getValue() { return value; }

    @Override public String toString() {
	if (java.util.Objects.isNull(value)) {
	    return String.format("{\"%s\":null}", key);
	}
	return String.format("{\"%s\":\"%s\"}", key, value); 
    }

    private static String extractQuotes(String string) {
	int keyBeginIndex = string.indexOf('\"') + 1;
	int keyEndIndex = string.indexOf('\"', keyBeginIndex); 
	return string.substring(keyBeginIndex, keyEndIndex); 
    }
}
