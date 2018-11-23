package 集合;


import java.util.Iterator;

/**
 * @author WilderGao
 * time 2018-11-02 22:10
 * motto : everything is no in vain
 * description 手动实现ArrayList
 */
public class MyArrayList<AnyType> implements Iterable<AnyType> {
    /**
     * 数组的默认容量
     */
    private static final int DEFAULT_CAPACITY = 10;

    private int theSize;
    private AnyType[] theItems;

    public MyArrayList() {
        doClear();
    }

    public void clear() {
        doClear();
    }

    /**
     * 清空数组的操作
     */
    private void doClear() {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public int size() {
        return theSize;
    }

    /**
     * 判断集合是否为空方法
     *
     * @return true代表空，false为非空
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    public AnyType set(int idx, AnyType newVal) {
        if (idx < 0 || idx >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        AnyType old = theItems[idx];
        theItems[idx] = newVal;
        return old;
    }

    public AnyType get(int idx) {
        if (idx < 0 || idx >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return theItems[idx];
    }

    public boolean add(AnyType x) {
        add(size(), x);
        return true;
    }

    public void add(int idx, AnyType x) {
        if (idx > theSize){
            throw new IndexOutOfBoundsException();
        }
        if (theItems.length == size()) {
            //数组扩容
            ensureCapacity(size() * 2 + 1);
        }
        //元素向后移动
        for (int i = theSize; i > idx; i--) {
            theItems[i] = theItems[i - 1];
        }
        theItems[idx] = x;
        theSize++;
    }


    public AnyType remove(int idx) {
        if (idx > theSize) {
            throw new IndexOutOfBoundsException();
        }
        AnyType removeItem = theItems[idx];
        for (int i = idx; i < size() - 1; i++) {
            theItems[i] = theItems[i + 1];
        }
        //减小数组长度
        theSize--;
        return removeItem;
    }

    /**
     * 数组的扩容
     *
     * @param newCapacity 数组的长度
     */
    public void ensureCapacity(int newCapacity) {
        if (newCapacity < theSize) {
            return;
        }

        AnyType[] old = theItems;
        theItems = (AnyType[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            theItems[i] = old[i];
        }
    }

    @Override
    public Iterator<AnyType> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements java.util.Iterator<AnyType> {
        int current = 0;

        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public AnyType next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            return theItems[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }

    }
}
