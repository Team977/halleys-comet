
package org.usfirst.frc.team977.robot.subsystems;

import org.usfirst.frc.team977.robot.RobotMap;
import org.usfirst.frc.team977.robot.commands.ArcadeDriveControl;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {
    
	private SpeedController leftMotors, rightMotors;
	private RobotDrive drive;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public Drivetrain(){
		super();
		leftMotors = new VictorSP(RobotMap.LeftMotorPWM);
		rightMotors = new VictorSP(RobotMap.RightMotorPWM);
		drive = new RobotDrive(leftMotors, rightMotors);
		drive.setSafetyEnabled(false);
	}
	
	//drive method, arcade-style
	public void drive(double throttle, double turn){
		drive.arcadeDrive(throttle*RobotMap.SpeedModifier, turn*RobotMap.TurnModifier, true);
		//drive.tankDrive(throttle, turn);
	}
	
	public void drive(Joystick joy){
		
		//some method of determining/choosing which input style is desired
		
		//Logitech Joystick Controls
		/*
		if (Robot.RobotCamera.Current_session == Robot.RobotCamera.Shooter_session){
			drive(-joy.getRawAxis(1), -joy.getRawAxis(2));
		}
		else if (Robot.RobotCamera.Current_session == Robot.RobotCamera.Drive_session){
			drive(joy.getRawAxis(1), -joy.getRawAxis(2));
		}
		*/
		
		drive(-joy.getRawAxis(1), -joy.getRawAxis(2));
		
		//Forza-style Xbox controls
		//drive(joy.getRawAxis(3)-joy.getRawAxis(2), -joy.getRawAxis(0));
		//drive(-joy.getRawAxis(1), -joy.getRawAxis(5));
		
		
	}
	
	
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ArcadeDriveControl());
    }
}

