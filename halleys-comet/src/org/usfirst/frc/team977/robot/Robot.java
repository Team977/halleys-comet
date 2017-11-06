
package org.usfirst.frc.team977.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team977.robot.commands.AutoDefenseCross;
import org.usfirst.frc.team977.robot.subsystems.Camera;
import org.usfirst.frc.team977.robot.subsystems.Drivetrain;
import org.usfirst.frc.team977.robot.subsystems.PickupArm;
import org.usfirst.frc.team977.robot.subsystems.PneumaticGrip;
import org.usfirst.frc.team977.robot.subsystems.PneumaticLifter;
import org.usfirst.frc.team977.robot.subsystems.PneumaticPusher;
import org.usfirst.frc.team977.robot.subsystems.Shooter;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	public static OI oi; //= new OI();
	public static final Drivetrain RobotDrive = new Drivetrain();
	public static final PickupArm RobotArm = new PickupArm();
	public static final Shooter RobotShooter = new Shooter();
	public static final Camera RobotCamera = new Camera();
	public static final PneumaticPusher RobotPneumaticPusher = new PneumaticPusher();
	public static final PneumaticLifter RobotPneumaticLifter = new PneumaticLifter();
	public static final PneumaticGrip RobotPneumaticGrip = new PneumaticGrip();
	//PowerDistributionPanel pdp = new PowerDistributionPanel();
	//BuiltInAccelerometer RobotAccel = new BuiltInAccelerometer();
	public static Gyro RobotGyro = new ADXRS450_Gyro();
	
	

    Command autonomousCommand;
   // SendableChooser chooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	RobotArm.resetEncoder();
//    	SmartDashboard.putNumber("AUTO Drive Speed", AUTODrivespeed);
  //  	SmartDashboard.putNumber("AUTO Drive Duration", AUTODriveDuration);
    //	SmartDashboard.putNumber("AUTO Turn Angle", AUTOTurnAngle);
    	
		oi = new OI();
     //   chooser = new SendableChooser();
      //  chooser.addDefault("Approach", new GraspIt());
     //   chooser.addObject("Low Bar", new LowBarCross());
    //    chooser.addObject("Drive Straight", new Position4Crosser());

      //  chooser.addObject("Spy", new Spy());
        
        
        
     //   SmartDashboard.putData("Auto mode", chooser);

    	//SmartDashboard.putNumber("Gyro Angle", RobotGyro.getAngle());
    	//SmartDashboard.putNumber("PDP Temp", pdp.getTemperature());
    	//SmartDashboard.putNumber("Total Current Draw", pdp.getTotalCurrent());
    	//SmartDashboard.putNumber("Acceleration X", RobotAccel.getX());
    	//SmartDashboard.putNumber("Acceleration Y", RobotAccel.getY());
    	//SmartDashboard.putNumber("Acceleration Z", RobotAccel.getZ());
    	//SmartDashboard.putNumber("Shooter Speed", ShooterSpeed);
    	//SmartDashboard.putNumber("Encoder Distance", RobotArm.getEncoder());
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){
    	//RobotGyro.calibrate();
    	RobotArm.resetEncoder();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
        //SmartDashboard.putNumber("Gyro Angle", RobotGyro.getAngle());
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
    	autonomousCommand = new AutoDefenseCross();
    	
    	/*
    	switch (oi.getAuto()){
    	case 1: autonomousCommand = new Approach();
    		break;
    	case 2: autonomousCommand = new LowBarCross();
    		break;
    	case 3: autonomousCommand = new AutoDefenseCross();
    		break;
    	}
    	*/
        
		/* String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "My Auto":
			autonomousCommand = new MyAutoCommand();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new ExampleCommand();
			break;
		} */
    	
    	// schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        //SmartDashboard.putNumber("Gyro Angle", RobotGyro.getAngle());
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        
        //RobotCamera.BeginStream();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        //SmartDashboard.putNumber("Gyro Angle", RobotGyro.getAngle());
        //SmartDashboard.putString("Camera", RobotCamera.getCamera());
    	//SmartDashboard.putNumber("Total Current Draw", pdp.getTotalCurrent());
    	//SmartDashboard.putNumber("Acceleration X", RobotAccel.getX());
    	//SmartDashboard.putNumber("Acceleration Y", RobotAccel.getY());
    	//SmartDashboard.putNumber("Acceleration Z", RobotAccel.getZ());
    	//SmartDashboard.putNumber("Encoder Distance", RobotArm.getEncoder());

    	//SmartDashboard.putNumber("Throttle", oi.getThrottle());
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
