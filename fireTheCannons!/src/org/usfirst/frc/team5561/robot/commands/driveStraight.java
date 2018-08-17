package org.usfirst.frc.team5561.robot.commands;

import org.usfirst.frc.team5561.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class driveStraight extends Command {
	//private double dist=595;
	//double distanceL;
	//double distanceR;
    public driveStraight(double distin) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	// setTimeout(11.55);
    	setTimeout(distin);
    	requires(Robot.drive_subsystem);
    	//dist = distin;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Robot.drive_subsystem.intialPosL = Robot.drive_subsystem.encoderInfoLeft();
    	//Robot.drive_subsystem.intialPosR = Robot.drive_subsystem.encoderInfoRight();
    	//distanceL = Robot.drive_subsystem.intialPosL + dist;
    	//distanceR = Robot.drive_subsystem.intialPosR + dist;
    	Robot.drive_subsystem.gyro.zeroYaw();
    	//Robot.drive_subsystem.leftEncoder.reset();
    	//Robot.drive_subsystem.rightEncoder.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		Robot.drive_subsystem.jkgnjankDrive(.45, .5);
    	//	Robot.drive_subsystem.arcadeDrive(1.0, Robot.drive_subsystem.getGyroAngle()*-0.1);
    	//SmartDashboard.putNumber("left encoder", Robot.drive_subsystem.encoderInfoLeft()-Robot.drive_subsystem.intialPosL);
    	//SmartDashboard.putNumber("right encoder", Robot.drive_subsystem.encoderInfoRight()-Robot.drive_subsystem.intialPosR);
    	SmartDashboard.putNumber("gyro", Robot.drive_subsystem.getGyroAngle());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return isTimedOut();
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
