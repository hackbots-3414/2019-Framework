package org.usfirst.frc.team3414.diagnostic;

import org.usfirst.frc.team3414.actuators.DriveTrain;
import org.usfirst.frc.team3414.teleop.Teleop;

public class Diagnostic {
	static boolean driveEnabled = false;
	static double speed = 0;
	static boolean recording;
	public static int position;
	public static boolean newController = false;
	public static String message;
	public static void checkInput() {
		DiagnosticServer.execute();
		switch (DiagnosticServer.getInput()) {

		case "exit":
			message = "Diagnostic Stopped";
			System.out.println(message);
			reset();
			DiagnosticServer.sendMessage(message);
		case "stop":
			message = "Diagnostic Stopped";
			System.out.println(message);
			reset();
			DiagnosticServer.sendMessage(message);
		case "kill":
			message = "Killing Robot";
			System.out.println(message);
			DiagnosticServer.sendMessage(message);
			System.exit(0);
		case "runmotor":
			message = "Use the command runmotor1, runmotor2";
			System.out.println(message);
			DiagnosticServer.sendMessage(message);
		case "speed1":
			speed = 1;
			message = ("speed is "+speed);
			System.out.println(message);
			DiagnosticServer.sendMessage(message);
		case "speed0":
			speed = 0;
			message = ("speed is "+speed);
			System.out.println(message);
			DiagnosticServer.sendMessage(message);
		case "speed-1":
			speed = -1;
			message = ("speed is "+speed);
			System.out.println(message);
			DiagnosticServer.sendMessage(message);
		case "runmotor1":
			message = "Running Motor 1 at: " + (speed * 100) + "%.";
			System.out.println(message);
			DriveTrain.getInstance().left.setFront(speed);
			DiagnosticServer.sendMessage(message);
		case "runmotor2":
			message = "Running Motor 2 at: " + (speed * 100) + "%.";
			System.out.println(message);
			DriveTrain.getInstance().left.setMiddle(speed);
			DiagnosticServer.sendMessage(message);
		case "runmotor3":
			message = "Running Motor 3 at: " + (speed * 100) + "%.";
			System.out.println(message);
			DriveTrain.getInstance().left.setRear(speed);
			DiagnosticServer.sendMessage(message);
		case "runmotor4":
			message = "Running Motor 4 at: " + (speed * 100) + "%.";
			System.out.println(message);
			DriveTrain.getInstance().right.setFront(speed);
			DiagnosticServer.sendMessage(message);
		case "runmotor5":
			message = "Running Motor 5 at: " + (speed * 100) + "%.";
			System.out.println(message);
			DriveTrain.getInstance().right.setMiddle(speed);
			DiagnosticServer.sendMessage(message);
		case "runmotor6":
			message = "Running Motor 6 at: " + (speed * 100) + "%.";
			System.out.println(message);
			DriveTrain.getInstance().left.setRear(speed);
			DiagnosticServer.sendMessage(message);
		case "encoderleft":
			message = "Gettting Encoder on Motor 1";
			System.out.println(message);
			DriveTrain.getInstance().left.getEncoder();
			DiagnosticServer.sendMessage(message);
		case "encoderRight":
			message = "Gettting Encoder on Motor 4";
			System.out.println(message);
			DriveTrain.getInstance().right.getEncoder();
			DiagnosticServer.sendMessage(message);
		case "encoderReset":
			message = "Resetting Encoders";
			System.out.println(message);
			DriveTrain.getInstance().left.resetEncoder();
			DriveTrain.getInstance().right.resetEncoder();
			DiagnosticServer.sendMessage(message);
		case "enabledrive":
			message = "Enabling drivetrain";
			System.out.println(message);
			driveEnabled = true;
			DiagnosticServer.sendMessage(message);
		case "disabledrive":
			message = "Disabling drivetrain";
			System.out.println(message);
			driveEnabled = false;
			reset();
			DiagnosticServer.sendMessage(message);
		case "record":
			message = "Recording";
			System.out.println(message);
			recording = true;
			DiagnosticServer.sendMessage(message);
		case "stoprecord":
			message = "Recording Stopped";
			System.out.println(message);
			recording = false;
			DiagnosticServer.sendMessage(message);
		case "pos1":
			position = 1;
			message =  "Position "+position;
			System.out.println(message);
			DiagnosticServer.sendMessage(message);
		case "pos2":
			position = 2;
			message =  "Position "+position;
			System.out.println(message);
			DiagnosticServer.sendMessage(message);
		case "pos3":
			position = 3;
			message =  "Position "+position;
			System.out.println(message);
			DiagnosticServer.sendMessage(message);
		case "tradcontrol":
			message = "Got it, using traditional controls";
			System.out.println(message);
			newController = false;
			DiagnosticServer.sendMessage(message);
		case "newcontrol":
			message = "Got it, using new controls";
			System.out.println(message);
			newController = true;
			}
		
	}

	public static boolean isRunning() {
		if ((DiagnosticServer.getInput() == null) || (DiagnosticServer.getInput() == "exit")
				|| (DiagnosticServer.getInput() == "stop")) {
			return false;
		} else {
			return true;
		}
	}
	public static boolean isNewControls() {
		return newController;
	}
	public static void reset() {
		speed = 0;
		DriveTrain.getInstance().left.setFront(0);
		DriveTrain.getInstance().left.setMiddle(0);
		DriveTrain.getInstance().left.setRear(0);
		DriveTrain.getInstance().right.setFront(0);
		DriveTrain.getInstance().right.setMiddle(0);
		DriveTrain.getInstance().right.setRear(0);

	}

	public static void runTeleop() {
		if (driveEnabled) {
			Teleop.getInstance().drive();
		}
	}

	public static boolean isRecording() {
		return recording;
	}
}
