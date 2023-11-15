package stacks;

public class UseStack {

	public static void main(String[] args) {
		
		LinkedStack<String> strStack = new LinkedStack<String>();
        LinkedStack<Integer> intStack = new LinkedStack<>();
        
        try {
        strStack.push("hello");
        System.out.println("The top of stack strStack has: " 
        + strStack.get_top());
        strStack.pop();
        System.out.println("The top os stack strStack has: " 
        + strStack.get_top());
        } catch (StackUnderflowException e) {
        	System.out.println("hey, you made a mistake!");
        }
        System.out.println("We are at the end");
        
	}

}
