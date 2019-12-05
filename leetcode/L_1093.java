class Solution {
    public double[] sampleStats(int[] count) {
        double[] stats = new double[5];
        double min = -1, max = -1, mean = 0, median = -1, mode = 0, total = 0;
        //traverse through the given array
        for(int i=0; i<count.length; i++){
            //'min' is always the first index with count > 0
            if(min == -1 && count[i] > 0){
                min = i;
            }
            //'max' is the number with greatest count
            if(count[i] > 0 && i > max){
                max = i;
            }
            //'mean' is the summation of all numbers (count[i]*i for ith number) divided by 'total' which is calculated below
            mean += i*count[i];
            total += count[i];
            //'mode' is the number with highest frequency
            if(count[i] > count[(int)mode]){
                mode = i;
            }
        }
        //calculate mean
        mean = mean/total;        
        //tricky part: median. we calculate this based on the total length being even or odd.
        int countSoFar = 0;
        //traverse the array again
        for(int i=0; i<count.length; i++){
            countSoFar += count[i];  //increment countSoFar everytime
            //odd length: median is single mid element
            if(total % 2 != 0){
                if(countSoFar > total/2){   //if we 'cross' the mid element, it is the median
                   median = i;
                   break;
                }
            }
            //even length: median is average of 2 consecutive mid elements
            else{
                //'count[i] > 0 here is to avoid counting 'zero' freq elements
                //countSoFar == total/2 implies we are at the 'first' of 2 mid elements
                if(count[i] > 0 && countSoFar == total/2){
                   median = i;
                }
                //countSoFar crossed total/2 implies that we reached 'second' of  mid elements
                if(countSoFar > total/2){
                    //if median is -1 at this point, this means both the mid elements are the same element. Eg: 1,1,2,2,2,2,3,3, here median = (2+2)/2 => 2
                    if(median == -1){
                       median = i;
                    }
                    //add first and second and take average
                    else median = (median+i)/2;
                    break;
                }
            }
        }
        //finally, fill the stats array and return
        stats[0] = min; stats[1] = max; stats[2] = mean; stats[3] = median; stats[4] = mode;
        return stats;
    }
}

//https://leetcode.com/problems/statistics-from-a-large-sample/discuss/317874/Easy-to-understand-Java-Solution-(tried-my-best-to-explain)
