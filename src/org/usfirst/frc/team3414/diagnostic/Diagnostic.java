package org.usfirst.frc.team3414.diagnostic;

import org.usfirst.frc.team3414.actuators.DriveTrain;
import org.usfirst.frc.team3414.teleop.Teleop;

public class Diagnostic {
	public static void checkInput() {
		DiagnosticServer.execute();
		double speed = 0;
		switch(DiagnosticServer.getInput()) {
		case "exit":
			System.out.println("Diagnostic Stopped");
		case "stop":
			System.out.println("Diagnostic Stopped");
		case "kill":
			System.out.println("Killing Robot");
			System.exit(0);
		case "runmotor":
			System.out.println("Use the command runmotor1, runmotor2");
		case "speed1":
			speed = 1;
		case "speed0":
			speed = 0;
		case "speed-1":
			speed = -1;
		case "runmotor1":
			System.out.println("Running Motor 1 at: "+(speed*100)+"%.");
			DriveTrain.getInstance().left.setFront(speed);
		case "runmotor2":
			System.out.println("Running Motor 2 at: "+(speed*100)+"%.");
			DriveTrain.getInstance().left.setMiddle(speed);
		case "runmotor3":
			System.out.println("Running Motor 3 at: "+(speed*100)+"%.");
			DriveTrain.getInstance().left.setRear(speed);
		case "runmotor4":
			System.out.println("Running Motor 4 at: "+(speed*100)+"%.");
			DriveTrain.getInstance().right.setFront(speed);
		case "runmotor5":
			System.out.println("Running Motor 5 at: "+(speed*100)+"%.");
			DriveTrain.getInstance().right.setMiddle(speed);
		case "runmotor6":
			System.out.println("Running Motor 6 at: "+(speed*100)+"%.");
			DriveTrain.getInstance().left.setRear(speed);
		
		case "encoderleft":
			System.out.println("Gettting Encoder on Motor 1");
			DriveTrain.getInstance().left.getEncoder();
		case "encoderRight":
			System.out.println("Gettting Encoder on Motor 4");
			DriveTrain.getInstance().right.getEncoder();
		case "encoderReset":
			System.out.println("Resetting Encoders");
			DriveTrain.getInstance().left.resetEncoder();
			DriveTrain.getInstance().right.resetEncoder();
		}
		}
		
		
		
		
	}
	public static boolean isRunning() {
		if((DiagnosticServer.getInput() == null )|| (DiagnosticServer.getInput()=="exit")) {
			return false;
		}
		else {
			return true;
		}
	}
	public static void teleop() {
		Teleop.getInstance().drive();
	}
}
