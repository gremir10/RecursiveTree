public class Main
{
    public static void main(String[] args)
    {

        Tree aTree = new Tree();

        aTree.insert(10); //root
        aTree.insert( 5); //left child of root
        aTree.insert( 15); //right child of root
        aTree.insert(2); //left child of 5
        aTree.insert(7); //right child of 5
        aTree.insert(12); //left child 15
        aTree.insert(16); //right child 15



        /*aTree.printInOrder();
        aTree.printPreOrder(); //parent(root), left child, right child
        aTree.printPostOrder();

        aTree.search(16); */

        aTree.deleteByValue(5);


    }
}