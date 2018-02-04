
public class JSONAttribute extends JSONNode {
	private String name;
	private String content;
	public JSONAttribute(String content, String name) {
		this.name = name;
		this.content = content;
	}
	public String getName() {
		return name;
	}
	public String getType() {
		return "attribute";
	}
	public String getContent() {
		return content;
	}
}
