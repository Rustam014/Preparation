package leetcode.collections;

public class MergeKLists {
    public static boolean flag = true;

    public int findMin(ListNode[] lists) {
        int min = 1000000000;
        for(ListNode a: lists) {
            if(a!=null && a.val < min)
                min = a.val;
        }


        return min;
    }

    public ListNode[] deleteNode(ListNode[] lists, int x) {
        for(int i=0; i< lists.length; i++) {
            if(lists[i] !=null && lists[i].val == x) {
                lists[i] = lists[i].next;
                break;
            }
        }
        flag = false;
        for(ListNode a: lists){
            if (a != null) {
                flag = true;
                break;
            }
        }
        return lists;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode tmp = new ListNode();
        ListNode result = tmp;
        while(flag) {
            int x = findMin(lists);
            lists = deleteNode(lists, x);
            tmp.next = new ListNode(x);
            tmp = tmp.next;
        }


        return result.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode b = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode c = new ListNode(2, new ListNode(6));
        ListNode[] array = {a, b, c};
        MergeKLists x = new MergeKLists();
        ListNode res = x.mergeKLists(array);

        System.out.println("vyvod");
        while(res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
