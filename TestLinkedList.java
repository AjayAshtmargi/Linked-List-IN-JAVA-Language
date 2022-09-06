import java.util.Scanner;
class Node
{
	private int data;
	private Node Next;
	public Node()
	{
		data=0;
		Next=null;
	}
	public Node(int d, Node n)
	{
		data=d;
		Next=n;
	}
	public void setData(int d)
	{
		data=d;
	}
	public void setNext(Node n)
	{
		Next=n;
	}
	public int getData()
	{
		return(data);
	}
	public Node getNext()
	{
		return(Next);
	}
}
class LinkedList
{
	private int size;
	private Node start;
	
	public LinkedList()
	{
		size=0;
		start=null;
	}
	public void insertAtFirst(int val)
	{
		Node n;
		n=new Node();
		n.setData(val);
		n.setNext(start);
		start=n;
		size++;
	}
	public void insertAtLast(int val)
	{
		Node n,t;
		n=new Node();
		n.setData(val);
		t=start;
		if(t==null)
			start=n;
		else
		{
			while(t.getNext()!=null)
				t=t.getNext();
			t.setNext(n);
		}
		size++;
	}
	public void insertAtPos(int val, int pos)
	{
		if(pos==1)
			insertAtFirst(val);
		else if(pos==size+1)
			insertAtLast(val);
		else if(pos>1 && pos<=size)
		{
			Node n,t;
			n=new Node(val, null);
			t=start;
			for(int i=1;i<pos-1;i++)
				t=t.getNext();
			n.setNext(t.getNext());
			t.setNext(n);
			size++;
		}
		else
			System.out.println("Insertion not possible at position" +pos);
	}
	public void deleteAtPos(int pos)
	{
		if(start==null)
			System.out.println("List is already empty");
		else if(pos<1 || pos>size)
			System.out.println("Invalid position");
		else if(pos==1)
			deleteFirst();
		else if(pos==size)
			deleteLast();
		else
		{
			Node t,t1;
			t=start;
			for(int i=1;i<pos-1;i++)
				t=t.getNext();
			t1=t.getNext();
			t.setNext(t1.getNext());
			size--;
		}
	}
	public void deleteLast()
	{
		if(start==null)
			System.out.println("List is already empty");
		else if(size==1)
		{
			start=null;
			size--;
		}
		else
		{
			Node t;
			t=start;
			for(int i=1;i<size-1;i++)
				t=t.getNext();
			t.setNext(null);
			size--;
		}
	}
	public void deleteFirst()
	{
		if(start==null)
			System.out.println("List is alrady empty");
		else
		{
			start=start.getNext();
			size--;
		}
	}
	public boolean isEmpty()
	{
		if(start==null)
			return(true);
		else
			return(false);
	}
	public int getListSize()
	{
		return(size);
	}
	public void viewList()
	{
		Node t;
		if(isEmpty())
			System.out.println("List is empty");
		else
		{
			t=start;
			for(int i=1;i<=size;i++)
			{
				System.out.println(" "+t.getData());
				t=t.getNext();
			}
		}
	}
}

public class TestLinkedList
{
	public static void main(String []args)
	{
		Scanner sc=new Scanner(System.in);
		LinkedList list = new LinkedList();
		boolean flag=true;
		while(flag)
		{
			System.out.println(" ");
			System.out.println("1. Add Item to the list at start");
			System.out.println("2. Add Item to the list at last");
			System.out.println("3. Add item to the list at position");
			
			System.out.println("4. Delete first item from the list");
			System.out.println("5. Delete last item from the list");
			System.out.println("6. Delete item from the list with given position");
			
			System.out.println("7. View List");
			System.out.println("8. Exit");
			System.out.println("Enter your choice");
			
			int choice=sc.nextInt();
			int position, val;
			switch(choice)
			{
				case 1:
				System.out.println("Enter the value of the list item");
				val=sc.nextInt();
				list.insertAtFirst(val);
				break;
				
				case 2:
				System.out.println("Enter the value of the list item");
				val=sc.nextInt();
				list.insertAtLast(val);
				break;
				
				case 3:
				System.out.println("Enter position");
				position=sc.nextInt();
				System.out.println("Enter value of list item");
				val=sc.nextInt();
				list.insertAtPos(val, position);
				break;
				
				case 4:
				list.deleteFirst();
				break;
				
				case 5:
				list.deleteLast();
				break;
				
				case 6:
				System.out.println("Enter position");
				position=sc.nextInt();
				list.deleteAtPos(position);
				break;
				
				case 7:
				list.viewList();
				break;
				
				case 8:
				flag=false;
				break;
				
				default:
				System.out.println("Invalid choice");
			}
		}
	}
}