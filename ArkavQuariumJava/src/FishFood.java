import java.util.List;
import java.util.LinkedList;

/**
 * FishFood
 */
public class FishFood extends ObjekMati {
    protected static List<FishFood> listFood = new LinkedList<FishFood>();
    protected static int foodlvl;

    public FishFood() {
        super();
    }

    public FishFood(Point p) {
        super(p);
        listFood.add(this);     // Method is still uncertain
    }

    public static void setFoodLvl(int m) {
        foodlvl = m;
    }

    public static int getFoodLvl() {
        return foodlvl;
    }

    public static void incFoodLvl() {
        foodlvl++;
    }

    public void removeFromList() {
        listFood.remove(this);  // Method is still uncertain
    }

    public static List<FishFood> getFoodList() {
        return(listFood);
    }

    // void draw() {

    // }

    public void drown() {
        if (pos.getY() < max.getY() - 100) {
            drown();
        } else {
            listFood.remove(this);
        }
    }
}