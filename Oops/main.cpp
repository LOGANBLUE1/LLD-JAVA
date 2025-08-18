#include<bits/stdc++.h>
using namespace std;

class Animal{
    public:
    int size;
    static int b;
    // char l;
    Animal(){
        this->size = 5;
        cout<<"this is animal."<<endl;
    }
    void Sleep(){
        cout<<"Sleeping animal"<<endl;
    }
    ~Animal(){
        cout<<"animal died."<<endl;
    }
}; 


// class Dog:public Animal{
// public:
//     Dog(){
//         cout<<"this is Dog."<<endl;
//     }
//     void Sleep(){
//         cout<<"Sleeping dog"<<endl;
//     }
//     ~Dog(){
//         cout<<"dog died."<<endl;
//     }
// };

int Animal::b = 0;

int main(){
    // Dog d;
    // d.Animal::Sleep();
    // Animal a = Animal(4);
    // Animal *a1 = new Animal();
    // cout<<a.size<<endl;
    cout << Animal::b << endl; 
    // a1->Sleep();
    // delete(a1);
    return 0;
}