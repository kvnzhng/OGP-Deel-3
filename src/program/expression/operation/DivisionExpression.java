package program.expression.operation;

import jumpingalien.part3.programs.SourceLocation;
import program.expression.Expression;


public class DivisionExpression extends DoubleExpressionOperation{

	/**
	 * 
	 * @param left
	 * @param right
	 *  
	 */
	public DivisionExpression(Expression left, Expression right, 
			SourceLocation sourceLocation){
		super(left, right, sourceLocation);
	}
}
