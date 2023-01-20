/**
 * Class that tests the function in BST
 *
 */
public class TestBST {
  public static void main(String[] args) {
    // create a BST object
    BST<Integer> bst = new BST<Integer>(45);

    // insert data into BST
    System.out.println("Test insert");
    bst.insert(10); 
    bst.insert(7); 
    bst.insert(12);
    bst.insert(90);
    bst.insert(50);
    bst.insert(50);
    // print the BST after insert
    System.out.println("The BST Created with input data(Left-root-right):");
    System.out.println(bst.toString());

    // lookup 
    System.out.println("Test lookup");
    System.out.println(bst.lookup(45)==null?"Not found":"Found it");
    System.out.println(bst.lookup(5)==null?"Not found":"Found it");
    System.out.println(bst.lookup(12)==null?"Not found":"Found it");

    // deleteWithCopyLeft
    System.out.println("Test deleteWithCopyLeft");
    System.out.println("Before calling deleteWithCopyLeft");
    System.out.println(bst);
    System.out.println("Root="+bst.getData()); 
    System.out.println("After calling deleteWithCopyLeft(45)");
    System.out.println(bst.deleteWithCopyLeft(45)); 
    System.out.println("Root="+bst.getData()); 

    bst.insert(100);
    System.out.println("After calling deleteWithCopyLeft(7)");
    System.out.println(bst.deleteWithCopyLeft(7)); 
    System.out.println("Root="+bst.getData()); 
    System.out.println("After calling deleteWithCopyLeft(90)");
    System.out.println(bst.deleteWithCopyLeft(90));
    System.out.println("Root="+bst.getData()); 

    /**
    // rotateRight
    System.out.println("Test rotateRight");
    System.out.println("Before calling rotateRight");
    System.out.println(bst);
    System.out.println("Root="+bst.getData());
    System.out.println("After calling rotateRight");
    System.out.println(bst.rotateLeft()); 
    System.out.println("Root="+bst.getData());
    */
  }
}
