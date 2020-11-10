package NO03;

public class KeyIndexedCounting {

	public KeyIndexedCounting() {
		// TODO Auto-generated constructor stub
	}
	
	public void sort(String[] str) {
		int[] count = new int[7];
		int[] copy = new int[str.length];
		int[] aux = new int[str.length];
		for(int i = 0; i < str.length; i++) {
			switch (str[i]) {
			case "A": copy[i] = 0; break;
			case "B": copy[i] = 1; break;
			case "C": copy[i] = 2; break;
			case "D": copy[i] = 3; break;
			case "E": copy[i] = 4; break;
			case "F": copy[i] = 5; break;
			}
		}
		
		for(int i = 0; i < str.length; i++) {
			count[copy[i] + 1]++;
		}
		
		System.out.print("count[]: ");
		for(var c : count) {
			System.out.print(c + " ");
		}
		System.out.println();
		
		for(int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}
		
		System.out.print("count[]: ");
		for(var c : count) {
			System.out.print(c + " ");
		}
		System.out.println();
		
		for(int i = 0; i < str.length; i++) {
			aux[count[copy[i]]++] = copy[i];
		}

		System.out.print("count[]: ");
		for(var c : count) {
			System.out.print(c + " ");
		}
		System.out.println();
		
		for(int i = 0; i < str.length; i++) {
			switch (aux[i]){
			case 0: str[i] = "A"; break;
			case 1: str[i] = "B"; break;
			case 2: str[i] = "C"; break;
			case 3: str[i] = "D"; break;
			case 4: str[i] = "E"; break;
			case 5: str[i] = "F"; break;
			}
		}
	}
	
	public static void main(String[] args) {
		KeyIndexedCounting kic = new KeyIndexedCounting();
		String mystr = "ABDCEDDFFCABEEECCEFDDAAF";
		String[] mystr1 = mystr.split("");
		kic.sort(mystr1);
		for(var c : mystr1) System.out.print(c + " ");
	}

}
