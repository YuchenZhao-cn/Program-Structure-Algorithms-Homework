package NO6;

public class RabinKarp {
	
	private final int d = 10;

	public RabinKarp(String text, String pattern, int q) {
		int M = pattern.length();
		int N = text.length();
		int p = 0, t = 0;
		int h = 1;
		int j;
		
		for(int i = 0; i < M - 1; i++) {
			h = (h * d) % q;
		}
		
		for(int i = 0; i < M; i++) {
			p = (p * d + pattern.charAt(i)) % q;
			t = (t * d + text.charAt(i)) % q;
		}
		
		for(int i = 0; i < N - M; i++) {
			if(p == t) {
				for(j = 0; j < M; j++) {
					if(text.charAt(i + j) != pattern.charAt(j)) break;
				}
				if(j == M) System.out.println(i);
			}
			t = ((t - text.charAt(i) * h) * d + text.charAt(i + M)) % q;
			if(t < 0) t += q;
		}
	}
	
	public static void main(String[] args) {
		String Text = "ABCADBABCBABABCDABCDABDE";
		String pattern = "BAB";
		new RabinKarp(Text, pattern, 101);
	}

}
