package NO5;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}
	
	// A Tree node
	class Node
	{
		char ch;
		int freq;
		Node left = null, right = null;

		Node(char ch, int freq)
		{
			this.ch = ch;
			this.freq = freq;
		}

		public Node(char ch, int freq, Node left, Node right) {
			this.ch = ch;
			this.freq = freq;
			this.left = left;
			this.right = right;
		}
	}

	static class HuffmanEncoding
	{
		// traverse the Huffman Tree and store Huffman Codes in a map.
		public static void encode(Node root, String str, Map<Character,String> huffmanCode)
		{
			if (root == null)
				return;

			// found a leaf node
			if (root.left == null && root.right == null) {
				huffmanCode.put(root.ch, str);
			}

			encode(root.left, str + '0', huffmanCode);
			encode(root.right, str + '1', huffmanCode);
		}

		// traverse the Huffman Tree and decode the encoded string
		public static int decode(Node root, int index, StringBuilder sb)
		{
			if (root == null)
				return index;

			// found a leaf node
			if (root.left == null && root.right == null)
			{
				System.out.print(root.ch);
				return index;
			}

			index++;

			if (sb.charAt(index) == '0')
				index = decode(root.left, index, sb);
			else
				index = decode(root.right, index, sb);

			return index;
		}

		// Builds Huffman Tree and huffmanCode and decode given input text
		public static void buildHuffmanTree(String text)
		{
			Map<Character, Integer> freq = new HashMap<Character, Integer>();
			// count frequency of appearance of each character and store it in a map
			for (char c: text.toCharArray()) {
				freq.put(c, freq.getOrDefault(c, 0) + 1);
			}

			// Create a priority queue to store live nodes of Huffman tree
			// Notice that highest priority item has lowest frequency
			var pq = new PriorityQueue<Node>(Comparator.comparingInt(l -> l.freq));

			// Create a leaf node for each character and add it
			// to the priority queue.
			Main m = new Main();
			for (var entry : freq.entrySet()) {
				pq.add(m.new Node(entry.getKey(), entry.getValue()));
			}

			// do till there is more than one node in the queue
			while (pq.size() != 1)
			{
				// Remove the two nodes of highest priority
				// (lowest frequency) from the queue
				Node left = pq.poll();
				Node right = pq.poll();

				// Create a new internal node with these two nodes as chil-dren
				// and with frequency equal to the sum of the two nodes
				// frequencies. Add the new node to the priority queue.
				int sum = left.freq + right.freq;
				pq.add(m.new Node('\0', sum, left, right));
			}

			// root stores pointer to root of Huffman Tree
			Node root = pq.peek();

			// traverse the Huffman tree and store the Huffman codes in a map
			Map<Character, String> huffmanCode = new HashMap<>();
			encode(root, "", huffmanCode);

			// print the Huffman codes
			System.out.println("Huffman Codes are : " + huffmanCode);
			System.out.println("Original string was : " + text);

			// print encoded string
			StringBuilder sb = new StringBuilder();
			for (char c: text.toCharArray()) {
				sb.append(huffmanCode.get(c));
			}
			System.out.println("Encoded string is : " + sb);

			// traverse the Huffman Tree again and this time
			// decode the encoded string
			int index = -1;
			System.out.print("Decoded string is: ");
			while (index < sb.length() - 2) {
				index = decode(root, index, sb);
			}
		}

		public static void main(String[] args)
		{
			String text = "Huffman coding is a data compression algorithm.";

			buildHuffmanTree(text);
		}
	}


}
