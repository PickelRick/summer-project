package JVM;

public class Store implements Executable {
	
	private int slotNumber;
	private String type;
	
	public Store(int slotNumber,String type) {
		this.slotNumber = slotNumber;
		this.type = type;
	}
	
	@Override
	public void execute(Frame f) {
		if(f.getOperandStack().peek().getType().equals(this.type)) {
			f.getLocalVariables().put(slotNumber, f.getOperandStack().pop());
		}else {
			throw new IllegalArgumentException();
		}
		
	}
}
