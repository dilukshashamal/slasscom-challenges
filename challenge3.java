import java.util.*;

public class challenge3 {

    public static void main(String[] arg){
        int[] array = {47,84,75,21,14,14,79};
        //sorted array
        Arrays.sort(array);
        int l = array.length;

        //call classes
        int m1 = median(l,array);
        double m2 = mean(l,array);
        int m3 = mode(l,array);
        System.out.println("Median :"+m1);
        System.out.println("Mean   :"+m2);
        System.out.println("Mode   :"+m3);

    }

    //find median
    static int median(int a,int arr[]){
        int n=0;

        if(a%2 == 1){
            n = arr[((a+1)/2)-1];
        }
        else{
            n = (arr[n/2-1] + arr[n/2])/2;
        }
        return n;
    }

    //find mean
    static double mean(int a,int arr[]){
        int sum = 0;
        for(int i=0;i < a;i++){
            sum+=arr[i];
        }
        return (double)sum/(double)a;
    }

    //find mode
    static int mode(int a,int arr[]){
        int mValue = 0,mCount = 0;

        //need to check all the arrays
        for(int i=0;i<a;i++){
            int c = 0;
            for(int j=0;j<a;j++){
                if(arr[j]==arr[i]){
                    //max count
                    c++;
                }

            }

            //identify mode value
            if(c > mCount){
                mCount = c;
                mValue = arr[i];
            }
        }

        return mValue;
    }
}
