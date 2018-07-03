package JVM;

public class Load implements Executable {
	
	private int slotNumber;
	private String type;
	
	public Load(int slotNumber,String type) {
		this.slotNumber = slotNumber;
		this.type = type;
	}
	
	@Override
	public void execute(Frame f) {
		Variable a = f.getLocalVariables().get(slotNumber);
		if(a.getType().equals(this.type)) {
		f.getOperandStack().push(a);
		}else {
			throw new IllegalArgumentException();
		}
	}

}
