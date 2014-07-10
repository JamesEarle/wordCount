import java.util.ArrayList;
import java.util.ListIterator;
import java.io.*;

public class testList {
	
	ArrayList<String> listA;
	ListIterator<String> iterA;
	
	ArrayList<Node> listB;
	ListIterator<Node> iterB;
	
	public testList ( ) {
		
		/* Start of ArrayList<String> manipulation */
		listA = new ArrayList<String>();
		String[] str = {"Zero","One","Two","Three","Four","Five"};
		for (int i=0;i<str.length;i++) {
			listA.add(str[i]);
		}
		iterA = listA.listIterator();
		while ( iterA.hasNext() ) {
			String s = iterA.next();
			System.out.println(s);
		}
		/* End of ArrayList<String> manipulation */
		/* * * * * * * * * * * * * * * * * * * * */
		/* Start of ArrayList<Node> manipulation */
		listB = new ArrayList<Node>();
		Node[] nodes = { new Node("Alpha",1), new Node("Bravo",1),
				new Node("Charlie",1), new Node("Delta",1), 
				new Node("Echo",1), new Node("Foxtrot",1) };
		for (int i=0;i<nodes.length;i++) {
			listB.add(nodes[i]);
		}
		iterB = listB.listIterator();
		while ( iterB.hasNext() ) {
			Node n = iterB.next();
			System.out.println(n.data + " - " + n.count);
		}
		/* End of ArrayList<Node> manipulation */
		
	}
	
	
	public static void main (String args[]) {
		new testList();
	}
}

