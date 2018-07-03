package JVM;

public class Const implements Executable {
	private Variable operand;
	
	public Const(Variable operand) {
		this.operand = operand;
	}
	
	@Override
	public void execute(Frame f) {
		f.getOperandStack().push(this.operand);
	}

}
