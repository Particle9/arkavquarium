public class Objek {
	protected static Point max;
	protected static int idList;
	protected int id;
	protected Point pos;

	static {
		idList = 0;
		max = new Point(500,500);
	}

	//initializeMaxPoint deleted because it did the same thing as setMaxPoint

	public Objek() {
		id = idList;
		++idList;
	}

	public Objek(Point P) {
		pos = P;
		id = idList;
		++idList;
	}

	public Point getPoint() {
		return pos;
	}

	public int getId() {
		return id;
	}

	public void setPoint(Point P) {
		pos = P;
	}

	public Point getBatas() {
		return max;
	}

	public static void setMaxPoint(Point P) {
		max = P;
	}

	public boolean equals(Objek O) {
		return (id == O.id);
	}
}