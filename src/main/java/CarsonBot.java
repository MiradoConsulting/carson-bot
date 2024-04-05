import robocode.*;
import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * CarsonBot - a robot by (your name here)
 */
public class CarsonBot extends Robot
{
	private Double foundAtHeading = null;

	/**
	 * run: CarsonBot's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		setColors(Color.red,Color.blue,Color.green); // body,gun,radar

		// Robot main loop
		while(true) {
			if (foundAtHeading != null) {
				double target = angleBetween(foundAtHeading, getGunHeading());
				if (target < 0) {
					turnGunLeft(-target);
				} else {
					turnGunRight(target);
				}

				fire(1);
				foundAtHeading = null;
			}

			ahead(100);
			turnRight(30);
			scan();
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
