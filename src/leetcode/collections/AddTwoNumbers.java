package leetcode.collections;

public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode tmp = new ListNode();
      ListNode result = tmp;
      boolean ten = false;

      while(l1 != null || l2 != null) {
        int x = 0;
        if(l1 != null) {
          x += l1.val;
        }
        if(l2 != null) {
          x += l2.val;
        }
        if(ten) {
          x++;
          ten = false;
        }
        if(x >= 10) {
          x -= 10;
          ten = true;
        }
        tmp.next = new ListNode(x);

        if(l1 != null) l1 = l1.next;
        if(l2 != null) l2 = l2.next;
        tmp = tmp.next;
      }
      if(ten) {
        tmp.next = new ListNode(1);
      }

      return result.next;
    }

    public static void main(String[] args) {
      ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));

      ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));

      ListNode res = addTwoNumbers(l1, l2);

      System.out.println("vyvod");
      while(res != null) {
        System.out.println(res.val);
        res = res.next;
      }
    }
}
