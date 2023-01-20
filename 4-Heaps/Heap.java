import java.util.*;

/**
 *  Implements a heap data structure, using ArrayList for storage.
 */
public class Heap<E extends Comparable<E>> {
    /** Elements of the heap are stored in a ArrayList */
    private ArrayList<E> storage;

    /** Default constructor creates an empty heap */
    public Heap() {
        storage = new ArrayList<E>();
    }

    /** defining a private constructor that takes the external `ArrayList` as its argument */
    public Heap(ArrayList<E> arrayList) {
        storage = arrayList;
    }

    /** @return  heap size */
    public int size() {
        return storage.size();
    }

    /** @return largest element in heap */
    public E peekTop() {
        return storage.get(0);
    }

    /** @return index of parent */
    private static int parent(int pos) {
        //FILL IN
        return (pos-1)/2;
    }

    /** @return index of left child */
    private static int leftChild(int pos) {
        //FILL IN
        return 2*pos+1;
    }

    /** @return index of right child */
    private static int rightChild(int pos) {
        //FILL IN
        return 2*pos+2;
    }

    /** @return T/F does left child exist in tree? */
    private boolean hasLeftChild(int pos) {
        return (leftChild(pos)<size());
    }

    /** @return T/F does right child exist in tree? */
    private boolean hasRightChild(int pos) {
        return (rightChild(pos)<size());
    }

    /** 
     *  Swaps an element upwards
     * @param pos  Position of element to swap upwards
     */
    private void swapWithParent(int pos) {
        E tmp = storage.get(parent(pos));
        storage.set(parent(pos),storage.get(pos));
        storage.set(pos,tmp);
    }

    /** 
     *  Swaps an element downwards to the right
     * @param pos  Position of element to swap 
     */
    private void swapWithRightChild(int pos) {
        E tmp = storage.get(rightChild(pos));
        storage.set(rightChild(pos),storage.get(pos));
        storage.set(pos,tmp);
    }

    /** 
     *  Swaps an element downwards to the left
     * @param pos  Position of element to swap 
     */
    private void swapWithLeftChild(int pos) {
        E tmp = storage.get(leftChild(pos));
        storage.set(leftChild(pos),storage.get(pos));
        storage.set(pos,tmp);
    }

    /**
     *  Compares to elements in the heap
     *  @return  true iff the first is bigger than the second
     */
    private boolean isBigger(int pos1, int pos2) {
        //Comparable c1 = storage.get(pos1);
        //Comparable c2 = storage.get(pos2);
        //return c1.compareTo(c2) > 0;
        return storage.get(pos1).compareTo(storage.get(pos2)) > 0;
    }

    /** 
     *  Bubbles an item down toward the larger of its two children, if any.
     *  It starts at the root (position 0), and follows the item as it sinks.
     *  At each point it should perform several comparisons to determine
     *  what swap is necessary.
     *
     *  First, if the current item has a right child, and that right
     *  child is larger than the current item and its left child, 
     *  then swap the current item with its right child.
     *
     *  Otherwise, if the current item has a left child, and that left
     *  child is larger than the current item, 
     *  then swap the current item with its left child.
     *
     *  Otherwise, don't swap anything.  You are done.
     *
     *  If the current position is swapped with either child, continue
     *  the process with the child position.  
     */
    public void bubbleDown() {
        int posInArr = 0;
        while (this.hasRightChild(posInArr) || this.hasLeftChild(posInArr)) {
            boolean done = false;
            int pos = posInArr;
            while (!done) {
                //if the current item has a right child, and that right child is larger
                //than the current item and its left child, then swap it with its right child.
                if (this.hasRightChild(pos) && this.hasLeftChild(pos) &&
                        this.isBigger(rightChild(pos), leftChild(pos)) &&
                        this.isBigger(rightChild(pos), pos)) {
                    this.swapWithRightChild(pos);
                    pos = rightChild(pos);
                //if the current item has a left child, and that left child is larger than the current item
                //then swap the current item with its left child.
                } else if (this.hasLeftChild(pos) && this.isBigger(leftChild(pos), pos)) {
                    this.swapWithLeftChild(pos);
                    pos = leftChild(pos);
                } else {
                    done = true;
                }
            }
            posInArr++;
        }
    }

    /**
     *  Bubbles an item down toward the larger of its two children, if any.
     *
     *  As long as the current item is greater than its parent, swap upwards.
     *
     *  @param pos  The position to work with
     */
    public void bubbleDown(int pos) {
        boolean done = false;
        while (!done) {
            //if the current item has a right child, and that right child is larger
            //than the current item and its left child, then swap it with its right child.
            if (this.hasRightChild(pos) && this.hasLeftChild(pos) &&
                    this.isBigger(rightChild(pos), leftChild(pos)) &&
                    this.isBigger(rightChild(pos), pos)) {
                this.swapWithRightChild(pos);
                pos = rightChild(pos);
            //if the current item has a left child, and that left child is larger than the current item
            //then swap the current item with its left child.
            } else if (this.hasLeftChild(pos) && this.isBigger(leftChild(pos), pos)) {
                this.swapWithLeftChild(pos);
                pos = leftChild(pos);
            } else {
                done = true;
            }
        }
    }

    /** 
     *  Pops largest element off heap and returns it.
     *
     *  The last element in the heap is copied to the root, 
     *  and removed from its position at the end.  Then it is bubbled down.
     *  Finally, return the value of the original root
     *
     *  @return the former root element
     */
    public E popTop() {
        E originalRoot = this.peekTop();

        //copy the last element to the root
        storage.set(0,storage.get(size()-1));

        //removed from its position at the end
        storage.remove(size()-1);

        //bubble it down
        boolean done = false;
        int pos = 0;
        while (!done) {
            if (this.hasRightChild(pos) && this.hasLeftChild(pos) &&
                    this.isBigger(rightChild(pos), leftChild(pos)) &&
                    this.isBigger(rightChild(pos), pos)) {
                this.swapWithRightChild(pos);
                pos = rightChild(pos);
            } else if (this.hasLeftChild(pos) && this.isBigger(leftChild(pos), pos)) {
                this.swapWithLeftChild(pos);
                pos = leftChild(pos);
            } else {
                done = true;
            }
        }
        return originalRoot;
    }

    /**
     *  Bubbles an item up until it reaches equilibrium.
     *
     *  As long as the current item is greater than its parent, swap upwards.
     *
     *  @param pos  The position to work with
     */
    public void bubbleUp(int pos) {
        // swap upwards as long as the current item is greater than its parent
        while (parent(pos)>=0 && this.isBigger(pos, parent(pos))) {
            this.swapWithParent(pos);
            pos = parent(pos);
        }
    }

    /**
     *  Inserts a new item and re-heapifies
     *
     *  Add the item at the end of the heap, and bubble it up.
     *
     *  @param item  The item to insert
     */
    public void insert(E item) {
        // first insert it in next open spot
        this.storage.add(item);
        // bubble up until parent is larger or at the root
        bubbleUp(size()-1);
    }

    /**
     *  Sort an array list in place
     *  @param array list to sort
     */
    public static <T extends Comparable<T>> ArrayList<T> heapSort(ArrayList<T> v) {
        //build the heap from ArrayList
        Heap<T> heapToSort = new Heap<T>(v);

        // arrange according to heap constraints
        for (int i=heapToSort.size()-1; i>=0; i--) {
            heapToSort.bubbleUp(i);
        }
        int n = heapToSort.size();
        // extract an element one by one from the back of heap
        for (int i=n-1; i>=0; i--) {
            // Switch current root with the one at the end
            T root = (T)heapToSort.storage.get(0);
            heapToSort.storage.set(0, (T)heapToSort.storage.get(i));
            heapToSort.storage.set(i, root);

            // heapify on the reduced heap
            for (int j = i - 1; j >= 0; j--) {
                heapToSort.bubbleUp(j);
            }
        }
        return v;
    }

    /** Prints heap for debugging */
    public void print() {
        int j = 1, k = 0;
        System.out.println("Heap contents:");
        for (E item : storage) {
            System.out.print(item+" ");
            k++;
            if (k >= j) {
                j = j << 1;
                k = 0;
                System.out.println("");
            }
        }
        System.out.println("");
    }
}
