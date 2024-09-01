#include <iostream>
#include <stdlib.h>
using namespace std;

#ifndef _LIST_
#define _LIST_
template <typename T>
class List{
	protected:
		class ListElmt{
			public :
				T value;
				ListElmt* next;
				ListElmt(){
					next = NULL;
				}
				ListElmt(T val){
					next = NULL;
					value = val;
				}
				ListElmt(ListElmt* L){
					value = L->value;
					if(L->next != NULL){
						next = new ListElmt(L->next);
					}
					else{
						next = NULL;
					}
				}
				T get(int i){
					if(i == 1){
						return(value);
					}
					else{
						return(next->get(i-1));
					}
				}
				ListElmt getNext(){
					return(next);
				}
				int find(T val){
					if (value == val){
						return(1);
					}
					else if(next == NULL){
						return(-999);
					}
					else{
						return(1 + find(val));
					}
				}
				void add(T val){
					if(next == NULL){
						next = new ListElmt(val);
					}
					else{
						next->add(val);
					}
				}
				void remove(T val){
					if (next == NULL){
						return ;
					}
					else if ((next->next == NULL) and (next->value == val)){
						next = NULL;
					}
					else if (value == val){
						clone(next);
					}
					else{
						next->remove(val);
					}
				}
				void clone(ListElmt* L){
					if (L == NULL){
						next = NULL;
					}
					else if(L->next == NULL){
						value = L->value;
						next = NULL;
					}
					else{
						value = L->value;
						next->clone(L->next);
					}	
				}
				T popLast(){
					if(next == NULL){
						next = NULL;
						T val = value;
						return(val);
					}
					else{
						return(next->popLast());
					}
				}
				ListElmt& operator<<(T val){
					add(val);
					return(*this);
				}
				ListElmt& operator>>(T& val){
					val = popLast();
					return(*this);
				}	
				friend ostream& operator<<(ostream& out, ListElmt& L){
					if(L.next == NULL){
						return(out << L.value);
					}
					else{
						out << L.value << " , ";
						return(out << *(L.next));
					}
				}
				friend istream& operator>>(istream& in, ListElmt& L){
					int n;
					in >> n;
					T val;
					for(int i = 0; i < n ; i++){
						in >> val;
						L << val;
					}
					return(in);
				}
		
				int size(){
					if(next == NULL){
						return(1);
					}
					else{
						return(next->size() + 1);
					}
				}
		
				void drawAll(){
					if(next == NULL){
						value.draw();
					}
					else{
						value.draw();
						next->drawAll();
					}
				}
				void printAll()    {
					if(next == NULL){
						cout << value.getId() << endl;
					}
					else{
						cout << value.getId() << " ";
						next->printAll();
					}
				}
				void moveAll(){
					if(next == NULL){
						value.move();
					}
					else{
						value.move();
						next->moveAll();
					}
				}
		
				void drownAll(){
					if(next == NULL){
						value.drown();
					}
					else{
						value.drown();
						next->drownAll();
					}
				}		
		};

	public:
		ListElmt* first;
		List(){
			first = NULL;
		}
		List(T val){
			first = new ListElmt(val);
		}
		void clone(const List<T> &L){
			if (L.first == NULL){
				first = NULL;
			}
			else{
				first = new ListElmt(L.first);
			}
		}
		bool isEmpty(){
			return(first == NULL);
		}
		T get(int i){
			return(first->get(i));

		}
		int find(T val){
			return(first->find(val));
		}
		bool isOneElmt(){
			return(first->next == NULL);
		}
		void add(T val){
			if(isEmpty()){
				first = new ListElmt(val);
			}
			else{
				first->add(val);
			}
		}
		void remove(T val){
			if(isEmpty()){}
			else if(first->value == val){
				if (first->next == NULL){
					first = NULL;
				}
				else first = first->next;
			}
			else if(first->next == NULL){
				return;
			}
			else {
				first->remove(val);
			}
		}
		ListElmt& operator<<(T val){
			return(*first << val);
		}
		ListElmt& operator>>(T val){
			return(*first >> val);
		}
		friend ostream& operator<<(ostream& out, List& L){
			if(L.isEmpty()) return (out << "");
			return(out << *(L.first));
		}
		int size(){
			if(first == NULL) return 0;
			return(first->size());
		}
		void drawAll(){
			if(isEmpty()) return;
			first->drawAll();
		}
		void moveAll(){
			if(isEmpty()) return;
			first->moveAll();
		}
		void drownAll(){
			if(isEmpty()) return;
			first->drownAll();
		}
		void printAll()	{
			if(isEmpty()) return;
			first->printAll();
		}
};

#endif

