package CodingInterview;

import java.util.*;

public class Main01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()){
            String input = scan.next();
            String[] strings = input.split("\\},");
            List<Integer> A = new ArrayList<>();
            List<Integer> B = new ArrayList<>();
            int R = 0;
            for (int i=0;i<strings.length;i++){
                if(i != strings.length-1){
                    String[] vals = strings[i].split("\\{")[1].split("\\}")[0].split(",");
                    for (String v:vals){
                        if(i==0){
                            A.add(Integer.parseInt(v));
                        }
                        if(i==1){
                            B.add(Integer.parseInt(v));
                        }
                    }
                } else {
                    R = Integer.parseInt(strings[i].split("=")[1]);
                }
            }
            Integer[] a = new Integer[A.size()];
            A.toArray(a);
            Integer[] b = new Integer[B.size()];
            B.toArray(b);
            solve1(a,b,R);
        }
    }

    private static void solve1(Integer[] a,Integer[] b,int r){
        if(a.length==0 || b.length==0){
            return;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> elem = null;
        for (int i=0;i<a.length;i++){
            boolean isFind = false;
            for (int j=0;j<b.length;j++){
                elem = new ArrayList<>();
                if(b[j] >= a[i] && b[j] - a[i] <= r){
                    elem.add(a[i]);
                    elem.add(b[j]);
                    isFind = true;
                } else if(b[j] >= a[i] && b[j] - a[i] > r && isFind == false){
                    elem.add(a[i]);
                    elem.add(b[j]);
                }
            }
        }

        for (List<Integer> ele: result){
            System.out.print("("+ele.get(0)+","+ele.get(1)+")");
        }
    }

}
