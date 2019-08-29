package com.jaga1;

//import com.jaga.NaryTreeNode;

public class App {
	public static void main(String[] args) {
		Node root = new Node("Matter");

        root.addChild("Pure");
            root.getChild(0).addChild("Elements");
                root.getChild(0).getChild(0).addChild("Metals");
                root.getChild(0).getChild(0).addChild("Metalloids");
                root.getChild(0).getChild(0).addChild("Non-metals");
            root.getChild(0).addChild("Compounds");
                root.getChild(0).getChild(1).addChild("Water");
                root.getChild(0).getChild(1).addChild("Carbon dioxide");
                root.getChild(0).getChild(1).addChild("Salt");
                root.getChild(0).getChild(1).addChild("Camphor");  // won't add
        root.addChild("Mixture");
            root.getChild(1).addChild("Homogeneous");
                root.getChild(1).getChild(0).addChild("Air");
                root.getChild(1).getChild(0).addChild("Vinegar");
            root.getChild(1).addChild("Heterogeneous");
                root.getChild(1).getChild(1).addChild("Colloids");
                root.getChild(1).getChild(1).addChild("Suspensions");

        Node.print(root);
	}
}
