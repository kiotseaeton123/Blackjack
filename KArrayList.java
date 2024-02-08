import java.util.Random;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class KArrayList<T> implements Iterable<T>{

    private static final int INITIAL_CAPACITY = 10;
    private int size;
    private Object[] elements;

    @Override
    public Iterator<T> iterator(){
        return new KIterator();
    }

    public KArrayList(){
        this.elements = new Object[INITIAL_CAPACITY];
        this.size = 0;
    }

    public void add(T element){
        if(this.size == elements.length){
            increaseCapacity();
        }

        this.elements[size++]=element;
    }

    public void increaseCapacity(){
        int newCapacity = this.elements.length * 2;
        Object[] elements = new Object[newCapacity];

        for(int i = 0; i < this.elements.length; i++){
            elements[i] = this.elements[i];
        }

        this.elements = elements;
    }

    @SuppressWarnings("unchecked")
    public T get(int index){
        if(index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
        }

        return (T)this.elements[index];
    }

    public T remove(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
        }

        T removedElement = get(index);

        //shift elements to left to fill in gap
        for(int i = index; i < size - 1; i++){
            this.elements[i] = this.elements[i+1];
        }

        //set last element, and decrement size
        this.elements[size-1] = null;
        size--;
        return removedElement;
    }

    public int getSize(){
        return this.size;
    }

    public void shuffle(){ //fisher yates algorithm
        Random rand = new Random();

        for(int i = size - 1; i > 0; i--){
            int j = rand.nextInt(i+1);
            swap(i, j);
        }
    }

    @SuppressWarnings("unchecked")
    public void swap(int i, int j){
        T temp = (T)this.elements[i];
        this.elements[i] = this.elements[j];
        this.elements[j] = temp;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for(int i = 0; i < this.size; i++){
            sb.append(this.elements[i]);
            if(i < this.size - 1){
                sb.append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }


    //Iterator class
    private class KIterator implements Iterator<T>{
        private int currentIndex = 0;

        public boolean hasNext(){
            return currentIndex < size;
        }

        public T next(){
            if(!hasNext()){
                throw new NoSuchElementException("no more elements in iterable");
            }
            return get(currentIndex++);
        }
    }

}