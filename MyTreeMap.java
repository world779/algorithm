package task14;


//*MyTreeMapはMap インターフェイスを(部分的に）実装するクラスなので
//*インポートする
import java.util.Collection;
import java.util.Map;
import java.util.Set;



//*マップデータ構造を2 分探索木によって実装する
public class MyTreeMap implements Map{

	//*木の根のノードを参照するNode 型変数をrootとする
	private Node root;

	//*木のノードを表す内部クラスNodeを使用する
	private class Node {
		private Comparable key;
		private Object value;

		//*rightは右を参照し、leftは左を参照する。
		private Node left;
		private Node right;
		private Node(Object key, Object value,
		Node left, Node right) {
		this.key = (Comparable) key;
		this.value = value;
		this.left = left;
		this.right = right;
		}
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
	public boolean containsKey(Object key) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	//*このマップにおいてキーkey のもとに登録されている値を返す。
	//*マップ中にkeyがなければnull を返す。
	@Override
	public Object get(Object key) {
		// TODO 自動生成されたメソッド・スタブ

		//*根から探索する
		Node v = root;


		//*与えられた引数keyと同じv.keyの有無をvを一つずつ探索していく
		while(v != null) {

			//*もしkeyを見つけた場合は、そのもとに登録されている値valueを返す
			if (key.equals(v.key)) {
				return v.value;
			}

			//*keyが違う場合は次の値を参照するようにする
			else if ((v.key).compareTo(key) > 0) {
				if(v.left != null)
				   v = v.left;
			}
			else {
				if (v.right != null)
					 v = v.right;
			}

		}
		//*ここまでで返り値を得られない場合は、Map内にそのkeyがなかったということなので
		//*nullを返す
		return null;
	}


	//*この（this の参照する）マップにおいて、キーkey のもとに値value を登録する。
	//*もともとkey のもとにある値が登録されていた場合はその値を、そうでなければnull を返す。
	@Override
	public Object put(Object key, Object value) {
		// TODO 自動生成されたメソッド・スタブ

		Object a;

		//根から探索を開始する
		Node v = root;

		//*root の値がnull であるとき、木は空でしたがってその表す集合も空である
		//*そのため、新しくkeyとvalueの値を追加し、nullを返す
		if (root == null) {
			root = new Node(key, value, null, null);
			return null;
		}

		//*値を、ノードがなくなるまで1つずつ調べていく
		while(v != null) {
			if (key.equals(v.key)) {

				//*もともとkey のもとにある値が登録されていなかった場合は
				//*nullを返す
				if(v.value == null) {
				    v.value = value;
				    return null;
				}

				//*もともとkey のもとにある値が登録されていた場合はその値を返す
				//*ただし、v.valueの値は上書きされてしまうので、
				//*上記で定義しておいたaという変数に値を保存しておく
				else {
					a = v.value;
					v.value = value;
				}
				//*保存しておいた、もともとkeyに登録されていた値を返す
				return a;
			}

			//*もし追加したい要素が、参照しているnodeの要素の値よりも小さいとき
			else if ((v.key).compareTo(key) > 0) {
				//*まだその先にnodeがある場合は、次のnodeを参照するようにする
				if(v.left != null)
				   v = v.left;

				//*もしその先にnodeがない場合は、値を追加する
				else {
					v.left = new Node(key, value, null, null);
					return null;
				}
			}

			//*もし追加したい要素が、参照しているnodeの要素よりも大きいとき
			else {
				//*もし先にnodeがある場合は、次のnodeを参照するようにする
				if (v.right != null)
					 v = v.right;

				//*もしその先にnodeがない場合は、値を追加する
				else {
					 v.right = new Node(key, value, null, null);
					 return null;
				}
			}

		}
		return null;
	}

	@Override
	public Object remove(Object key) {
		// TODO 自動生成されたメソッド・スタブ
		
		Node v = root;
		Node u = root;
		Node w = root;
		Node y = root;
		
		//*もし空集合の時はfalseを返す
		if (root == null) {
			return null;
			}
	
		//*nodeがなくなるまで一つずつ探索する
		while(v != null) {
			//*等しい値を見つけたとき
		if(v.key.equals(key)) {
			//*削除対象ノードが、片方の子を持つ場合－－－－－－－－－－－－－－－－－－－－－－－－－－－－
			if(v == root && v.right == null) {  //*根を参照していて、かつ、左の子のみを持つとき
				//*親と、子の子をつなぐ
				root = v.left;
				return v.value;
			  }
			
			else if(v == root && v.left == null) {  //*根を参照していて、かつ、右の子のみを持つとき
				root = v.right;
				return v.value;
			}
			
			else if(v.right == null && u.right == v) {  //*ｖがuの右の子で、vが左の子のみ持つとき
				u.right = v.left;
				return v.value;
			}
			
			else if(v.right == null && u.left == v) {  //*ｖがuの左の子で、vが左の子のみ持つとき
				u.left = v.left;
				return v.value;
			}
			
			else if(v.left == null && u.right == v) {  //*ｖがuの右の子で、vが右の子のみ持つとき
				u.right = v.right; 
				return v.value;
			}
			
			else if(v.left == null && u.left == v) {  //*ｖがuの左の子で、vが右の子のみ持つとき
				u.left = v.right;
				return v.value;
			}
			
			//*ここまで－－－－－－－－－－－－－－－－－－－ーー－－－－－－－－－－－－－－－－－－－
			
			else {  //*削除対象ノードが、両方の子を持つ場合
				
				w = v.right;
				y = v;
				
				//*もし削除対象ノードの右側の子が最小値であった場合
				if(w.left == null) {
					//*その値を削除対象ノードに代入し、
					//*最小値のあったノードを削除する
					v.key = w.key;
					y.right = w.right;
					return v.value;
				}
				
				//*右の子からたどってその中の最小値を探す
				while(w.left != null) {	
					y = w;
					w = w.left;
				}
				
				//*最小値を削除対象のノードに代入し、
				//*最小値のあったノードを削除する
				v.key = w.key;
				y.left = w.right;
				return v.value;
			}
			
		}
		
		else if (v.key.compareTo(key) > 0) {
			u = v;
			v = v.left;
		}
		
		else{
			u = v;
			v = v.right;
		}
		
		}
		return null;
	}

	@Override
	public void putAll(Map m) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void clear() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public Set keySet() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Collection values() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Set entrySet() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	public String toString() {
		return "{" + toString(root) + "}";
		}

	//*テストやデバッグのために、toString メソッドを次のように上書きしておく
	private String toString(Node v) {
		StringBuilder sb = new StringBuilder();
		if (v != null) {
		if (v.left != null) {
		sb.append(toString(v.left) + ",");
		}
		sb.append("(" + v.key + "," + v.value + ")");
		if (v.right != null) {
		sb.append("," + toString(v.right));
		}
		}
		return sb.toString();
		}

	//*この集合（今生成されようとしているオブジェクト）を空の集合に初期化する
	public MyTreeMap() {
	       root = null;
		}


	public static void main(String[] args) {
		MyTreeMap a = new MyTreeMap();

		//*各メソッドをそれぞれ実行し、出力する
		//*まず木に何もない状態でgetメソッドを実行し、valueに値はないので、返り値がnullであることを確認する
		System.out.println("key = 1のとき  value = " + a.get(1));
		System.out.println();


		a.put(1,2);

		System.out.print("a = ");
		System.out.println(a);



        //*Nodeを1つ追加した後、正しく追加が行われているかテストする
		System.out.println("key = 1のとき  value = " + a.get(1));
		System.out.println();



		a.put(2,8);
		System.out.print("a = ");
		System.out.print(a);

		System.out.println();
		System.out.println("key = 1のとき  value = " + a.get(1));

		System.out.println();


		a.put(5,4);
		System.out.print("a = ");
		System.out.print(a);
		System.out.println();
		System.out.println("key = 5のとき  value = " + a.get(5));

		System.out.println();

		a.put(7,9);
		System.out.print("a = ");
		System.out.print(a);
		System.out.println();

		System.out.println();
		
		a.remove(2);

		System.out.print("a = ");
		System.out.print(a);
		System.out.println();

		System.out.println();

		a.put(3,3);

		System.out.print("a = ");
		System.out.print(a);
		System.out.println();

		System.out.println("key = 5のとき  value = " + a.get(5));

		System.out.println();


		//*同じKeyのもとのvalueを上書きしたい場合についてテストする
		//*また、valueの値を上書きするとき、前の値がputメソッドの返り値として正しく取れているかもテストする
		System.out.println("key = 5 の前の値は" + a.put(5,2));

		System.out.print("a = ");
		System.out.println(a);
		System.out.println("key = 5のとき  value = " + a.get(5));

		System.out.println();

		//System.out.println();

		//*keyがないものをremoveとして実行するとき、正しく処理が行われているかテストした
		a.remove(4);
		System.out.print("a = ");
		System.out.print(a);
		System.out.println();

		System.out.println();
		
		

		a.put(4,1);

		System.out.print("a = ");
		System.out.print(a);
		System.out.println();

		System.out.println();


		System.out.print("a = ");
		System.out.print(a);
		System.out.println();

		System.out.println();

		a.put(2,8);

		System.out.print("a = ");
		System.out.print(a);
		System.out.println();

		System.out.println();


		a.put(2,6);

		System.out.print("a = ");
		System.out.print(a);
		System.out.println();

		System.out.println();

		a.remove(1);

		System.out.print("a = ");
		System.out.print(a);
		System.out.println();
		System.out.println();

		//*removeの返り値が正しいかもテストする。
		System.out.println("key = 3 の前の値は" + a.remove(3));
		System.out.print("a = ");
		System.out.print(a);
		System.out.println();
		
	}


}



