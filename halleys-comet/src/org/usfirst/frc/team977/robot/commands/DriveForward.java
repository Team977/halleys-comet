package org.usfirst.frc.team977.robot.commands;

import org.usfirst.frc.team977.robot.Robot;
import org.usfirst.frc.team977.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveForward extends Command {

	private double init_angle;
	private double speed;
	
    public DriveForward(double power, double time) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.RobotDrive);
    	setTimeout(time);
    	speed = power;
    	
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	init_angle = Robot.RobotGyro.getAngle();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	double angle = Robot.RobotGyro.getAngle();
    	Robot.RobotDrive.drive(speed, (angle - init_angle) * RobotMap.Kp);
    	//Robot.RobotDrive.drive(0.75, 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.RobotDrive.drive(0, 0);
    }
}
