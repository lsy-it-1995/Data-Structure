#ifndef QUEUE_LIST_H
#define QUEUE_LIST_H

#include <iostream>
#include <fstream>

using namespace std;

template <class T>
struct node{
    T _item;
    node<T> *_next;

    node();
    node(const T& item = T(), node<T> * next = NULL) : _item(item), _next(next){}
    friend ostream& operator << (ostream &outs, const node<T> &print){
        outs<<"["<<print._item>>"]->";
        return outs;
    }
};
template <class T>
node<T> *init_head(node<T>* &head){
    return head = NULL;
}

template <class T>
void delete_all(node<T> *&head){
    while(head !=NULL){
        delete_head(head);
    }
}

/*delete the node at the head of the list, return the item:*/
template <class T>
T delete_head(node<T> *&head){
    node<T> *temp_head = head;
    T temp_head_item = head->_item;
    head = head->_next;
    delete temp_head;
    return temp_head_item;
}

//true if head is NULL, false otherwise.
template <class T>
bool empty(const node<T> *head){
    return head==NULL?true:false;
}

template <class T>
node<T> *copy_list(const node<T> *head, node<T> *&cpy){
    const node<T> *temp_head = head;
    node<T> *walk = NULL;
    while(temp_head){
        walk = insert_after(cpy, walk, temp_head->_item);
        temp_head = temp_head->_next;
    }
    return walk;
}

//insert at the beginning of the list
template <class T>
node<T> *insert_head(node<T>*&head, T item){
    node<T> *temp_head = new node<T>(item);
    temp_head->_next = head;
    head = temp_head;
    return head;
}

//insert_after: if after is NULL, inserts at head
template <class T>
node<T> *insert_after(node<T> *&head, node<T> *&after, const T& item){
    return head==NULL?insert_head(head,item):insert_head(after->_next, item);
}


template<class T>
ostream& print_list(const node<T> *head, ostream &outs=cout){
    const node<T> *print_head = head;
    while(print_head){
        outs<<"["<<print_head->_item<<"]";
        print_head = print_head->_next;
    }
    return outs;
}

#endif //QUEUE_LIST_H
