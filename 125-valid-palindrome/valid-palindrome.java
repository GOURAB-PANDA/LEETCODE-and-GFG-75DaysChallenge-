class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {//ensuring array is not empty or contains null.
            return true; 
        }

        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
           
            while (start < end && !Character.isLetterOrDigit(s.charAt(start))) {//moving start until alphanumeric char found.
                start++;
            }
            
            while (start < end && !Character.isLetterOrDigit(s.charAt(end))) {//moving end for same as above.
                end--;
            }
            //using two-pointer method to find if character at start is equals to end. If not returning false.
            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;

        /*less efficient method
        //  if (s == null || s.isEmpty()) {
        //     return true; // An empty string is considered a palindrome.
        // }

        // String t = s.toLowerCase().replaceAll("[^a-zA-Z0-9]","");//the "^" works as negation and the statement means: if the element is not from the range in [], replace it with empty string.

        // int start =0;
        // int end = t.length()-1;

        // while(start < end){//after removing alphanumeric cases if the array is empty, this will not be triggered.
        //     if(t.charAt(start) == t.charAt(end)){
        //         start++;
        //         end--;
        //     }else{
        //         return false;
        //     }
        // }
        // return true;
        */
    }
}