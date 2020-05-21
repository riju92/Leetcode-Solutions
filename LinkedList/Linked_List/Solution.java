class Node
{
    Node next;
    int value;
    public Node(int value)
    {
        this.value = value;
    }
}

public class LinkedList
{
    Node head;

    public void append(int data)
    {
        if (head == null) head = new Node(data);
        Node current = head;
        while(current.next != null)
        {
            current = current.next;
        }
        current.next = new Node(data);
    }

    public void delete(int data)
    {
        if(head.value == data)
        {
            head = head.next;
            return;
        }
        Node current = head;
        while(current.next != null)
        {
            if(current.value == data)
            {
                current = current.next.next;
            }
        }
    }

    public void display()
    {   
        Node curr = head;
        while(curr.next != null)
        {
            int count = 0;
            System.out.println("Node"+(count+1)+": "+curr.value);
            curr = curr.next;
        }
    }

    public static void main(String[] args)
    {
        //Node head = new Node();
        LinkedList l1 = new LinkedList();   
        l1.append(23);
        l1.append(32);
        l1.append(56);
        l1.append(37);
        l1.append(55);
        l1.append(21);
        l1.display();
        l1.delete(21);
        l1.display();
    }
}

