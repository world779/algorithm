package task10;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class ArraySet2<T> implements Set<T> {


	//*ArraySet2 では、ふたつのインスタンス変数を使用する
	//*aは集合、nは集合の要素数を表す
	private Object[] a;
	private int n;

	//*コンストラクタのなかでは,aの参照する配列オブジェクトを作成し、
	//*集合の要素数を0に初期化する
	public ArraySet2() {
		final int INITIAL_SIZE = 20;
		a = new Object[INITIAL_SIZE];
	}


	//*この集合の大きさ（要素数）を返す。
	@Override
	public int size() {
		// TODO 自動生成されたメソッド・スタブ

			//*for文で要素数を数える
			int count = 0;
			for(int i = 0; i < n; i++) {
				count++;
			}
			return count;
	}

	@Override
	public boolean isEmpty() {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}



	//*この集合がo と等しい要素を持てばtrue,
	//*持たなければfalse を返す。
	@Override
	public boolean contains(Object o) {
		// TODO 自動生成されたメソッド・スタブ

		for(int i = 0; i < n; i++) {

			  //*x の参照するオブジェクトとa[i] の参照するオブジェクトが等しいかの判定には、
			  //*x == a[i] ではなく、x.equals(a[i]) またはa[i].equals(x) を用いる。
			  if(o.equals(this.a[i]))
					return true;
		}
		  return false;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	//*この集合に要素e を追加する。
	//*x と等しい要素が集合のなかになく、実際に追加できたときはtrue、
	//*そうでないときはfalse を返す。
	public boolean add(T e) {
		// TODO 自動生成されたメソッド・スタブ


		for(int i = 0; i < n; i++) {
			if(e.equals(this.a[i]))
				return false;
			}

		//*要素数がいくつ追加されるか分からないため、足りなくなる度に
		//*大きな配列を取り直す。
		//*追加する要素e が配列内に無いことを確認した上で
		//*要素数が現在の配列の大きさを超えようとしていたら、
		//*これまでの内容を新しい配列（例えば２倍の長さ）にコピーするようにする
		if (n == a.length) {
			a = Arrays.copyOf(a, a.length * 2);
			}

		//*追加する要素e が配列内に無いことを確認したら、
		//*集合に要素を追加する
		//*a[n]は集合の要素に含まれるようになり、要素数が増えるので、ｎを１増やす
		a[n] = e;
		n++;
		return true;

	}



    //*この集合からe と等しい要素を削除する。
	//*e と等しい要素が集合のなかにあって、実際に削除できたときはtrue、
	//*そうでないときはfalse を返す。
	@Override
	public boolean remove(Object o) {
		// TODO 自動生成されたメソッド・スタブ

		for(int i = 0; i < n; i++) {

			//*削除する要素e が配列内に有ることを確認したら、
			//*集合から要素を削除する
			//*a[n-1] は、n を１減らすことによって集合の要素に含まれなくなる
			if(o.equals(a[i])) {
				a[i] = a[n-1];
				n--;
			return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public void clear() {
		// TODO 自動生成されたメソッド・スタブ

	}


	public static void main(String[] args) {
		//*ArraySet2 オブジェクトを作る
		//*ArraySet2を使用する際は、具体的な要素の型を指定する
		Set<String> a = new ArraySet2<String>();
		Set<Integer> b = new ArraySet2<Integer>();

		//*各メソッドをそれぞれ実行し、出力する
		//*実行前 a.n = 0, a.a = {}
		a.add("b");
		//*実行後 a.n = 1, a.a = {1}
		System.out.println("a = ");
		System.out.print(a);
		System.out.println();
		System.out.print("size = ");
		System.out.print(a.size());
		System.out.println();

		//*まず、a.add(0);という、
		//*String型にInteger型の要素を入れて試したが、
		//*型の一致しない使いかたをすると、エラーとなった。


		//*実行前 a.n = 1, a.a = {1}
		a.add("c");
		//*実行後 a.n = 2, a.a = {1,3}

		//*実行前 a.n = 2, a.a = {1,3}
		a.add("ab");
		//*実行後 a.n = 3, a.a = {1,3,7}

		//*実行前 a.n = 3, a.a = {1,3,7}
		a.add("d");
		//*実行後 a.n = 4, a.a = {1,3,7,5}

		//*実行前 a.n = 4, a.a = {1,3,7,5}
		a.add("cd");
		//*実行後 a.n = 5, a.a = {1,3,7,5,9}
		System.out.print("a = ");
		System.out.print(a);
		System.out.println();
		System.out.print("size = ");
		System.out.print(a.size());
		System.out.println();

		//*実行前 a.n = 5, a.a = {1,3,7,5,9}
		a.remove("a");
		//*実行後 a.n = 4, a.a = {3,7,5,9}
		System.out.print("a = ");
		System.out.print(a);
		System.out.println();
		System.out.print("size = ");
		System.out.print(a.size());
		System.out.println();

		//*実行前 a.n = 4, a.a = {3,7,5,9}
		a.remove("bc");
		//*実行後 a.n = 4, a.a = {3,7,5,9}
		System.out.print("a = ");
		System.out.print(a);
		System.out.println();
		System.out.print("size = ");
		System.out.print(a.size());
		System.out.println();

		//*実行前 a.n = 4, a.a = {3,7,5,9}
		a.remove("cd");
		//*実行後 a.n = 4, a.a = {3,7,5,9}
		System.out.print("a = ");
		System.out.print(a);
		System.out.println();
		System.out.print("size = ");
		System.out.print(a.size());
		System.out.println();

		//*実行前 a.n = 4, a.a = {3,7,5,9}
		a.remove("e");
		//*実行後 a.n = 3, a.a = {3,7,9}
		System.out.print("a = ");
		System.out.print(a);
		System.out.println();
		System.out.print("size = ");
		System.out.print(a.size());
		System.out.println();

		//*実行前 a.n = 3, a.a = {3,7,9}
		a.remove("f");
		//*実行後 a.n = 3, a.a = {3,7,9}
		System.out.print("a = ");
		System.out.print(a);
		System.out.println();
		System.out.print("size = ");
		System.out.print(a.size());
		System.out.println();
		System.out.println();



		//*ここで、実行結果を見ただけでは、何の値と比較してその正誤を出力したのか
		//*わからなかったため、必須課題10その2では出力結果を工夫し、
		//*それらの実行結果が正しかったかどうかが、実行結果を見てよくわかるように書き換えた
		System.out.print("a  ");
		System.out.print(a.contains("a"));
		System.out.println();
		System.out.print("b  ");
		System.out.print(a.contains("b"));
		System.out.println();
		System.out.print("ab  ");
		System.out.print(a.contains("ab"));
		System.out.println();
		System.out.print("c  ");
		System.out.print(a.contains("c"));
		System.out.println();
		System.out.print("f  ");
		System.out.print(a.contains("f"));

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

		//*ここに不必要なコメントがあったため、必須課題10その2では削除した。


	}


	private static char[] a(int i) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}







}
