package org.usfirst.frc.team977.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LowBarCross extends CommandGroup {
    
    public  LowBarCross() {
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
    	

    	
    	addSequential(new GraspIt());
    	addSequential(new Wait(.4));
    	//addParallel(new MoveArm(0.85));
    	addSequential(new Wait(.25));
    	addSequential(new DriveForward(.6,2.4));
    	addSequential(new RaiseShooter());
    	//addParallel(new MoveArm(0));
    	addSequential(new TurnBot(45));
    	addSequential(new DriveForward(.7,.2));
    	

    	


    }
}
