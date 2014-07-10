import java.util.Scanner;
import java.util.ArrayList;
import java.util.ListIterator;
import java.io.*;

public class wordCount 
{
	File src;
	Scanner in;
	ArrayList<Node> list;
	ListIterator<Node> iter;
	
	public wordCount ( String s ) 
	{
		long startTime = System.currentTimeMillis();
		list = new ArrayList<Node>();
		try 
		{
			in = new Scanner(src = new File(s));
			while ( in.hasNext() ) 
			{	
				String str = in.next();
				str = str.replaceAll("\\p{P}","");
				str = str.replaceAll("\\s","");
				
				if ( !str.equals("") ) 
				{
					Node n = new Node(str,1);
					if ( !exists(n,list) ) 
					{
						list.add(n);
					}
				}
			}
			iter = list.listIterator();
			
			Node[] orderedNodes = toOrderedArray( list,iter );
			printList( orderedNodes );
		} 
		catch ( FileNotFoundException e ) 
		{
			System.out.println( e.getMessage() );
			e.printStackTrace();
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println( "\nRuntime: " + ( ( (float)( endTime - startTime ) / 1000 ) + "s" ) );
	}
	
	public Node[] toOrderedArray ( ArrayList<Node> list, ListIterator<Node> iter ) 
	{
		Node[] nodes = new Node[list.size()];
		int i=0;
		while ( list.size() > 0 ) 
		{
			Node n = findMax( list,iter );
			nodes[i] = n;
			i++;
			list.remove( n );
		}
		return nodes;
	}
	
	public Node findMax ( ArrayList<Node> list, ListIterator<Node> iter ) 
	{
		
		//Default value for each Node is 1.
		Node n = null;
		int max = 0;
		for ( int i=0;i<list.size();i++ ) 
		{
			if ( list.get(i).count > max ) 
			{
				n = list.get( i );
				max = n.count;
			}
		}
		return n;
	}
	
	public boolean exists ( Node n, ArrayList<Node> list ) 
	{
		
		for ( int i=0;i<list.size();i++ )  
		{
			Node m = list.get(i);
			if ( n.data.equals(m.data) ) 
			{
				m.count++;
				return true;
			}
		}
		return false;
	}
	
	public void printList ( Node[] nodes ) 
	{
		PrintWriter pw;
		try 
		{
			pw = new PrintWriter( "wordCount_Output_HP.txt","UTF-8" );
			for ( int i=0;i<nodes.length;i++ ) 
			{
				pw.println( "("+nodes[i].data+", "+nodes[i].count+")" );
			}
			pw.close();
		} 
		catch ( FileNotFoundException e ) 
		{
			System.out.println( e.getMessage() );
			e.printStackTrace();
		} 
		catch ( UnsupportedEncodingException e ) 
		{
			System.out.println( e.getMessage() );
			e.printStackTrace();
		}
	}
	
	public static void main (String args[]) 
	{
		new wordCount( "HarryPotter1-7.txt" );
	}
}

