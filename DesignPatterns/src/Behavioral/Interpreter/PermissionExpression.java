package Behavioral.Interpreter;

//Abstract expression
public interface PermissionExpression {

	boolean interpret(User user);
}
