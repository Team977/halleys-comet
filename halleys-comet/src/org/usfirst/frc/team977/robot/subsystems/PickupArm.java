
package org.usfirst.frc.team977.robot.subsystems;

import org.usfirst.frc.team977.robot.RobotMap;
import org.usfirst.frc.team977.robot.commands.PickupArmControl;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PickupArm extends Subsystem {
    
	
	private SpeedController rotator;
	private Encoder the_encoder;
	
	public PickupArm(){
		super();
		
		rotator = new Spark(RobotMap.ArmRotatePWM);
		the_encoder = new Encoder(0, 1, true);
		the_encoder.setMinRate(0);
		the_encoder.setDistancePerPulse(1);
		
	}
	public void resetEncoder(){
		the_encoder.reset();
	}
	public void rotate(double speed){
		rotator.set(speed);
	}	/*
	public void moveArm(Joystick joy){
		rotate((-joy.getRawAxis(3) + 1)/2);
	}
	public void moveArm(double position){
		
		double difference = ((the_encoder.getDistance()/497)*2 - position);
		
		if (difference > 0.15 || difference < -0.15){
			rotate(difference);
		}
		else if (difference > 0 && difference <0.15){
			rotate(0.15);
		}
		else if (difference < 0 && difference >-0.15){
			rotate(-0.15);
		} */
	
	public void rotate(Joystick joy){
		
		double difference = ((the_encoder.getDistance()/497)*2 - (-joy.getRawAxis(3) + 1)/2);
		
		if (difference > 0.25 || difference < -0.25){
			rotate(difference);
		}
		else if (difference > 0 && difference <0.25){
			rotate(0.25);
		}
		else if (difference < 0 && difference >-0.25){
			rotate(-0.25);
		}
	}
	

	
	public double getEncoder(){
		return the_encoder.getDistance();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new PickupArmControl());
    }
}

