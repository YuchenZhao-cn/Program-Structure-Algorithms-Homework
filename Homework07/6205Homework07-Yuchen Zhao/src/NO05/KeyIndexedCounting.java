package NO05;

public class KeyIndexedCounting {
	
	people[] p;

	public KeyIndexedCounting() {
		// TODO Auto-generated constructor stub
	}
	
	private class people {
		String name;
		int section;
		private people(String name, int section) {
			this.name = name;
			this.section = section;
		}
	}
	
	public void sort(String[] name, int[] section) {
		p = new people[name.length];
		for(int i = 0; i < name.length; i++) {
			p[i] = new people(name[i], section[i]);
		}
		
		int[] count = new int[5];
		people[] aux = new people[p.length];
		
		for(int i = 0; i < p.length; i++) {
			count[p[i].section]++;
		}
		
		System.out.print("count[]: ");
		for(var c : count) {
			System.out.print(c + " ");
		}
		System.out.println();
		
		for(int i = 0; i < 4; i++) {
			count[i + 1] += count[i];
		}
		
		System.out.print("count[]: ");
		for(var c : count) {
			System.out.print(c + " ");
		}
		System.out.println();
		
		for(int i = 0; i < p.length; i++) {
			aux[count[p[i].section - 1]++] = p[i];
		}
		
		System.out.print("count[]: ");
		for(var c : count) {
			System.out.print(c + " ");
		}
		System.out.println();
		
		for(int i = 0; i < p.length; i++) {
			name[i] = aux[i].name;
			section[i] = aux[i].section;
		}
	}
	
	public static void main(String[] args) {
		String[] name = {"Anderson", "Brown", "Davis", "Garcia", "Harris", "Jackson", "Johnson", "Jones", "Martin", "Martinez", "Miller", "Moore", "Robinson", 
				"Smith", "Taylor", "Thomas", "Thompson", "White", "Williams", "Wilson"};
		int[] section = {2, 3, 3, 4, 1, 3, 4, 3, 1, 2, 2, 1, 2, 4, 3, 4, 4, 2, 3, 4};
		KeyIndexedCounting kic = new KeyIndexedCounting();
		kic.sort(name, section);
		for(int i = 0; i < name.length; i++) {
			System.out.println(section[i] + " " + name[i]);
		}
	}
}
