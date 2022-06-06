package tp2;

public class Ej7 {

  public static void main(String[] args) {
    Tree tree = new Tree(null);
    tree.add(15);
    tree.add(6);
    tree.add(18);
    tree.add(3);
    tree.add(7);
    tree.add(17);
    tree.add(20);
    tree.add(2);
    tree.add(4);
    tree.add(13);
    tree.add(9);

    // System.out.println("getHeight: " + tree.getHeight());

    // System.out.print("printPreOrder: ");
    // tree.printPreOrder();
    // System.out.println();

    // System.out.print("printInOrder: ");
    // tree.printInOrder();
    // System.out.println();

    // System.out.print("printPostOrder: ");
    // tree.printPostOrder();
    // System.out.println();

    // System.out.println("getLongestBranch: " + tree.getLongestBranch());

    // System.out.println("getFrontera: " + tree.getFrontera());

    // System.out.println("getMaxElement: " + tree.getMaxElement());

    System.out.println("getElemAtLevel0:" + tree.getElemAtLevel(0));
    System.out.println("getElemAtLevel1:" + tree.getElemAtLevel(1));
    System.out.println("getElemAtLevel2:" + tree.getElemAtLevel(2));
    System.out.println("getElemAtLevel3:" + tree.getElemAtLevel(3));
    System.out.println("getElemAtLevel4:" + tree.getElemAtLevel(4));

    System.out.println(tree.delete(15));

    System.out.println("getElemAtLevel0:" + tree.getElemAtLevel(0));
    System.out.println("getElemAtLevel1:" + tree.getElemAtLevel(1));
    System.out.println("getElemAtLevel2:" + tree.getElemAtLevel(2));
    System.out.println("getElemAtLevel3:" + tree.getElemAtLevel(3));
    System.out.println("getElemAtLevel4:" + tree.getElemAtLevel(4));
  }

}
