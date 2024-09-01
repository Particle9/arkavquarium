#include <iostream>
using namespace std;


#ifndef _LIST_
#define _LIST_
template <typename T>
class List{
	protected:
		T value;
		int num;
		List* next;
	public:
		List(){
			next = NULL;
			num = 0 ;
		}
		List(T val){
			next = new List();
			value = val;
			num = 1;
		}
		bool isEmpty(){
			return(num == 0);
		}
		List(const List& L){
			if (L.isEmpty()){
				num = 0;
				next = NULL;
			}
			else{
				value = L.value;
				num = L.num;
				next = new List(&(L.next));
			} 
		}
		~List(){
			delete [] next;
		}
		T get(int i){
			if(i == 1){
				return(value);
			}
			else{
				return(next->get(i-1));
			}
		}
		int find(T val){
			if (value == val){
				return(1);
			}
			else if(isEmpty()){
				return(-999);
			}
			else{
				return(1 + find(val));
			}
		}
		bool isOneElmt(){
			return(next->num == 0);
		}
		void add(T val){
			if(isEmpty()){
				next = new List;
				value = val;
				num = 1;
			}
			else{
				next->add(val);
			}
		}
		void remove(T val){
			if(isEmpty()){
				return ;
			}
			else if (next->value == val){
				next = new List(next->next);
			}
			else{
				next->remove(val);
			}
		}
		T popLast(){
			if(isOneElmt()){
				delete [] next;
				next = NULL;
				T val = value;
				num = 0;
				return(val);
			}
			else{
				return(next->popLast());
			}
		}
		List& operator<<(T val){
			add(val);
			return(*this);
		}
		List& operator>>(T& val){
			val = popLast();
			return(*this);
		}
		friend ostream& operator<<(ostream& out, List& L){
			if(L.isOneElmt()){
				return(out << L.value);
			}
			else if (L.isEmpty()){
				return(out);
			}
			else{
				out << L.value << " , ";
				return(out << *(L.next));
			}
		}
		friend istream& operator>>(istream& in, List& L){
			int n;
			in >> n;
			T val;
			for(int i = 0; i < n ; i++){
				in >> val;
				L << val;
			}
			return(in);
		}
		void drawAll(){
			if(isOneElmt()){
				
			}
			else if (isEmpty()){
				
			}
			else{
				value.draw();
			}
		}
};

#endif
