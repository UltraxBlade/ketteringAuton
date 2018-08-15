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
	
		public double intialPosL = 0;
		public double intialPosR = 0;
		
		private WPI_TalonSRX frontLeft = new WPI_TalonSRX(RobotMap.frontLeft);
		private WPI_TalonSRX frontRight = new WPI_TalonSRX(RobotMap.frontRight);
		private WPI_TalonSRX backLeft = new WPI_TalonSRX(RobotMap.backLeft);
		private WPI_TalonSRX backRight = new WPI_TalonSRX(RobotMap.backRight);
	//	private WPI_TalonSRX middleLeft  = new WPI_TalonSRX(RobotMap.middleLeft);
	//	private WPI_TalonSRX middleRight = new WPI_TalonSRX(RobotMap.middleRight);
		
		private SpeedControllerGroup left = new SpeedControllerGroup(frontLeft, backLeft);
		private SpeedControllerGroup right = new SpeedControllerGroup(frontRight, backRight);
		
		public Encoder leftEncoder = new Encoder(2,3);
		public Encoder rightEncoder = new Encoder(4,5);
		
	
		private DifferentialDrive jankDrive=new DifferentialDrive(left,right);
		
		public static final double pulsesToInches = (6*(Math.PI))/4096;
		
	    public void initDefaultCommand() 
	    	{
	    		// Set the default command for a subsystem here.
	        	setDefaultCommand(new driveWithJoystick());
	        	//leftEncoder.setDistancePerPulse(pulsesToInches);
	        	//rightEncoder.setDistancePerPulse(pulsesToInches);
	    	
	    	}
	    
	    public void jkgnjankDrive(double l, double r)
		    {
		    	jankDrive.tankDrive(l, r);
		    }
	    
	    public void arcadeDrive(double spe, double ang) {
	    	jankDrive.arcadeDrive(spe, ang);
	    }
	    
	    public double encoderInfoLeft() {
	    	return -backLeft.getSensorCollection().getQuadraturePosition() * pulsesToInches;
	    }
	    
	    public double encoderInfoRight() {
	    	return frontRight.getSensorCollection().getQuadraturePosition() * pulsesToInches;
	    }
	    
	    public double getGyroAngle() {
	    	return gyro.getAngle();
	    }
	}

