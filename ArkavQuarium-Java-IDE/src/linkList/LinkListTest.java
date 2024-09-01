package linkList;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class LinkListTest {
    @Test
    void testListCtor() {
      LinkList<Integer> l1 = new LinkList<Integer>();
      assertTrue(l1.first == null);
      LinkList<Integer> l2 = new LinkList<Integer>(new ListElmt<Integer>(1));
      assertTrue(l2.first.value == 1);
      LinkList<Integer> l3 = new LinkList<Integer>(1);
      assertTrue(l3.first.value == 1);
    }
    
    @Test 
    void testGetAdd() {
      LinkList<Integer> l = new LinkList<Integer>();
      l.add(1);
      l.add(2);
      l.add(3);
      assertTrue(l.get(0) == 1);
      assertTrue(l.get(1) == 2);
      assertTrue(l.get(2) == 3);
    }
    
    @Test
    void toStringTest() {
      LinkList<Integer> l = new LinkList<Integer>();
      l.add(1);
      l.add(2);
      l.add(3);
      String sTest = l.toString();
      assertTrue(sTest.equals("[1,2,3]"));
    }
    
    @Test
    void sizeTest() {
      LinkList<Integer> l = new LinkList<Integer>();
      assertTrue(l.size() == 0);
      l.add(1);
      assertTrue(l.size() == 1);
      l.add(2);
      assertTrue(l.size() == 2);
    }
    
    @Test
    void isEmptyTest() {
      LinkList<Integer> l = new LinkList<Integer>();
      assertTrue(l.isEmpty());
      l.add(0);
      assertTrue(l.isOneElmt());
    }
    @Test
    void removeTest() {
      LinkList<Integer> l = new LinkList<Integer>();
      l.add(1);
      l.remove(1);
      assertTrue(l.isEmpty());
      l.add(1);
      l.add(5);
      l.add(0);
      l.remove(5);
      assertTrue(l.size() == 2);
      assertTrue(l.get(0) == 1);
      assertTrue(l.get(1) == 0);
      l.add(10);
      l.add(9);
      l.remove(1);
      assertTrue(l.get(0) == 0);
    }
    
    @Test
    void cloneTest() {
      LinkList<Integer> l1 = new LinkList<Integer>();
      l1.add(1);
      l1.add(2);
      l1.add(3);
      l1.add(4);
      LinkList<Integer> l2 = l1.clone();
      assertTrue(l2.toString().equals(l1.toString()));
      l1.remove(1);
      assertTrue(!l2.toString().equals(l1.toString()));
    }
    
    @Test
    void findTest() {
      LinkList<Integer> l = new LinkList<Integer>();
      l.add(9);
      l.add(7);
      l.add(0);
      assertTrue(l.find(0) == 3);
    }
    
}
