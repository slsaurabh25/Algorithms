import java.util.HashMap;
import java.util.Map;

public class MapExample {

    public static void main(String args[])
    {
        MapExample mapExample = new MapExample();
        mapExample.asd();

    }

    public void asd() {
        Map<Integer, Integer> updateOrderItemMap = new HashMap<>();
        addData(updateOrderItemMap);
        System.out.println(updateOrderItemMap);
    }
    private void addData(final Map<Integer, Integer> updateOrderItemMap) {
        updateOrderItemMap.putIfAbsent(1, 1);
        updateOrderItemMap.putIfAbsent(2, 2);
        updateOrderItemMap.putIfAbsent(3, 3);
    }
}
