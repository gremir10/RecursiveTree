public class Tree
{
    public Node root;

    //insertion that doesn't require null every time
    //public so can be called from outside,vs private which can only be called within
    public void insert(int newData)
    { //check if root
        if(root == null) {
            //if no root, one is created
            System.out.println("Insert Root:\t" + newData);
            root = new Node();
            root.data = newData;
        }
        else
        {
            System.out.println("Start:\t" + newData);
            insertSupport(root, newData); //if you already have root, pass node down to insertsupport
        }
    }
    private Node insertSupport(Node current, int newData)
    {
        //see current node that's being compared to
    if(current == null)
    {
        System.out.println("Insert node:\t" + newData);
        current = new Node();
        current.data = newData;
    }
    else  //else add child to root
    {
        //check if you're adding to left or right child:
        if(newData <= current.data) //less than or equal to parent goes left
        {
            System.out.println("Go left:\t" + newData);
            current.left = insertSupport(current.left, newData);
        }
        else
        {
            System.out.println("Go right:\t" + newData);
            current.right = insertSupport(current.right, newData);
        }
    }
    return current;
  }

  public void deleteByValue(int searchData)
  { //deleting first found instance of value, good for if there's two of the same value
      Node parent;
      Node child;
      parent = findParent(root, searchData);
      child = searchSupport(root, searchData);
      //use searchsupport bc it needs a return of some kind
      System.out.println("Parent: " + parent.data);

      System.out.println("Child: " + child.data);
      System.out.println("Left child: " + child.left.data);
      System.out.println("Right child: " + child.right.data);

  }

  //done recursively- traverses tree
  public void printInOrder()
  { //left child, parent, right child
      System.out.println("In Order:");
      printInOrderSupport(root);
      //start with furthest left leaf
  }
  private void printInOrderSupport(Node current)
  {
      if(current != null)
      {
          printInOrderSupport(current.left);
      }
      if(current != null)
      {
          System.out.println(current.data);
      }
      if(current != null)
      {
          printInOrderSupport(current.right);
      }

  }

    public void printPreOrder()
    { //parent, left child, right child
        System.out.println("Pre-Order:");

        printPreOrderSupport(root);
    }
    public void printPreOrderSupport(Node current)
    {
        if(current != null)
        {
            System.out.println(current.data);
        }
        //go to left or right child
        if(current.left != null)
        {
            printPreOrderSupport(current.left);
        }
        if(current.right != null)
        {
            printPreOrderSupport(current.right);
        }

    }

    public void printPostOrder()
    { //left child, right child, parent
        System.out.println("Post-Order:");
        printPostOrderSupport(root);

    }
    public void printPostOrderSupport(Node current)
    {//left child, right child, parent
        if(current.left != null)
        {
            printPostOrderSupport(current.left);
        }
        if(current.right != null)
        {
            printPostOrderSupport(current.right);
        }
        if(current != null)
        {
            System.out.println(current.data);
        }
    }
    public void search(int searchData)
    {
        System.out.println("Searching: " + searchData);
        System.out.println(searchSupport(root, searchData).data);

    }
    private Node searchSupport(Node current, int searchData)
    {

        if (current != null)
        {
            if (searchData == current.data)
            {
                return current;
                //System.out.println("found searched data:" + current.data);
            } else if (searchData <= current.data)
            { //if data is <= current, go left
               return searchSupport(current.left, searchData);
            } else
            { //if data is <= current, go left
                return searchSupport(current.right, searchData);
            }

            }
        //if search for something that doesn't exist attempted:
        //^(aka if current = null):
             return null;
         }

         private Node findParent(Node current, int searchData)
         {//will return node of parent that contains data we're looking for

             if(current.left.data == searchData || current.right.data == searchData)
             {
                 return current;
             }
             else
             {
                 return null;
             }

         }
    }


