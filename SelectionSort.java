package task03;

public class SelectionSort {
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


	//*ソートのプログラムでは、左から配列の要素を調べていき、より小さい値があった場合に入れ替え、
	//*小さい順に整列させる
	private static void sort(int a[], int n) {

		//*まず１つ目のfor文で順番に基準の値を決めていく
		for(int i = 0; i < n; i++) {
			//*iの値をmで保存しておく
			int m=i;

			//*基準の値・a[m]より小さい値がないか２つ目のfor文で順番に調べていく
			for(int j = i+1; j < n; j++) {

				//*そして、小さい値があればその添え字をmに代入していく
				if(a[j] < a[m])
					m = j;
			}

			//*２つ目のfor文が終わった後、配列の要素同士を入れ替える
			int p = a[i];
			a[i] = a[m];
			a[m] = p;
		}
	}
	//*これを1つ目のfor文で繰り返すことで、配列の要素を小さい順に並び替え、整列させることができる。
}

