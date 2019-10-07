package CodingInterview;

import java.util.*;

public class Main03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()){
            int n = scan.nextInt();
            List<List<String>> orders = new ArrayList<>();
            for (int i=0;i<n;i++){
                String[] info = scan.next().split(",");
                orders.add(Arrays.asList(info));
            }

            int m = scan.nextInt();
            List<List<String>> changes = new ArrayList<>();
            for (int j=0;j<m;j++){
                String[] info = scan.next().split(",");
                changes.add(Arrays.asList(info));
            }

            solve3(orders,changes);

        }
    }

    private static void solve3(List<List<String>> orders, List<List<String>> changes){

        Map<Flight, String> orderMap = new HashMap<>();  // <Flight : Name>
        Map<Flight,Flight> changeMap = new HashMap<>();

        for (List<String> order: orders){
            Flight flight = new Flight();

            flight.id = order.get(0);
            flight.pos = order.get(1);
            flight.isChanged = false;
            orderMap.put(flight, order.get(2));
        }


        for (List<String> change: changes){
            Flight flight = new Flight();
            Flight newFlight = new Flight();

            flight.id = change.get(0);
            flight.pos = change.get(1);
            flight.isChanged = false;
            newFlight.id = change.get(2);
            newFlight.pos = change.get(3);
            newFlight.isChanged = false;

            changeMap.put(flight,newFlight);
        }

        Map<Flight, String> resultMap = new HashMap<>();


        for (Map.Entry<Flight,String> o:orderMap.entrySet()){
            for (Map.Entry<Flight,Flight> c:changeMap.entrySet()){
                if(o.getKey().id.equals(c.getKey().id) && o.getKey().pos.equals(c.getKey().pos)){
                    o.getKey().isChanged = true;
                    resultMap.put(c.getValue(),o.getValue());
                }
            }
        }

        for (Map.Entry<Flight,String> o:orderMap.entrySet()){
            if(!o.getKey().isChanged){
                resultMap.put(o.getKey(), o.getValue());
            }
        }

        for (Map.Entry<Flight,String> r:resultMap.entrySet()){
            System.out.println(r.getKey().id+","+r.getKey().pos+","+r.getValue());
        }

    }
}

class Flight{
    String id;
    String pos;
    boolean isChanged;
}
