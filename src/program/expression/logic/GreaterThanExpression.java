package program.expression.logic;


import jumpingalien.part3.programs.SourceLocation;
import program.expression.Expression;

public class GreaterThanExpression extends Logic{

	/**
	 * 
	 * @param left
	 * @param right
	 *  
	 */
	public GreaterThanExpression(Expression left, Expression right, 
			SourceLocation sourceLocation){
		super(left, right, sourceLocation);
	}
}
