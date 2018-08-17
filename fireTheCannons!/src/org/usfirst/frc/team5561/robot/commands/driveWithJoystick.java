package org.usfirst.frc.team5561.robot.commands;

import org.usfirst.frc.team5561.robot.OI;
import org.usfirst.frc.team5561.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class driveWithJoystick extends Command {

    public driveWithJoystick() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive_subsystem);
    	//requires(Robot.shooter_subsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drive_subsystem.jkgnjankDrive(-0.75 * OI.stick.getRawAxis(1), -0.75 * OI.stick.getRawAxis(5));
    	Robot.shooter_subsystem.shoot(OI.stick.getRawAxis(2));
    	Robot.aquire_subsystem.aquireBall(-OI.stick.getRawAxis(3));
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
