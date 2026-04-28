class Solution {
    public String solution(int[] food) {
        int[] reverseArray = new int[food.length];
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < food.length; i++){
            int count = food[i];
            reverseArray[i] = count / 2;
            for(int j = 0; j < count / 2; j++) sb.append(i);
        }
        sb.append("0");
        for(int i = reverseArray.length - 1; i > 0; i--){
            int count = reverseArray[i];
            for(int j = 0; j < count; j++) sb.append(i);
        }
        return sb.toString();
    }
}