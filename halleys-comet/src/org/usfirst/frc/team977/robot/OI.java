package org.usfirst.frc.team977.robot;

import org.usfirst.frc.team977.robot.commands.FireBoulder;
import org.usfirst.frc.team977.robot.commands.GraspIt;
import org.usfirst.frc.team977.robot.commands.LowerShooter;
import org.usfirst.frc.team977.robot.commands.PrepareToFire;
import org.usfirst.frc.team977.robot.commands.RaiseShooter;
import org.usfirst.frc.team977.robot.commands.ReleaseBall;
import org.usfirst.frc.team977.robot.commands.StopShooters;
import org.usfirst.frc.team977.robot.commands.SwapCamera;
import org.usfirst.frc.team977.robot.commands.ToggleOverlay;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	Joystick stick = new Joystick(0);
	//Joystick autoSelector = new Joystick(1);
	
	
	public OI(){
		
		Button button1 = new JoystickButton(stick, 1);
		button1.whenPressed(new FireBoulder());
		
		Button button2 = new JoystickButton(stick, 2);
		button2.whenPressed(new PrepareToFire());
		button2.whenReleased(new StopShooters());
		
		Button button3 = new JoystickButton(stick, 3);
		button3.whenPressed(new RaiseShooter());
		
		Button button4 = new JoystickButton(stick, 4);
		button4.whenPressed(new LowerShooter());
		
		//Button button5 = new JoystickButton(stick, 5);
				
		//Button button6 = new JoystickButton(stick, 6);
				
		Button button7 = new JoystickButton(stick, 7);
		button7.whenPressed(new SwapCamera());
		
		Button button8 = new JoystickButton(stick, 8);
		button8.whenPressed(new ToggleOverlay());
		
	//	Button button9 = new JoystickButton(stick, 9);
	//	button9.whenPressed(new RaiseArms());
	//	button9.whenReleased(new StopArms());
		
		Button button10 = new JoystickButton(stick, 10);
		button10.whenPressed(new GraspIt());
				
	//	Button button11 = new JoystickButton(stick, 11);
	//	button11.whenPressed(new LowerArms());
	//	button11.whenReleased(new StopArms());
		
		Button button12 = new JoystickButton(stick, 12);
		button12.whenPressed(new ReleaseBall());
		
		
		//adds buttons on dashboard
		//SmartDashboard.putData("Toggle Overlay", new ToggleOverlay());

	}
	
	public Joystick getJoystick(){
		return stick;
	}
	public double getThrottle(){
		return stick.getRawAxis(3);
	}
	/*public int getAuto(){
		if (autoSelector.getRawAxis(0) <= -42){
			return 1;
		}
		else if (autoSelector.getRawAxis(0) <= 42){
			return 2;
		}
		else {
			return 3;
		}
	}*/
}

