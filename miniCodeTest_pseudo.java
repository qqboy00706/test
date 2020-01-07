//Pseudo code, not compilable, to show the steps only.I do not have the Java environment near me.
class Solution {
    private Map<String, String> lettermap = new HashMap<String,String>();
    private Map<String, String> resultmap = new HashMap<String,String>();
    public List<String> letterCombinations(int[] digits) {
	//check if empty array
        if (digits.length == 0)
        {
            return Collections.emptyList();
        }
	//convert int[] to String
	StringBuffer sb = new StringBuffer();
	for(int i=0;i<digits.length;i++)
	{
	   sb.append(digits[i]+"");
	}
	String digitstring = sb.toString();
	//
        char[] digitchars = digitstring.toCharArray();
        List<Character> digitArray = new ArrayList<Character>();
	//remove 0s and 1s through iteration
        for (int i = 0; i< digitchars.length;i++)
        {
            if (digitchars[i]=='0' || digitchars [i] == '1')
            {
                continue;
            }
            else
            {
                digitArray.add(digitchars[i]);
            }
        }
	//check length again
        if (digitArray.size() == 0)
        {
            return Collections.emptyList();
        }
        lettermap.put("2","abc");
        lettermap.put("3","def");
        lettermap.put("4","ghi");
        lettermap.put("5","jkl");
        lettermap.put("6","mno");
        lettermap.put("7","pqrs");
        lettermap.put("8","tuv");
        lettermap.put("9","wxyz");
	//build string from arraylist
        StringBuilder digitstr = new StringBuilder();
        for (Character character : digitArray) 
        {
            digitstr.append(character);
        }
        return recur(digitstr.toString());
    }
    //recursive method
    public List<String> recur (String digits)
    {
        List<String> result = new ArrayList<String>();
	//basic step
        if (digits.length() == 1)
        {
            int maplength = lettermap.get(digits).length();
            for (int i = 0; i<maplength-1;i++)
            {
                result.add(lettermap.get(digits).substring(i,i+1));
            }
            result.add(lettermap.get(digits).substring(maplength-1));
            return result;
        }
	//recursive step
        else
        {
            List<String> rest = recur (digits.substring(1));
            String head = lettermap.get(digits.substring(0,1));
            char[] charhead = head.toCharArray();
	    //combined the letters mapped to the first digit to the rest of the results
            for (int i = 0; i < charhead.length;i++)
            {
                for (int j = 0; j < rest.size();j++)
                {
                    result.add(String.valueOf(charhead[i]) +""+ rest.get(j));
                }
            }
            return result;
        }
    }
}


#------------Test case 1---------------
#input []
#expect output []


#------------Test case 2---------------
#input [0]
#expect output []


#------------Test case 3---------------
#input [1,0]
#expect output []

#------------Test case 4---------------
#input [2]
#expect output ["a","b","c"]

#------------Test case 5---------------
#input [1,2,3]
#expect output ["ad","ae","af","bd","be","bf","cd","ce","cf"]

#------------Test case 6---------------
#input [1,0,0,0,2,1,0,1,1,1,1,1,1,3,0,0,1,1]
#expect output ["ad","ae","af","bd","be","bf","cd","ce","cf"]



#step 2
#almost the same,transfer int[] to String
#for example input [1,22,99,10,7,56,81], first convert to string "122991075681",then remove 0s and 1s and call the "recur" method