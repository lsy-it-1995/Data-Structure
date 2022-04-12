#include <iostream>
#include "Queue.h"
#include <string>
using namespace std;

int main() {
    Queue<string> q1;
    for(int i = 0; i < 10; i++){
        q1.push(to_string(i));
    }

    Queue<string> q2;
    q2 = q1;
    cout<<q1.size()<<endl;
    cout<<q2.size()<<endl;

    for(int i = 0; i < 2 ;i++){
        cout<<q1.size()<<endl;
        q1.pop();
    }
    cout<<q1<<endl;
    return 0;
}
