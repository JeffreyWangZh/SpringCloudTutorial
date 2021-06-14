package list.Offer;

import common.ListNode;

/**
 * @Author jw9j
 * @create 2021/6/9 23:45
 *
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */
public class Offer6 {
    public static void main(String[] args) {
        ListNode test = new ListNode(1);
        test.next = new ListNode(3);
        test.next.next = new ListNode(2);
        int[] result = new int[3];
        result = reversePrint_2(test);

    }

    // 两次遍历
    public static int[] reversePrint_1(ListNode head) {
        // 计算Linked List 长度
        if (head==null) return new int[0];
        int len = 0;
        ListNode current = head;
        while(current.next!=null){
            len++;
            current = current.next;
        }
        int[] result = new int[len+1];
        // 第二次循环遍历 填充数据
        while(head!=null){

            result[len] = head.val;
            len--;
            head = head.next;
        }
        return result;
    }

    // 利用递归进行倒序
    public static int[] res;
    static int i=0,j=0;
    public static int[] reversePrint_2(ListNode head){
        if(head==null) return res;
        rescure(head);
        return res;
    }

    public static void rescure(ListNode head){
        if(head==null){
            res = new int[i];
            return;
        }
        i++;
        rescure(head.next);
        res[j] =  head.val;
        j++;
    }

}



