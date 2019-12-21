package task07;


//*インターフェイスとは、宣言されたメゾットを用意するという約束のようなもので、
//*プログラム同士の間でデータのやり取りをする際の形式を定めたもの

//*Comparableインターフェイスはそのインターフェイスを実装するクラスでは
//*オブジェクト同士の大小比較が可能であることを表す
//*Comparable インターフェイスを実装したクラスのオブジェクトは、
//*比較演算子(< や　<= など）の代わりにcompareTo メソッドを用いることによって
//*大小比較ができるので、それによって整列アルゴリズムを一般的に記述することができる

//*ここで、ObjectSortクラスは、Comparableインターフェイスの中に宣言してあるメソッド(≒関数)を
//*全て持つことを「約束」する
//*普通は、ComparableインターフェイスにはSortメソッドが定義し、
//*もしくは今回のように既にComparable インターフェイスを実装しているString クラスとInteger クラスを使用することで
//*オブジェクトそれぞれにSortメゾットを必ず持つと約束してあるという意味になり、
//*ひとつのsort メソッドが種々のクラスのオブジェクトに対して使用できるようになる





public class ObjectSort {


	public static void main(String[] args)	{

		String a[];
		String b[];
		String c[];


		a = new String[] {"f","a","y","y","s","y","s","d","a","y"};
		b = new String[] {"z","y","x","w","v","u","t","s","r","q"};
		c = new String[] {"abc","bab","bcd","abcd","abcde","a","b","bbb","ab","c"};

		Integer d[] = new Integer[] {5,2,6,8,3,1,3,5,7,3};
		Integer e[] = new Integer[] {9,8,7,6,5,4,3,2,1,0};
		Integer f[] = new Integer[] {123,1,2,3,12,1234,23,134,13,14};



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


		System.out.print("d = ");
		for (int i = 0; i < 10; i++)
			System.out.print(d[i] + " ");
		System.out.println();
		System.out.print("e = ");
		for (int i = 0; i < 10; i++)
			System.out.print(e[i] + " ");
		System.out.println();
		System.out.print("f = ");
		for (int i = 0; i < 10; i++)
		    System.out.print(f[i] + " ");
		System.out.println();
		System.out.println();


		//*sortを呼び出して整列する
		sort(a,10);
		sort(b,10);
		sort(c,10);

		sort(d,10);
		sort(e,10);
		sort(f,10);

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
		System.out.println();


		System.out.print("d = ");
		for (int i = 0; i < 10; i++)
			System.out.print(d[i] + " ");
		System.out.println();
		System.out.print("e = ");
		for (int i = 0; i < 10; i++)
			System.out.print(e[i] + " ");
		System.out.println();
		System.out.print("f = ");
		for (int i = 0; i < 10; i++)
		    System.out.print(f[i] + " ");
		System.out.println();
		System.out.println();

	}

	//*ソートのプログラムでは、まず１つ目のfor文で順番に基準の値を決めていく
    //*iの値をmで保存しておき、基準の値・a[m]より小さい値がないか２つ目のfor文で順番に調べていく
	//*そして、小さい値があればその添え字をmに代入していく
	//*２つ目のfor文が終わった後、配列の要素同士を入れ替える
	//*これを1つ目のfor文で繰り返すことで、配列の要素を小さい順に並び替え、整列させることができる。
	public static void sort(Comparable a[], int n) {
			for(int i = 0; i < n; i++) {
				int m=i;
				for(int j = i+1; j < n; j++) {
					if(a[j].compareTo(a[m]) < 0)
						m = j;
				}
				Comparable p = a[i];
				a[i] = a[m];
				a[m] = p;
			}
		}

}
