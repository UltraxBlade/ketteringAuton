package org.usfirst.frc.team5561.robot.commands;

import org.usfirst.frc.team5561.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class spin extends Command {
	private double spinSpeed;
    public spin(double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive_subsystem);
    	spinSpeed = speed;
    	setTimeout(5);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drive_subsystem.spin(spinSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
