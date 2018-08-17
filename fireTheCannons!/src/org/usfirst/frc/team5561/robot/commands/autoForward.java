package org.usfirst.frc.team5561.robot.commands;

import org.usfirst.frc.team5561.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class autoForward extends Command {
	private double initDistL;
	private double initDistR;
    public autoForward() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	setTimeout(5);
    	requires(Robot.drive_subsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	initDistL=Robot.drive_subsystem.leftEncoder.getDistance();
    	initDistR=Robot.drive_subsystem.rightEncoder.getDistance();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drive_subsystem.jkgnjankDrive(-.5*1.25, -.52*1.25);
    	System.out.println(Robot.drive_subsystem.leftEncoder.getDistance());
    	System.out.println(Robot.drive_subsystem.rightEncoder.getDistance());

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.drive_subsystem.leftEncoder.getDistance()>=initDistL+1 || Robot.drive_subsystem.rightEncoder.getDistance()>=initDistR+1 || isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drive_subsystem.jkgnjankDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.drive_subsystem.jkgnjankDrive(0, 0);
    }
}
