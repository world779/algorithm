package task04;

public class InsertionSort {
	//*大きさ10 以上のint 型の配列a, b, c を用意し、それらの要素を適当に初期化する。
	//*a, b, c 三つの配列のそれぞれについて順番に、配列の内容をprint し、
	//*sort を呼び出して整列し、再び配列の内容をprint する。
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
//*ソートのプログラムでは、左から調べて小さな値があった場合、その値を結果の列の適切な場所に挿入していき、
//*小さい順に整列させる
private static void sort(int a[], int n) {

	//*このfor文で左から値を確認していく
	for(int i = 0; i<n; i++) {

		//*a[i]の値をw、iの値をkで保存しておく
		int w = a[i];
		int k = i;

		//*while文で、a[k]の一つ左側にある値（a[k-1]）がa[k]より小さければ
		//*a[k-1]にあった要素を1つずらしa[k]に入れる
		//*これを、while文の条件を満たすだけ行う。
		//*つまり、a[k]にあった値が適切な場所に入るまで、
		//*その間にある要素を一つずつずらしていく
		while(k>0 && a[k-1]>w) {
			a[k] = a[k-1];
			k--;
		}
		//*もともとa[k]にあった値をwに保存しておいたので、
		//*適切な場所、つまりwhile文の条件を満たさなくなったとき、
		//*その配列の要素としてwを代入する
		a[k] = w;
	}
}
}
