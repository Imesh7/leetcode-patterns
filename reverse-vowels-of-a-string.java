// Brute force solution
class Solution {
    public String reverseVowels(String s) {
        int n = s.length();
        Stack<Character> queue = new Stack<>();
        Set<Character> set = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A','E','I','O','U'));

        String res = "";

        for(int i = 0; i < n; i++){
            if(isVowel(s.charAt(i), set)){
                queue.push(s.charAt(i));
            }
        }

        for(int i = 0; i < n; i++){
            if(isVowel(s.charAt(i), set)){
               Character val = queue.pop();
                res += val;
            } else {
                res += s.charAt(i);
            }
        }
        return res;
    }

    boolean isVowel(char ch, Set<Character> set){
      return set.contains(ch);
    }
}


//Optimal solution
class Solution {
    public String reverseVowels(String s) {
        char[] ch = s.toCharArray();
        Set<Character> set = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A','E','I','O','U'));
        int start = 0;
        int end = s.length()-1;

        while(start < end){
            while(start < end && !isVowel(s.charAt(start), set)){
                start++;
            }

            while(end > start && !isVowel(s.charAt(end), set)){
                end--;
            }

            char temp = ch[end];
            ch[end] = ch[start];
            ch[start] = temp;
          
            start++;
            end--;
        }

        return String.valueOf(ch);
    }

    boolean isVowel(char ch, Set<Character> set){
      return set.contains(ch);
    }
}

