package org.usfirst.frc.team5561.robot.commands;

import org.usfirst.frc.team5561.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class shootLow extends Command {

    public shootLow() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.shooter_subsystem);
    	setTimeout(5);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.shooter_subsystem.shoot(0.325);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooter_subsystem.shoot(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.shooter_subsystem.shoot(0.0);
    }
}
