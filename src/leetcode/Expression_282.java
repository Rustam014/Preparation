package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Expression_282 {
        public List<String> addOperators(String num, int target) {
            List<String> result = new ArrayList<>();
            recursion(result, "", num, target, 0, 0, 0);
            return result;
        }

        private void recursion(List<String> result, String path, String num, int target, int pos, long eval, long multed) {
            if (pos == num.length()) {
                if (target == eval) {
                    result.add(path);
                }
                return;
            }
            for (int i = pos; i < num.length(); i++) {
                if (i != pos && num.charAt(pos) == '0') break;
                long cur = Long.parseLong( num.substring(pos,i+1) );
                if(pos == 0) {
                    recursion(result, path+cur, num, target, i+1, cur, cur);
                }
                else {
                    recursion(result, path+"+"+cur, num, target, i+1, cur+eval, cur);
                    recursion(result, path+"-"+cur, num, target, i+1, eval-cur, -cur);
                    recursion(result, path+"*"+cur, num, target, i+1, eval - multed + multed * cur, multed * cur);
                }
            }
        }

    public static void main(String[] args) {
            Expression_282 solution = new Expression_282();
            String num = "6546575132";
            int target = 6;
            List<String> result = solution.addOperators(num, target);
            System.out.println(result);
        }
}
