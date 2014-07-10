
/* Node object contains a single string, as data, and a count 
 * of how many times that string has occurred in our input text.
 * Stored in buckets for use in extendible hashing.
 * 
 * @author		James Earle <je11zi@brocku.ca>
 * @version		1.0
 * @since 		2013-12-02
 */ 
public class Node {

  public String data;
  public int count;
  
  public Node(String d, int c) {
	  
	  this.data = d;
	  this.count = c;
  }
 
}

