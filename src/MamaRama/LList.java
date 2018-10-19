package MamaRama;
public class LList 
{
	Node front = null;
	Node rear = null;
	class Node
	{
		int val;
		Node next = null;
		Node prev = null;

		public Node (int val)
		{
			this.val = val;
		}

		public Node (int val, Node next)
		{
			this.val = val;
			this.next = next;
		}

		public Node (int val, Node next, Node prev)
		{
			this.val = val;
			this.next = next;
			this.prev = prev;
		}
	}

	
	public void clear()
	{
		front = null;
		rear = null;
	}

	
	public void init(int[] ini)
	{
		if (ini == null)
		{
			ini = new int[0];
		} 
		clear();
		for (int i = 0; i < ini.length; i++)
		{
			addEnd(ini[i]);
		}
	}

	
	public int[] toArray()
	{
		int[] res = new int[size()];
		Node tmp = front;

		for (int i = 0; i < res.length; i++)
		{
			res[i] = tmp.val;
			tmp = tmp.next;
		}
		return res;
	}

	
	public String toString()
	{
		if(front == null)
			return "";
		String res ="";
		Node tmp = front;
		while (tmp.next != null)
		{
			res += tmp.val+", ";
			tmp = tmp.next;
		}
		res += tmp.val;
		return res;
	}

	
	public int size()
	{
		int count = 0;
		Node tmp = front;
		while (tmp!=null)
		{
			tmp = tmp.next;
			count++;
		}
		return count;
	}

	
	public void addStart(int val)
	{
		if (front == null)
			front = rear = new Node(val);
		else
		{
			Node tmp = new Node(val,front);
			front.prev = tmp;
			front = tmp;
		}		
	}

	
	public void addEnd(int val)
	{
		if (front == null)
			front = rear = new Node(val);
		else
		{
			rear.next = new Node(val,null,rear);
			rear = rear.next;
		}
	}

	
	public void addPos(int pos, int val)
	{
		if (pos < 0 || pos >size())
			throw new IllegalArgumentException();

		if(front == null || pos == 0)
			addStart(val);
		else if (pos == size())
		{
			addEnd(val);
		} 
		else 
		{
			int count = 0;
			Node tmp = front;
			while (count < pos-1)
			{
				tmp = tmp.next;
				count++;
			}	
			Node tmp1 = new Node(val,tmp.next,tmp);
			tmp.next = tmp1;
			tmp.next.prev = tmp1;
		}
	}

	
	public int delStart()
	{
		if (front == null)
			throw new IllegalArgumentException();
		int res = front.val;
		if(size() == 1)
			clear();
		else 
		{
			front = front.next;
			front.prev = null;
		}
		return res;
	}

	
	public int delEnd()
	{
		if (front == null)
			throw new IllegalArgumentException();

		int res = rear.val;
		if (size() == 1)
			clear();
		else
		{
			rear = rear.prev;
			rear.next = null;
		}
		return res;
	}

	
	public int delPos(int pos)
	{
		if (front == null || pos < 0 || pos >size()-1)
			throw new IllegalArgumentException();
		int res = front.val;
		if (size() == 1)
			clear();		
		else
			if(pos == 0)
				res = delStart();
			else
			{
				int count = 0;
				Node tmp = front;
				while (count < pos-1)
				{
					tmp = tmp.next;
					count++;
				}
				res = tmp.next.val;
				tmp.next = tmp.next.next;
			}
		return res;
	}

	
	public int min()
	{
		if (front == null)
			throw new IllegalArgumentException();

		int min = front.val;
		Node tmp = front;
		while (tmp!=null)
		{
			if (tmp.val < min)
			{
				min = tmp.val;
			}
			tmp = tmp.next;			
		}
		return min;
	}

	
	public int max()
	{
		if (front == null)
			throw new IllegalArgumentException();

		int max = front.val;
		Node tmp = front;
		while (tmp!=null)
		{
			if (tmp.val > max)
			{
				max = tmp.val;
			}
			tmp = tmp.next;			
		}
		return max;
	}

	
	public int minPos()
	{
		if (front == null)
			throw new IllegalArgumentException();

		int min = front.val;
		int minPos = 0;
		int count = 0;
		Node tmp = front;
		while (tmp!=null)
		{
			if (tmp.val < min)
			{
				min = tmp.val;
				minPos = count;
			}
			tmp = tmp.next;
			count++;			
		}
		return minPos;
	}

	
	public int maxPos()
	{
		if (front == null)
			throw new IllegalArgumentException();

		int max = front.val;
		int maxPos = 0;
		int count = 0;
		Node tmp = front;
		while (tmp!=null)
		{
			if (tmp.val > max)
			{
				max = tmp.val;
				maxPos = count;
			}
			tmp = tmp.next;
			count++;			
		}
		return maxPos;
	}

	
	public void sort()
	{
		if (front == null || size() == 1)
			return;
		Node tmp = new Node(min());
		delPos(minPos());

		Node tmp1 = tmp;

		while(front.next != null)
		{
			tmp1.next = new Node(delPos(minPos()));
			tmp1 = tmp1.next;			
		}
		tmp1.next = new Node(front.val);
		front = tmp;
	}

	
	public void reverse()
	{
		if (front == null || size() == 1)
			return;

		Node tmp = new Node(get(size()-1));
		delEnd();
		Node tmp1 = tmp;

		while (front != null)
		{
			tmp1.next = new Node(get(size()-1));
			delEnd();
			tmp1 = tmp1.next;
		}
		front = tmp;
	}

	
	public void halfReverse()
	{
		if(front == null || size() == 1)
			return;

		int count = 0;
		int l = size();
		Node tmp1 = front;
		Node tmp2 = front;
		
		while (count < l/2-1)
		{
			count++;		
			tmp1 = tmp1.next;							 
		}
		
		if(l%2 == 0)
		{
			tmp2 = tmp1.next;
			rear.next = front;
			front.prev = rear.next;
		}
		else
		{
			tmp2 = tmp1.next.next;
			rear.next = tmp1.next;
			tmp1.next.prev = rear;
			rear.next.next = front;
			front.prev = rear.next.next;	
		}
		tmp1.next = null;
		tmp2.prev = null;
		front = tmp2;
		rear = tmp1;

	}

	
	public int get(int pos)
	{
		if (front == null || pos < 0 || pos > size()-1)
			throw new IllegalArgumentException();
		int res=0;
		int count = 0;
		Node tmp = front;
		while (tmp!=null)
		{
			if (pos == count)
			{
				res = tmp.val; 
			}
			tmp = tmp.next;
			count++;
		}		
		return res;
	}

	
	public void set(int pos, int val)
	{
		if (front == null || pos < 0 || pos > size()-1)
			throw new IllegalArgumentException();
		int count = 0;
		Node tmp = front;

		while (tmp!=null)
		{
			if (pos == count)
			{
				tmp.val = val; 
			}
			tmp = tmp.next;
			count++;
		}			
	}

}