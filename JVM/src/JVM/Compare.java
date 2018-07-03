package JVM;

public class Compare implements Executable {
	private String type;
	private final Variable greater = new Variable((int)1);
	private final Variable equal = new Variable((int)0);
	private final Variable smaller = new Variable((int)-1);
	public Compare(String type) {
		this.type = type;
	}
	
	
	@Override
	public void execute(Frame f) {
		Variable a2 = f.getOperandStack().pop();
		Variable a1 = f.getOperandStack().pop();
		if(a1.getType().equals(a2.getType())&&a1.getType().equals(this.type)) {
			if(this.type.equals("Double")) {
				double d2 = Transfer.getDouble(a2.load());
				double d1 = Transfer.getDouble(a1.load());
				if(d1 > d2) {
					f.getOperandStack().push(greater);
				}else if(d1 == d2) {
					f.getOperandStack().push(equal);
				}else {
					f.getOperandStack().push(smaller);
				}
			}else if(this.type.equals("Float")) {
				float f2 = Transfer.getFloat(a2.load());
				float f1 = Transfer.getFloat(a1.load());
				if(f1 > f2) {
					f.getOperandStack().push(greater);
				}else if(f1 == f2) {
					f.getOperandStack().push(equal);
				}else {
					f.getOperandStack().push(smaller);
				}
			}else if(this.type.equals("Long")) {
				long l2 = Transfer.getLong(a2.load());
				long l1 = Transfer.getLong(a1.load());
				if(l1 > l2) {
					f.getOperandStack().push(greater);
				}else if(l1 == l2) {
					f.getOperandStack().push(equal);
				}else {
					f.getOperandStack().push(smaller);
				}
			}else {
				f.getOperandStack().push(a1);
				f.getOperandStack().push(a2);
				throw new IllegalArgumentException();
			}
		}else {
			f.getOperandStack().push(a1);
			f.getOperandStack().push(a2);
			throw new IllegalArgumentException();
		}
	}

}
