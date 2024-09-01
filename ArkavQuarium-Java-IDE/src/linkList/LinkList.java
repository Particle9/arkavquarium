package linkList;


class ListElmt<T>{
  ListElmt<T> next;
  T value;
  ListElmt(){
    next = null;
  }
  ListElmt(T val){
    value = val;
    next = null;
  }
  ListElmt(T val, ListElmt<T> l){
    value = val;
    next = l;
  }
  ListElmt(ListElmt<T> L){
    value = L.value;
    if(L.next != null){
      next = new ListElmt<T>(L.next);
    }
  }
  T get(int i){
    if (i == 0) return(value);
    else return(next.get(i-1));
  }
  ListElmt<T> getNext(){
    return(next);
  } 
  int find(T val){
    if(value.equals(val)) return(1);
    else if (next == null) return(-999);
    else return(1 + next.find(val));
  }
  void add(T val){
    if(next == null) next = new ListElmt<T>(val);
    else next.add(val);
  }

  void remove(T val){
    if(next == null) return;
    else if ((next.next == null) && val.equals(next.value)) next = null;
    else if (val.equals(next.value)) next = next.next.clone();
    else next.remove(val);
  }

  public ListElmt<T> clone(){
    if(next == null){
      ListElmt<T> LT  = new ListElmt<T>(value);
      return(LT);
    }
    else{
      return(new ListElmt<T>(value,next.clone()));
    }
  }
  T popLast(){
    if(next.next == null){
      T val = value;
      next = null;
      return(val);
    }
    else{
      return(next.popLast());
    }
  }
  
  public String toString() {
    if(next == null){
      return(value.toString());
    }
    else{
      String s = value.toString() + ",";
      return(s + next);
    }
  }
  public int size(){
    if(next == null) return(1);
    else return(next.size() + 1);
  }

}

public class LinkList<T>{
  public ListElmt<T> first;
  public LinkList(){
    first = null;
  }
  public LinkList(ListElmt<T> LT){
    first = LT;
  }
  public LinkList(T val){
    first = new ListElmt<T>(val);
  }
  public LinkList<T> clone(){
    if(first == null){
      return(new LinkList<T>());
    }
    else{
      return(new LinkList<>(first.clone()));
    }
  }
  public boolean isEmpty(){
    return(first == null);
  }
  public T get(int i){
    if(first == null) return null;
    return(first.get(i));
  }
  public int find(T  val){
    return(first.find(val));
  }
  public boolean isOneElmt(){
    return(first.next == null);
  }
  public void add(T val){
    if(isEmpty()){
      first = new ListElmt<T>(val);
    }
    else{
      first.add(val);
    }
  }
  public void remove(T val){
    if(isEmpty()){}
    else if(val.equals(first.value)){
      if(first.next == null) first = null;
      else first = first.next;
    }
    else if(first.next == null) return;
    else first.remove(val);
  }
  public void removeAll() {
    first = null;
  }
  public String toString(){
    return("[" + first + "]");
  }
  public int size(){
    if(first == null) return 0;
    else return first.size();
  }
}