package JVM;
import java.util.*;

public class OperandStack<T> {
	private List<T> list;
	public OperandStack(){
		list = new ArrayList<T>();
	}
	
	public void push(T element) {
		list.add(element);
	}
	
	public T pop() {
		if(list.isEmpty()) {
			throw new EmptyStackException();
		}else {
			return list.remove(list.size()-1);
		}
	}
	
	public T peek() {
		if(list.isEmpty()) {
			throw new EmptyStackException();
		}else {
			return list.get(list.size()-1);
		}
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
}
