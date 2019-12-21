//* 今回は、配列aとbの対を選んだ
//* a = new String[] {"f","a","y","y","s","y","s","d","a","y"};
//* b = new String[] {"z","y","x","w","v","u","t","s","r","q"};

//*トレース
//*1. add メソッドの実行  s.add(a[0]); 集合s = {f}
//*1. add メソッドの実行  s.add(a[1]); 集合s = {f,a}
//*1. add メソッドの実行  s.add(a[2]); 集合s = {f,a,y}
//*1. add メソッドの実行  s.add(a[3]); 集合s = {f,a,y,y}
//*1. add メソッドの実行  s.add(a[4]); 集合s = {f,a,y,y,s}
//*1. add メソッドの実行  s.add(a[5]); 集合s = {f,a,y,y,s,y}
//*1. add メソッドの実行  s.add(a[6]); 集合s = {f,a,y,y,s,y,s}
//*1. add メソッドの実行  s.add(a[7]); 集合s = {f,a,y,y,s,y,s,d}
//*1. add メソッドの実行  s.add(a[8]); 集合s = {f,a,y,y,s,y,s,d,a}
//*1. add メソッドの実行  s.add(a[9]); 集合s = {f,a,y,y,s,y,s,d,a,y}

//*2. contains メソッドの実行  s.contains(b[0]); false
//*2. contains メソッドの実行  s.contains(b[1]); true
//*2. contains メソッドの実行  t.contains(b[1]); false
//*3. 要素のプリント  1行目 "y"

//*1. add メソッドの実行  t.add(b[1]); 集合t = {y}

//*2. contains メソッドの実行  s.contains(b[2]); false
//*2. contains メソッドの実行  s.contains(b[3]); false
//*2. contains メソッドの実行  s.contains(b[4]); false
//*2. contains メソッドの実行  s.contains(b[5]); false
//*2. contains メソッドの実行  s.contains(b[6]); false
//*2. contains メソッドの実行  s.contains(b[7]); true
//*2. contains メソッドの実行  t.contains(b[7]); false
//*3. 要素のプリント  2行目 "s"

//*1. add メソッドの実行  t.add(b[7]); 集合t = {y,s}

//*2. contains メソッドの実行  s.contains(b[8]); false
//*2. contains メソッドの実行  s.contains(b[9]); false



package task09;


//*他のパッケージで定義されたクラスやインターフェイスを使用するために
//*インポート文を記述する
//*インポート文が必要
//*この課題では、java.util パッケージのSet インターフェイスとHashSet クラスを使用するので、
//*ここで記述する
import java.util.HashSet;
import java.util.Set;



public class SetExercise {
	//*配列a と配列b の両方に共通して現れる要素を一行にひとつずつ出力する。
	private static void printCommonElements(Object[] a, Object[] b) {
		//*ここではSetインターフェイスとHashSet クラスを用いるため、
		//*それを定義する
		//*のちに重複を避けるために使う集合sも定義しておく
		Set s = new HashSet();
		Set t = new HashSet();

		//*配列aの要素をすべてひとつの集合sに格納する
		for(int i = 0; i < a.length; i++)
			s.add(a[i]);


        //*配列b の要素を順に見て行き、s の要素であるなら出力する
		//*重複を避けるために定義しておいた集合ｔを使い、
		//*配列b の要素を処理するたびに、集合tにその要素を追加し、
		//*ある要素が前にも現れたかどうか、集合tに対するcontains メソッドによって判定する
		//*
		for(int j = 0; j < b.length; j++) {
			boolean k = s.contains(b[j]);
			if (k == true) {
				boolean l = t.contains(b[j]);
				if (l != true) {
					System.out.println(b[j]);
					t.add(b[j]);
				}
			}
		}
	}

	//*mainメソッドでprintCommonElements が正しく動くことを確認するテストを行う
	public static void main(String[] args) {
		//*String型とInteger型の配列を用意する。
		String a[];
		String b[];
		String c[];


		a = new String[] {"f","a","y","y","s","y","s","d","a","y"};
		b = new String[] {"z","y","x","w","v","u","t","s","r","q"};
		c = new String[] {"abc","bab","bcd","abcd","abcde","a","b","bbb","ab","c"};

		Integer d[] = new Integer[] {5,2,6,8,3,1,3,5,7,3};
		Integer e[] = new Integer[] {9,3,7,6,5,4,3,2,1,0};
		Integer f[] = new Integer[] {123,1,2,3,12,1234,23,134,13,14};



		//*用意した配列の内容をそれぞれ出力する
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


        //*String型の配列に対してテストする
		printCommonElements(a,b); System.out.println();
		printCommonElements(b,c); System.out.println();
		printCommonElements(a,c); System.out.println();

        //*Integer型の配列に対してテストする
		printCommonElements(d,e); System.out.println();
		printCommonElements(e,f); System.out.println();
		printCommonElements(d,f);


	}
}

