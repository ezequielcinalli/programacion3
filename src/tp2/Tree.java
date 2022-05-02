package tp2;

import java.util.ArrayList;

public class Tree {
    private Integer value;
    private Tree left;
    private Tree right;

    public Tree(Integer value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public Tree getLeft() {
        return this.left;
    }

    public Tree getRight() {
        return this.right;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    public void setRight(Tree right) {
        this.right = right;
    }

    // Complejidad: O(h)
    public void add(Integer newValue) {
        if (this.value == null)
            this.value = newValue;
        else {
            if (this.value > newValue) {
                if (this.left == null)
                    this.left = new Tree(newValue);
                else
                    this.left.add(newValue);
            } else if (this.value < newValue) {
                if (this.right == null)
                    this.right = new Tree(newValue);
                else
                    this.right.add(newValue);
            }
        }
    }

    // Complejidad: O(1)
    public Integer getRoot() {
        return this.value;
    }

    // Complejidad: O(1)
    public boolean isEmpty() {
        return this.value == null;
    }

    // Complejidad: O(n)
    public int getHeight() {
        if (this.value == null)
            return -1;
        if (this.left == null && this.right == null)
            return 0;
        int left = 0;
        int right = 0;
        if (this.left != null)
            left = this.left.getHeight();
        if (this.right != null)
            right = this.right.getHeight();
        return 1 + (left >= right ? left : right);
    }

    // Complejidad: O(n)
    public ArrayList<Integer> getFrontera() {
        if (this.left == null && this.right == null) {
            ArrayList<Integer> result = new ArrayList<Integer>();
            result.add(this.value);
            return result;
        }
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (this.left != null)
            result.addAll(this.left.getFrontera());
        if (this.right != null)
            result.addAll(this.right.getFrontera());
        return result;
    }

    // Complejidad: O(n)
    public ArrayList<Integer> getLongestBranch() {
        if (this.left == null && this.right == null) {
            ArrayList<Integer> result = new ArrayList<Integer>();
            result.add(this.value);
            return result;
        }
        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();

        if (this.left != null) {
            left.add(this.value);
            left.addAll(this.left.getLongestBranch());
        }
        if (this.right != null) {
            right.add(this.value);
            right.addAll(this.right.getLongestBranch());
        }

        if (left.size() >= right.size())
            return left;
        else
            return right;
    }

    // Complejidad: O(h)
    public boolean hasElement(Integer element) {
        if (this.value == element)
            return true;
        if (this.value > element && this.left != null)
            return this.left.hasElement(element);
        if (this.value < element && this.right != null)
            return this.right.hasElement(element);
        return false;
    }

    // Complejidad: O(h)
    public Integer getMaxElement() {
        if (this.right == null)
            return this.value;
        return this.right.getMaxElement();
    }

    // Complejidad: O(n)
    public ArrayList<Integer> getElemAtLevel(int level) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (level == 0) {
            result.add(this.value);
            return result;
        }
        if (this.left != null)
            result.addAll(this.left.getElemAtLevel(level - 1));
        if (this.right != null)
            result.addAll(this.right.getElemAtLevel(level - 1));

        return result;
    }

    // Complejidad: O(n)
    public void printPreOrder() {
        System.out.print(this.value + " ");
        if (this.left != null)
            this.left.printPreOrder();
        if (this.right != null)
            this.right.printPreOrder();
    }

    // Complejidad: O(n)
    public void printInOrder() {
        if (this.left != null)
            this.left.printInOrder();
        System.out.print(this.value + " ");
        if (this.right != null)
            this.right.printInOrder();
    }

    // Complejidad: O(n)
    public void printPostOrder() {
        if (this.left != null)
            this.left.printPostOrder();
        if (this.right != null)
            this.right.printPostOrder();
        System.out.print(this.value + " ");
    }

    // Complejidad: O(h)
    public boolean delete(Integer element) {
        // VOY HACIA DERECHA
        if (this.value < element) {
            if (this.right == null)
                return false;
            else {
                if (this.right.getRoot() == element) {
                    if (this.right.getLeft() == null && this.right.getRight() == null) {
                        this.right = null;
                        return true;
                    } else if (this.right.getLeft() == null && this.right.getRight() != null) {
                        this.right = this.right.getRight();
                        return true;
                    } else if (this.right.getLeft() != null && this.right.getRight() == null) {
                        this.right = this.right.getLeft();
                        return true;
                    } else {
                        Integer aux = getNMI(this.right).getRoot();
                        this.right.delete(aux);
                        this.right.setValue(aux);
                        return true;
                    }
                } else {
                    return this.right.delete(element);
                }
            }
        }
        // VOY HACIA IZQUIERDA
        else if (this.value > element) {
            if (this.left == null)
                return false;
            else {
                if (this.left.getRoot() == element) {
                    if (this.left.getLeft() == null && this.left.getRight() == null) {
                        this.left = null;
                        return true;
                    } else if (this.left.getLeft() == null && this.left.getRight() != null) {
                        this.left = this.left.getRight();
                        return true;
                    } else if (this.left.getLeft() != null && this.left.getRight() == null) {
                        this.left = this.left.getLeft();
                        return true;
                    } else {
                        Integer aux = getNMD(this.left).getRoot();
                        this.left.delete(aux);
                        this.left.setValue(aux);
                        return true;
                    }
                } else {
                    return this.left.delete(element);
                }
            }
        }
        // ES LA RAIZ
        else {
            if (this.left == null && this.right == null) {
                this.value = null;
                return true;
            } else if (this.left != null && this.right == null) {
                this.value = this.left.getRoot();
                this.right = this.left.getRight();
                this.left = this.left.getLeft();
                return true;
            } else if (this.left == null && this.right != null) {
                this.value = this.right.getRoot();
                this.left = this.right.getLeft();
                this.right = this.right.getRight();
                return true;
            } else {
                Integer aux = getNMD(this.left).getRoot();
                this.left.delete(aux);
                this.value = aux;
                return true;
            }
        }
    }

    // Complejidad: O(h)
    public Tree getNMI(Tree current) {
        if (current.getLeft() == null)
            return current;
        return current.getLeft().getNMI(current.getLeft());
    }

    // Complejidad: O(h)
    public Tree getNMD(Tree current) {
        if (current.getRight() == null)
            return current;
        return current.getRight().getNMD(current.getRight());
    }

}
