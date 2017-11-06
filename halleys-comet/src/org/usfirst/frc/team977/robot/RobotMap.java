package org.usfirst.frc.team977.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	//PWM ports
	public static int LeftMotorPWM = 0;
	public static int RightMotorPWM = 1;
	public static int ArmRotatePWM = 4;
	public static int ShooterMotorPWM1 = 3;
	public static int ShooterMotorPWM2 = 2;
	
	
	//Solenoid ports
	public static int ArmGraspPort = 2;
	public static int BoulderPusherPort = 1;
	public static int ShooterLifter =0;
	
	
	//Constants
	public static double SpeedModifier = 1; //scales motor output forwards and backwards
	public static double TurnModifier = 0.8;  //scales motor output when turning
	public static final double Kp = 0.18;
	
	
	
}
