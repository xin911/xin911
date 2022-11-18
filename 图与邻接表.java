import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class 图与邻接表 {

}

class 点 {
    public int 值;
    public int in;
    public int out;

    public List<点> nexts = new ArrayList<>();
    public List<边> 多边 = new ArrayList<>();

    /**
     * @param 值
     */
    public 点(int 值) {
        this.值 = 值;
    }

}

class 边 {
    public int weight;
    public 点 from;
    public 点 to;

    /**
     * @param weight
     * @param from
     * @param to
     */
    public 边(int weight, 点 from, 点 to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }

}

class 图 {
    public Map<Integer, 点> 多点 = new HashMap<>();
    public Set<边> 多边 = new HashSet<>();
}