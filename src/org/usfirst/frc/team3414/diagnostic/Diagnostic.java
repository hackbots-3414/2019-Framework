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
		case "runmotor1":
			System.out.println("Running Motor 1 at: "+(speed*100)+"%.");
			DriveTrain.getInstance().left.setFront(speed);
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
