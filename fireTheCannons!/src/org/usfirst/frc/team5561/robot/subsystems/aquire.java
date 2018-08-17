package org.usfirst.frc.team5561.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class aquire extends Subsystem {

	private Victor aquire = new Victor(2);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void aquireBall(double speed) {
    	aquire.set(speed);
    }
}

