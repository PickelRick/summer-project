package JVM;

public class Condition implements Executable {
	private Form form;
	private int programCounter;
	
	public Condition(Form form, int programCounter) {
		this.form = form;
		this.programCounter = programCounter;
	}
	
	@Override
	public void execute(Frame f) {
		Variable a2 = f.getOperandStack().pop();
		Variable a1 = f.getOperandStack().pop();
		if(a1.getType().equals(a2.getType())&&a1.getType().equals(DataType.INTEGER)) {
			int i2 = Transfer.getInt(a2.load());
			int i1 = Transfer.getInt(a1.load());
			switch(this.form) {
				case icmpeq:
					if(i1 == i2) {
						f.setProgramCounter(this.programCounter);
					}
				case icmpne:
					if(i1 != i2) {
						f.setProgramCounter(this.programCounter);
					}
				case icmplt:
					if(i1 < i2) {
						f.setProgramCounter(this.programCounter);
					}
				case icmpge:
					if(i1 <= i2) {
						f.setProgramCounter(this.programCounter);
					}
				case icmpgt:
					if(i1 > i2) {
						f.setProgramCounter(this.programCounter);
					}
				case icmple:
					if(i1 >= i2) {
						f.setProgramCounter(this.programCounter);
					}
					
			}
		}else {
			f.getOperandStack().push(a1);
			f.getOperandStack().push(a2);
			throw new IllegalArgumentException();
		}
	}

}
