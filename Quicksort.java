package task05;
/*
int[] partition(int a[], int low, int high, int x)
 *
 *   配列a[]の要素 a[low], a[low + 1], ..., a[high] を
 *   並べ替えて、三つの区間に分割する。左の区間の要素はどれも
 *   xより小さく、中央の区間の要素はすべてxと等しく、そして
 *   右の区間の要素はどれもxより大きいようにする。
 *   正確には次の条件を満たす。　この関数の戻り値を mで表す。
 *   mは２要素のint配列を参照する。
 *
 *   （A）　low <= m[0] <= m[1] <= high
 *   （B）  low <= i < m[0] なる i については a[i] < x である。
 *   （C) m[0] <= i <= m[1] なる i　については a[i] = x である。
 *   （D) m[1] < i <= high なる i　については a[i] > x である。
 *
 *   (A)の条件から、（B)や（D)の区間は空かもしれないが、（C)の区間は決し空でないことに注意する。
 *
 *   引数は、次の条件を満たすと仮定する。
 *   （１）　0 <= low < high < a.length
 *   low < high なので、扱う区間の大きさ（要素数）は 2以上であることに注意する。
 *   （２） a[low], ..., a[high] のなかに x と等しいものが少なくともひとつはある。
 *
 *   下の実装では、補助配列を用いる。
 */

public class Quicksort{

	public static void main(String[] args)	{

		//*int型の配列a,b,cを用意し、初期化する
		int [] a = {4, 5, 2, 9, 1, 8, 3, 7, 6, 0};
		int [] b = {3, 6, 8, 1, 9, 7, 4, 2, 0, 5};
		int [] c = {1, 6, 0, 4, 7, 5, 3, 9, 2, 8};

		//*用意した配列の内容をそれぞれ出力する
		//*配列の要素は1桁とは限らないため、要素それぞれに空白も加える
		System.out.print("a = ");
		for (int i = 0; i < 10; i++)
			System.out.print(a[i] + " ");
		System.out.println();
		System.out.print("b = ");
		for (int i = 0; i < 10; i++)
			System.out.print(b[i] + " ");
		System.out.println();
		System.out.print("c = ");
		for (int i = 0; i < 10; i++)
			System.out.print(c[i] + " ");
		System.out.println();
		System.out.println();

		//*sortを呼び出して整列する
		sort(a,10);
		sort(b,10);
		sort(c,10);

		//*整列させた配列をそれぞれ出力する
		System.out.print("a = ");
		for (int i = 0; i < 10; i++)
			System.out.print(a[i] + " ");
		System.out.println();
		System.out.print("b = ");
		for (int i = 0; i < 10; i++)
			System.out.print(b[i] + " ");
		System.out.println();
		System.out.print("c = ");
		for (int i = 0; i < 10; i++)
			System.out.print(c[i] + " ");
		System.out.println();

	}



	private static int[] partition(int [] a, int low, int high, int x) {
		// 区間の要素をいったん別の配列にコピーする。
		// 同時に、 xより小さい要素の個数と x と等しい要素の個数を数える。
		int b[] = new int[high - low + 1];
		int small = 0;
		int equal = 0;

		for (int i = 0; i < b.length;  i++) {
			b[i] = a[low + i];
			if (b[i] < x) {
				small++;
			}
			if (b[i] == x) {
				equal++;
			}
		}

		// 配列 b より a に要素を戻す。このとき、
		// a[low], ..., a[low + small - 1] に
		// x より小さい要素を、
		// a[low + small], ..., a[low + small + equal - 1] に
		// x と等しい要素を、
		// a[low + small + equal], ..., a[high] に
		// x より大きい要素を入れる。
		int j = low;
		int k = low + small;
		int h = low + small + equal;
		for (int i = 0; i < b.length; i++) {
			if (b[i] < x) {
				a[j++] = b[i];
			}
			else if (b[i] == x) {
				a[k++] = b[i];

			}
			else {
				a[h++] = b[i];
			}
		}

		/* 下の戻り値配列の要素を、仕様を満たすように書き換えてください。
		 * なぜそう書き換えたかの説明が必要です。
		 */

		//*上記の説明でいうm[0]の値を返すためには、lowからsmall個分進んだ値、
		//*つまり、番地がlow+smallの値を返せばよい。
		//*同様に、m[1]の値を返すためには、lowからsmall個とequal個分進んだ値のひとつ前、
		//*つまり、番地がlow+small+high-1の値を返せばよい。
		//*low+samll+equalと書いて間違えやすいが、m[1]の値はそのひとつ前の値であることに注意する
		//*よって戻り値は配列の要素は下記のようになる。

		return new int[]{low+small,low+small+equal-1};

	}

	//*main関数から簡単に呼び出せるように、引数の少ない関数をここで定義する
	//*Java では同じメソッド名でも、引数リストが異なれば異なるメソッドとして区別される
	private static void sort(int a[], int n) {
		sort(a,0,n-1);

	}


    //*ここでは、再帰メゾットを定義する。
	private static void sort(int a[], int low, int high) {
		//*もし、要素数が1以下の場合、並び替える必要はないので、
		//*returnする
		if(low>=high) return;

		//*次に、分割の基準となる値を決める
		//*ここで、xは a[low], ..., a[high] のなかに1つでも等しい値がなければならないので、
		//*aの配列の中にある値を用いる。
		int x = a[low];

		//*分割アルゴリズムを実装するメソッドpartitionを呼び出す
		//*ここでは補助配列を使用しているため、呼び出した値は配列に入れる
		int m[] = partition(a,low,high,x);

		//*再帰呼び出しを使って、分割したものをさらにsort関数に入れ、何度も繰り返すことで
		//*小さい順に並び替える
		sort(a,low,m[0]-1);
        sort(a,m[1]+1,high);
	}

}
