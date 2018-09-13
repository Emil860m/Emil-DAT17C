package ArrayList;

import ArrayList.MyList;

import java.util.List;
import java.util.Arrays;

import static java.util.Arrays.copyOf;


public class MyArrayList<T> implements MyList {

    private T[] data = (T[])new Object[10];
    private int size = 0;

    public MyArrayList(T[] data) {
        this.data = data;
    }

    public MyArrayList() {
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public void add(Object T) {
        if(size == data.length) {
            T[] temp = copyOf(data, data.length + 10);
            data=temp;
        }
        data[size] = (T) T;
        size++;
    }

    @Override
    public Object remove(int index) {
        Object tempObject="Invalid input";
        if(index>=0&&index<size) {
            tempObject = data[index];
            for (int i = index; i <= size; i++) {
                data[i] = data[i + 1];
            }
            size--;
        }
        return tempObject;
    }

    @Override
    public Object get(int index){
        if(index>=0&&index<size) {
            return data[index];
        }
        else {
            return "Invalid input";
        }
    }

    @Override
    public String toString() {
        String temp = "";
        for(int i = 0; i<size-1;i++){
            temp+=data[i].toString() + ", ";
        }
        temp+=data[size-1].toString();
        return "MyArrayList{"+temp+"}";
    }
}
