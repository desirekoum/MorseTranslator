package desire.morse;

import java.util.ArrayList;

class MorseCodeTree<T> implements LinkedConverterTreeInterface<T> {

    private TreeNode<String> root;

    /**
     *  Constructor - calls the buildTree method
     */
    public MorseCodeTree() {
        buildTree();
    }


    @Override
    public void buildTree()
    {
        //build root node
        root = new TreeNode<>("");
        TreeNode<String> eNode = new TreeNode<String>("e");
        root.setLeft(eNode);
        TreeNode<String> tNode = new TreeNode<String>("t");
        root.setRight(tNode);
        TreeNode<String> iNode = new TreeNode<>("i");
        eNode.setLeft(iNode);
        TreeNode<String> aNode = new TreeNode<>("a");
        eNode.setRight(aNode);
        TreeNode<String> sNode = new TreeNode<>("s");
        iNode.setLeft(sNode);
        TreeNode<String> uNode = new TreeNode<>("u");
        iNode.setRight(uNode);
        TreeNode<String> hNode = new TreeNode<>("h");
        sNode.setLeft(hNode);
        TreeNode<String> vNode = new TreeNode<>("v");
        sNode.setRight(vNode);
        TreeNode<String> fNode = new TreeNode<>("f");
        uNode.setLeft(fNode);

        TreeNode<String> rNode = new TreeNode<>("r");
        aNode.setLeft(rNode);
        TreeNode<String> wNode = new TreeNode<>("w");
        aNode.setRight(wNode);
        TreeNode<String> lNode = new TreeNode<>("l");
        rNode.setLeft(lNode);
        TreeNode<String> pNode = new TreeNode<>("p");
        wNode.setLeft(pNode);
        TreeNode<String> jNode = new TreeNode<>("j");
        wNode.setRight(jNode);

        TreeNode<String> nNode = new TreeNode<>("n");
        tNode.setLeft(nNode);
        TreeNode<String> mNode = new TreeNode<>("m");
        tNode.setRight(mNode);
        TreeNode<String> dNode = new TreeNode<>("d");
        nNode.setLeft(dNode);
        TreeNode<String> kNode = new TreeNode<>("k");
        nNode.setRight(kNode);

        TreeNode<String> bNode = new TreeNode<>("b");
        dNode.setLeft(bNode);
        TreeNode<String> xNode = new TreeNode<>("x");
        dNode.setRight(xNode);
        TreeNode<String> cNode = new TreeNode<>("c");
        kNode.setLeft(cNode);
        TreeNode<String> yNode = new TreeNode<>("y");
        kNode.setRight(yNode);

        TreeNode<String> gNode = new TreeNode<>("g");
        mNode.setLeft(gNode);
        TreeNode<String> oNode = new TreeNode<>("o");
        mNode.setRight(oNode);
        TreeNode<String> zNode = new TreeNode<>("z");
        gNode.setLeft(zNode);
        TreeNode<String> qNode = new TreeNode<>("q");
        gNode.setRight(qNode);

    }

    @Override
    public TreeNode<T> getRoot() {
        return (TreeNode<T>) this.root;
    }

    @Override
    public void setRoot(TreeNode<T> newNode) {
        TreeNode<T> temp = new TreeNode<>(newNode);
        this.root = (TreeNode<String>) temp;
    }


    @Override
    public MorseCodeTree<T> insert(T code, T result) {
        addNode(getRoot(), code, result);
        return this;
    }

    @Override
    public void addNode(TreeNode<T> root, T code, T letter) {
        TreeNode<String> newRoot = (TreeNode<String>) root;
        TreeNode<String> currentNode = (TreeNode<String>) root;
        String newCode = null;
        if(code.toString().length()==1)
        {
            if(code.toString().contains("."))
            {
                currentNode = new TreeNode<String>((String) letter);
                newRoot.setLeft(currentNode);
            }
            if(code.toString().contains("-"))
            {
                currentNode = new TreeNode<String>((String) letter);
                newRoot.setRight(currentNode);
            }

            return;
        }
        else//there is more than one character in the morse code
        {
            if(code.toString().charAt(0)=='.')
            {
                newRoot = currentNode.getLeft();
            }
            if(code.toString().charAt(0)=='-')
            {
                newRoot = currentNode.getRight();
            }
            newCode = code.toString().substring(1);
        }
        addNode((TreeNode<T>)newRoot, (T)newCode, letter);
    }//end of addNode method

    @SuppressWarnings("unchecked")
    @Override
    public T fetch(String code) {

        return (T) fetchNode(this.root, code);
    }

    public String fetchNode(TreeNode<String> root, String code) {

        String newCode = code;

        if(newCode.length()==1)// there is only one char in the morse code
        {
            if(newCode.equals("."))
            {
                return root.getLeft().getData().toString();
            }
            if(newCode.equals("-"))
            {
                return root.getRight().getData().toString();
            }
        }
        //else//we have a morse code with more than one char*
        //{
        if(newCode.charAt(0)=='.')
        {
            root = root.getLeft();
        }
        if(newCode.charAt(0)=='-')
        {
            root = root.getRight();
        }
        newCode = newCode.substring(1);
        //}
        //newCode = newCode.substring(1);
        return fetchNode(root, newCode);
    }

    @Override
    public ArrayList<T> toArrayList() {

        ArrayList<T> list = new ArrayList<>();
        LNRoutputTraversal(this.getRoot(), list);
        return list;
    }

    @Override
    public void LNRoutputTraversal(TreeNode<T> root, ArrayList<T> list) {

        if(root.getLeft() != null)
            LNRoutputTraversal(root.getLeft(), list);  // traverse the entire left subtree
        list.add(root.getData());  // output the root node
        if(root.getRight() != null)
            LNRoutputTraversal(root.getRight(), list);  // traverse the entire right subtree
    }


    @Override
    public T fetchNode(TreeNode<T> root, T code) {
        return null;
    }
    @Override
    public LinkedConverterTreeInterface<T> delete(T data) throws UnsupportedOperationException {
        return null;
    }
    @Override
    public LinkedConverterTreeInterface<T> update() throws UnsupportedOperationException {
        return null;
    }

}
