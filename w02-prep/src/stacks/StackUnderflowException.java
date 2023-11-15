package stacks;

public class StackUnderflowException extends RuntimeException
{

	private static final long serialVersionUID = -6623542719807588248L;

public StackUnderflowException()
  {
    super();
  }

  public StackUnderflowException(String message)
  {
    super(message);
  }
}