import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] inOrder, preOrder, postOrder, inOrderIndex;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        inOrder = new int[n];
        inOrderIndex = new int[n + 1];
        preOrder = new int[n];
        postOrder = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
			inOrder[i] = Integer.parseInt(st.nextToken());
			inOrderIndex[inOrder[i]] = i;
		}
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
			postOrder[i] = Integer.parseInt(st.nextToken());
		}
        cycle(0, n - 1, 0, n - 1);
        System.out.println(sb);
    }
    
    static void cycle(int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) return;
    	int rootNode = postOrder[postEnd];
    	int index = inOrderIndex[rootNode];
    	sb.append(rootNode).append(" ");
        int leftSize = index - inStart;
        // 왼쪽 서브트리
        cycle(inStart, index - 1, postStart, postStart + leftSize - 1);
        // 오른쪽 서브트리
        cycle(index + 1, inEnd, postStart + leftSize, postEnd - 1);
    }
}








