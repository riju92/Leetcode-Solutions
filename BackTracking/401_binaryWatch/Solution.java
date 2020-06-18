/*
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).

Each LED represents a zero or one, with the least significant bit on the right.
*/

class Solution
{
	public List<String> readBinaryWatch(int num)
	{
		List<String> result = new ArrayList<>();

		for(int h = 0; h < 12; h++)
		{
			for(int min = 0; min < 60; min++)
			{
				if(Integer.bitCount(h) + Integer.bitCount(min) == num)
					result.add(String.format("%d:%02d", h, min));
			}
		}
		return result;
	}
}
