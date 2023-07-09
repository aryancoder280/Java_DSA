 package graph;

import java.util.*;


class FindCelebrity{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt(),m = sc.nextInt();
        Vector<Vector<Integer> > edgeList = new Vector<Vector<Integer> >();
        for(int i =0;i<m;i++)
        {
        	edgeList.add(new Vector<Integer>());
        	edgeList.get(i).add(sc.nextInt());
        	edgeList.get(i).add(sc.nextInt());	
        }
        System.out.println(findCelebrity(n,edgeList));
    }
    private static int findCelebrity(int n,Vector<Vector<Integer> > edgeList){
        boolean know[] = new boolean[n+1];
        Arrays.fill(know, true);
        int count[] = new int[n+1];
        Arrays.fill(count, 0);
        for(int i=0;i<edgeList.size();i++) {
            int cut = edgeList.get(i).get(0).intValue();
            int add = edgeList.get(i).get(1).intValue();
            know[cut] = false;
            count[cut]--;
            count[add]++;
        }
        for(int i=1;i<=n;i++) {
            if(count[i] == n-1 && know[i] == true) return i;
        }
        return -1;
    }
}
