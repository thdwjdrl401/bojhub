import java.io.*;
import java.util.*;

public class Main {
	
	static int N, x, y;
	static Point[] points;
	static StringBuilder sb = new StringBuilder();
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        points = new Point[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());			
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i] = new Point(x, y);
		}
        
        int baseIndex = 0;
        for (int i = 1; i < N; i++) {
        	Point tmp = points[baseIndex];
        	if(tmp.y > points[i].y || (tmp.y == points[i].y && tmp.x > points[i].x)) {
        		baseIndex = i;
        	}
		}
        Point tmp = points[baseIndex];
        points[baseIndex] = points[0];
        points[0] = tmp;
        Point base = points[0];
        
        Arrays.sort(points, 1, N, new Comparator<Point>() {
        	@Override
        	public int compare(Point a, Point b) {
        		long ccw = ccw(base, a, b);
        		
        		if(ccw > 0) return -1;
        		if(ccw < 0) return 1;
        		return Long.compare(distSquare(base, a), distSquare(base, b));
        	}
        });
        Stack<Point> stack = new Stack<>();
        stack.push(points[0]);
        stack.push(points[1]);
        for (int i = 2; i < N; i++) {
			while(stack.size() >= 2) {
				Point first = stack.get(stack.size() - 1);
				Point second = stack.get(stack.size() - 2);
				if(ccw(second, first, points[i]) > 0) break;
				stack.pop();
			}
			stack.push(points[i]);
		}
        System.out.println(stack.size());
        
    }
    
    static Long distSquare(Point a, Point b) {
    	long dx = a.x - b.x;
    	long dy = a.y - b.y;
    	return dx * dx + dy * dy; 
    }
    
    static long ccw(Point a, Point b, Point c) {
    	return (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
    }
    
    static class Point{
    	long x, y;
    	Point(){};
    	Point(long x, long y){
    		this.x = x;
    		this.y = y;
    	}
    }
}
