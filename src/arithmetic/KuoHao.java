package arithmetic;

import java.util.ArrayList;
import java.util.LinkedList;

public class KuoHao {

    public boolean isValid(String s) {

        ArrayList<String> left = new ArrayList<>();
        left.add("{");
        left.add("[");
        left.add("(");

        LinkedList<String> queue = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            String ch = queue.peek();

            char current = s.charAt(i);

            if (left.contains(new String(new char[]{current}))) {
                System.out.println("左边 "+current+" 进");
                queue.push(new String(new char[]{current}));
            }else{
                if (current == '}'&&"{".equals(ch)) {
                    System.out.println("右边 "+current+" 出");
                    queue.pop();
                }else if(current == ']'&&"[".equals(ch)){
                    System.out.println("右边 "+current+" 出");
                    queue.pop();
                } else if (current == ')'&&"(".equals(ch)) {
                    System.out.println("右边 "+current+" 出");
                    queue.pop();
                }else{
                    System.out.println("右边 "+current+" 与前面的不能消除非法！！");
                    return false;
                }
            }

        }

        return queue.isEmpty();

    }

    public static void main(String[] args) {
        KuoHao kuoHao = new KuoHao();
        kuoHao.isValid("{[]}");
    }

}
