package org.usfirst.frc.team5561.robot.subsystems;

import org.usfirst.frc.team5561.robot.commands.driveWithJoystick;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class shooter extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private Victor shoot = new Victor(3);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	//setDefaultCommand(new driveWithJoystick());
    }
    
    public void shoot(double speed) {
    	shoot.set(speed);
    }
}

