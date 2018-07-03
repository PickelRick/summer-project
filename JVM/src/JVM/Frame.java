package JVM;
import java.util.*;
import java.util.regex.*;


public class Frame {
	
	private OperandStack<Variable> operandStack;
	private int stackDeep;
	private HashMap<Integer,Variable> localVariables;
	private int programCounter;
	private int stackCounter;
	private String callerFrame;
	
	
	public Frame(HashMap<Integer,Variable> localVariables, int programCounter, String callerFrame,int stackDeep) {
		this.operandStack = new OperandStack<Variable>();
		this.localVariables = localVariables;
		this.programCounter = programCounter;
		this.stackCounter = 0;
		this.callerFrame = callerFrame;
		this.stackDeep = stackDeep; 
	}
	
	
	public OperandStack<Variable> getOperandStack() {
		return operandStack;
	}


	public void setOperandStack(OperandStack<Variable> operandStack) {
		this.operandStack = operandStack;
	}


	public int getStackDeep() {
		return stackDeep;
	}


	public void setStackDeep(int stackDeep) {
		this.stackDeep = stackDeep;
	}


	public HashMap<Integer, Variable> getLocalVariables() {
		return localVariables;
	}


	public void setLocalVariables(HashMap<Integer, Variable> localVariables) {
		this.localVariables = localVariables;
	}


	public int getProgramCounter() {
		return programCounter;
	}


	public void setProgramCounter(int programCounter) {
		this.programCounter = programCounter;
	}


	public int getStackCounter() {
		return stackCounter;
	}


	public void setStackCounter(int stackCounter) {
		this.stackCounter = stackCounter;
	}


	public String getCallerFrame() {
		return callerFrame;
	}


	public void setCallerFrame(String callerFrame) {
		this.callerFrame = callerFrame;
	}


	public void execute(Executable e) {
		e.execute(this);
	}
}