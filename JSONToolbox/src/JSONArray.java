
public class JSONArray extends JSONNode {
	private JSONNode[] JSONNodes;
	private String name;
	private String value;
	public JSONArray(String value, String name) {
		this.value = value;
		this.name = name;
		
	}
	public String getName() {
		return name;
	}
	public String getContent() {
		return value;
	}
	public String getType() {
		return "array";
	}
}
