class Solution
{
    public List<Long> countSentences(List<String> wordSet, List<String> sentences)
    {
        List<Long> result = new ArrayList<>();
        HashMap<String, Integer> anaCount = new HashMap<>();
        for(String s : wordSet)
        {
            char[] freq = new char[26];
            for(char c : s.toCharArray())
                freq[c - 'a']++;
            String key = String.valueOf(freq);
            anaCount.put(key, anaCount.getOrDefault(key, 0) + 1);
            
        }

        for(String s : sentences)
        {
            int count = 1;

            String[] words = sentences.split(" ");
            for(String w : words)
            {
                char[] freq = new char[26];
                for(char w : w.toCharArray())
                    freq[w - 'a']++;
                String key = String.valueOf(freq);
                if(anacount.get() > 1)
                    count *= anaCount.get(key);
            }
        }

        result.add(count);
    }

    return result;
}