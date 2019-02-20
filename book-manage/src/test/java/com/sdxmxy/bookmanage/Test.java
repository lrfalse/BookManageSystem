package com.sdxmxy.bookmanage;

import org.codehaus.groovy.runtime.powerassert.SourceText;

public class Test {

    @org.junit.Test
    public void test(){
        Integer a=0;
        for (int i = 2; i <= 100; i++) {
           int j=2;
            while(i%j!=0){
                j++;
            }
            if(j==i){
                System.out.println(i);
            }
        }

    }




 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
  }
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head==null)
            return head;
        ListNode res = new ListNode(head.val);
        ListNode left = head.next;
        while ((left!=null)){
            ListNode cur = left;
            left = left.next;
            //比较头
            if(cur.val <= res.val){
                cur.next = res;
                res = cur;
                continue;
            }
            //在res中寻找插入点
            ListNode p = res;
            ListNode last = p;
            while (p!=null&&p.val<cur.val){
                last = p;
                p = p.next;
            }
            last.next = cur;
            last.next.next = p;
        }
        return res;
    }
}



}
