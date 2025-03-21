package L9_Collections;

public class D12_RedBlackTree {
    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();

        tree.insert(55);
        tree.insert(40);
        tree.insert(65);
        tree.insert(60);
        tree.insert(50);
        tree.insert(12);
        tree.insert(65);
        tree.insert(234);
        tree.insert(6);

        tree.printTree(); // Çıktı: 40 50 55 60 65
    }
}

class RedBlackTree {
    private Node root;
    private Node TNULL; // Sentinel node (NIL)

    // Node yapısı
    class Node {
        int data;
        boolean color; // true for red, false for black
        Node left, right, parent;

        public Node(int data) {
            this.data = data;
            this.color = true; // New node is always red
            this.left = this.right = this.parent = null;
        }
    }

    // Kırmızı-Siyah Ağaç Constructor
    public RedBlackTree() {
        TNULL = new Node(0); // Sentinel node (black leaf)
        TNULL.color = false; // Sentinel node is black
        root = TNULL;
    }

    // Sol Dönme
    private void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != TNULL) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    // Sağ Dönme
    private void rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != TNULL) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    // Düğüm Renk Düzeltme
    private void fixInsert(Node k) {
        Node u;
        while (k.parent.color == true) { // Parent is red
            if (k.parent == k.parent.parent.right) {
                u = k.parent.parent.left;
                if (u.color == true) {
                    u.color = false;
                    k.parent.color = false;
                    k.parent.parent.color = true;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.left) {
                        k = k.parent;
                        rightRotate(k);
                    }
                    k.parent.color = false;
                    k.parent.parent.color = true;
                    leftRotate(k.parent.parent);
                }
            } else {
                u = k.parent.parent.right;
                if (u.color == true) {
                    u.color = false;
                    k.parent.color = false;
                    k.parent.parent.color = true;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.right) {
                        k = k.parent;
                        leftRotate(k);
                    }
                    k.parent.color = false;
                    k.parent.parent.color = true;
                    rightRotate(k.parent.parent);
                }
            }
            if (k == root) {
                break;
            }
        }
        root.color = false;
    }

    // Ekleme İşlemi
    public void insert(int key) {
        Node node = new Node(key);
        node.parent = null;
        node.data = key;
        node.left = TNULL;
        node.right = TNULL;
        node.color = true;

        Node y = null;
        Node x = root;

        while (x != TNULL) {
            y = x;
            if (node.data < x.data) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        node.parent = y;
        if (y == null) {
            root = node;
        } else if (node.data < y.data) {
            y.left = node;
        } else {
            y.right = node;
        }

        if (node.parent == null) {
            node.color = false;
            return;
        }

        if (node.parent.parent == null) {
            return;
        }

        fixInsert(node);
    }

    // Ağacı ekrana yazdırma (Inorder traversal)
    public void inorderHelper(Node root) {
        if (root != TNULL) {
            inorderHelper(root.left);
            System.out.print(root.data + " ");
            inorderHelper(root.right);
        }
    }

    public void printTree() {
        inorderHelper(this.root);
    }
}