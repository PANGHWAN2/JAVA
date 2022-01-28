package algorismProject2;

import java.util.Comparator;
import java.util.Scanner;

public class algorismProject2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		algorismProject2 ap = new algorismProject2();
		ap.startOfDataManagement();
	}

	public void startOfDataManagement() {
		BinTree<Integer, Data> tree = new BinTree<Integer, Data>();
		Data data;
		Data ptr;

		String menu = "(1) 상품등록 (2) 상품삭제 (3) 상품검색 (4) 전체 상품 조회 (5) 종료 ";
		Scanner scan = new Scanner(System.in);
		Data temp = new Data(scan);
		boolean flag = false;
		while (!flag) {
			System.out.println(menu);
			System.out.print("메뉴 선택 : ");
			int choice = scan.nextInt();

			switch (choice) {
			case 1:
				System.out.println();
				System.out.println("상품 등록");
				data = new Data(scan);
				data.scanData("삽입", Data.NO | Data.NAME);
				tree.add(data.keyCode(), data);
				break;
			case 2:
				System.out.println();
				System.out.println("상품 삭제");
				temp.scanData("삭제", Data.NO);
				tree.remove(temp.keyCode());
				System.out.println("상품 삭제 완료");
				System.out.println();
				break;
			case 3:
				System.out.println();
				System.out.println("상품 검색");
				temp.scanData("검색", Data.NO);
				
				ptr = tree.search(temp.keyCode());
				
				System.out.println("상품명 : " + ptr);
				System.out.println();
				break;
			case 4:	
				tree.print();
				System.out.println();
				break;
			case 5:
				System.out.println("종료합니다.");
				flag = true;
			}
		}
		scan.close();
	}
	public class BinTree<K, V> {
		static class Node<K, V> {
			private K key;
			private V data;
			private Node<K, V> left;
			private Node<K, V> right;
			// 생성자
			Node(K key, V data, Node<K, V> left, Node<K, V> right) {
				this.key = key;
				this.data = data;
				this.left = left;
				this.right = right;
			}

			K getKey() {
				return key;
			}

			V getValue() {
				return data;
			}
			void print() {
				System.out.println(data);
			}
		}

		private Node<K, V> root;
		private Comparator<? super K> comparator = null;

		public BinTree() {
			root = null;
		}

		public BinTree(Comparator<? super K> c) {
			this();
			comparator = c;
		}

		private int comp(K key1, K key2) {
			return (comparator == null) ? ((Comparable<K>) key1).compareTo(key2) : comparator.compare(key1, key2);
			}

		public V search(K key) {
			Node<K, V> p = root;

			while (true) {
				if (p == null)
					return null;
				int cond = comp(key, p.getKey());
				if (cond == 0)
					return p.getValue();
				else if (cond < 0)
					p = p.left;
				else
					p = p.right;
			}

		}

		private void addNode(Node<K, V> node, K key, V data) {
			int cond = comp(key, node.getKey());
			if (cond == 0)
				return;
			else if (cond < 0) {
				if (node.left == null)
					node.left = new Node<K, V>(key, data, null, null);
				else
					addNode(node.left, key, data);
			} else {
				if (node.right == null)
					node.right = new Node<K, V>(key, data, null, null);
				else
					addNode(node.right, key, data);
			}
		}

		public void add(K key, V data) {
			if (root == null)
				root = new Node<K, V>(key, data, null, null);
			else
				addNode(root, key, data);
		}
		public boolean remove(K key) {
			Node<K, V> p = root;
			Node<K, V> parent = null;
			boolean isLeftChild = true;

			while (true) {
				if (p == null) 
					return false; 
				int cond = comp(key, p.getKey()); 
				if (cond == 0) 
					break;
				else {
					parent = p; 
					if (cond < 0) {
						isLeftChild = true; 
						p = p.left; 
					} else {
						isLeftChild = false; 
						p = p.right;
					}
				}
			}

			if (p.left == null) { 
				if (p == root)
					root = p.right;
				else if (isLeftChild)
					parent.left = p.right;
				else
					parent.right = p.right; 
			} else if (p.right == null) { 
				if (p == root)
					root = p.left;
				else if (isLeftChild)
					parent.left = p.left;
				else
					parent.right = p.left; 
			} else {
				parent = p;
				Node<K, V> left = p.left;
				isLeftChild = true;
				while (left.right != null) { 
					parent = left;
					left = left.right;
					isLeftChild = false;
				}
				p.key = left.key; 
				p.data = left.data; 
				if (isLeftChild)
					parent.left = left.left; 
				else
					parent.right = left.left; 
			}
			return true;
		}


		private void printSubTree(Node node) {
			if (node != null) {
				printSubTree(node.left); 
				System.out.println(node.key + " " + node.data); 
				printSubTree(node.right); 
			}
		}
		public void print() {
			if(root == null) {
				System.out.println();
				System.out.println("등록된 상품이 없습니다.");
			}
			printSubTree(root);
			
		}
	}

	public class Data {
		public static final int NO = 1; 
		public static final int NAME = 2; 

		private Integer no; 
		private String name; 
		private Scanner stdIn;

		public Data(Scanner stdIn) {
			this.stdIn = stdIn;
		}

		Integer keyCode() {
			return no;
		}

		public String toString() {
			return name;
		}

		void scanData(String guide, int sw) {

			if ((sw & NO) == NO) {
				System.out.print("상품 번호 입력：");
				no = stdIn.nextInt();
			}
			if ((sw & NAME) == NAME) {
				System.out.print("상품명 입력：");
				name = stdIn.next();
				System.out.println();
			}
		}
	}
}
