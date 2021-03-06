package program.statement;

import java.util.HashSet;

import program.Program;
import program.ProgramFactory.Movement;
import program.expression.Expression;
import jumpingalien.part3.programs.IProgramFactory.Direction;
import jumpingalien.part3.programs.SourceLocation;


public class MoveStatement extends Statement{

	/**
	 * 
	 *  
	 */
	public MoveStatement(Movement movement, Expression<Direction> direction,SourceLocation sourceLocation){
		super(sourceLocation);
		this.movement = movement;
		
		this.ExprDirection = direction;
		

	}

	@Override
	public void advanceTime(double dt, Program program) {
		if(!this.isExecutionComplete()){
			
			if(ExprDirection != null){
				Direction value = (Direction) ExprDirection.evaluate(program);
				if(value == Direction.LEFT)
					this.direction = false;
				else if(value== Direction.RIGHT) 
					this.direction = true;
			}
			
			switch(getMovement()){
			case STARTRUN:  
				program.getGameObject().startMoveProgram(getDirection());
				break;
			case STARTJUMP:  
				program.getGameObject().startJumpProgram();
				break;
			case STARTDUCK:  
				program.getGameObject().startDuckProgram();
				break;
			case STOPRUN:  
				program.getGameObject().stopMoveProgram(getDirection());
				break;
			case STOPJUMP:  
				program.getGameObject().stopJumpProgram();
				break;
			case STOPDUCK:  
				program.getGameObject().stopDuckProgram();
				break;
			}
			
			ExecutionDone = true;
			program.decreaseRemainingTime();
		}

	}
	@Override
	public boolean isExecutionComplete() {
		return ForceReset || ExecutionDone;
	}

	@Override
	public void forceReset() {
		ForceReset = true;
	}

	@Override
	public void Reset() {
		ExecutionDone = false;
	}

	public Movement getMovement() {
		return movement;
	}

	public final Boolean getDirection() {
		return direction;
	}

	@Override
	public boolean isWellFormed(HashSet<String> parentStatements) {
		return (!parentStatements.contains("For"));
	}
	private final Movement movement;
	private Expression<Direction> ExprDirection;
	private Boolean direction;
	private boolean ForceReset = false;
	private boolean ExecutionDone = false;
}
