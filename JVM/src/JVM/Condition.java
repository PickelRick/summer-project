package JVM;

public class Condition implements Executable {
	private String form;
	private int programCounter;
	
	public Condition(String form, int programCounter) {
		this.form = form;
		this.programCounter = programCounter;
	}
	
	@Override
	public void execute(Frame f) {
		Variable a2 = f.getOperandStack().pop();
		Variable a1 = f.getOperandStack().pop();
		if(a1.getType().equals("Integer")&&a2.getType().equals("Integer")) {
			int i2 = Transfer.getInt(a2.load());
			int i1 = Transfer.getInt(a1.load());
			if(this.form.equals("icmpeq")&& i1 == i2) {
				f.setProgramCounter(this.programCounter);
			}else if(this.form.equals("icmpne")&&!(i1 == i2)) {
				f.setProgramCounter(this.programCounter);
			}else if(this.form.equals("icmplt")&&i1 < i2) {
				f.setProgramCounter(this.programCounter);
			}else if(this.form.equals("icmpge")&&i1 <= i2) {
				f.setProgramCounter(this.programCounter);
			}else if(this.form.equals("icmpgt")&&i1 > i2) {
				f.setProgramCounter(this.programCounter);
			}else if(this.form.equals("icmple")&&i1 >= i2) {
				f.setProgramCounter(this.programCounter);
			}
			
		}else {
			f.getOperandStack().push(a1);
			f.getOperandStack().push(a2);
			throw new IllegalArgumentException();
		}
	}

}
