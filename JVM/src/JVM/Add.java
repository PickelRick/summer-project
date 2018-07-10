package JVM;

public class Add implements Executable {
	private DataType type;
	public Add(DataType type) {
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
					Variable isum = new Variable(i1+i2);
					f.getOperandStack().push(isum);
				case LONG:
					long l2 = Transfer.getLong(f.getOperandStack().pop().load());
					long l1 = Transfer.getLong(f.getOperandStack().pop().load());
					Variable lsum = new Variable(l1+l2);
					f.getOperandStack().push(lsum);
				case FLOAT:
					float f2 = Transfer.getFloat(f.getOperandStack().pop().load());
					float f1 = Transfer.getFloat(f.getOperandStack().pop().load());
					Variable fsum = new Variable(f1+f2);
					f.getOperandStack().push(fsum);
				case DOUBLE:
					double d2 = Transfer.getDouble(f.getOperandStack().pop().load());
					double d1 = Transfer.getDouble(f.getOperandStack().pop().load());
					Variable dsum = new Variable(d1+d2);
					f.getOperandStack().push(dsum);
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
