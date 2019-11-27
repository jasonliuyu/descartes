import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description: Domo
 * @Author: Jason
 * @Date: 2019/11/27 10:57
 **/
public class Domo {

    public static final List<String> TWO = List.of("A", "B", "C");
    public static final List<String> THREE = List.of("D", "E", "F");
    public static final List<String> FOUR = List.of("G", "H", "I");
    public static final List<String> FIVE = List.of("J", "K", "L");
    public static final List<String> SIX = List.of("M", "N", "O");
    public static final List<String> SEVEN = List.of("P", "Q", "R", "S");
    public static final List<String> EIGHT = List.of("T", "U", "V");
    public static final List<String> NINE = List.of("W", "X", "Y", "Z");


    /**
     * Discription: 笛卡尔乘积算法
     * 把一个List{[1,2],[A,B],[a,b]} 转化成 List{[1,A,a],[1,A,b],[1,B,a],[1,B,b],[2,A,a],[2,A,b],[2,B,a],[2,B,b]} 输出
     *
     * @param dimensionValue 原List
     * @param result         通过乘积转化后的结果
     * @param layer          中间参数
     * @param currentList    中间参数
     */
    public <T> void descartes(List<List<T>> dimensionValue, List<List<T>> result, int layer, List<T> currentList) {
        if (layer < dimensionValue.size() - 1) {
            if (dimensionValue.get(layer).size() == 0) {
                descartes(dimensionValue, result, layer + 1, currentList);
            } else {
                for (int i = 0; i < dimensionValue.get(layer).size(); i++) {
                    List<T> list = new ArrayList<T>(currentList);
                    list.add(dimensionValue.get(layer).get(i));
                    descartes(dimensionValue, result, layer + 1, list);
                }
            }
        } else if (layer == dimensionValue.size() - 1) {
            if (dimensionValue.get(layer).size() == 0) {
                result.add(currentList);
            } else {
                for (int i = 0; i < dimensionValue.get(layer).size(); i++) {
                    List<T> list = new ArrayList<T>(currentList);
                    list.add(dimensionValue.get(layer).get(i));
                    result.add(list);
                }
            }
        }
    }

    /**
     * @Description: test
     * @Author: Jason
     * @Date: 2019/11/27 11:53
     */
    @Test
    public void test() {
        List<List<String>> dimensionValue = List.of(TWO, FIVE, NINE);// 原List
        List<List<String>> result = new ArrayList<>(); // 返回集合
        new Domo().descartes(dimensionValue, result, 0, new ArrayList<String>());
        result.forEach(System.out::print);
    }


}
