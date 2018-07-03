package JVM;

public class Add implements Executable {
	private String type;
	public Add(String type) {
		this.type = type;
	}
	
	public void execute(Frame f) {
		Variable a2 = f.getOperandStack().pop();
		Variable a1 = f.getOperandStack().pop();
		if(this.type.equals("Integer")) {
			if(a1.getType().equals(this.type)&&a2.getType().equals(this.type)) {
				int i2 = Transfer.getInt(f.getOperandStack().pop().load());
				int i1 = Transfer.getInt(f.getOperandStack().pop().load());
				Variable sum = new Variable(i1+i2);
				f.getOperandStack().push(sum);
			}else {
				f.getOperandStack().push(a1);
				f.getOperandStack().push(a2);
				throw new IllegalArgumentException("NOT INTEGER");
			}
				
		}else if(this.type.equals("Long")){
			if(a1.getType().equals(this.type)&&a2.getType().equals(this.type)) {
				long l2 = Transfer.getLong(f.getOperandStack().pop().load());
				long l1 = Transfer.getLong(f.getOperandStack().pop().load());
				Variable sum = new Variable(l1+l2);
				f.getOperandStack().push(sum);
			}else {
				f.getOperandStack().push(a1);
				f.getOperandStack().push(a2);
				throw new IllegalArgumentException("NOT LONG");
			}
			
		}else if(this.type.equals("Float")) {
			if(a1.getType().equals(this.type)&&a2.getType().equals(this.type)) {
				float f2 = Transfer.getFloat(f.getOperandStack().pop().load());
				float f1 = Transfer.getFloat(f.getOperandStack().pop().load());
				Variable sum = new Variable(f1+f2);
				f.getOperandStack().push(sum);
			}else {
				f.getOperandStack().push(a1);
				f.getOperandStack().push(a2);
				throw new IllegalArgumentException("NOT FLOAT");
			}
			
		}else if(this.type.equals("Double")){
			if(a1.getType().equals(this.type)&&a2.getType().equals(this.type)) {
				double d2 = Transfer.getDouble(f.getOperandStack().pop().load());
				double d1 = Transfer.getDouble(f.getOperandStack().pop().load());
				Variable sum = new Variable(d1+d2);
				f.getOperandStack().push(sum);
			}else {
				f.getOperandStack().push(a1);
				f.getOperandStack().push(a2);
				throw new IllegalArgumentException("NOT DOUBLE");
			}
			
		}else {
			throw new IllegalArgumentException();
		}
	}

}
