package JVM;

public class Mul implements Executable{
	private DataType type;
	public Mul(DataType type) {
		this.type = type;
	}
	
	public void execute(Frame f) {
		Variable a2 = f.getOperandStack().pop();
		Variable a1 = f.getOperandStack().pop();
		if(a1.getType().equals(a2.getType())&&a1.getType().equals(this.type)) {
			switch(this.type) {
				case INTEGER:
					int i2 = Transfer.getInt(f.getOperandStack().pop().load());
					int i1 = Transfer.getInt(f.getOperandStack().pop().load());
					Variable iprod = new Variable(i1*i2);
					f.getOperandStack().push(iprod);
				case LONG:
					long l2 = Transfer.getLong(f.getOperandStack().pop().load());
					long l1 = Transfer.getLong(f.getOperandStack().pop().load());
					Variable lprod = new Variable(l1*l2);
					f.getOperandStack().push(lprod);
				case FLOAT:
					float f2 = Transfer.getFloat(f.getOperandStack().pop().load());
					float f1 = Transfer.getFloat(f.getOperandStack().pop().load());
					Variable fprod = new Variable(f1*f2);
					f.getOperandStack().push(fprod);
				case DOUBLE:
					double d2 = Transfer.getDouble(f.getOperandStack().pop().load());
					double d1 = Transfer.getDouble(f.getOperandStack().pop().load());
					Variable dprod = new Variable(d1*d2);
					f.getOperandStack().push(dprod);
				case ADDRESS:
					throw new IllegalArgumentException();
			}
		}else {
			f.getOperandStack().push(a1);
			f.getOperandStack().push(a2);
			throw new IllegalArgumentException();
		}
	}
}
