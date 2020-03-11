import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMap {

    public static void main(String[] args) {
        Map<Character, List<Character>> listMap = new HashMap<>();

        listMap.putIfAbsent('A', new ArrayList<>());


    }

}
