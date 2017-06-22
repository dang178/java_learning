package DataStructureAndAlgorithm;

import com.sun.xml.internal.bind.v2.model.annotation.Quick;

/**
 * Created by BFD-295 on 2017/6/22.
 * 步骤：
 * 1、确定分区基准值，可恒定选取最右端的值（当为有序列时，不适用；可采取计算数组第一个、最后一个及
 * 中间索引的中间项作为基准值，并可以同时拍好序）
 * 2、进行分区，并返回分区后的中间位置索引；
 * 3、以中间位置索引为基准，对左右两半部分分别进行迭代排序。
 */
public class QuickSort {
    private int[] theArray;
    private int nElems;

    public QuickSort(int max) {
        theArray = new int[max];
        nElems = 0;
    }

    public void Insert(int value) {
        theArray[nElems++] = value;
    }

    public void Display() {
        int i = 0;
        while (i < nElems) {
            System.out.print(theArray[i] + "\t");
            i++;
        }
        System.out.println("");
    }

    public void Sort()
    {
        Sort(0,nElems-1);
    }

    public void Sort(int s_index,int e_index)
    {
        if(e_index>s_index)
        {
            int pivot = theArray[e_index];

            int mid_index = PartitionInt(s_index,e_index,pivot);

            Sort(s_index,mid_index-1);
            //Display();
            Sort(mid_index+1,e_index);
            //Display();
        }
    }

    public int PartitionInt(int start_Index, int end_Index,int pivot) {
        int leftPtr=start_Index-1;
        int rightptr=end_Index;
        while(true){
            while(theArray[++leftPtr]<pivot)
                ;
            while(rightptr>0&&theArray[--rightptr]>pivot)
                ;
            if(leftPtr>=rightptr)
                break;
            else
            {
                swap(leftPtr,rightptr);
            }
        }
        swap(leftPtr,end_Index);
        //Display();
        return leftPtr;
    }

    public void swap(int a,int b){
        int temp=theArray[a];
        theArray[a]=theArray[b];
        theArray[b]=temp;
    }
}

class QuickSort1App
{
    public static void main(String[] args)
    {
        int maxSize = 16; // array size
        QuickSort arr;
        arr = new QuickSort(maxSize); // create array
        for(int j=0; j<maxSize; j++) // fill array with
        { // random numbers
            int n = (int)(java.lang.Math.random()*99);
            arr.Insert(n);
        }
        arr.Display(); // display items
        arr.Sort(); // quicksort them
        arr.Display(); // display them again
    } // end main()
} // end class QuickSort1App
