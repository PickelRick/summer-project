package JVM;

public class Variable {
	private byte[] variable;
	private String type;
	
	public Variable(int intVariable) {
		this.variable = Transfer.getBytes(intVariable);
		this.type = "Integer";
	}
	
	public Variable(long longVariable) {
		this.variable = Transfer.getBytes(longVariable);
		this.type = "Long";
	}
	
	public Variable(float floatVariable) {
		this.variable = Transfer.getBytes(floatVariable);
		this.type = "Float";
	}
	
	public Variable(double doubleVariable) {
		this.variable = Transfer.getBytes(doubleVariable);
		this.type = "Double";
	}
	public Variable(String referenceVariable) {
		this.variable = referenceVariable.getBytes();
		this.type = "Adress";
	}
	
	public String getType() {
		return this.type;
	}
	
	public byte[] load() {
		return this.variable;
	}
	
}
