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
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.VictorSP;

/**
 *
 */
public class driveTrain extends Subsystem 
	{
		public AHRS gyro = new AHRS(SPI.Port.kMXP);
	
		public double intialPosL = 0;
		public double intialPosR = 0;
		
		private Jaguar frontLeft = new Jaguar(RobotMap.frontLeft);
		private Jaguar frontRight = new Jaguar(RobotMap.frontRight);
	//	private Jaguar backLeft = new Jaguar(RobotMap.backLeft);
	//	private Jaguar backRight = new Jaguar(RobotMap.backRight);
	//	private Jaguar middleLeft  = new Jaguar(RobotMap.middleLeft);
	//	private Jaguar middleRight = new Jaguar(RobotMap.middleRight);
		
		
		private SpeedControllerGroup left = new SpeedControllerGroup(frontLeft);
		private SpeedControllerGroup right = new SpeedControllerGroup(frontRight);
		
		public Encoder leftEncoder = new Encoder(0,1);
		public Encoder rightEncoder = new Encoder(4,5);
		
	
		private DifferentialDrive jankDrive=new DifferentialDrive(left,right);
		
		public static final double pulsesToInches = 1;
		
	    public void initDefaultCommand() 
	    	{
	    		// Set the default command for a subsystem here.
	        	setDefaultCommand(new driveWithJoystick());
	        	//leftEncoder.setDistancePerPulse(pulsesToInches);
	        	//rightEncoder.setDistancePerPulse(pulsesToInches);
	    	
	    	}
	    
	    public void jkgnjankDrive(double l, double r)
		    {
		    	jankDrive.tankDrive(-l, r);
		    }
	    
	    public void arcadeDrive(double spe, double ang) {
	    	jankDrive.arcadeDrive(spe, ang);
	    }
	    public void spin(double speed) {
	    	Robot.drive_subsystem.jkgnjankDrive(speed, -speed);
	    }
	    
	    public double encoderInfoLeft() {
	    	return leftEncoder.getDistance();
	    }
	    
	    public double encoderInfoRight() {
	    	return 0;
	    }
	    
	    public double getGyroAngle() {
	    	return gyro.getAngle();
	    }
	}

