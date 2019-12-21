package task10;

//*ArraySet クラスがSet インターフェイスを実装すると宣言しているため、
//*Set インターフェイスをインポートする
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;


//*Set インターフェイスを（部分的に）実装するpublic クラスArraySetを作成した
public class ArraySet implements Set{

	//*ArraySet では、ふたつのインスタンス変数を使用する
	//*aは集合、nは集合の要素数を表す
	private Object[] a;
	private int n;

	//*コンストラクタのなかでは,aの参照する配列オブジェクトを作成し、
	//*集合の要素数を0に初期化する
	public ArraySet() {
		final int INITIAL_SIZE = 20;
		a = new Object[INITIAL_SIZE];
	}

	//*この集合がx と等しい要素を持てばtrue,
	//*持たなければfalse を返す。
	public boolean contains(Object x) {
	  for(int i = 0; i < n; i++) {
		  //*x の参照するオブジェクトとa[i] の参照するオブジェクトが等しいかの判定には、
		  //*x == a[i] ではなく、x.equals(a[i]) またはa[i].equals(x) を用いる。
		  if(x.equals(this.a[i]))
				return true;
	}
	  return false;


}
    //*この集合に要素x を追加する。
	//*x と等しい要素が集合のなかになく、実際に追加できたときはtrue、
	//*そうでないときはfalse を返す。
	public  boolean add(Object x) {
		for(int i = 0; i < n; i++) {
			if(x.equals(this.a[i]))
				return false;
			}

		//*要素数がいくつ追加されるか分からないため、足りなくなる度に
		//*大きな配列を取り直す。
		//*追加する要素x が配列内に無いことを確認した上で
		//*要素数が現在の配列の大きさを超えようとしていたら、
		//*これまでの内容を新しい配列（例えば２倍の長さ）にコピーするようにする
		if (n == a.length) {
			a = Arrays.copyOf(a, a.length * 2);
			}

		//*追加する要素x が配列内に無いことを確認したら、
		//*集合に要素を追加する
		//*a[n]は集合の要素に含まれるようになり、要素数が増えるので、ｎを１増やす
		a[n] = x;
		n++;
		return true;
	}

    //*この集合からx と等しい要素を削除する。
	//*x と等しい要素が集合のなかにあって、実際に削除できたときはtrue、
	//*そうでないときはfalse を返す。
	public boolean remove(Object x) {
		for(int i = 0; i < n; i++) {

			//*削除する要素x が配列内に有ることを確認したら、
			//*集合から要素を削除する
			//*a[n-1] は、n を１減らすことによって集合の要素に含まれなくなる
			if(x.equals(a[i])) {
				a[i] = a[n-1];
				n--;
			return true;
			}
		}
       return false;
	}



    //*この集合の大きさ（要素数）を返す。
	public int size() {
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

	//*テスト用にtoString メソッドを次のようにオーバーライドしておく
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for (int i = 0; i < n; i++) {
		if (i > 0) sb.append(",");
		sb.append(a[i]);
		}
		sb.append("}");
		return sb.toString();
		}


	//*ArraySet クラスのmain メソッドで、ArraySet オブジェクトを2つつくり、
	//*それぞれに対して、add、remove、contains、size 　の各メソッドの実行をそれぞれ行う
	public static void main(String[] args) {
		//*ArraySet オブジェクトを作る
		ArraySet a = new ArraySet();
		ArraySet b = new ArraySet();


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
		//*実行後 a.n = 4, a.a = {1,3,7,5}

		//*実行前 a.n = 4, a.a = {1,3,7,5}
		a.add(9);
		//*実行後 a.n = 5, a.a = {1,3,7,5,9}
		System.out.print("a = ");
		System.out.print(a);
		System.out.println();
		System.out.print("size = ");
		System.out.print(a.size());
		System.out.println();

		//*実行前 a.n = 5, a.a = {1,3,7,5,9}
		a.remove(1);
		//*実行後 a.n = 4, a.a = {3,7,5,9}
		System.out.print("a = ");
		System.out.print(a);
		System.out.println();
		System.out.print("size = ");
		System.out.print(a.size());
		System.out.println();

		//*実行前 a.n = 4, a.a = {3,7,5,9}
		a.remove(4);
		//*実行後 a.n = 4, a.a = {3,7,5,9}
		System.out.print("a = ");
		System.out.print(a);
		System.out.println();
		System.out.print("size = ");
		System.out.print(a.size());
		System.out.println();

		//*実行前 a.n = 4, a.a = {3,7,5,9}
		a.remove(2);
		//*実行後 a.n = 4, a.a = {3,7,5,9}
		System.out.print("a = ");
		System.out.print(a);
		System.out.println();
		System.out.print("size = ");
		System.out.print(a.size());
		System.out.println();

		//*実行前 a.n = 4, a.a = {3,7,5,9}
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



		//*ここで、実行結果を見ただけでは、何の値と比較してその正誤を出力したのか
		//*わからなかったため、必須課題10その2では出力結果を工夫し、
		//*それらの実行結果が正しかったかどうかが、実行結果を見てよくわかるように書き換えた
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

		//*ここに不必要なコメントがあったため、必須課題10その2では削除した。


	}



}
