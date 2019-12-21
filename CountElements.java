package task13;

//*他のパッケージで定義されたクラスやインターフェイスを使用するために
//*インポート文を記述する
//*この課題では、java.util パッケージのMap インターフェイスとHashMap クラスを使用するので、
//*ここで記述する
import java.util.HashMap;
import java.util.Map;

public class CountElements{

	public static void count(String a[]) {
		//*ここではMapインターフェイスとHashMap クラスを用いるため、
		//*それを定義し、マップを表すオブジェクトを生成する
		Map map = new HashMap();

		//*配列a の各要素について前から順番に、その要素と、
		//*それが同じ文字列の何番目の出現であるかを出力する
		for(int i = 0; i < a.length; i++) {
			//*もしmap.get(a[i])がnullであったときは、
			//*まだその要素がないということなので、何番目であるかの整数値を1として、
			//*文字列と整数値をmapへ登録する
			if(map.get(a[i]) == null)
				map.put(a[i], 1);

			//*もしmap.get(a[i])がnullでなかったときは、
			//*map内に既に同じ文字列があるということなので、
			//*何番目であるかの整数値を、map.get(a[i])の次の値、つまりmap.get(a[i])＋1とする
			//*戻り値が、たとえばInteger クラスオブジェクトであることがわかっていて、
			//*そのように使いたいため、戻り値を該当クラスの型にキャストして用いる
			else
			    map.put(a[i], (Integer)map.get(a[i])+1);

			System.out.println(a[i] + " " + (Integer)map.get(a[i]));
		}


	}
	//*mainメソッドでCounteElements が正しく動くことを確認するテストを行う
	 public static void main(String[] args) {

		 //*まず、String型の配列a　を用意する
		 String a[];
		 a =   new String[] {"ab","ac","abc","bd","ab","ab","bd","ca","cba"};

		 //*何をテストしたかわかるようにa　の配列の内容を出力する
		 System.out.print("a = {");
		 for(int i = 0; i < a.length; i++)
		   System.out.print(a[i] + " ");
		 System.out.println("}");

         //*上記で作成したクラスCountElementsを実行する
		 count(a);

		 //*ここで、aの配列のテストでは文字列が2個以上の時を考え、
		 //*同じ値が再度出てきたときは、何番目であるかの整数値が1ずつ増えていくことが
		 //*確認できた

		 //*また文字列が途中まで同じ、もしくは一部が同じとき（ここではab と abc等)も
		 //*きちんと違う値として処理されていることが、結果から確認することができた

		 System.out.println();

		//*次に、String型の配列b　を用意する
		 String b[];
		 b =   new String[] {"acd","ac","  ","ad","acd","e","a","e","e","e","e"};

		//*何をテストしたかわかるようにb　の配列の内容を出力する
		 System.out.print("b = {");
		 for(int i = 0; i < b.length; i++)
		   System.out.print(b[i] + " ");
		 System.out.println("}");

		 //*ここでも同様に、上記で作成したCountElementsを実行する
		 count(b);

		 //*ここでは文字列が1つだった場合のテストも行った
		 //*この結果により、文字列が1つの時もそれぞれが正しく処理されていることが分かった
		 //*また、空白の時も結果が正しく出力された
	 }

}
