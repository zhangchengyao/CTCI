package chapter17_Hard;

public class Q10_MajorityElement {
    int findMajorityElement(int[] a){
        int candidate = -1;
        int count = 0;
        for(int num: a){
            if(count==0) candidate = num;
            if(num==candidate) count++;
            else count--;
        }

        if(candidate==-1) return -1;
        return validate(a, candidate)?candidate:-1;
    }

    private boolean validate(int[] a, int x){
        int cnt = 0;
        for(int num: a){
            if(num==x) cnt++;
        }
        return cnt>a.length/2;
    }
}
