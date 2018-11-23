package 集合;

import java.util.Iterator;

/**
 * @author WilderGao
 * time 2018-11-03 11:35
 * motto : everything is no in vain
 * description 手动实现linkedList
 */
public class MyLinkedList<AnyType> implements Iterable<AnyType> {
    private int theSize;
    private int modCount = 0;
    private Node<AnyType> beginMarker;
    private Node<AnyType> endMarker;

    private static class Node<AnyType> {
        public AnyType data;
        public Node<AnyType> pre;
        public Node<AnyType> next;

        public Node(AnyType data, Node<AnyType> pre, Node<AnyType> next) {
            this.data = data;
            this.pre = pre;
            this.next = next;
        }
    }

    public void clear() {
        doClear();
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private void doClear() {
        beginMarker = new Node<>(null, null, null);
        endMarker = new Node<>(null, beginMarker, null);
        beginMarker.next = endMarker;

        theSize = 0;
        modCount++;
    }

    public AnyType remove(int idx){
        return remove(getNode(idx));
    }

    public AnyType set(int idx, AnyType newVal) {
        Node<AnyType> oldNode = getNode(idx);
        AnyType oldVal = oldNode.data;
        oldNode.data = newVal;
        return oldVal;
    }

    public boolean add(AnyType x) {
        add(size(), x);
        return true;
    }

    public void add(int idx, AnyType x) {
        addBefore(getNode(idx, 0, size()), x);
    }

    public AnyType get(int idx) {
        return getNode(idx).data;
    }

    private Node<AnyType> getNode(int idx) {
        return getNode(idx, 0, size() - 1);
    }

    /**
     * 获取某个节点
     *
     * @param idx   indx
     * @param lower 起点
     * @param upper 终点
     * @return 返回相应节点
     */
    private Node<AnyType> getNode(int idx, int lower, int upper) {
        Node<AnyType> p;
        if (idx < lower || idx > upper) {
            throw new IndexOutOfBoundsException();
        }
        if (idx < size() / 2) {
            //如果在前半部分则从表头开始找
            p = beginMarker.next;
            for (int i = 0; i < idx; i++) {
                p = p.next;
            }
        } else {
            p = endMarker.pre;
            for (int i = size(); i > idx; i--) {
                p = p.pre;
            }
        }
        return p;
    }

    private void addBefore(Node<AnyType> p, AnyType x) {
        Node<AnyType> newNode = new Node<>(x, p.pre, p);
        newNode.pre.next = newNode;
        p.pre = newNode;
        theSize++;
        modCount++;
    }

    private AnyType remove(Node<AnyType> p){
        p.pre.next = p.next;
        p.next.pre = p.pre;
        theSize--;
        modCount++;
        return p.data;
    }

    @Override
    public Iterator<AnyType> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements java.util.Iterator<AnyType>{
        private Node<AnyType> current = beginMarker.next;
        private int exceptModCount = modCount;
        private boolean okToRemove = false;

        @Override
        public boolean hasNext() {
            return current!=endMarker;
        }

        @Override
        public AnyType next() {
            if (modCount != exceptModCount){
                throw new java.util.ConcurrentModificationException();
            }
            if (!hasNext()){
                throw new java.util.NoSuchElementException();
            }
            AnyType data = current.data;
            current = current.next;
            okToRemove = true;
            return data;
        }

        @Override
        public void remove(){
            if (modCount != exceptModCount){
                throw new java.util.ConcurrentModificationException();
            }
            if (!okToRemove){
                throw new IllegalStateException();
            }
            MyLinkedList.this.remove(current.pre);
            exceptModCount++;
            //置为false的原因是这个节点已经被移除了，除非指针跳转到下一个节点不然的话就要设置移除失败
            okToRemove = false;
        }
    }
}
