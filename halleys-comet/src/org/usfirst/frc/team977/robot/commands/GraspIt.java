package org.usfirst.frc.team977.robot.commands;

import org.usfirst.frc.team977.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GraspIt extends Command {

    public GraspIt() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.RobotPneumaticGrip);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.RobotPneumaticGrip.grab();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
