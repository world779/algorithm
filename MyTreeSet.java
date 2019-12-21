//*�@����́A���L�ō����b�Ƃ����W����I��  b = {0,1,3,5,6,8,9,10}

//*root �ɂ���ĎQ�Ƃ����Node �I�u�W�F�N�g��node1�A
//*root.left �ŎQ�Ƃ����Node �I�u�W�F�N�g���@node2�A...�ƌĂԂ��Ƃɂ���
//*root.right �ŎQ�Ƃ����Node �I�u�W�F�N�g���@node10�A...�ƌĂԂ��Ƃɂ���
//*�@�܂��A���s����new�ł�����Node �I�u�W�F�N�g���Anewnode�Ƃ���


//*1. ����Ώۂ̕ϐ��F x  ��������l�F7
//*1. Node �^�ϐ��ւ̑���F�@����Ώۂ̕ϐ�: node1 ��������l:root
//*2. �ǉ������l�Ɗ��ɂ���l�̔�r
//*2.v.value.compareTo(x) > 0,  v.value = node1.value = 6, x = 7,  node1.value < x
//*1. Node �^�ϐ��ւ̑���F�@����Ώۂ̕ϐ�: node10 ��������l:node1.right  
//*2.v.value.compareTo(x) > 0,  v.value = node10.value = 10, x = 7,  node10.value > x
//*1. Node �^�ϐ��ւ̑���F�@����Ώۂ̕ϐ�: node11 ��������l:node10.left 
//*2.v.value.compareTo(x) > 0,  v.value = node11.value = 8, x = 7,  node11.value > x
//*node11.left == null�Ȃ̂�
//*node11.left = new Node(7, null, null);
//*�܂�Anewnode.value = 7

package task12;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class MyTreeSet implements Set{

	//*�؂̍��̃m�[�h���Q�Ƃ���Node �^�ϐ���root�Ƃ���
	private Node root;

	
	//*�A�����X�g�̏ꍇ�̃��X�g�Z���̂����ɁA�m�[�h��\�������N���XNode���g�p����
	private class Node {
		//*right�͉E���Q�Ƃ��Aleft�͉E���Q�Ƃ���Bvalue��node�ɓ����Ă���l�ł���
		private Comparable value;
		private Node left, right;
		private Node(Object value, Node left, Node right) {
		this.value = (Comparable) value;
		this.left = left;
		this.right = right;
		}
		}

	//*���̏W���i����������悤�Ƃ��Ă���I�u�W�F�N�g�j����̏W���ɏ���������
	public MyTreeSet() {
       root = null;
	}


	@Override
	public int size() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return false;
	}

	@Override
	//*���̏W���ithis �̎Q�Ƃ���I�u�W�F�N�g�j��x ��v�f�Ƃ��Ď����Ă����true, �����Ă��Ȃ����false ��Ԃ�
	public boolean contains(Object x) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		Node v = root; // ������o������B
		//*�l���A�m�[�h���Ȃ��Ȃ�܂�1�����ׂĂ���
		while (v != null) {
		//*���������v�f�������Ă����true��Ԃ�
		if (x.equals(v.value))  return true;
		
		//*�v�f���Ⴄ�ꍇ�͎��̒l���Q�Ƃ���悤�ɂ���
		if (v.value.compareTo(x) > 0) v = v.left;
		else v = v.right;
		}
		//*�����܂łŕԂ�l�������Ȃ���΁A�����v�f���Ȃ��Ƃ������ƂȂ̂�false��Ԃ�
		return false;
	}

	@Override
	public Iterator iterator() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return null;
	}

	@Override
	public Object[] toArray(Object[] a) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return null;
	}

	@Override
	//*���̏W���ɗv�fx ��ǉ�����B
	//*���Ƃ���x �����̏W���̗v�f�łȂ��A���ۂɒǉ��ł����Ƃ���true�A
	//*�����łȂ��Ƃ���false ��Ԃ�
	public boolean add(Object x) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u

		//*root �̒l��null �ł���Ƃ��A�؂͋�ł��������Ă��̕\���W������ł���
		//*���̂��߁A�V�����l��ǉ����Breturn��Ԃ�
		if (root == null) {
		root = new Node(x, null, null);
		return true;
		}
		Node v = root; //������T�����J�n
	
		while (true) {
		//*���������v�f������Ηv�f�̒ǉ����s��Ȃ��̂�false��Ԃ�
		if (x.equals(v.value)) {
		 return false;
		}
		
		//*�����ǉ��������v�f���A�Q�Ƃ��Ă���node�̗v�f�̒l�����������Ƃ�
		if (v.value.compareTo(x) > 0) {
			//*�܂����̐��node������ꍇ�́A����node���Q�Ƃ���悤�ɂ���
		if (v.left != null) {
		 v = v.left;
		}
		//*�������̐��node���Ȃ��ꍇ�́A�l��ǉ�����
		else {
			v.left = new Node(x, null, null);
		return true;
		}
		}
		
		//*�����ǉ��������v�f���A�Q�Ƃ��Ă���node�̗v�f�����傫���Ƃ�
		else {
			//*�������node������ꍇ�́A����node���Q�Ƃ���悤�ɂ���
			if (v.right != null) {
				 v = v.right;
			}
			//*�������̐��node���Ȃ��ꍇ�́A�l��ǉ�����
			else {
				v.right = new Node(x, null, null);
				  return true;
			}
		}
		}
		}


	@Override
	public boolean remove(Object o) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return false;
	}

	@Override
	public boolean containsAll(Collection c) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return false;
	}

	@Override
	public boolean addAll(Collection c) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return false;
	}

	@Override
	public boolean retainAll(Collection c) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return false;
	}

	@Override
	public boolean removeAll(Collection c) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return false;
	}

	@Override
	public void clear() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u

	}

	//*�e�X�g��f�o�b�O�̂��߂ɁAtoString ���\�b�h�����̂悤�ɏ㏑�����Ă���
	public String toString() {
		return "{" + toString(root) + "}";
		}
		private String toString(Node v) {
		if (v == null) {
		return "";
		}
		StringBuilder sb = new StringBuilder();
		if (v.left != null) {
		sb.append(toString(v.left) + ",");
		}
		sb.append(v.value);
		if (v.right != null) {
		sb.append("," + toString(v.right));
		}
		return sb.toString();
		}

		//*MytreeSet �N���X��main ���\�b�h�ŁAMyTreeSet �I�u�W�F�N�g��2����A
		//*���ꂼ��ɑ΂��āAadd�Acontains�A �@�̊e���\�b�h�̎��s�����ꂼ��s��
    public static void main(String[] args) {
		MyTreeSet a = new MyTreeSet();
		MyTreeSet b = new MyTreeSet();

		
		//*���������Ă��Ȃ��Ƃ��̋A������������ōs����
		System.out.print("1  ");
		System.out.print(a.contains(1));
		System.out.println();
		System.out.println();

		//*�e���\�b�h�����ꂼ����s���A�o�͂���
		//*���s�O a.n = 0, a.a = {}
		a.add(1);
		//*���s�� a.n = 1, a.a = {1}
		System.out.print("a = ");
		System.out.print(a);
		//System.out.print("size = ");
		//System.out.print(a.size());
		System.out.println();

		System.out.print("1  ");
		System.out.print(a.contains(1));
		System.out.println();
		System.out.println();


		
		a.add(9);
		System.out.print("a = ");
		System.out.print(a);
		System.out.println();
		//System.out.print("size = ");
		//System.out.print(a.size());
		System.out.print("0  ");
		System.out.print(a.contains(0));
		System.out.println();
		System.out.print("9  ");
		System.out.print(a.contains(9));
		System.out.println();
		System.out.println();
		

		
		a.add(8);
		System.out.print("a = ");
		System.out.print(a);
		System.out.println();
		//System.out.print("size = ");
		//System.out.print(a.size());
		System.out.print("3  ");
		System.out.print(a.contains(3));
		System.out.println();
		System.out.print("8  ");
		System.out.print(a.contains(8));
		System.out.println();
		System.out.println();
		
		a.add(7);
		System.out.print("a = ");
		System.out.print(a);
		System.out.println();
		System.out.print("2  ");
		System.out.print(a.contains(2));
		System.out.println();
		System.out.print("1  ");
		System.out.print(a.contains(1));
		System.out.println();
		//System.out.print("size = ");
		//System.out.print(a.size());
		System.out.println();
		
		a.add(7);
		
		System.out.print("a = ");
		System.out.print(a);
		System.out.println();
		System.out.print("5  ");
		System.out.print(a.contains(5));
		System.out.println();
		//System.out.print("size = ");
		//System.out.print(a.size());
		System.out.println();

		a.add(5);
		
		System.out.print("a = ");
		System.out.print(a);
		System.out.println();
		System.out.print("4  ");
		System.out.print(a.contains(4));
		System.out.println();
		//System.out.print("size = ");
		//System.out.print(a.size());
		System.out.println();

		a.add(4);
		
		System.out.print("a = ");
		System.out.print(a);
		System.out.println();
		System.out.print("10  ");
		System.out.print(a.contains(10));
		System.out.println();
		//System.out.print("size = ");
		//System.out.print(a.size());
		System.out.println();

		a.add(3);
		
		System.out.print("a = ");
		System.out.print(a);
		System.out.println();
		System.out.print("2  ");
		System.out.print(a.contains(2));
		System.out.println();
		//System.out.print("size = ");
		//System.out.print("a.size());
		System.out.println();

		a.add(2);
		
		System.out.print("a = ");
		System.out.print(a);
		System.out.println();
		System.out.print("1  ");
		System.out.print(a.contains(1));
		System.out.println();
		//System.out.print("size = ");
		//System.out.print(a.size());
		System.out.println();

/*
		//*���s�O a.n = 5, a.a = {1,3,5,7,9}
		a.remove(1);
		//*���s�� a.n = 4, a.a = {3,5,7,9}
		System.out.print("a = ");
		System.out.print(a);
		System.out.println();
		System.out.print("size = ");
		System.out.print(a.size());
		System.out.println();

		//*���s�O a.n = 4, a.a = {3,5,7,9}
		a.remove(4);
		//*���s�� a.n = 4, a.a = {3,5,7,9}
		System.out.print("a = ");
		System.out.print(a);
		System.out.println();
		System.out.print("size = ");
		System.out.print(a.size());
		System.out.println();

		//*���s�O a.n = 4, a.a = {3,5,7,9}
		a.remove(2);
		//*���s�� a.n = 4, a.a = {3,5,7,9}
		System.out.print("a = ");
		System.out.print(a);
		System.out.println();
		System.out.print("size = ");
		System.out.print(a.size());
		System.out.println();

		//*���s�O a.n = 4, a.a = {3,5,7,9}
		a.remove(5);
		//*���s�� a.n = 3, a.a = {3,7,9}
		System.out.print("a = ");
		System.out.print(a);
		System.out.println();
		System.out.print("size = ");
		System.out.print(a.size());
		System.out.println();

		//*���s�O a.n = 3, a.a = {3,7,9}
		a.remove(0);
		//*���s�� a.n = 3, a.a = {3,7,9}
		System.out.print("a = ");
		System.out.print(a);
		System.out.println();
		System.out.print("size = ");
		System.out.print(a.size());
		System.out.println();
		System.out.println();

*/

/*
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
*/
		System.out.println();
		System.out.println();
		System.out.println();


		System.out.print("5  ");
		System.out.print(b.contains(5));
		System.out.println();
		System.out.println();
		b.add(6);
		System.out.print("b = ");
		System.out.print(b);
		System.out.println();
		System.out.print("1  ");
		System.out.print(b.contains(1));
		System.out.println();
		System.out.println();
		//System.out.print("size = ");
		//System.out.print(b.size());
		b.add(10);
		System.out.print("b = ");
		System.out.print(b);
		System.out.println();
		System.out.print("8  ");
		System.out.print(b.contains(8));
		System.out.println();
		System.out.println();
		b.add(3);
		System.out.print("b = ");
		System.out.print(b);
		System.out.println();
		System.out.print("6  ");
		System.out.print(b.contains(6));
		System.out.println();
		System.out.println();
		b.add(5);
		System.out.print("b = ");
		System.out.print(b);
		System.out.println();
		System.out.print("7  ");
		System.out.print(b.contains(7));
		System.out.println();
		System.out.println();
		b.add(8);
		System.out.print("b = ");
		System.out.print(b);
		System.out.println();
		System.out.print("2  ");
		System.out.print(b.contains(2));
		System.out.println();
		System.out.println();
		//System.out.print("size = ");
		//System.out.print(b.size());
		System.out.println();

		b.add(9);
		System.out.print("b = ");
		System.out.print(b);
		System.out.println();
		System.out.print("6  ");
		System.out.print(b.contains(6));
		System.out.println();
		System.out.println();

		b.add(0);
		System.out.print("b = ");
		System.out.print(b);
		System.out.println();
		System.out.print("0  ");
		System.out.print(b.contains(0));
		System.out.println();
		System.out.println();

		b.add(1);
		System.out.print("b = ");
		System.out.print(b);
		System.out.println();
		System.out.print("7  ");
		System.out.print(b.contains(7));
		System.out.println();
		System.out.println();



		/*b.remove(6);
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
*/


	}


}

