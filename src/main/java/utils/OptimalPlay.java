/**
 * 
 */
package utils;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * @author gbuah
 *
 */
public class OptimalPlay {

	//create subtrees
		public static DefaultMutableTreeNode createSubTree(int a, int b) {
					DefaultMutableTreeNode newRoot = new DefaultMutableTreeNode(a);
					newRoot.add( new DefaultMutableTreeNode(b));
					
					return newRoot;
			}
		
		
		//return tree		
		public static DefaultMutableTreeNode getTree(){
			
				DefaultMutableTreeNode root = new DefaultMutableTreeNode(0);
				
				DefaultMutableTreeNode one = new DefaultMutableTreeNode(1);
				DefaultMutableTreeNode two = new DefaultMutableTreeNode(2);
				DefaultMutableTreeNode three = new DefaultMutableTreeNode(3);
				DefaultMutableTreeNode four = new DefaultMutableTreeNode(4);
				DefaultMutableTreeNode seven = new DefaultMutableTreeNode(7);
				
				one.add(createSubTree(5,9));
				one.add(createSubTree(2,3));
				one.add(createSubTree(4,7));
				two.add(createSubTree(5,8));
				three.add(createSubTree(6,9));
				three.add(createSubTree(5,7));
				four.add(createSubTree(5,6));
				seven.add(createSubTree(8,9));
				
				root.add(one);
				root.add(two);
				root.add(three);
				root.add(four);
				root.add(seven);
				
				return root;
			}
			
}
