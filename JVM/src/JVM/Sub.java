package JVM;

public class Sub implements Executable{
	private DataType type;
	public Sub(DataType type) {
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
					Variable idiff = new Variable(i1-i2);
					f.getOperandStack().push(idiff);
				case LONG:
					long l2 = Transfer.getLong(f.getOperandStack().pop().load());
					long l1 = Transfer.getLong(f.getOperandStack().pop().load());
					Variable ldiff = new Variable(l1-l2);
					f.getOperandStack().push(ldiff);
				case FLOAT:
					float f2 = Transfer.getFloat(f.getOperandStack().pop().load());
					float f1 = Transfer.getFloat(f.getOperandStack().pop().load());
					Variable fdiff = new Variable(f1-f2);
					f.getOperandStack().push(fdiff);
				case DOUBLE:
					double d2 = Transfer.getDouble(f.getOperandStack().pop().load());
					double d1 = Transfer.getDouble(f.getOperandStack().pop().load());
					Variable ddiff = new Variable(d1-d2);
					f.getOperandStack().push(ddiff);
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
