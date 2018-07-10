package JVM;

public class Compare implements Executable {
	private DataType type;
	private final Variable greater = new Variable((int)1);
	private final Variable equal = new Variable((int)0);
	private final Variable smaller = new Variable((int)-1);
	public Compare(DataType type) {
		this.type = type;
	}
	
	
	@Override
	public void execute(Frame f) {
		Variable a2 = f.getOperandStack().pop();
		Variable a1 = f.getOperandStack().pop();
		if(a1.getType().equals(a2.getType())&&a1.getType().equals(this.type)) {
			switch(this.type) {
			case LONG:
				long l2 = Transfer.getLong(a2.load());
				long l1 = Transfer.getLong(a1.load());
				if(l1 > l2) {
					f.getOperandStack().push(greater);
				}else if(l1 == l2) {
					f.getOperandStack().push(equal);
				}else {
					f.getOperandStack().push(smaller);
				}
			case FLOAT:
				float f2 = Transfer.getFloat(a2.load());
				float f1 = Transfer.getFloat(a1.load());
				if(f1 > f2) {
					f.getOperandStack().push(greater);
				}else if(f1 == f2) {
					f.getOperandStack().push(equal);
				}else {
					f.getOperandStack().push(smaller);
				}
			case DOUBLE:
				double d2 = Transfer.getDouble(a2.load());
				double d1 = Transfer.getDouble(a1.load());
				if(d1 > d2) {
					f.getOperandStack().push(greater);
				}else if(d1 == d2) {
					f.getOperandStack().push(equal);
				}else {
					f.getOperandStack().push(smaller);
				}
			case ADDRESS:
				throw new IllegalArgumentException();
			case INTEGER:
				throw new IllegalArgumentException();
			}
		}else {
			f.getOperandStack().push(a1);
			f.getOperandStack().push(a2);
			throw new IllegalArgumentException();
		}
	}

}
