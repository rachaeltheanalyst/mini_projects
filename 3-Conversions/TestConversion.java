import java.util.Arrays;

/**
 * Class that tests the function in Conversions
 */
public class TestConversion {
  public static void main(String[] args) {
    // test arrayToBinaryTree
    Integer arr[] = { -2, 3, 9, -7, 1, 2, 6, -3 };
    System.out.println("Testing arrayToBinaryTree");
    System.out.println("Array to sort=" + Arrays.toString(arr));
    System.out.println("Converted binary tree");
    BinaryTree<Integer> btree = Conversion.arrayToBinaryTree(arr);
    System.out.println(btree.toString());

    // test binaryTreeToDLL
    DLL<Integer> dll = Conversion.binaryTreeToDLL(btree);
    System.out.println("Converted DLL");
    System.out.println(dll.toString());
    System.out.println(dll.getHead().getRight().getRight().getRight().getRight().getRight().getRight().getRight().getData());
    System.out.println(dll.getTail().getLeft().getLeft().getLeft().getLeft().getLeft().getLeft().getLeft().getData());

    // test arrayToBinaryTree
    Integer arr1[] = { -10, -7, 2, 4, -30, -15 };
    System.out.println("Testing arrayToBinaryTree");
    System.out.println("Array to sort=" + Arrays.toString(arr1));
    System.out.println("Converted binary tree");
    BinaryTree<Integer> btree1 = Conversion.arrayToBinaryTree(arr1);
    System.out.println(btree1.toString());

    // test binaryTreeToDLL
    DLL<Integer> dll1 = Conversion.binaryTreeToDLL(btree1);
    System.out.println("Converted DLL");
    System.out.println(dll1.toString());
  }
}
