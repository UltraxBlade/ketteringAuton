package org.usfirst.frc.team5561.robot.commands;

import org.usfirst.frc.team5561.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class driveStraight extends Command {
	private double initDistL;
	private double initDistR;
	private double dist=604;
    public driveStraight() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	// setTimeout(11.55);
    	setTimeout(15);
    	requires(Robot.drive_subsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drive_subsystem.gyro.zeroYaw();
    	initDistL=Robot.drive_subsystem.leftEncoder.getDistance();
    	initDistR=Robot.drive_subsystem.rightEncoder.getDistance();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drive_subsystem.arcadeDrive(-0.75, Robot.drive_subsystem.getGyroAngle()*0.1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return Robot.drive_subsystem.leftEncoder.getDistance()>=initDistL+dist || Robot.drive_subsystem.rightEncoder.getDistance()>=initDistR+dist || isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
