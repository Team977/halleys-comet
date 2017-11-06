package org.usfirst.frc.team977.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Spy extends CommandGroup {
    
    public  Spy() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    	//addSequential(new DriveForward(.5,2));
    	
    	
    	/*addSequential(new RaiseShooter());
    	addSequential(new DriveForward(0.5));
    	//addSequential(new TurnBot(-5));
    	addSequential(new DriveForward(.25));
    	
    	addParallel(new SpinUpShooter());
    	addSequential(new Wait(1));
    	addSequential(new FireBoulder());
    	addSequential(new Wait(1));
    	addSequential(new StopShooters());
    	*/
    	
    	//addSequential(new TurnBot(90));
    	
    }
}
