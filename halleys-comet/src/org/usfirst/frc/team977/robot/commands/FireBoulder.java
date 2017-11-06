package org.usfirst.frc.team977.robot.commands;

import org.usfirst.frc.team977.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FireBoulder extends Command {

    public FireBoulder() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.RobotPneumaticPusher);
    	setTimeout(2);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	Robot.RobotPneumaticPusher.Fire();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.RobotPneumaticPusher.Reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
