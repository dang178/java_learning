package DataStructureAndAlgorithm;

/**
 * Created by BFD-295 on 2017/6/21.
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
    }

    public void Sort()
    {
        int inner,outer;
        double temp;
        int h=1;
        while(h<nElems){
            h=3*h+1;
        }
        //间距循环
        while(h>0){
            //从最大的间隔开始，从当前间隔为索引，对索引倍数进行插入排序。并逐步加一
            for(outer=h;outer<nElems;outer++)
            {
                temp = arraySh[outer];
                for(inner=outer-h;inner<0;inner-=h)
                {
                    if(arraySh[inner]>temp)
                        arraySh[outer]=arraySh[inner];
                }
                arraySh[inner]=temp;
            }
            h=(h-1)/3;
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
