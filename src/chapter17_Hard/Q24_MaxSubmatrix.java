package chapter17_Hard;

public class Q24_MaxSubmatrix {
    class Range{
        int left;
        int right;
        int sum;
        Range(int _left, int _right, int _sum){
            left = _left;
            right = _right;
            sum = _sum;
        }
    }

    int[][] maxSum2D(int[][] matrix){
        int numRow = matrix.length;
        int numCol = matrix[0].length;
        int[][] best = new int[2][2];
        int maxSum = Integer.MIN_VALUE;

        for(int r=0;r<numRow;r++){
            int[] partialSum = new int[numCol];

            for(int rEnd=r;rEnd<numRow;rEnd++){
                for(int c=0;c<numCol;c++){
                    partialSum[c] += matrix[rEnd][c];
                }
                Range curBest = maxSum1D(partialSum);
                if(curBest.sum>maxSum){
                    maxSum = curBest.sum;
                    best[0][0] = r;
                    best[0][1] = curBest.left;
                    best[1][0] = rEnd;
                    best[1][1] = curBest.right;
                }
            }
        }

        return best;
    }

    private Range maxSum1D(int[] array){
        Range best = new Range(0, 0, array[0]);
        int start = 0;
        int sum = array[0];

        for(int i=1;i<array.length;i++){
            if(array[i]<array[i]+sum){
                sum += array[i];
            } else {
                sum = array[i];
                start = i;
            }

            if(sum>best.sum){
                best = new Range(start, i, sum);
            }
        }

        return best;
    }
}
