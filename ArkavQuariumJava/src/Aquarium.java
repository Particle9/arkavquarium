public class Aquarium   {
    protected int eggState;
    public static final int[] eggPrice = {0,2000,3000,4000};
    public static final int[] foodPrice = {0,15,10,5};

    Aquarium()  {
        Siput Snaily = new Siput('R', 250);
        Submarine Sb = new Submarine(250,250);
        Objek.setMaxPoint(Point(500,500));
        Guppy G = new Guppy(Point(250,250));
        eggState = 0;
    }
    Aquarium(int a, int b)  {
        Siput Snaily = new Siput('R', a/2);
        Submarine Sb = new Submarine(a/2,b/2);
        Objek.setMaxPoint(Point(a,b));
        Guppy G = new Guppy(Point(a/2,b/2));
        eggState = 0;
    }
    public int getEggState(){
        return(eggState);
    }
    public void increaseEggState(){
        eggState += 1;
    }
    public int getCurrEggPrice(){
        return(eggPrice[eggState + 1]);
    }
    public int getCurrFoodPrice(){
        return(foodPrice[FishFood.getFoodLvl()]);
    }
}