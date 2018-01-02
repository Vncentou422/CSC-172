public class TreeNode{

    Line lineval;
    TreeNode left, right, parent;
    int linenumber;
    TreeNode(){
    }
    TreeNode(Line x, int z){
	lineval = x;
	linenumber = z;
    }

    TreeNode(Line x,int z, TreeNode initLeft, TreeNode initRight){
	this(x,z);
	left = initLeft;
	right = initRight;
    }
    TreeNode getParent(){
	return parent;
    }
    TreeNode getLeft(){
	return left;
    }
    TreeNode getRight(){
	return right;
    }
    Line getLine(){
	return lineval;
    }
    int getLineNum(){
	return linenumber;
    }
    void setLeft(TreeNode newLeft){
	left = newLeft;
    }
    void setRight(TreeNode newRight){
	right = newRight;
    }
    void setParent(TreeNode newParent){
	parent = newParent;
    }
    void setLine(Line x){
        lineval = x;
    }
    void setLineNum(int x){
	linenumber = x;
    }
}
