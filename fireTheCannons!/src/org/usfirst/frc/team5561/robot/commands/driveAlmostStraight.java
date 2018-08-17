package org.usfirst.frc.team5561.robot.commands;

import org.usfirst.frc.team5561.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class driveAlmostStraight extends Command {

    public driveAlmostStraight(double distin) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive_subsystem);
    	setTimeout(distin);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drive_subsystem.jkgnjankDrive(.45, .51);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drive_subsystem.jkgnjankDrive(0.0, 0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.drive_subsystem.jkgnjankDrive(0.0, 0.0);
    }
}
