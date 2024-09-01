import java.util.Dictionary;

public class LinkListDrive{
    static public void main(String args[]){
        LinkList<Integer> L = new LinkList<>();
        LinkList<Integer> LI = new LinkList<>(9);
        LI.add(91);
        LI.add(1000);
        LI.add(18218);
        LinkList<Integer> LL = LI.clone();
        LI.remove(1000);
        LI.remove(91); 
        System.out.println(LL);
        System.out.println(LI);
        System.out.println(L);
        LinkList<String> LS = new LinkList<>("ASAS");
        LS.add("ADA");
        LS.add("Liebe");
        LS.add("Dich");
        System.out.println(LS);
        LS.remove("ADA");
        System.out.println(LS);
        System.out.println(LS.get(1));
        
    }
}