public class ObjekMati extends Objek {
	protected static final double drownSpeed;

	static {
		drownSpeed = 0.1;
	}

	public ObjekMati() {};
	
	public ObjekMati(Point P) {
		super(P);
	}

	public static final double getDrownSpeed() {
		return drownSpeed;
	}

	public void drown() {
		pos.setY(pos.getY() + drownSpeed);
	}
}