package practice.algorithm;

import java.util.ArrayList;
import java.util.List;

public class RecurseApp_1 {
    static List<Integer> a=new ArrayList<Integer>();
    public static void main(String[] args)
    {
        paoLouTi(a,1,10);
    }
	public static void paoLouTi(List<Integer> a,int i,int t) {
	    if(t==0) {
	        System.out.println(a);
	    }else if (i<=t) {
	        a.add(i);
	        paoLouTi(a,i,t-i);
	        a.remove(a.size()-1);
	        paoLouTi(a,i+1,t);
	    }
	}
}
