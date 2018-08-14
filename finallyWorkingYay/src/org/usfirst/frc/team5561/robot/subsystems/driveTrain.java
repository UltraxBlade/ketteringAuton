package org.usfirst.frc.team5561.robot.subsystems;

import org.usfirst.frc.team5561.robot.OI;
import org.usfirst.frc.team5561.robot.Robot;
import org.usfirst.frc.team5561.robot.RobotMap;
import org.usfirst.frc.team5561.robot.commands.driveWithJoystick;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;

/**
 *
 */
public class driveTrain extends Subsystem 
	{
	
		private VictorSP frontLeft = new VictorSP(RobotMap.frontLeft);
		private VictorSP frontRight = new VictorSP(RobotMap.frontRight);
		private VictorSP backLeft = new VictorSP(RobotMap.backLeft);
		private VictorSP backRight = new VictorSP(RobotMap.backRight);
		private VictorSP middleLeft  = new VictorSP(RobotMap.middleLeft);
		private VictorSP middleRight = new VictorSP(RobotMap.middleRight);
		
		private SpeedControllerGroup left = new SpeedControllerGroup(frontLeft, middleLeft, backLeft);
		private SpeedControllerGroup right = new SpeedControllerGroup(frontRight, middleRight, backRight);
	
		private DifferentialDrive tankDrive=new DifferentialDrive(left,right);
	    public void initDefaultCommand() 
	    	{
	    		// Set the default command for a subsystem here.
	        	setDefaultCommand(new driveWithJoystick());
	    	
	    	}
	    
	    public void jkgnjankDrive(double l, double r)
		    {
		    	tankDrive.tankDrive(l, r);
		    }
	    
	    
	}

