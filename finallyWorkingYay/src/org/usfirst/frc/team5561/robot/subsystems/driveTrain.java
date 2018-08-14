package org.usfirst.frc.team5561.robot.subsystems;

import org.usfirst.frc.team5561.robot.OI;
import org.usfirst.frc.team5561.robot.Robot;
import org.usfirst.frc.team5561.robot.RobotMap;
import org.usfirst.frc.team5561.robot.commands.driveWithJoystick;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;

/**
 *
 */
public class driveTrain extends Subsystem 
	{
		public AHRS gyro = new AHRS(SPI.Port.kMXP);
		
		private VictorSP frontLeft = new VictorSP(RobotMap.frontLeft);
		private VictorSP frontRight = new VictorSP(RobotMap.frontRight);
		private VictorSP backLeft = new VictorSP(RobotMap.backLeft);
		private VictorSP backRight = new VictorSP(RobotMap.backRight);
		private VictorSP middleLeft  = new VictorSP(RobotMap.middleLeft);
		private VictorSP middleRight = new VictorSP(RobotMap.middleRight);
		
		private SpeedControllerGroup left = new SpeedControllerGroup(frontLeft, middleLeft, backLeft);
		private SpeedControllerGroup right = new SpeedControllerGroup(frontRight, middleRight, backRight);
		
		public Encoder leftEncoder = new Encoder(2,3);
		public Encoder rightEncoder = new Encoder(4,5);
	
		private DifferentialDrive jankDrive=new DifferentialDrive(left,right);
		
	    public void initDefaultCommand() 
	    	{
	    		// Set the default command for a subsystem here.
	        	setDefaultCommand(new driveWithJoystick());
	        	leftEncoder.setDistancePerPulse(1.0/38.4);
	        	rightEncoder.setDistancePerPulse(1.0/38.4);
	    	
	    	}
	    
	    public void jkgnjankDrive(double l, double r)
		    {
		    	jankDrive.tankDrive(l, r);
		    }
	    
	    public void arcadeDrive(double spe, double ang) {
	    	jankDrive.arcadeDrive(spe, ang);
	    }
	    
	    public double getGyroAngle() {
	    	return gyro.getAngle();
	    }
	}

