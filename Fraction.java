//*ソート前
//*case 1 = 3/3 2/3 1/3 4/5 3/5 5/5 2/5 1/5 2/3 2/3
//*case 2 = 0/9 9/9 1/9 8/9 2/9 7/9 3/9 6/9 4/9 5/9
//*case 3 = 1/3 2/3 5/3 8/3 4/3 7/3 4/3 9/3 7/3 3/3

//*ソート後
//* case 1 = 1/5 1/3 2/5 3/5 2/3 2/3 2/3 4/5 5/5 3/3
//* case 2 = 0/9 1/9 2/9 3/9 4/9 5/9 6/9 7/9 8/9 9/9
//* case 3 = 1/3 2/3 3/3 4/3 4/3 5/3 7/3 7/3 8/3 9/3
//*

//*case 1 では、自然な（昇順や逆順に近くない）ものを用意した。
//*case 2 では、分母がすべて同じ値のときを用意した。
//*case 3 では、分数が1以上になる値を複数入れてテストした。

//*今回は、整列アルゴリズムを自分で定義したクラスのオブジェクトに適用する
//*Fractionクラスは、分数を表現する意図のクラスである。

package task08;

public class Fraction implements Comparable<Fraction> {
	//		分数を表現する。
	//		分子は numerator,分母はdenominatorで保持する。
	//		分母は正でなくてはならない。
	//  Comparable インターフェイスを実装する。

	private int numerator; //　　分子
	private int denominator; //  分母

	// コンストラクタ：
	// 分子が numerator、分母が denominator のFraction オブジェクトを作成する
	public Fraction(int numerator, int denominator) {
		if (denominator <= 0) {
			throw new RuntimeException("分母が０または負です");
		}
		this.numerator = numerator;
		this.denominator = denominator;
	}

	// この分数とfを比較し、結果のint値を返す。
	// Comparableインターフェイスの仕様に従う。

	//*前回のStringクラスとIntegerクラスは既にComparableインターフェイスを実装していたため、
	//*比較にcompareToを使用することができたが、
	//*今回は自分で定義したクラスのオブジェクトに適用するため
	//*compareToを使うことができない
	//*よって、ここで分数の比較を行うプログラムを記述する。
	//*fは、分数を表し、C言語でいう構造体のような役割を果たす。

	//*分数の比較をするには、分母を揃えて分子の大小を比較すればよい
	//*分母同士をかけ合わせれば公倍数となり、分母が等しくなるので、
	//*その時の分子を比較すればよい
	//*fの分子がthisの分子より小さいときは正の値、等しいときは0、大きいときは負の値を返す

	@Override
	public int compareTo(Fraction f) {
		if (f.numerator * this.denominator < this.numerator * f.denominator)
			return 1;

		else if (f.numerator * this.denominator == this.numerator * f.denominator)
			return 0;

		else
			return -1;

	}

	// この分数を約分して既約にする
	// 分子が0の場合の既約分数は 0/1とする
	// ** 未実装 **
	public void reduce() {
	}

	// この分数の符号を反転した結果のFraction オブジェクトを新しく作り返す
	// ** 未実装 **
	public Fraction negate() {
		return null;
	}

	// この分数と fを足した結果を既約にした Fraction オブジェクトを新しく作り返す
	// ** 未実装 **
	public Fraction add(Fraction f) {
		return null;
	}

	// この分数から fを引いた結果を既約にした Fraction オブジェクトを新しく作り返す
	// ** 未実装 **
	public Fraction subtract(Fraction f) {
		return null;
	}

	// この分数と fを掛けた結果を既約にした Fraction オブジェクトを新しく作り返す
	// ** 未実装 **
	public Fraction multiply(Fraction f) {
		return null;
	}

	// この分数を fで割った結果を既約にした Fraction オブジェクトを新しく作り返す
	// fはゼロでないと仮定する（呼び出し側の責任）。
	// ** 未実装 **
	public Fraction divide(Fraction f) {
		return null;
	}

	// 分子を取り出す。
	public int getNumerator() {
		return numerator;
	}

	// 分母を取り出す。
	public int getDenominator() {
		return denominator;
	}

	// この分数の文字列表現を返す。
	public String toString() {
		return numerator + "/" + denominator;
	}

	// 最大公約数

	private static int gcd(int n, int m) {
		// |n|と |m|の最大公約数を返す
		// n = 0 のときは|m|, m = 0のときは|n|を答えとする
		if (n < 0)
			n = -n;
		if (m < 0)
			m = -m;
		while (n > 0 && m > 0) {
			if (n > m)
				n = n % m;
			else
				m = m % n;
		}
		if (n == 0)
			return m;
		else
			return n;
	}

	//*Fraction 型の配列について、int 型配列やString 型配列と同様に
	//*変数宣言と配列オブジェクトの作成を同時に行うことができる。
	//*なお、Fraction クラスは次のようにtoString メソッドを上書きしているため、
	//*Fraction オブジェクトのprint時には3/5 のように自然に表現される。
	//*switch文で、iの値が変わることで呼び出す配列を変えることができる

	public static Fraction[] testInput(int i) {
		// i の値に応じて、テスト用のFraction配列を返す。
		// 配列の要素数は、いずれの場合も１０以上とする。
		// 現在は、要素数が0の配列を返すようになっている。
		switch (i) {
		case 1:
			return new Fraction[] { new Fraction(3, 3), new Fraction(2, 3), new Fraction(1, 3),
					new Fraction(4, 5), new Fraction(3, 5), new Fraction(5, 5), new Fraction(2, 5), new Fraction(1, 5),
					new Fraction(2, 3), new Fraction(2, 3) };

		case 2:
			return new Fraction[] { new Fraction(0, 9), new Fraction(9, 9), new Fraction(1, 9), new Fraction(8, 9),
					new Fraction(2, 9), new Fraction(7, 9), new Fraction(3, 9), new Fraction(6, 9), new Fraction(4, 9),
					new Fraction(5, 9), new Fraction(2, 9), };

		case 3:
			return new Fraction[] { new Fraction(1, 3), new Fraction(2, 3), new Fraction(5, 3), new Fraction(8, 3),
					new Fraction(4, 3), new Fraction(7, 3), new Fraction(4, 3), new Fraction(9, 3), new Fraction(7, 3),
					new Fraction(3, 3), new Fraction(10, 3), };
		}
		return null;
	}

	public static void main(String args[]) {
		// 必須課題では何もする必要がない
	}
}
