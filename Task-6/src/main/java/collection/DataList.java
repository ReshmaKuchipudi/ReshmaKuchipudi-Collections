package collection;

import java.util.Arrays;

public class DataList<T> {
	private int size=0;
	private static final int DEFAULT_CAPACITY=10;
	private Object ele[];
	public DataList()
	{
		ele=new Object[DEFAULT_CAPACITY];
	}
	public void add(T element)
	{
		ele[size++]=element;
	}
	public T get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        return (T) ele[i];
    }
     
    @SuppressWarnings("unchecked")
    public T remove(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        Object item = ele[i];
        int numElts = ele.length - ( i + 1 ) ;
        System.arraycopy( ele, i + 1, ele, i, numElts ) ;
        size--;
        return (T) item;
    }
     
    //Get Size of list
    public int size() {
        return size;
    }
     
    @Override
    public String toString() 
    {
         StringBuilder sb = new StringBuilder();
         sb.append('[');
         for(int i = 0; i < size ;i++) {
             sb.append(ele[i].toString());
             if(i<size-1){
                 sb.append(",");
             }
         }
         sb.append(']');
         return sb.toString();
    }
     
    private void ensureCapacity() {
        int newSize = ele.length * 2;
        ele = Arrays.copyOf(ele, newSize);
    }
}
	
