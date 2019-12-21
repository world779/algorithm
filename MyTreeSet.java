//*　今回は、下記で作ったbという集合を選んだ  b = {0,1,3,5,6,8,9,10}

//*root によって参照されるNode オブジェクトをnode1、
//*root.left で参照されるNode オブジェクトを　node2、...と呼ぶことにする
//*root.right で参照されるNode オブジェクトを　node10、...と呼ぶことにする
//*　また、実行中にnewでつくられるNode オブジェクトを、newnodeとする


//*1. 代入対象の変数： x  代入される値：7
//*1. Node 型変数への代入：　代入対象の変数: node1 代入される値:root
//*2. 追加される値と既にある値の比較
//*2.v.value.compareTo(x) > 0,  v.value = node1.value = 6, x = 7,  node1.value < x
//*1. Node 型変数への代入：　代入対象の変数: node10 代入される値:node1.right  
//*2.v.value.compareTo(x) > 0,  v.value = node10.value = 10, x = 7,  node10.value > x
//*1. Node 型変数への代入：　代入対象の変数: node11 代入される値:node10.left 
//*2.v.value.compareTo(x) > 0,  v.value = node11.value = 8, x = 7,  node11.value > x
//*node11.left == nullなので
//*node11.left = new Node(7, null, null);
//*つまり、newnode.value = 7

package task12;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class MyTreeSet implements Set{

	//*木の根のノードを参照するNode 型変数をrootとする
	private Node root;

	
	//*連結リストの場合のリストセルのかわりに、ノードを表す内部クラスNodeを使用する
	private class Node {
		//*rightは右を参照し、leftは右を参照する。valueはnodeに入っている値である
		private Comparable value;
		private Node left, right;
		private Node(Object value, Node left, Node right) {
		this.value = (Comparable) value;
		this.left = left;
		this.right = right;
		}
		}

	//*この集合（今生成されようとしているオブジェクト）を空の集合に初期化する
	public MyTreeSet() {
       root = null;
	}


	@Override
	public int size() {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	//*この集合（this の参照するオブジェクト）がx を要素として持っていればtrue, 持っていなければfalse を返す
	public boolean contains(Object x) {
		// TODO 自動生成されたメソッド・スタブ
		Node v = root; // 根から出発する。
		//*値を、ノードがなくなるまで1つずつ調べていく
		while (v != null) {
		//*もし同じ要素を持っていればtrueを返す
		if (x.equals(v.value))  return true;
		
		//*要素が違う場合は次の値を参照するようにする
		if (v.value.compareTo(x) > 0) v = v.left;
		else v = v.right;
		}
		//*ここまでで返り値をえられなければ、同じ要素がないということなのでfalseを返す
		return false;
	}

	@Override
	public Iterator iterator() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Object[] toArray(Object[] a) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	//*この集合に要素x を追加する。
	//*もともとx がこの集合の要素でなく、実際に追加できたときはtrue、
	//*そうでないときはfalse を返す
	public boolean add(Object x) {
		// TODO 自動生成されたメソッド・スタブ

		//*root の値がnull であるとき、木は空でしたがってその表す集合も空である
		//*そのため、新しく値を追加し。returnを返す
		if (root == null) {
		root = new Node(x, null, null);
		return true;
		}
		Node v = root; //根から探索を開始
	
		while (true) {
		//*もし同じ要素があれば要素の追加を行わないのでfalseを返す
		if (x.equals(v.value)) {
		 return false;
		}
		
		//*もし追加したい要素が、参照しているnodeの要素の値よりも小さいとき
		if (v.value.compareTo(x) > 0) {
			//*まだその先にnodeがある場合は、次のnodeを参照するようにする
		if (v.left != null) {
		 v = v.left;
		}
		//*もしその先にnodeがない場合は、値を追加する
		else {
			v.left = new Node(x, null, null);
		return true;
		}
		}
		
		//*もし追加したい要素が、参照しているnodeの要素よりも大きいとき
		else {
			//*もし先にnodeがある場合は、次のnodeを参照するようにする
			if (v.right != null) {
				 v = v.right;
			}
			//*もしその先にnodeがない場合は、値を追加する
			else {
				v.right = new Node(x, null, null);
				  return true;
			}
		}
		}
		}


	@Override
	public boolean remove(Object o) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean containsAll(Collection c) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean addAll(Collection c) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean retainAll(Collection c) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean removeAll(Collection c) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public void clear() {
		// TODO 自動生成されたメソッド・スタブ

	}

	//*テストやデバッグのために、toString メソッドを次のように上書きしておく
	public String toString() {
		return "{" + toString(root) + "}";
		}
		private String toString(Node v) {
		if (v == null) {
		return "";
		}
		StringBuilder sb = new StringBuilder();
		if (v.left != null) {
		sb.append(toString(v.left) + ",");
		}
		sb.append(v.value);
		if (v.right != null) {
		sb.append("," + toString(v.right));
		}
		return sb.toString();
		}

		//*MytreeSet クラスのmain メソッドで、MyTreeSet オブジェクトを2つつくり、
		//*それぞれに対して、add、contains、 　の各メソッドの実行をそれぞれ行う
    public static void main(String[] args) {
		MyTreeSet a = new MyTreeSet();
		MyTreeSet b = new MyTreeSet();

		
		//*何も入っていないときの帰属判定もここで行った
		System.out.print("1  ");
		System.out.print(a.contains(1));
		System.out.println();
		System.out.println();

		//*各メソッドをそれぞれ実行し、出力する
		//*実行前 a.n = 0, a.a = {}
		a.add(1);
		//*実行後 a.n = 1, a.a = {1}
		System.out.print("a = ");
		System.out.print(a);
		//System.out.print("size = ");
		//System.out.print(a.size());
		System.out.println();

		System.out.print("1  ");
		System.out.print(a.contains(1));
		System.out.println();
		System.out.println();


		
		a.add(9);
		System.out.print("a = ");
		System.out.print(a);
		System.out.println();
		//System.out.print("size = ");
		//System.out.print(a.size());
		System.out.print("0  ");
		System.out.print(a.contains(0));
		System.out.println();
		System.out.print("9  ");
		System.out.print(a.contains(9));
		System.out.println();
		System.out.println();
		

		
		a.add(8);
		System.out.print("a = ");
		System.out.print(a);
		System.out.println();
		//System.out.print("size = ");
		//System.out.print(a.size());
		System.out.print("3  ");
		System.out.print(a.contains(3));
		System.out.println();
		System.out.print("8  ");
		System.out.print(a.contains(8));
		System.out.println();
		System.out.println();
		
		a.add(7);
		System.out.print("a = ");
		System.out.print(a);
		System.out.println();
		System.out.print("2  ");
		System.out.print(a.contains(2));
		System.out.println();
		System.out.print("1  ");
		System.out.print(a.contains(1));
		System.out.println();
		//System.out.print("size = ");
		//System.out.print(a.size());
		System.out.println();
		
		a.add(7);
		
		System.out.print("a = ");
		System.out.print(a);
		System.out.println();
		System.out.print("5  ");
		System.out.print(a.contains(5));
		System.out.println();
		//System.out.print("size = ");
		//System.out.print(a.size());
		System.out.println();

		a.add(5);
		
		System.out.print("a = ");
		System.out.print(a);
		System.out.println();
		System.out.print("4  ");
		System.out.print(a.contains(4));
		System.out.println();
		//System.out.print("size = ");
		//System.out.print(a.size());
		System.out.println();

		a.add(4);
		
		System.out.print("a = ");
		System.out.print(a);
		System.out.println();
		System.out.print("10  ");
		System.out.print(a.contains(10));
		System.out.println();
		//System.out.print("size = ");
		//System.out.print(a.size());
		System.out.println();

		a.add(3);
		
		System.out.print("a = ");
		System.out.print(a);
		System.out.println();
		System.out.print("2  ");
		System.out.print(a.contains(2));
		System.out.println();
		//System.out.print("size = ");
		//System.out.print("a.size());
		System.out.println();

		a.add(2);
		
		System.out.print("a = ");
		System.out.print(a);
		System.out.println();
		System.out.print("1  ");
		System.out.print(a.contains(1));
		System.out.println();
		//System.out.print("size = ");
		//System.out.print(a.size());
		System.out.println();

/*
		//*実行前 a.n = 5, a.a = {1,3,5,7,9}
		a.remove(1);
		//*実行後 a.n = 4, a.a = {3,5,7,9}
		System.out.print("a = ");
		System.out.print(a);
		System.out.println();
		System.out.print("size = ");
		System.out.print(a.size());
		System.out.println();

		//*実行前 a.n = 4, a.a = {3,5,7,9}
		a.remove(4);
		//*実行後 a.n = 4, a.a = {3,5,7,9}
		System.out.print("a = ");
		System.out.print(a);
		System.out.println();
		System.out.print("size = ");
		System.out.print(a.size());
		System.out.println();

		//*実行前 a.n = 4, a.a = {3,5,7,9}
		a.remove(2);
		//*実行後 a.n = 4, a.a = {3,5,7,9}
		System.out.print("a = ");
		System.out.print(a);
		System.out.println();
		System.out.print("size = ");
		System.out.print(a.size());
		System.out.println();

		//*実行前 a.n = 4, a.a = {3,5,7,9}
		a.remove(5);
		//*実行後 a.n = 3, a.a = {3,7,9}
		System.out.print("a = ");
		System.out.print(a);
		System.out.println();
		System.out.print("size = ");
		System.out.print(a.size());
		System.out.println();

		//*実行前 a.n = 3, a.a = {3,7,9}
		a.remove(0);
		//*実行後 a.n = 3, a.a = {3,7,9}
		System.out.print("a = ");
		System.out.print(a);
		System.out.println();
		System.out.print("size = ");
		System.out.print(a.size());
		System.out.println();
		System.out.println();

*/

/*
		System.out.print("1  ");
		System.out.print(a.contains(1));
		System.out.println();
		System.out.print("2  ");
		System.out.print(a.contains(2));
		System.out.println();
		System.out.print("3  ");
		System.out.print(a.contains(3));
		System.out.println();
		System.out.print("4  ");
		System.out.print(a.contains(4));
		System.out.println();
		System.out.print("5  ");
		System.out.print(a.contains(5));
*/
		System.out.println();
		System.out.println();
		System.out.println();


		System.out.print("5  ");
		System.out.print(b.contains(5));
		System.out.println();
		System.out.println();
		b.add(6);
		System.out.print("b = ");
		System.out.print(b);
		System.out.println();
		System.out.print("1  ");
		System.out.print(b.contains(1));
		System.out.println();
		System.out.println();
		//System.out.print("size = ");
		//System.out.print(b.size());
		b.add(10);
		System.out.print("b = ");
		System.out.print(b);
		System.out.println();
		System.out.print("8  ");
		System.out.print(b.contains(8));
		System.out.println();
		System.out.println();
		b.add(3);
		System.out.print("b = ");
		System.out.print(b);
		System.out.println();
		System.out.print("6  ");
		System.out.print(b.contains(6));
		System.out.println();
		System.out.println();
		b.add(5);
		System.out.print("b = ");
		System.out.print(b);
		System.out.println();
		System.out.print("7  ");
		System.out.print(b.contains(7));
		System.out.println();
		System.out.println();
		b.add(8);
		System.out.print("b = ");
		System.out.print(b);
		System.out.println();
		System.out.print("2  ");
		System.out.print(b.contains(2));
		System.out.println();
		System.out.println();
		//System.out.print("size = ");
		//System.out.print(b.size());
		System.out.println();

		b.add(9);
		System.out.print("b = ");
		System.out.print(b);
		System.out.println();
		System.out.print("6  ");
		System.out.print(b.contains(6));
		System.out.println();
		System.out.println();

		b.add(0);
		System.out.print("b = ");
		System.out.print(b);
		System.out.println();
		System.out.print("0  ");
		System.out.print(b.contains(0));
		System.out.println();
		System.out.println();

		b.add(1);
		System.out.print("b = ");
		System.out.print(b);
		System.out.println();
		System.out.print("7  ");
		System.out.print(b.contains(7));
		System.out.println();
		System.out.println();



		/*b.remove(6);
		System.out.print("b = ");
		System.out.print(b);
		System.out.println();
		System.out.print("size = ");
		System.out.print(b.size());
		System.out.println();

		b.remove(31);
		System.out.print("b = ");
		System.out.print(b);
		System.out.println();
		System.out.print("size = ");
		System.out.print(b.size());
		System.out.println();

		b.remove(7);
		System.out.print("b = ");
		System.out.print(b);
		System.out.println();
		System.out.print("size = ");
		System.out.print(b.size());
		System.out.println();

		b.remove(3);
		System.out.print("b = ");
		System.out.print(b);
		System.out.println();
		System.out.print("size = ");
		System.out.print(b.size());
		System.out.println();

		b.remove(0);
		System.out.print("b = ");
		System.out.print(b);
		System.out.println();
		System.out.print("size = ");
		System.out.print(b.size());
		System.out.println();
		System.out.println();

		System.out.print("5  ");
		System.out.print(b.contains(5));
		System.out.println();
		System.out.print("31  ");
		System.out.print(b.contains(31));
		System.out.println();
		System.out.print("4  ");
		System.out.print(b.contains(4));
		System.out.println();
		System.out.print("7  ");
		System.out.print(b.contains(7));
		System.out.println();
		System.out.print("2  ");
		System.out.print(b.contains(2));
*/


	}


}

