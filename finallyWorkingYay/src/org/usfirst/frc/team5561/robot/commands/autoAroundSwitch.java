package org.usfirst.frc.team5561.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class autoAroundSwitch extends CommandGroup {

    public autoAroundSwitch() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	
    	addSequential(new driveStraight(205));
    	addSequential(new leftTurn(92));
    	addSequential(new driveStraight(103));
    	addSequential(new leftTurn(92));
    	addSequential(new driveStraight(205));
    	addSequential(new leftTurn(92));
    	addSequential(new driveStraight(103));
    	//addSequential(new leftTurn(92));
    	

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
    }
}
