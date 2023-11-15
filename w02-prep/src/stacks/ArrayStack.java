package stacks;

public class ArrayStack<T> implements BoundedStackInterface<T> {

	private T[] container;
	private int size;
	private int top;
	
	public ArrayStack(int size) {
		this.top = -1;
		this.size = size;
		//this.container = new T[size];
		this.container = (T[]) new Object[size];
	}
	
	public void push(Object info) throws StackOverflowException {
		if(this.top == this.size-1)
			throw new StackOverflowException("Stack is full");
		this.top += 1;
		this.container[this.top] = (T) info;

	}
	
	public void pop() {
		if (this.isEmpty()) 
			throw new StackUnderflowException("Stack is empty");
		this.top -= 1;
	}
	
	public T get_top() {
		if (this.isEmpty())
			throw new StackUnderflowException("stack is empty");
		return this.container[this.top];
	}
	
	public boolean isEmpty() {
		return this.top == -1;
	}

}
