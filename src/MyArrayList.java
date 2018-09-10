import java.util.List;


public class MyArrayList<T> implements MyList{

    private T[] data = (T[])new Object[0];

    public MyArrayList(T[] data) {
        this.data = data;
    }

    public MyArrayList() {
    }

    @Override
    public int size(){
        /*int temp = 0;
        for(int i = 0;i<data.length;i++){
            if (data[i] != null) {
                temp++;
            }
        }
        */
        return data.length;
    }

    @Override
    public void add(Object T) {
        T[] temp = (T[]) new Object[data.length+1];
        for(int i = 0; i<data.length;i++){
            temp[i]=data[i];
        }
        temp[data.length] = (T) T;
        data=temp;
    }

    @Override
    public Object remove(int index) {
        T[] temp = (T[]) new Object[data.length-1];
        Object tempObject = data[index];
        for(int i = 0; i<data.length;i++){
            if(i<index) {
                temp[i] = data[i];
            }else if(i>index){
                temp[i-1] = data[i];
            }
        }
        data=temp;
        return tempObject;
    }

    @Override
    public Object get(int index){
        return data[index];
    }

    @Override
    public String toString() {
        String temp = "";
        for(int i = 0; i<data.length-1;i++){
            if(data[i]!=null){
                temp+=data[i] + ", ";
            }
        }
        temp+=data[data.length-1];
        return "MyArrayList{"+temp+"}";
    }
}
