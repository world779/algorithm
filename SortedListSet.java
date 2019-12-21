//*呼び出し前の集合の要素 c = {0,1,2,3,5,6,7}とする
//*1. Cell 型変数への代入 代入対象の変数:x  代入される値:4
//*2.比較のコード：p.value.compareTo(x)>0  比較される2つの値:0，4  比較結果:false
//*2.比較のコード：p.value.compareTo(x)>0  比較される2つの値:1，4  比較結果:false
//*2.比較のコード：p.value.compareTo(x)>0  比較される2つの値:2，4  比較結果:false
//*2.比較のコード：p.value.compareTo(x)>0  比較される2つの値:3，4  比較結果:false
//*2.比較のコード：p.value.compareTo(x)>0  比較される2つの値:5，4  比較結果:true
//*1. Cell 型変数への代入 代入対象の変数:n1  代入される値:4
//*c4.next = new Cell(4,c4.next);




package task11;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class SortedListSet implements Set{



	//*連結リストのセルを表すクラスはSortedListSet の内部クラスにする。
	//*以下では、この内部クラスの名前をCell として定義する。
	private class Cell {
		//*Cell クラスの変数value はそのセルの保持する集合要素（オブジェクト）
		//*を参照する
		private Comparable value;

		//*変数next は連結リストの次のセルを参照する
		private Cell next;
		private Cell(Object value, Cell next) {
			this.value = (Comparable) value;
			this.next = next;
			}
			}

	//*リストの先頭セルを参照するインスタンス変数が必要なので
	//*ここで定義する
	private Cell head;

	//*この集合の大きさ（要素数）を返す
	@Override
	public int size() {
		// TODO 自動生成されたメソッド・スタブ

		//* 初期値をheadとして、pがnullになるまでpを一つずつ進めていき、
		//*count変数で要素数を数える
		Cell p = head;
		int count = 0;
		while(p != null){
			count++;
			p = p.next;
		}
		return count;

	}

	@Override
	public boolean isEmpty() {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}


	//*この集合(this の参照する集合）がx を要素として持っていればtrue,
	//*持っていなければfalse を返す。
	@Override
	public boolean contains(Object x) {
		// TODO 自動生成されたメソッド・スタブ

		//*Cell型の変数p、qを用意する
		Cell p;
		p = head;

		//*pをで１つずつ値を調べていき、同じ値があればfalseを返す
		while(p!=null){
			if(x.equals(p.value))
				return true;

			//*ここでは小さい順に要素を並べているので、
			//*もしxの値より大きい値が出てくれば、それ以降を調べても
			//*同じ値が出てくることはないのでfalseを返す
			if(p.value.compareTo(x)>0)
				return false;

			//*while文の中でpを1つずつ進める
			p = p.next;
		}

		//*ここまでで返り値がないときは、同じ値がなかったときなので
		//*falseを返す
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
	//*そうでないときはfalse を返す。
	public boolean add(Object x) {
		// TODO 自動生成されたメソッド・スタブ
		//*Cell型の変数p、qを用意する
		Cell p,q;
		p = head;
		q = head;

		//*もしこの集合(this の参照する集合）がxを要素として持っていれば
		//*falseを返すので、上記で作ったcontainsで調べる
		if(contains(x))
			return false;

		//*もしheadがnullであれば、リストもその表す集合も空ということなので
		//*要素を追加する
		if(head == null) {
			head = new Cell(x,null);
			return true;
		}

		//*もしpがheadで、リスト内に、追加する要素よりも小さい値がなかったときは
		//*リストの1番初めに要素を追加する
		//*その処理をこのif文で行う
		if(p == head){
			if(p.value.compareTo(x)>0) {
				  head = new Cell(x,head);
				  return true;
				}
		}

		//*ｐがnullでないときは値を調べていき、
		//*もしeより大きい要素にたどり着いた時は、その要素がないということなので
		//*p の参照するセルのひとつ前のセルのnextに新しいセルを作る
		//*そうでないときは、今までのpをqとして(つまりqを1つ進めて)、pもひとつ先に進める
		while(p != null) {
			if(p.value.compareTo(x)>0) {
				q.next = new Cell(x,q.next);
				return true;
			}
			q = p;
			p = p.next;
		}

		//*ここまでで返り値を得られなかったときは、
		//*追加する要素が、リスト内にあったどの要素よりも大きいときなので、
		//*新しいセルを作り、そのセルのnextにはnullを追加する
			q.next = new Cell(x,null);

		return true;


	}


	@Override
	//*この集合から要素x を削除する。
	//*もともとx がこの集合の要素であって、実際に削除できたときはtrue、
	//*そうでないときはfalse を返す
	public boolean remove(Object x) {
		// TODO 自動生成されたメソッド・スタブ
		//*Cell型の変数p、qを用意する
		Cell p,q;
		p = head;
		q = head;

		//*もしpがheadで、さらにその値が同じであったときは
		//*headの値を書き換える
		//*この時のqはnullということになる
		if(p == head) {
			if(x.equals(p.value)) {
				head = p.next;
				return true;
			}
		}

		//*pがnullでないとき、値を1つずつ見ていく
		while(p != null) {
		    //*もし同じ値があれば、p の参照するセルのひとつ前の
			//*セルのnext 欄を書き換え、ｐの参照するセルの一つ後の
			//*セルを参照するようにする
			if(x.equals(p.value)) {
				q.next = p.next;
				return true;
			}
			q = p;
			p = p.next;
		}

		//*ここまでで返り値を得られなかったときは
		//*リストの中に同じ要素、つまり削除する要素がなかった時なので
		//*falseを返す
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

	//*テストのためには、toString メソッドを次のように上書きしておく
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		Cell p = head;
		while (p != null) {
		sb.append(p.value);
		p = p.next;
		if (p != null)
		sb.append(",");
		}
		sb.append("}");
		return sb.toString();
		}



	public static void main(String[] args) {
		SortedListSet a = new SortedListSet();
		SortedListSet b = new SortedListSet();
        SortedListSet c = new SortedListSet();

		for(int i = 0; i < 4; i++) {
			c.add(i);
		}

		for(int i = 5; i < 8; i++) {
			c.add(i);
		}

		System.out.print("c = ");
		System.out.print(c);
		System.out.println();
		System.out.print("size = ");
		System.out.print(c.size());
		System.out.println();

		c.add(4);
		System.out.print("c = ");
		System.out.print(c);
		System.out.println();
		System.out.print("size = ");
		System.out.print(c.size());
		System.out.println();
		System.out.println();



		//*各メソッドをそれぞれ実行し、出力する
		//*実行前 a.n = 0, a.a = {}
		a.add(1);
		//*実行後 a.n = 1, a.a = {1}
		System.out.print("a = ");
		System.out.print(a);
		System.out.println();
		System.out.print("size = ");
		System.out.print(a.size());
		System.out.println();

		//*実行前 a.n = 1, a.a = {1}
		a.add(3);
		//*実行後 a.n = 2, a.a = {1,3}

		//*実行前 a.n = 2, a.a = {1,3}
		a.add(7);
		//*実行後 a.n = 3, a.a = {1,3,7}

		//*実行前 a.n = 3, a.a = {1,3,7}
		a.add(5);
		//*実行後 a.n = 4, a.a = {1,3,5,7}

		//*実行前 a.n = 4, a.a = {1,3,5,7}
		a.add(9);
		//*実行後 a.n = 5, a.a = {1,3,5,7,9}
		System.out.print("a = ");
		System.out.print(a);
		System.out.println();
		System.out.print("size = ");
		System.out.print(a.size());
		System.out.println();

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

		System.out.println();
		System.out.println();
		System.out.println();

		b.add(8);
		System.out.print("b = ");
		System.out.print(b);
		System.out.println();
		System.out.print("size = ");
		System.out.print(b.size());
		System.out.println();
		b.add(2);
		b.add(7);
		b.add(10);
		b.add(31);
		System.out.print("b = ");
		System.out.print(b);
		System.out.println();
		System.out.print("size = ");
		System.out.print(b.size());
		System.out.println();

		b.remove(6);
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



	}



}
