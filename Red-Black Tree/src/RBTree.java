public class RBTree {
    public Node root;

    //node class for a node in RB tree
    public class Node{
        int value;
        Node parent;
        Node left;
        Node right;
        boolean isRed;

        //constructor to create a new node w/ value
        public Node(int value){
            this.value = value;
            this.isRed = true;
        }
    }

    //inserting a new value into RB tree
    public void insert(int value){
        Node newNode = new Node(value);
        Node current = root;
        Node parent = null;

        while(current != null){
            parent = current;
            if(value < current.value){
                current = current.left;
            }else{
                current = current.right;
            }
        }
        newNode.parent = parent;

        if(parent == null){
            root = newNode;
        }else if (value < parent.value){
            parent.left = newNode;
        }else{
            parent.right = newNode;
        }
        fixInsert(newNode);
    }

    // RB fix-up for newly inserted node
    public void fixInsert(Node node){
        while(node !=root && node.parent.isRed){
            if(node.parent == node.parent.parent.left){
                Node uncle = node.parent.parent.right;
                if(uncle != null && uncle.isRed){
                    node.parent.isRed = false;
                    uncle.isRed = false;
                    node.parent.parent.isRed = true;
                    node = node.parent.parent;
                }else{
                    if(node == node.parent.right){
                        node = node.parent;
                        rotateLeft(node);
                    }
                    node.parent.isRed = false;
                    node.parent.parent.isRed = true;
                    rotateRight(node.parent.parent);
                }
            } else{
                Node uncle = node.parent.parent.left;
                if(uncle !=null && uncle.isRed){
                    node.parent.isRed = false;
                    uncle.isRed = false;
                    node.parent.parent.isRed = true;
                    node = node.parent.parent;
                }else{
                    if(node == node.parent.left){
                        node = node.parent;
                        rotateRight(node);
                    }
                    node.parent.isRed = false;
                    node.parent.parent.isRed = true;
                    rotateLeft(node.parent.parent);
                }
            }
        }
        root.isRed = false;
    }

    //rotate node to the left
    public void rotateLeft(Node node){
        Node rightChild = node.right;
        node.right = rightChild.left;

        if(rightChild.left != null){
            rightChild.left.parent = node;
        }
        rightChild.parent = node.parent;

        if(node.parent == null){
            root = rightChild;
        }else if(node == node.parent.left){
            node.parent.left = rightChild;
        }else{
            node.parent.right = rightChild;
        }
        rightChild.left = node;
        node.parent = rightChild;
    }

    //rotate node to the right
    public void rotateRight(Node node){
        Node leftChild = node.left;
        node.left = leftChild.right;

        if(leftChild.right != null){
            leftChild.right.parent = node;
        }
        leftChild.parent = node.parent;

        if(node.parent == null){
            root = leftChild;
        }else if(node == node.parent.right){
            node.parent.right = leftChild;
        }else{
            node.parent.left = leftChild;
        }

        leftChild.right = node;
        node.parent = leftChild;
    }

    //search for a value in RB tree
    //returns true if the value is found, false if it's not

    public boolean find(int value){
        Node current = root;

        while(current != null){
            if(value == current.value){
                return true;
            }else if(value < current.value){
                current = current.left;
            }else{
                current = current.right;
            }
        }
        return false;
    }

    //checks if the node is red
    public boolean isRed(Node node){
        return node != null && node.isRed;
    }


    public String toString(){
        return toString(root);
    }

    public String toString(Node root){
        String rtn = "";
        if(root != null){
            if(root.left != null){
                rtn+=toString(root.left);
            }
            rtn += " "+root.value+" ";
            if(root.right != null){
                rtn+=toString(root.right);
            }
        }
        return rtn;
    }


}
