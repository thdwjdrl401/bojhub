import java.util.*;

class Solution {
    
    class Obj{
        String genre;
        int sum;
        
        @Override
        public String toString(){
            return genre + " " + sum;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        Map<String, PriorityQueue<int[]>> pqMap = new HashMap<>();
        List<Obj> listForSort = new ArrayList<>();
        Map<String, Integer> indexMap = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++){
            String curG = genres[i];
            int curP = plays[i];
            if(indexMap.containsKey(curG)){
                int idx = indexMap.get(curG);
                Obj curO = listForSort.get(idx);
                curO.sum += curP;
                pqMap.get(curG).offer(new int[]{i, curP});
            } else{
                indexMap.put(curG, listForSort.size());
                Obj curO = new Obj();
                curO.genre = curG;
                curO.sum = curP;
                listForSort.add(curO);
                pqMap.put(curG, new PriorityQueue<int[]>(new Comparator<int[]>(){
                    @Override
                    public int compare(int[] a, int[] b){
                        int result = Integer.compare(b[1], a[1]);
                        if(result == 0) return Integer.compare(a[0], b[0]);
                        return result;
                    }
                }));
                pqMap.get(curG).offer(new int[]{i, curP});
            }
        }
        listForSort.sort(new Comparator<Obj>(){
            @Override
            public int compare(Obj a, Obj b){
                return Integer.compare(b.sum, a.sum);
            }
        });
        
        
        List<Integer> list = new ArrayList<>();
        for(Obj o : listForSort){
            PriorityQueue<int[]> curPQ = pqMap.get(o.genre);
            if(!curPQ.isEmpty()) list.add(curPQ.poll()[0]);
            if(!curPQ.isEmpty()) list.add(curPQ.poll()[0]);
        }
        int[] resultArr = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            resultArr[i] = list.get(i);
        }
        
        return resultArr;
    }
}