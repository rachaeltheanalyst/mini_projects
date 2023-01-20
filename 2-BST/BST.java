/**
 * Implements binary search trees.
 */

public class BST<E extends Comparable<E>> extends BinaryTree<E> implements BST_Ops<E> {
  public BST() {
    super();
  }

  /** leaf constructor */
  public BST(E s) {
    super(s);
  }

  /** branch node constructor */
  public BST(E data, BinaryTree<E> left, BinaryTree<E> right) {
    super(data, left, right);
  }

  /** constructor that makes a deep copy of the entire tree structure */
  public BST(BinaryTree<E> tree) {
    super(tree);
  }

  /** @override */
  /** Accessor for left child */
  public BST<E> getLeft() {
    return (BST<E>) super.getLeft();
  }

  /** @override */
  /** Accessor for right child */
  public BST<E> getRight() {
    return (BST<E>) super.getRight();
  }

  /**
   * Starts recursive lookup process
   * 
   * @param key The value of the given element
   * @return the node of the given element, or null if not found
   */
  public BST<E> lookup(E data) {
    return search(this, data);
  }

  /**
   * Returns the node of the given element, or null if not found
   *
   * @param key  The value of the given element
   * @param root The element that marks where the program should begin looking for
   *             the given element
   * @return the node of the given element, or null if not found
   */
  public BST<E> search(BST<E> root, E key) {
    // Base Cases: root is null or key is present at root
    if (root == null || root.getData() == key)
      return root;

    // Key is greater than root's key
    if (root.getData().compareTo(key) < 0)
      return search(root.getRight(), key);

    // Key is smaller than root's key
    return search(root.getLeft(), key);
  }

  /**
   * Starts insert recursive process
   *
   * @param data The element to insert
   */
  public void insert(E data) {
    BST<E> root = insertRecursive(this, data);
  }

  /**
   * Inserts a new node into the tree
   *
   * @param key  The element to insert
   * @param root The element that marks where the program should begin looking for
   *             the correct location to put the given element
   * @return the node of the given element, or null if not found
   */
  public BST<E> insertRecursive(BST<E> root, E key) {
    // tree is empty
    if (root == null) {
      root = new BST<E>(key);
      return root;
    }
    // traverse the tree
    if (key.compareTo(root.getData()) < 0)
      root.setLeft(insertRecursive(root.getLeft(), key));
    else if (key.compareTo(root.getData()) > 0)
      root.setRight(insertRecursive(root.getRight(), key));
    // return pointer
    return root;
  }

  /**
   * Deletes the specified element from the tree Returns the modified tree
   * 
   * @param evictee The element to delete
   * @return tree as modified
   */
  public BST<E> deleteWithCopyLeft(E evictee) {
    return deleteNode(this, evictee);
  }

  /**
   * Recursive helper to deletes the specified element from the tree 
   * the root node may have changed
   * 
   * @param evictee The element to delete
   * @param root    The element to begin looking for the element to delete
   * @return tree as modified
   */
  public BST<E> deleteNode(BST<E> root, E evictee) {
    if (root == null) {
      return null;
    }
    // search in the left of root
    if (evictee.compareTo(root.getData()) < 0) {
      root.setLeft(deleteNode(root.getLeft(), evictee));
    // search in the right of root
    } else if (evictee.compareTo(root.getData()) > 0) {
      root.setRight(deleteNode(root.getRight(), evictee));
    // search in the root
    } else {
      if (root.getLeft() == null) {
        return root.getRight();
      } else if (root.getRight() == null) {
        return root.getRight();
      }

      // search for the rightmost node in the left side of root
      BST<E> minNode = findNode(root.getLeft());
      // make the rightmost node in the left to be root
      root.setData(minNode.getData());
      root.setLeft(deleteNode(root.getLeft(), root.getData()));
    }
    return root;
  }

  /**
   * Returns the rightmost element in the tree
   * 
   * @param node The beginning element start looking for the rightmost element
   * @return rightmost node
   */
  private BST<E> findNode(BST<E> node) {
    while (node.getRight() != null) {
      node = node.getRight();
    }
    return node;
  }

  /**
   * Apply left rotation Returns the modified tree because the root node may have
   * changed
   *
   * @return tree as modified
   */


  public BST<E> rotateLeft() {
    return null;
  }

  public BST<E> rotateRight() {
    return null;
  }

  /**
   * Apply right rotation Returns the modified tree because the root node may have
   * changed
   *
   * @return tree as modified
   */

  /**
  public BST<E> rotateRight() {
    return increasingBST(this);
  }

  public BST<E> increasingBST(BST<E> root) {
    BST<E> dummy = new BST<E>();
    // link the original tree as a right child of the dummy node
    dummy.setRight(root);
    // assign pointers for traversal
    BST<E> ptr = dummy, pseudoRoot = dummy.getRight();

    while (pseudoRoot != null) {
      // if the current root node has a left child
      // rotate its left child up
      if (pseudoRoot.getLeft() != null) {
        BST<E> oldRoot = pseudoRoot;
        pseudoRoot = pseudoRoot.getLeft();

        // right rotate
        oldRoot.setLeft(pseudoRoot.getRight());
        pseudoRoot.setRight(oldRoot);
        // now pseudoRoot (the previous left child) becomes the new root node
        // link it to the right of the dummy node (since rotation is not complete yet)
        ptr.setRight(pseudoRoot);
      } else {
        // otherwise, right rotation is done, the tree structure has been flattened
        // update the head of the dummy node - newly rotated nodes would've been
        // assigned to its right child
        ptr = pseudoRoot;
        // and skip the node
        pseudoRoot = pseudoRoot.getRight();
      }
    }
    return dummy.getRight();
  }
  */

  /**
  public void rotateLeft(BST<E> n) {
    if (n.getRight() == null) {
      return;
    }
    BST<E> oldRight = n.getRight();
    n.setRight(oldRight.getLeft());
    if (parent(n) == null) {
      this = oldRight;
    } else if (parent(n).getLeft() == n) {
      parent(n).setLeft(oldRight);
    } else {
      parent(n).setRight(oldRight);
    }
      oldRight.setLeft(n);
  }

  public BST<E> parent(BST<E> p){
    parentHelper(this,p);
  }
  private BST<E> parentHelper(BST<E> currentRoot, BST<E> p) {   
    if (p == this || currentRoot == null) {
      return null;
    }
    else{
        if(currentRoot.getLeft() ==p || currentRoot.getRight()==p)
            return currentRoot;
        else {
            if (currentRoot.getData().compareTo(p.getData()) < 0) {
                return parentHelper(currentRoot.getRight(),p);
            }
            else {
                return parentHelper(currentRoot.getLeft(),p);
            }
        }
    }
  } 
  */
}
