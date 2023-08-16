import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static Node head = new Node('A', null, null);

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char data = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);

			makeNode(head, data, left, right);
		}

		preOrder(head);
		System.out.println();
		inOrder(head);
		System.out.println();
		postOrder(head);
	}

	static class Node {
		char data;
		Node left;
		Node right;

		Node(char data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	static void makeNode(Node node, char data, char left, char right) {
		if (node.data == data) {
			if (left == '.') { node.left = null; }
			else {
				node.left = new Node(left, null, null);
			}
			if (right == '.') { node.right = null; }
			else {
				node.right = new Node(right, null, null);
			}
		} else {
			if (node.left != null) { makeNode(node.left, data, left, right); }
			if (node.right != null) { makeNode(node.right, data, left, right); }
		}
	}

	static void preOrder(Node node) {
		if (node == null) return;
		System.out.print(node.data);
		preOrder(node.left);
		preOrder(node.right);
	}

	static void inOrder(Node node) {
		if (node == null) return;
		inOrder(node.left);
		System.out.print(node.data);
		inOrder(node.right);
	}

	static void postOrder(Node node) {
		if (node == null) return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data);
	}
}