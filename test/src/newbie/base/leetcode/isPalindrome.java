package newbie.base.leetcode;

public class isPalindrome {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        String temp = "1234567890QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm";
        StringBuffer sb = new StringBuffer();

        for( int i=0; i<s.length(); i++){
            if(temp.contains(String.valueOf(s.charAt(i))) ) {
                sb.append(s.charAt(i));
            }
        }

        if (sb.length() <= 0) {
            return true;
        }

        String newString = sb.toString();

        int begin = 0, end = newString.length() - 1;
        char a, b;
        while(begin < end){
            if(String.valueOf(newString.charAt(begin)).equalsIgnoreCase(String.valueOf(newString.charAt(end)))){
                begin++;
                end--;
            }else{
                return false;
            }
        }
        return true;
    }

}
