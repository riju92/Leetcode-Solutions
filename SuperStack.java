import java.util.*;

/*
Implement a stack that aaccepts the following commands and performs the operations described:

1. push v: Push integer v onto the top of the stack
2. pop: Pop the top element from the stack
3. inc i v: Add v to each of the bottom i elements of the stack

After each operation, print the value at the top of the stack. If the stack is empty, print "Empty"

I/P: operations = ['push 4', 'push 5', 'inc 2 1', 'pop', 'pop']
O/P: 4,5,6,5,EMPTY
*/

class SuperStack
{
    public void superStack(String[] operations)
    {
        HashMap<Integer, int[]> map = new HashMap<>();
        int top = 0;

        for(String operation : operations)
        {
            String[] ops = operation.split("\\s+");

            if(ops[0].equals("push"))
            {
                int[] temp = new int[2];
                int value = Integer.parseInt(ops[1]);

                top++;

                temp[0] = value;
                temp[1] = 0;
                map.put(top, temp);
            }
            else if(ops[0].equals("pop"))
            {
                if(top > 1)
                {
                    int[] temp = map.get(top - 1);
                    int value = temp[1] + map.get(top)[1];
                    temp[1] = value;
                    map.put(top - 1, temp);
                }
                map.remove(top);
                top--;
            }
            else if(ops[0].equals("inc"))
            {
                int i = Integer.parseInt(ops[1]);
                int v = Integer.parseInt(ops[2]);

                int[] temp = map.get(i);
                temp[1] += v;
                map.put(i, temp);

            }

            if(top != 0)
                System.out.println(map.get(top)[0] + map.get(top)[1]);
            else
                System.out.println("Baal Chirecho");
        }
    }

    public static void main(String[] args) {
        
        SuperStack obj = new SuperStack();

        String[] input = {"push 4", "push 5", "inc 2 1", "pop", "pop"};

        obj.superStack(input);
    }
}


