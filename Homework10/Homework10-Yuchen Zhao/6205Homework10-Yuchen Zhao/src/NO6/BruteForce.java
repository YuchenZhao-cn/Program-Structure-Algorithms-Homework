package NO6;

public class BruteForce {
	String[] Text;
	String[] pattern;
	
	public BruteForce(String Text, String pattern) {
		this.Text = Text.split("");
		this.pattern = pattern.split("");
		run();
	}
	
	private void run() {
		for(int i = 0; i < Text.length - pattern.length; i++) {
			for(int j = 0; j <= pattern.length; j++) {
				if(j == pattern.length) {
					System.out.println(i);
					break;
				}
				else if(!Text[i + j].equals(pattern[j])) break;
			}
		}
	}
	
	public static void main(String[] args) {
		String Text = "ABCADBABCBABABCDABCDABDE";
		String pattern = "BAB";
		new BruteForce(Text, pattern);
	}
}
