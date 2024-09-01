
#include "List.hpp"
#include <iostream>

int main(){
    List<int> LI;
    LI.add(10);
    LI.add(8);
    LI.add(9);
    List<int> LS;
    LS.clone(LI);
    LI.remove(0);
    LI.remove(8);
    LI.remove(9);
    cout << LI.size() << endl;
    cout << LI << "\n";
    cout << LS << "\n";
}