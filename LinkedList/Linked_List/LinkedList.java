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
        if (head == null)  
        {
           head = new Node(data);
           return;
        }
        Node current = head;
        while(current.next != null)
        {
            current = current.next;
        }
        current.next = new Node(data);
    }

    public void delete(int data)
    {
        if (head == null) return;
        if(head.value == data) 
        {
            head = head.next;
            return;
        }
        Node current = head;
        while(current.next != null )
        {
            if(current.next.value == data)
            {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }

    }

    public void display()
    {   
        Node curr = head;
        int count = 1;
        while(curr != null)
        {
            
            System.out.println("Node"+count+": "+curr.value);
            count += 1;
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

