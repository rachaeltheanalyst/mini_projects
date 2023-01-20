import java.util.ArrayList;
import java.util.Arrays;
/**
 *  Class that tests the function in Heap
 *
 */
public class TestHeap {
    public static void main(String[] args) {

        // test bubbleDown
        Integer arr[] = {-2,3,9,-7,1,2,6,-3};
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(arr));
        Heap<Integer> testHeap = new Heap<Integer>(al);

        System.out.println("test bubbleDown - initial Heap");
        testHeap.print();
        testHeap.bubbleDown();
        System.out.println("Heap After BubbleDown");
        testHeap.print();

        // test insert
        System.out.println("Test insert - insert 24");
        testHeap.insert(24);
        System.out.println("Heap after insert");
        testHeap.print();

        // test popTop
        System.out.println("Pop Top: "+ testHeap.popTop());
        System.out.println("Heap after popTop");
        testHeap.print();
        System.out.println("Pop Top: "+ testHeap.popTop());
        System.out.println("Heap after popTop");
        testHeap.print();

        // test heapSort
        Integer arr2[] = {1,4,5,8,3,9,2,16,25,10,6,12};
        ArrayList<Integer> al2 = new ArrayList<>(Arrays.asList(arr2));
        System.out.println("test heapSort - initial ArrayList");
        System.out.println(Arrays.toString(arr2));
        System.out.println("ArrayList after heapSort");
        System.out.println(Heap.heapSort(al2));

        // test bubbleDown
        Integer arr1[] = {-20, 10, 40, 60, -10, 30, 100};
        ArrayList<Integer> al1 = new ArrayList<>(Arrays.asList(arr1));
        Heap<Integer> testHeap1 = new Heap<Integer>(al1);

        System.out.println("test bubbleDown - initial Heap");
        testHeap1.print();
        testHeap1.bubbleDown();
        System.out.println("Heap After BubbleDown");
        testHeap1.print();

        // test insert
        System.out.println("Test insert - insert 24");
        testHeap1.insert(24);
        System.out.println("Heap after insert");
        testHeap1.print();

        // test popTop
        System.out.println("Pop Top: "+ testHeap1.popTop());
        System.out.println("Heap after popTop");
        testHeap1.print();
        System.out.println("Pop Top: "+ testHeap1.popTop());
        System.out.println("Heap after popTop");
        testHeap1.print();

        // test heapSort
        Integer arr3[] = {20,4,10,-200,4,30,70,80,10,25,6,12};
        ArrayList<Integer> al3 = new ArrayList<>(Arrays.asList(arr3));
        System.out.println("test heapSort - initial ArrayList");
        System.out.println(Arrays.toString(arr3));
        System.out.println("ArrayList after heapSort");
        System.out.println(Heap.heapSort(al3));
    }
}

