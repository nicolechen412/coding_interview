package chapter4TreeandPic;

/**
 * @author NicoleChen
 * @date 2018/3/23 17:10
 * 创建高度最小的二叉查找树
 */
public class createMinimalBST {
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,5,7,9,11,14};
        createMinimalBST(arr);
    }
    public static TreeNode createMinimalBST(int arr[], int start, int end) {
        if(end < start){
            return null;
        }
        int mid = (start + end)/2;
        TreeNode tn = new TreeNode(arr[mid]);
        tn.left = createMinimalBST(arr,start,mid-1);
        tn.right = createMinimalBST(arr,mid+1,end);

        return tn;
    }
    public static void createMinimalBST(int arr[]) {
        TreeNode n = createMinimalBST(arr, 0, arr.length-1);
        //n.showList(n);
        showLevelTree slt = new showLevelTree(n);
        //slt.showLevelTree(n);

        System.out.println(checkBST.checkBST(n));
    }

}
