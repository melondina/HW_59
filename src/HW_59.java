import java.util.ArrayList;
import java.util.List;

public class HW_59 {

    public static List<String> sort(List<String> strings) {
        if (strings.size() < 2) {
            return strings;
        }

        // разбить на две половинки
        int mid = strings.size() / 2;
        List<String> left = strings.subList(0, mid);
        List<String> right = strings.subList(mid, strings.size());

//        System.out.println("=== sort(" + strings + ") ===");
//        System.out.println("left = " + left);
//        System.out.println("right = " + right);

        // отсортировать каждую
        left = sort(left);
        right = sort(right);

        // слить две половинки
        return merge(left, right);
    }

    /**
     * Слияние двух отсортированных по возрастанию списков в один
     *
     * @param list1 отсортированный по возрастанию список строк
     * @param list2 отсортированный по возрастанию список строк
     * @return отсортированный по возрастанию итоговый список строк после слияния
     */
    private static List<String> merge(List<String> list1, List<String> list2) {

//        System.out.println("=== merge(" + list1 + ", " + list2 + ") ===");
        List<String> result = new ArrayList<>();
        int i1 = 0;
        int i2 = 0;

        while (i1 < list1.size() && i2 < list2.size()) {
            // пока оба списка не закончились
            String first = list1.get(i1);
            String second = list2.get(i2);
            if (first.compareToIgnoreCase(second) < 0) {
                result.add(first);
                ++i1;
            } else {
                result.add(second);
                ++i2;
            }
        }
        // покинули цикл - или list1, или list2 уже закончился

        // list1 не закончился - значит, list2 уже закончился, иначе мы были бы в цикле while
        // и можно безопасно добавлять остаток list1 в конец result
        while (i1 < list1.size()) {
            result.add(list1.get(i1));
            ++i1;
        }

        // list2 не закончился - значит, list1 уже закончился, иначе мы были бы в цикле while
        // и можно безопасно добавлять остаток list2 в конец result
        while (i2 < list2.size()) {
            result.add(list2.get(i2));
            ++i2;
        }

//        System.out.println("result = " + result);
        return result;
    }

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("Ivanov");
        strings.add("Petrov");
        strings.add("Sidorov");
        strings.add("gagarin");
        strings.add("Korolev");

        System.out.println(strings);
        strings = sort(strings);
        System.out.println(strings);
    }
}