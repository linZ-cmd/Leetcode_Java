import java.util.Map;

/*
 * @lc app=leetcode id=288 lang=java
 *
 * [288] Unique Word Abbreviation
 *
 * https://leetcode.com/problems/unique-word-abbreviation/description/
 *
 * algorithms
 * Medium (20.34%)
 * Likes:    75
 * Dislikes: 985
 * Total Accepted:    44K
 * Total Submissions: 215K
 * Testcase Example:  '["ValidWordAbbr","isUnique","isUnique","isUnique","isUnique"]\n[[["deer","door","cake","card"]],["dear"],["cart"],["cane"],["make"]]'
 *
 * An abbreviation of a word follows the form <first letter><number><last
 * letter>. Below are some examples of word abbreviations:
 * 
 * 
 * a) it                      --> it    (no abbreviation)
 * 
 * ⁠    1
 * ⁠    ↓
 * b) d|o|g                   --> d1g
 * 
 * ⁠             1    1  1
 * ⁠    1---5----0----5--8
 * ⁠    ↓   ↓    ↓    ↓  ↓    
 * c) i|nternationalizatio|n  --> i18n
 * 
 * ⁠             1
 * ⁠    1---5----0
 * ↓   ↓    ↓
 * d) l|ocalizatio|n          --> l10n
 * 
 * 
 * Assume you have a dictionary and given a word, find whether its abbreviation
 * is unique in the dictionary. A word's abbreviation is unique if no other
 * word from the dictionary has the same abbreviation.
 * 
 * Example:
 * 
 * 
 * Given dictionary = [ "deer", "door", "cake", "card" ]
 * 
 * isUnique("dear") -> false
 * isUnique("cart") -> true
 * isUnique("cane") -> false
 * isUnique("make") -> true
 * 
 * 
 */
class ValidWordAbbr {
    Map<String, String> map;
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
         for (String str : dictionary) {
            String abbStr = str.length() <=2 ? str : str.charAt(0) + Integer.toString(str.length()-2) + str.charAt(str.length()-1);
            if (map.keySet().contains(abbStr)) {
                if (!map.get(abbStr).equals(str)) {
                    map.put(abbStr, "");
                }
            } else map.put(abbStr, str);
         }
    }
    
    public boolean isUnique(String word) {
        String abbStr = word.length() <=2 ? word : word.charAt(0) + Integer.toString(word.length()-2) + word.charAt(word.length()-1);
        return !map.keySet().contains(abbStr) || map.get(abbStr).equals(word);
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */

