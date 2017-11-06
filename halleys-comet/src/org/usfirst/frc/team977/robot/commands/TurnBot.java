package org.usfirst.frc.team977.robot.commands;

import org.usfirst.frc.team977.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnBot extends Command {

    private double turn_angle;
    private double gyro_angle;
    
    public TurnBot(double turn) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.RobotDrive);
    	turn_angle = turn;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.RobotGyro.getAngle();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	gyro_angle = Robot.RobotGyro.getAngle();
    	if (turn_angle>0){
        	Robot.RobotDrive.drive(0, 0.4*(gyro_angle-turn_angle)/(turn_angle)-0.6);
    	}
    	else if (turn_angle<0){
    		Robot.RobotDrive.drive(0, 0.75);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return (turn_angle-gyro_angle)<=0.1;
		//return ((init_angle+turn_angle)-gyro_angle)*((init_angle+turn_angle)-gyro_angle)<=2;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.RobotDrive.drive(0,0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
