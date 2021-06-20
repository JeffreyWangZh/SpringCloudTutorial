package list;

import common.ListNode;

/**
 * @Author jw9j
 * @create 2021/6/7 1:24
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 */
public class _21 {
    public static void main(String[] args) {

    }



    // 递归
    public ListNode mergeTwoLists_1(ListNode l1, ListNode l2) {
        // 情况1： L1 || l2 empty
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists_1(l1.next,l2);
            return l1;
        }
        else{
            l2.next = mergeTwoLists_1(l1,l2.next);
            return l2;
        }
    }
}
