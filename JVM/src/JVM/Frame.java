package JVM;
import java.util.*;
import java.util.regex.*;


public class Frame {
	private Stack<Double> operandStack;
	private int stackDeep;
	private HashMap<Integer,Double> localVariables;
	private int programCounter;
	private int stackCounter;
	private String callerFrame;
	
	public Frame(HashMap<Integer,Double> localVariables, int programCounter, String callerFrame,int stackDeep) {
		this.operandStack = new Stack<Double>();
		this.localVariables = localVariables;
		this.programCounter = programCounter;
		this.stackCounter = 0;
		this.callerFrame = callerFrame;
		this.stackDeep = stackDeep;
	}
	
	public void push(double operand) {
		this.operandStack.push(operand);
		this.stackCounter ++;
	}
	
	public double pop() {
		this.stackCounter --;
		if(stackCounter >= 0) {
			return this.operandStack.pop();
		}else {
			this.stackCounter = 0;
			throw new IllegalArgumentException("cannot pop from empty stack");
		}
	}
	
	public void store(int slot,double value) {
		localVariables.replace(slot, value);
	}
	
	public double load(int slot) {
		if(localVariables.containsKey(slot)) {
			return localVariables.get(slot);
		}else {
			throw new IllegalArgumentException("do not have this slot");
		}
	}
	
	public int getStackDeep() {
		return this.stackDeep;
	}
	
	public int getStackCounter() {
		return this.stackCounter;
	}
	
	public int getProgramCounter() {
		return this.programCounter;
	}
	
	public String getCallerFrame() {
		return this.callerFrame;
	}
	
	public double returnValue() {
		return this.pop();
	}
	
	public void excute(String[] byteCodeLine) {
		Pattern pc = Pattern.compile("[0-9]*");
		Pattern op = Pattern.compile("(i|d)[a-z]*");
		Matcher pm = pc.matcher(byteCodeLine[1]);
		Matcher om = op.matcher(byteCodeLine[2]);
		if(pm.matches()) {
			this.programCounter = Integer.parseInt(byteCodeLine[1]);
			//change the pc
			if(om.matches()) {
				String opcode = byteCodeLine[2].substring(1);
				if(opcode.equals("load")) {
					int slot = Integer.parseInt(byteCodeLine[3]);
					this.push(localVariables.get(slot));
				}else if(opcode.equals("sub")) {
					this.push(-1*(this.pop()-this.pop()));
				}else if(opcode.equals("mul")) {
					this.push(this.pop()*this.pop());
				}else if(opcode.equals("const")) {
					double operand = Double.parseDouble(byteCodeLine[3]);
					this.push(operand);
				}else if(opcode.equals("return")) {
					this.returnValue();
				}else {
					throw new IllegalArgumentException("Opps, I do not know this byte code");
				}
			}else {
				throw new IllegalArgumentException("Illegal format(opcode)");
			}
			
		}else {
			throw new IllegalArgumentException("Illegal format(pc)");
		}
	}
	
	
}