### 解题思路
这题的数据量不大，总共就是9*9,所以只要是将它遍历常数遍能够完成就行

根据条件，很明显我们需要保存一下每一行、每一列、以及每个3*3的九宫格已经遍历过的数据的状况，比较简单的就是直接使用hashMap存一下，但是可以用数组优化一下。

关键在于如何遍历每个3*3小方格，只要找出所有的3\*3小方格行列开始的地方，这就界定了当前在遍历哪个小方格，然后遍历记录行列、小方格数据就好了。

### 代码

```java
class Solution {
    public static boolean isValidSudoku(char[][] board) {
        int[][] colums = new int[9][9];//colums[row][col]表示第col列是否出现过row这个数
        int[][] rows = new int[9][9];//rows[row][col]表示第row行是否出现过col这个数
        //为1表示出现过
        int rowBegin = 0;
        int colBegin = 0;
        while(rowBegin<=6){
            //rowBegin和colBegin框住一个9宫格
            int[] ninesFind = new int[9];
            for(int tempRow = rowBegin;tempRow<rowBegin+3;tempRow++){
                for(int tempCol = colBegin;tempCol<colBegin+3;tempCol++){
                    if(board[tempRow][tempCol]=='.') continue;
                    int cur = board[tempRow][tempCol]-'1';
                    if(colums[cur][tempCol]==1||rows[tempRow][cur]==1||ninesFind[cur]==1){
                        return false;
                    }
                    colums[cur][tempCol]=1;
                    rows[tempRow][cur]=1;
                    ninesFind[cur]=1;
                }
            }
            if(colBegin>=6){
                rowBegin+=3;
                colBegin=0;
            }else{
                colBegin+=3;
            }
        }
        return true;
    }
}
```