package elements;
import primitives.*;

/**
 * Camera.
 * Used as a substitute for a real eye.
 * Used mainly for the math used to create the image through the grid
 *
 */

public class Camera {

	private Point3D _p0;
	Vector vUp;
	Vector vTo;
	Vector vRight;	
	
	/**
	 * Constructor.
	 * Receives the camera's location (p0), Upwards vector (vUp), The vector that points towards the grid/screen (vTo) and calculates vRight, the vector Vertical to both vTo and vUp.
	 */
	public Camera(Point3D p0, Vector vUp, Vector vTo/*, Vector vRight*/) {
		this.p0 = new Point3D(p0);
		this.vUp = new Vector(vUp).normalize();
		this.vTo = new Vector(vTo).normalize();
		//this.vRight = new Vector(vRight);
		if(!(vUp.dotProduct(vTo)==0))
			vRight=null;
		else
			vRight = vUp.crossProduct(vTo).normalize();
	}
	
	/**
	 * The function constructs a ray through a given pixel in the given grid
	 * @param Nx
	 * @param Ny
	 * @param i
	 * @param j
	 * @param screenDistance
	 * @param screenWidth
	 * @param screenHeight
	 * @return
	 */
	
	public Ray constructRayThroughPixel(int Nx, int Ny, int i, int j, double screenDistance, double screenWidth, double screenHeight) {
		
		Point3D pC = new Point3D(
						p0.add(
						vTo.scalarMuliplication(screenDistance).getPoint3D()));
		
		Point3D pXY = pC.
				add(	vRight.scalarMuliplication(((i-((Nx)/2.0))*(screenWidth/Nx))+((screenWidth/Nx)/2.0)).
																getPoint3D().
						subtract(vUp.scalarMuliplication((j-((Ny)/2.0))*(screenHeight/Ny)+(screenHeight/Ny)/2.0).
																getPoint3D()));
		return new Ray(new Vector(pXY),p0);
	}

}