package DataStructureAndAlgorithm;

/**
 * Created by BFD-295 on 2017/6/21.
 * 与C++函数传参的区别：java都是值传递（基本数据类型不会发生改变，引用数据类型传递改变）
 * C++则有值传递和引用传递之分
 * 归并排序：
 * 针对两个数组的排序。
 * 当只存在一个数组时，将源数组按索引分为两部分，对于两部分的排序方法：
 *  1、可用简单排序将两部分排序；
 *  2、迭代mergesort方法；
 * 1、创建空目标数组对象；
 * 2、依次比较两个源数组的元素，当A元素比B元素大时，将小的值放入目标数组；
 * 3、按2依次进行，直到有一个源数组为空；
 * 4、将不为空的源数组剩余的元素直接赋值到目标数组，即完成排序；
 * 总结：排序速度为：O(N*logN),但更消耗内存空间，副本数为：O(N*logN)
 */
public class MergeSort {
    public static void main(String[] args){
        Integer [] arrayA={23,47,81,95};
        Integer[] arrayB={7, 14, 39, 55, 62, 74};
        Integer[] arrayC=new Integer[10];
merge(arrayA,4,arrayB,6,arrayC);
display(arrayC,10);

    }
    public static void merge(Integer[] arrayA,Integer sizeA,Integer[] arrayB,Integer sizeB,Integer[] arrayC){
        int indexA=0,indexB=0,indexC=0;
        while(indexA<sizeA&&indexB<sizeB)
        {
            if(arrayA[indexA]>arrayB[indexB])
            {
                arrayC[indexC]=arrayB[indexB];
                indexB++;
            }else
            {
                arrayC[indexC]=arrayA[indexA];
                indexA++;
            }
            indexC++;
        }
        while(indexA<sizeA)
            arrayC[indexC++]=arrayA[indexA++];
        while(indexB<sizeB)
            arrayC[indexC++]=arrayA[indexA++];
    }

    public static void display(Integer[] array,Integer size){
        int index=0;
        while(index<size)
        {
            System.out.print(array[index]+"\t");
            index++;
        }
        System.out.flush();
    }
}
