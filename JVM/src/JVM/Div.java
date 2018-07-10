package JVM;

public class Div implements Executable {
	private DataType type;
	public Div(DataType type) {
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
					Variable iquot = new Variable(i1/i2);
					f.getOperandStack().push(iquot);
				case LONG:
					long l2 = Transfer.getLong(f.getOperandStack().pop().load());
					long l1 = Transfer.getLong(f.getOperandStack().pop().load());
					Variable lquot = new Variable(l1/l2);
					f.getOperandStack().push(lquot);
				case FLOAT:
					float f2 = Transfer.getFloat(f.getOperandStack().pop().load());
					float f1 = Transfer.getFloat(f.getOperandStack().pop().load());
					Variable fquot = new Variable(f1/f2);
					f.getOperandStack().push(fquot);
				case DOUBLE:
					double d2 = Transfer.getDouble(f.getOperandStack().pop().load());
					double d1 = Transfer.getDouble(f.getOperandStack().pop().load());
					Variable dquot = new Variable(d1/d2);
					f.getOperandStack().push(dquot);
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
