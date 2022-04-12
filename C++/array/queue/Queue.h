#ifndef QUEUE_QUEUE_H
#define QUEUE_QUEUE_H
#include <iostream>
#include <cassert>
#include <fstream>
#include "list.h"

using namespace std;

template <class T>
class Queue {
public:
    Queue():_head(NULL), _tail(NULL), sizeN(0){}
    Queue(const Queue<T>& other);
    Queue<T> &operator =(const Queue& rhs);
    ~Queue();
    T operator = (T &rhs);
    bool empty();
    T pop();
    T front();
    void push(T item);
    size_t size() const;

    friend ostream& operator <<(ostream& outs, const Queue& q) {
        return print_list(q._head, outs);
    }
private:
    node<T> *_head;
    node<T> *_tail;
    int sizeN;
};

template <class T>
Queue<T>::Queue(const Queue<T>& other){
    init_head(_head);
    init_head(_tail);
    this->sizeN = other.sizeN;
    if(other._head){
        copy_list(other._head, _head);
    }
}

template<class T>
Queue<T> &Queue<T>::operator=(const Queue &rhs) {
    init_head(_head);
    init_head(_tail);
    this->sizeN = rhs.size();
    if(rhs._head){
        copy_list(rhs._head, _head);
    }
    return *this;
}
template <class T>
Queue<T>::~Queue(){
    delete_all(_head);
}

template <class T>
T Queue<T>::operator = (T &rhs){
    rhs = this;
    return rhs;
}
template <class T>
bool Queue<T>::empty(){
    return _head==NULL?true:false;
}
template <class T>
T Queue<T>::pop(){
    sizeN--;
    return delete_head(_head);
}
template <class T>
T Queue<T>::front(){
    return _tail->_item;
}
template <class T>
void Queue<T>::push(T item){
    sizeN++;
    _tail = insert_after(_head, _tail, item);
}
template <class T>
size_t Queue<T>::size() const{
    return sizeN;
}


#endif //QUEUE_QUEUE_H
