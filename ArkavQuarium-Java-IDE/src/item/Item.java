package item;

import point.*;
import thing.*;

public class Item extends Thing {
	protected static final double drownSpeed;

	static {
		drownSpeed = 1;
	}

	/**
	 * Default Item Constructor.
	 */
	public Item() {};
	
	/**
	 * User Defined Item Constructor.
	 * @param P position of Item as Point
	 */
	public Item(Point P) {
		super(P);
	}

	/**
	 * @return
	 */
	public static final double getDrownSpeed() {
		return drownSpeed;
	}

	public void drown() {
		pos.setY(pos.getY() + drownSpeed);
	}
}