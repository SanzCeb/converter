package converter;

public class Main {
    public static void main(String[] args) {
	var scanner = new java.util.Scanner(System.in);
	String input = scanner.nextLine().trim();
	if (input.startsWith("{")) {
	    var xmlElement = JsonXmlConverter.jsonToXml(input);
	    System.out.println(xmlElement);
	} else {
	    var jsonElement = JsonXmlConverter.xmlToJson(input);
	    System.out.println(jsonElement);
	}
    }
}
