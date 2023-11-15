package stacks;

public interface BoundedStackInterface<T> extends StackInterface<T>{
	
   void push(T info) throws StackOverflowException;

}
