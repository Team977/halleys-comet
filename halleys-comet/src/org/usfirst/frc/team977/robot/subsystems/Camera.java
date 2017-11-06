package org.usfirst.frc.team977.robot.subsystems;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team977.robot.commands.StreamCamera;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Camera extends Subsystem {
    
	public static boolean OverlayStatus = true;
	//int Current_session;
	UsbCamera shooterCam;
	UsbCamera driveCam;
	int IMG_WIDTH = 320;
	int IMG_HEIGHT = 240;
	Thread visionThread;
	//Image frame;
	
	// Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public Camera(){
		

		/*
		super();
		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
		Shooter_session = NIVision.IMAQdxOpenCamera("cam0", NIVision.IMAQdxCameraControlMode.CameraControlModeController);
		Drive_session = NIVision.IMAQdxOpenCamera("cam1", NIVision.IMAQdxCameraControlMode.CameraControlModeController);
		Current_session = Shooter_session;
		NIVision.IMAQdxConfigureGrab(Current_session);
		*/
		visionThread = new Thread(() -> {
			shooterCam = CameraServer.getInstance().startAutomaticCapture(0);
			shooterCam.setResolution(IMG_WIDTH, IMG_HEIGHT);
			
			driveCam = CameraServer.getInstance().startAutomaticCapture(1);
			driveCam.setResolution(IMG_WIDTH, IMG_HEIGHT);
			
			CvSink cvSink = CameraServer.getInstance().getVideo();
		// Setup a CvSource. This will send images back to the Dashboard
			CvSource outputStream = CameraServer.getInstance().putVideo("Rectangle", 640, 480);

		// Mats are very memory expensive. Lets reuse this Mat.
			Mat mat = new Mat();

		// This cannot be 'true'. The program will never exit if it is. This
		// lets the robot stop this thread when restarting robot code or
		// deploying.
			while (!Thread.interrupted()) {
			// Tell the CvSink to grab a frame from the camera and put it
			// in the source mat.  If there is an error notify the output.
				if (cvSink.grabFrame(mat) == 0) {
				// Send the output the error.
				outputStream.notifyError(cvSink.getError());
				// skip the rest of the current iteration
					continue;
				}
			// Put a rectangle on the image
				Imgproc.rectangle(mat, new Point(100, 100), new Point(400, 400),
					new Scalar(255, 255, 255), 5);
			// Give the output stream a new image to display
				outputStream.putFrame(mat);
		}
	});
	visionThread.setDaemon(true);
	visionThread.start();
	}
	
	
	public void BeginStream(){
		
		/*
		NIVision.IMAQdxStartAcquisition(Current_session);
		NIVision.IMAQdxGrab(Current_session, frame, 1);
		
		if (OverlayStatus == true && Current_session == Shooter_session) {
			NIVision.Rect rect1 = new NIVision.Rect(362, 237, 64, 64);
			//NIVision.Rect rect2 = new NIVision.Rect(425,298,52,52);
			
	        NIVision.imaqDrawShapeOnImage(frame, frame, rect1, DrawMode.DRAW_VALUE, ShapeMode.SHAPE_OVAL, 180.0f);
	        //NIVision.imaqDrawShapeOnImage(frame, frame, rect2, DrawMode.DRAW_VALUE, ShapeMode.SHAPE_OVAL, 180.0f);
	        
		}
		
		if (OverlayStatus == true && Current_session == Drive_session) {
			NIVision.Point point1 = new NIVision.Point(-550,560);
			NIVision.Point point2 = new NIVision.Point(320,235);
			NIVision.Point point3 = new NIVision.Point(1190,560);
			NIVision.Point point4 = new NIVision.Point(320,235);
			NIVision.imaqDrawLineOnImage(frame, frame, DrawMode.DRAW_VALUE, point1, point2, 500.0f);
			NIVision.imaqDrawLineOnImage(frame, frame, DrawMode.DRAW_VALUE, point3, point4, 500.0f);
		}
		
		
        
        CameraServer.getInstance().setImage(frame);
        
        */
	}
	/*
	public void SwapStreams(){
		if (Current_session == Shooter_session){
			NIVision.IMAQdxStopAcquisition(Current_session);
			Current_session = Drive_session;
			NIVision.IMAQdxConfigureGrab(Current_session);
		}
		else if (Current_session == Drive_session){
			NIVision.IMAQdxStopAcquisition(Current_session);
			Current_session = Shooter_session;
			NIVision.IMAQdxConfigureGrab(Current_session);
		}
	}
	
	public void EndStream(){
		NIVision.IMAQdxStopAcquisition(Current_session);
	}
	
	public String getCamera(){
		if (Current_session == Shooter_session){
			return "Shooter";
		}
		else {
			return "Drive";
		}
	}
	
*/
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    	setDefaultCommand(new StreamCamera());
    }
}

