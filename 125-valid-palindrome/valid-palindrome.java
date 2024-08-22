class Solution {
    public boolean isPalindrome(String s) {
        int st = 0;
        int end = s.length()-1;
        while(st <= end){
          char currFirst = s.charAt(st);
          char currlast = s.charAt(end);
          if(!Character.isLetterOrDigit(currFirst)){
            st++;
          }else if(!Character.isLetterOrDigit(currlast)){
            end--;
          }
          else{
            if(Character.toLowerCase(currFirst) != Character.toLowerCase(currlast)){
                return false;
            }
            st++;
            end--;
          }
        }
        return true;
    }
}