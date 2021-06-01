 import java.util.*;
//Using HashMap with O(NM) Solution
public class FindAnagrams {
    //"cat", "dog", "tac", "god", "act" 
	private static void printAnagrams(String arr[])	{  
 // key will be sorted word and values will be list of word having same characters
		HashMap<String, List<String> > map = new HashMap<>();

		// loop over all words
		for (int i = 0; i < arr.length; i++) {//arrlength=5

			// convert to char array, sort and
			// then re-convert to string
			String word = arr[i]; //1.word="cat" 2."dog"
			char[] letters = word.toCharArray();//['c','a','t']
			Arrays.sort(letters);//['a','c','t']
			String newWord = new String(letters);//1.newWord=act 2.newWord=dgo

			// calculate hashcode of string
			// after sorting
			if (map.containsKey(newWord)) {//first time it will be false
           //3.map contains word "act" so stored "tac"
           //4.map contains word "dgo" so stored "god" in list
           //5.map contains word "act" so stored "act" in list
              // so we have 3 values for key "act" in list ["cat","tac","act"]
              // and 2 values for key "dgo" in list ["dog","god"]
				map.get(newWord).add(word); 
			}
			else {//ist time only else will execute

				// This is the first time we are
				// adding a word for a specific
				// hashcode
				List<String> words = new ArrayList<>();
				words.add(word);//added original word at index i
               //words.add("cat")
               //words.add("dog")
		      map.put(newWord, words);
              //1.put sorted word "act" as key and value as "cat"
              //2.put sorted word "dgo" as key and value as "dog"
              //similarly
              
			}
		}

		// print all the values where size is > 1
		// If you want to print non-anagrams,
		// just print the values having size = 1
        // there is only 2 key value pair in map  {"act": "cat","tac","act"} and //{"dgo" : "dog","god"}
		for (String s : map.keySet()) {
			List<String> values = map.get(s);
			if (values.size() > 1) {
				System.out.print(values);
			}
		}
	}

	public static void main(String[] args)
	{

		// Driver program
		String arr[] = { "cat", "dog", "tac", "god", "act" };
		printAnagrams(arr);
	}
}

