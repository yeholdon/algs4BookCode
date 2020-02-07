package base;
import java.util.Iterator;
import edu.princeton.cs.algs4.*;
/*
 * 泛型可迭代的Queue数据类型的API：
 * Queue():创建一个空列表
 * void enqueue(Item item):添加一个元素
 * Item dequeue():删除最早添加的元素
 * boolean isEmpty():队列是否为空
 * int size():队列中的元素数量
 */
public class Queue<Item> implements Iterable<Item>{

	private Node first;
	private Node last;
	private int N;
	private class Node
	{
		Item item;
		Node next;
	}
	public boolean isEmpty(){return first==null;}
	public int size() {return N;}
	public void enqueue(Item item)
	{
		Node oldlast=last;
		last=new Node();
		last.item=item;
		last.next=null;
		if(isEmpty())first=last;
		else oldlast.next=last;
		N++;
	}
	public Item dequeue() 
	{
		Item item=first.item;
		first=first.next;
		if(isEmpty())last=null;
		N--;
		return item;
	}
	public Iterator<Item>iterator(){	return new ListIterator();	}
	
	private class ListIterator implements Iterator<Item>
	{
		private Node current = first;
		public boolean hasNext() {	return current != null;	}
		public void remove() {}
		public Item next()
		{
			Item item = current.item;
			current = current.next;
			return item;
		}
	}

	public static void main(String[] args) {
		Queue<String> q = new Queue<String>();
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-")) q.enqueue(item);
			else if (!q.isEmpty()) StdOut.print(q.dequeue() + " ");
		}
		StdOut.println("(" + q.size() + " left on queue)");
	}
}
