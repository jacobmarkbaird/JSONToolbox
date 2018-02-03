public class JSONTree extends JSONNode {
	private String value;
	private String content;
	private String type;
	private String[] fieldNames;
	private JSONNode[] nodes;
	private String name;
	public JSONTree(String jsonString, String name) {
		this.name = name;
		this.type = "tree";
		value = jsonString;
		trimFrontAndEnd();
		removeWhiteSpace();
		this.content = "{" + value + "}";
		System.out.println(value);
		System.out.println(getFieldCount());
		fieldNames = new String[getFieldCount()];
		parseJSON();
	}
	public String getName() {
		return name;
	}
	public String getContent() {
		return content;
	}
	public String getType() {
		return type;
	}
	private void parseJSON() {
		int startIndex = 0, endIndex = 0;
		int structDepth = 0, arrayDepth = 0;
		boolean isQuote = false;
		
	}
	private void trimFrontAndEnd() {
		while(value.charAt(0)!='{')
			value = value.substring(1);
		while(value.charAt(value.length()-1)!='}')
			value = value.substring(0,value.length()-1);
		value = value.substring(1,value.length()-1);
	}
	private int getFieldCount() {
		int fieldCount = 1;
		int structDepth = 0;
		int arrayDepth = 0;
		boolean isQuote = false;
		for(int i = 0; i < value.length(); i++) {
			char current = value.charAt(i);
			if(!isQuote&&current=='{')
				structDepth++;
			if(!isQuote&&current=='}')
				structDepth--;
			if(!isQuote&&current=='[')
				arrayDepth++;
			if(!isQuote&&current==']')
				arrayDepth--;
			if(current=='"')
				isQuote = !isQuote;
			if(!isQuote&&structDepth==0&&arrayDepth==0&&current==',')
				fieldCount++;
		}
		return fieldCount;
	}
	private void removeWhiteSpace() {
		int index = 0;
		char current;
		boolean isQuote = false;
		while(index < value.length()) {
			current = value.charAt(index);
			if(current=='"')
				isQuote = !isQuote;
			if(!isQuote) {
				if(current==' ' || current=='\t' || current=='\n') {
					String temp = value.substring(0,index) + value.substring(index+1);
					value = temp;
				} else {
					index++;
				}
			} else {
				index++;
			}
		}
	}
}
