package uaslp.enginering.labs.list;

import java.util.NoSuchElementException;

public class ArrayList<T> {

    public enum InsertPosition {
        BEFORE,
        AFTER
    }


    public class Iterator {

        private int currentIndex;

        public boolean hasNext() {
            return currentIndex < lastIndex;
        }

        public T next() {
            return (T)elements[currentIndex++];
        }

    }


    public static final int DEFAULT_SIZE = 2;

    private Object[] elements;
    private int lastIndex;

    public ArrayList() {
        this(DEFAULT_SIZE);
    }

    public ArrayList(int initialSize) {
        lastIndex = 0;
        elements = new Object[initialSize];
    }

    public void add(T element) {

        if (lastIndex == elements.length) {
            increaseArraySize();
        }

        elements[lastIndex++] = element;
    }

    public void delete(T element) throws NoSuchElementException {
        for (int index = 0; index < lastIndex; index++) {
            if (elements[index].equals(element)) {
                delete(index);
                break;
            }

            throw new NoSuchElementException();

        }
    }

    public void delete(int index) throws IndexOutOfBoundsException{
        if (lastIndex - index > 0 && index >= 0) {
            lastIndex--;
            System.arraycopy(elements, index + 1, elements, index, lastIndex - index);
        } else{
            throw new IndexOutOfBoundsException();
        }
    }

    public Iterator getIterator() {
        return new Iterator();
    }

    public int size() {
        return lastIndex;
    }

    public T getAt(int index) throws IndexOutOfBoundsException{
        if(index < lastIndex) {
            return (T) elements[index];
        }
        throw new IndexOutOfBoundsException();
    }

    public void insert(T reference, T newStudent, InsertPosition insertPosition) throws NoSuchElementException{

        if (lastIndex == elements.length) {
            increaseArraySize();
        }

        int index = 0;

        for ( ; index < lastIndex; index++){
            if (elements[index].equals(reference)) {
                if (insertPosition.equals(InsertPosition.BEFORE)) {
                    for (int j = lastIndex; j > index; j--) {
                        elements[j] = elements[j - 1];
                    }
                    elements[index] = newStudent;
                } else {
                    for (int j = lastIndex; j > index + 1; j--) {
                        elements[j] = elements[j - 1];
                    }
                    elements[index + 1] = newStudent;
                }
                break;
            }
        }

        if(index == lastIndex){
            throw new NoSuchElementException();
        }
        lastIndex++;
    }

    private void increaseArraySize() {
        Object[] newArray = new Object[elements.length * 2];

        System.arraycopy(elements, 0, newArray, 0, elements.length);

        elements = newArray;
    }
}
