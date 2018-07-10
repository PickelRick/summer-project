package JVM;

public class Variable {
	private byte[] variable;
	private DataType type;
	
	public Variable(int intVariable) {
		this.variable = Transfer.getBytes(intVariable);
		this.type = DataType.INTEGER;
	}
	
	public Variable(long longVariable) {
		this.variable = Transfer.getBytes(longVariable);
		this.type = DataType.LONG;
	}
	
	public Variable(float floatVariable) {
		this.variable = Transfer.getBytes(floatVariable);
		this.type = DataType.FLOAT;
	}
	
	public Variable(double doubleVariable) {
		this.variable = Transfer.getBytes(doubleVariable);
		this.type = DataType.DOUBLE;
	}
	public Variable(String referenceVariable) {
		this.variable = referenceVariable.getBytes();
		this.type = DataType.ADDRESS;
	}
	
	public DataType getType() {
		return this.type;
	}
	
	public byte[] load() {
		return this.variable;
	}
	
}
