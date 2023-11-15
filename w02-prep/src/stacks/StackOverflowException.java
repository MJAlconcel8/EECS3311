package stacks;

public class StackOverflowException extends RuntimeException{

	private static final long serialVersionUID = 8708071285001688524L;

	public StackOverflowException()
	  {
	    super();
	  }

	  public StackOverflowException(String message)
	  {
	    super(message);
	  }
	
}
