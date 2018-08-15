package org.usfirst.frc.team5561.robot.commands;

import org.usfirst.frc.team5561.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class encoderTest extends Command {

    public encoderTest() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive_subsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Robot.drive_subsystem.gyro.zeroYaw();
    	Robot.drive_subsystem.leftEncoder.reset();
    	Robot.drive_subsystem.rightEncoder.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putNumber("left encoder", Robot.drive_subsystem.leftEncoder.getDistance());
    	SmartDashboard.putNumber("right encoder", Robot.drive_subsystem.leftEncoder.getDistance());
    	//SmartDashboard.putNumber("gyro", Robot.drive_subsystem.getGyroAngle());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
