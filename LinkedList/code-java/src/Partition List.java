/*
Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

 

Example 1:


Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]
Example 2:

Input: head = [2,1], x = 2
Output: [1,2]
 

Constraints:

The number of nodes in the list is in the range [0, 200].
-100 <= Node.val <= 100
-200 <= x <= 200
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode curr1=null; //current node for LinkedList having value less than x
        ListNode head1=null; //head of LinkedList having value less than x
        
        ListNode curr2=null; //current node for LinkedList having value greater than or equal to x
        ListNode head2=null; //head of LinkedList having value greater than or equal to x
        
        //current node of the given LinkedList
        ListNode curr=head;
        
        if(head==null)
            return null;
        
        if(head.next==null)
            return head;
        
        while(curr!=null){
            if(curr.val<x){
                //if first time node having value less than x is encountered
                if(curr1==null){
                    head1=curr;
                    curr1=head1;
                } else {
                    //joining the already encountered node having value less than x to its next node having value less than x
                    curr1.next=curr;
                    curr1=curr1.next;
                }
            } else {
                //if first time node having value greater than or equal to x is encountered
                if(curr2==null){
                    head2=curr;
                    curr2=head2;
                } else {
                    //joining the already encountered node having value greater than or equal to x to its next node having value greater than or equal to x
                    curr2.next=curr;
                    curr2=curr2.next;
                }
            }
            curr=curr.next;
        }
        //if no node is found with value less than x then return head2
        if(curr1==null)
            return head2;
        //if no node is found with value greater than or equal to x then return head1
        if(curr2==null)
            return head1;

        //join the last node of head1 with head2
        curr1.next=head2;
        //clear the next node of the last node of head2
        curr2.next=null;

        return head1;
    }
}

//Time Complexity -> O(n)
//Space Complexity -> O(1)
