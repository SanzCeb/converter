package converter.xml;

public class XmlElement {

    private final String name;
    private final String content;

    public XmlElement(String name, String content) {
	this.name = name;
	this.content = content;
    }

    public static XmlElement parseXmlElement(String xmlString) {

	if (xmlString.endsWith("/>")) {
	    return parseEmptyXmlElement(xmlString);
	}

	int openTagIndex = xmlString.indexOf('<');
	int closeTagIndex = xmlString.indexOf('>');
	int lastOpenTagIndex = xmlString.lastIndexOf('<');
	String name = xmlString.substring(openTagIndex + 1, closeTagIndex);
	String content = xmlString.substring(closeTagIndex + 1, lastOpenTagIndex);

	return new XmlElement(name, content);
    }

    public String getName() {
	return name;
    }

    public String getContent() {
	return content;
    }

    @Override public String toString() {
	if (java.util.Objects.isNull(content)) {
	    return String.format("<%s/>", name);
	}

	String openTag = String.format("<%s>", name);
	String closeTag = String.format("</%s>", name);

	return openTag + content + closeTag;
    }

    private static XmlElement parseEmptyXmlElement(String xmlString) {
	int openTagIndex = xmlString.indexOf('<');
	int endTagIndex = xmlString.indexOf("/>");
	String name = xmlString.substring(openTagIndex + 1, endTagIndex);
	return new XmlElement(name, null);
    }
}
