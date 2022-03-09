class Solution 
{
    HashMap<Integer, Integer> inorderMap= new HashMap<>();//data -- index//hash map is used to optimize the search 
    
    public TreeNode TreeMaker(int[] postorder, int inorderStart, int inorderEnd, int postorderStart, int postorderEnd)
    {
        //we are using the postorder traversal(LEFT RIGHT ROOT) because we want to know the child information first and then the parent informaion 
        
        if(inorderStart > inorderEnd)//base case -- when index becomes out of bound, pointing to somewhere else so returning null,ending of that side of node 
            return null;//telling the parent that no node is present
        
        int rootData= postorder[postorderEnd];//[Root]

        int rootIndex= inorderMap.get(rootData);//root index//getting at O(1)
        
        //taking the advantage of inorder to calculate left and right subtree size (left root right)
        int leftSubTreeSize= rootIndex - inorderStart;//[Left]
        int rightSubTreeSize= inorderEnd - rootIndex;//[Right]
        
        //partition te array and creating the node //Divide and conqure
        TreeNode left= TreeMaker(postorder, inorderStart, inorderStart + leftSubTreeSize - 1, postorderStart, postorderStart + leftSubTreeSize - 1);//recursively traversing the left subtree//knowing more about left child 
        TreeNode right= TreeMaker(postorder, inorderStart + leftSubTreeSize + 1, inorderEnd, postorderEnd - rightSubTreeSize, postorderEnd - 1);
        //recursively traversing the right subtree //knowing more about right child 
        
        TreeNode rootNode= new TreeNode(rootData, left, right);//after getting the information and reference of child creating the node 
        
        return rootNode;//returning the node to maintain the backward link//telling the parent that i am present 
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder)
    {
        for(int i= 0; i < inorder.length; i++)//putting data and corresponding index into the Hash Map
            inorderMap.put(inorder[i], i);
        
        return TreeMaker(postorder, 0, inorderMap.size()-1, 0, postorder.length-1);//returns the new Root of the tree 
    }
}
//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/discuss/1323990/Java-oror-2-Easy-Approach-with-Explanation-oror-HashMap-And-Recursion
