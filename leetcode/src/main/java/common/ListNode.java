package common;



/**
 * @Author jw9j
 * @create 2021/6/10 0:12
 *
 * 常用单链表定义
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
