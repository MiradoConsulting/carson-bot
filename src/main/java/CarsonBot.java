import robocode.*;
import java.awt.Color;
import java.util.Random;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * CarsonBot - a robot by (your name here)
 */
public class CarsonBot extends Robot
{
	private Double foundAtHeading = null;
	private Double foundAtBearing = null;

	/**
	 * run: CarsonBot's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		Random rand = new Random();
		setColors(Color.pink, Color.pink, Color.pink); // body,gun,radar

		// Robot main loop
		while(true) {
			if (foundAtBearing != null) {
				if (foundAtBearing < 0) {
					turnLeft(-foundAtBearing);
				} else {
					turnRight(foundAtBearing);
				}

				fire(1);
				foundAtHeading = null;
				foundAtBearing = null;
				scan();
				ahead(50);
			}

			if (foundAtHeading == null) {
				turnGunLeft(360);
				turnRight(90);
				ahead(200);
			}
		}
	}

	private double angleBetween(double a1, double a2) {
		double res1 = (a1 - a2) % (2 * Math.PI);
		double res2 = (a2 - a1) % (2 * Math.PI);
		if (res1 < res2) {
			return -res1;
		} else {
			return res2;
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		foundAtHeading = e.getHeading();
		foundAtBearing = e.getBearing();
		fire(1);
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		back(10);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		back(20);
	}	
}
