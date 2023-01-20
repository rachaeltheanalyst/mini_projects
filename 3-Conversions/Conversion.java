import java.util.Arrays;

/**
 * Class to implement tree conversions
 */
public class Conversion<S> {
  /**
   * Converts a sorted array to a balanced binary tree
   * 
   * @param arr T[] Array to be converted
   * @return binary tree as the result of the conversion
   */
  public static <T extends Comparable<T>> BinaryTree<T> arrayToBinaryTree(T[] arr) {
    // sort the array if not already sorted
    Arrays.sort(arr);
    int n = arr.length;
    BinaryTree<T> binaryTree = arrayToBinaryTreeHelper(arr, 0, n - 1);
    return binaryTree;
  }

  /**
   * Recursive helper class that accept a sorted array, plus low and high index
   * numbers and build a balanced binary tree by splitting the active portion
   * around its middle element and recursively calling itself on the subranges
   * remaining on either side of the pivot.
   * 
   * @param arr      T[] Array to be converted
   * @param startIdx int low index
   * @param endIdx   int high index
   * @return binary tree as the result of the conversion
   */
  private static <T extends Comparable<T>> BinaryTree<T> arrayToBinaryTreeHelper(T arr[], int startIdx, int endIdx) {

    /* base case - return null if startIdx is bigger than endIdx */
    if (startIdx > endIdx) {
      return null;
    }
    // make the middle element the root
    int mid = (startIdx + endIdx) / 2;
    BinaryTree<T> middleNode = new BinaryTree<T>(arr[mid]);

    // recursively construct the left subtree of the pivot
    middleNode.setLeft(arrayToBinaryTreeHelper(arr, startIdx, mid - 1));

    // recursively construct the right subtree of the pivot
    middleNode.setRight(arrayToBinaryTreeHelper(arr, mid + 1, endIdx));

    return middleNode;
  }

  /**
   *  Convert BinaryTree to DLL
   *  @param t BinaryTree<S> binary tree to be processed
   *  @return the DLL to convert to
   */
  public static <S> DLL<S> binaryTreeToDLL(BinaryTree<S> t) {
    // create an empty DLL
    DLL<S> dll = new DLL<S>();
    if (t == null)
      return null;
    // call the recursive helper
    binaryTreeToDLLHelper(t, dll);
    return dll;
  }

  /**
   *  Recursive helper class that accept a binary tree
   *  and recursively calling itself on the subranges remaining on either side of the current tree node.
   *  @param t BinaryTree<S> binary tree to be processed
   */
  public static <S> void binaryTreeToDLLHelper(BinaryTree<S> t, DLL<S> dll) {
    // base case return if the binary tree is null
    if (t == null) {
      return;
    }
    // recursively convert left subtree
    binaryTreeToDLLHelper(t.getLeft(),dll);

    // now convert the current node
    if (dll.getTail() == null) {
      dll.setHead(t);
    } else {
      t.setLeft(dll.getTail());
      dll.getTail().setRight(t);
    }

    // save the node
    dll.setTail(t);

    // recursively convert right subtree
    binaryTreeToDLLHelper(t.getRight(),dll);
  }
  
}
