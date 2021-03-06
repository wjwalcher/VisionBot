package org.usfirst.frc.team4511.robot;

import org.usfirst.frc.team4511.robot.commands.Align;
import org.usfirst.frc.team4511.robot.commands.ArmDown;
import org.usfirst.frc.team4511.robot.commands.ArmUp;
import org.usfirst.frc.team4511.robot.commands.AutoAlign;
import org.usfirst.frc.team4511.robot.commands.DriveForward;
import org.usfirst.frc.team4511.robot.commands.LiftDown;
import org.usfirst.frc.team4511.robot.commands.LiftUp;
import org.usfirst.frc.team4511.robot.commands.LineDrive;
import org.usfirst.frc.team4511.robot.commands.Stop;
import org.usfirst.frc.team4511.robot.commands.TestStuff;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    static double deadzone = .1;
	//// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
	public static Joystick stick1 = new Joystick(0);
	public static Joystick stick2 = new Joystick(1);
   
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    public OI(){
    	JoystickButton button1 = new JoystickButton(stick1, 1);

    	JoystickButton button3l = new JoystickButton(stick1, 3);
    	JoystickButton button3r = new JoystickButton(stick2, 3);
    	JoystickButton button6r = new JoystickButton(stick2, 6);
    	JoystickButton button7r = new JoystickButton(stick2, 7);

    	button1.whenPressed(new AutoAlign());
    	button3l.whenPressed(new ArmDown());
    	//button3l.whenReleased(new Stop());
    	button3r.whenPressed(new ArmUp());
    	//button3r.whenReleased(new Stop());
    	//button6r.whenPressed(new DriveForward());
    	button6r.whenPressed(new LineDrive());
    	button7r.whenPressed(new TestStuff());
    }
	
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	public static double getYInput(Joystick stick){
		if(Math.abs(stick.getY()) > deadzone){
			return -stick.getY();
		}else{
			return 0;
		}
	}
	
}