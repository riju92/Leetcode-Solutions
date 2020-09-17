/* Sawtooth Sequence */

class sawToothSeq
{
    public int getSawToothCount(int[] arr)
    {
        int count = 0;
        

        for(int i = 0; i < arr.length - 1; i++)
        {
            boolean up = false;
            boolean down = false;

            for(int j = i + 1; j < arr.length; j++)
            {
                if(arr[j - 1] == arr[j])
                    continue;
                else if(!up && !down)
                {
                    if(arr[j - 1] < arr[j])
                        up = !up;
                    else
                        down = !down;
                    count++;
                }
                else if(up)
                {
                    if(arr[j - 1] > arr[j])
                    {  
                        up = !up;
                        down = !down;
                        count++;
                    }
                    else
                        break;
                }
                else if (down)
                {
                    if(arr[j - 1] < arr[j])
                    {
                        up = !up;
                        down = !down;
                        count++;
                    }
                    else
                        break;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        
        sawToothSeq obj = new sawToothSeq();
        int[] arr = {9,8,7,6,5};
        int count = obj.getSawToothCount(arr);
        System.out.println(count);
    }
}