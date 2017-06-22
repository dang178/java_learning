package DataStructureAndAlgorithm;

/**
 * Created by BFD-295 on 2017/6/21.
 *
 * shell排序：
 * 重点：
 * 1、间距生成器：knuth's sequence、h=n/2；间距会影响时间复杂度
 * 2、内部插入排序：比较顺序（h,0)(h+1,1)....(n,n-h)
 * 性能：时间复杂度O(N7/6)~O(N3/2)
 * 步骤：
 * 1、生成间距值：gap
 * 2、循环间距值，每次递减：h=h/3-1
 * 3、当前间距值进行插入排序，从索引为h开始，依次与前面的间距为h的索引进行比较
 */
public class ShellSort {
    public double[] arraySh;
    public int nElems;

    ShellSort(int max) {
        arraySh = new double[max];
        nElems = 0;
    }

    public void Insert(double value) {
        arraySh[nElems] = value;
        nElems++;
    }

    public void display() {
        int index = 0;
        while (index < nElems) {
            System.out.print(arraySh[index] + "\t");
            index++;
        }
        System.out.println("");
    }

    public void Sort()
    {
        int inner,outer;
        double temp;
        int h=1;
        //generate the gap
        while(h<=nElems/3)
        {
            h=3*h+1;
        }
        //h loop;decreasing h, until h=1
        while(h>0)
        {
            // insert-sort,index started at current gap,and compare to index at index-h
            for(outer=h; outer<nElems; outer++)
            {
                temp = arraySh[outer];
                inner = outer;
                // compare process:(h,h-h),(h+1,h+1-h)....(nElems,nElems-h)
                while(inner > h-1 && arraySh[inner-h] >= temp)
                    {
                    arraySh[inner] = arraySh[inner-h];
                    inner -= h;
                }
                arraySh[inner] = temp;
            } // end for
            h = (h-1) / 3; // decrease h
            display();
        }
    }
}

class ShellSortApp
{
    public static void main(String[] args)
    {
        int maxSize = 10; // array size
        ShellSort arr;
        arr = new ShellSort(maxSize); // create the array
        for(int j=0; j<maxSize; j++) // fill array with
        { // random numbers
            double n = (int)(java.lang.Math.random()*99);
            arr.Insert(n);
        }
        arr.display(); // display unsorted array
        arr.Sort(); // shell sort the array
        arr.display(); // display sorted array
    } // end main()
} // end class ShellSortApp
