// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//To create deep copy linked list of original list we make use of hashmap to store the deepcopies of the current node being proceesed in the original list
//We mainatin two pointers pointing to original list and deep copy list 
//As and when we traverse through the original nodes next we check if its deep copy created if not we create one and point the next and random pointer in deep copy list

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node copyNode = new Node(head.val);
        HashMap<Node, Node> map = new HashMap<>();
        map.put(head, copyNode);
        Node cur = head;
        Node copyCur = copyNode;
        while(cur != null) {
            copyCur.next = clone(cur.next, map);
            copyCur.random = clone(cur.random, map);
            cur = cur.next;
            copyCur = copyCur.next;
        }

        return copyNode;
    }

    private Node clone(Node node, HashMap<Node, Node> map) {
        if(node == null) return null;
        if(map.containsKey(node)) return map.get(node);
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        return newNode;
    }
}
