package DataStructureAndAlgorithm;

/**
 * Created by BFD-295 on 2017/6/21.
 * recursive function.
 * hanoi(n):
 * 1、move the subtree(n-1) from s to i;
 * 2、move the remaining(largest disk) from s to t;
 * 3、move the subtree(n-1) from i to t;
 */
public class Hanoi {
    static Integer nDisks=3;

    public static void main(String[] args){
        doTowers(nDisks,'s','i','t');
    }

    public static void doTowers(int topN,char from,char inter,char to){
        if(topN==1)
        {
            System.out.println("Disk 1 from "+from+" to "+to);
        }
        else
        {
            doTowers(topN-1,from,to,inter);//transfer topN-1 from
            System.out.println("Disk "+topN+" from "+ from +" to "+to);
            doTowers(topN-1,inter,from,to);
        }
    }
}
