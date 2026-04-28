class Solution {
    public String solution(String phone_number) {
        int length = phone_number.length();
        String sub = phone_number.substring(length - 4, length);
        StringBuilder sb = new StringBuilder(length);
        for(int i = 0; i < length - 4; i++) sb.append("*");
        sb.append(sub);
        return sb.toString();
    }
}