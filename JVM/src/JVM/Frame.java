package JVM;
import java.util.*;


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
			throw new IllegalArgumentException();
		}
	}
	
	public void store(int slot,double value) {
		localVariables.replace(slot, value);
	}
	
	public double load(int slot) {
		if(localVariables.containsKey(slot)) {
			return localVariables.get(slot);
		}else {
			throw new IllegalArgumentException();
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
}