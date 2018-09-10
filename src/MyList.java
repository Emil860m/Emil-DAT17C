public interface MyList<T> {
    /**
     * Returns the size of the list (how many elements are in the list)
     * @return int
     */
    int size();

    void add(Object T);

    T get(int index);

    T remove(int index);

    String toString();



}
