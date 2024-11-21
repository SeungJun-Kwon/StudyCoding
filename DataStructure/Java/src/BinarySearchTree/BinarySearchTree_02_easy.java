package BinarySearchTree;

import java.util.Scanner;

public class BinarySearchTree_02_easy {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int t = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            scanner.nextLine();

            int x = scanner.nextInt();
            BinarySearchTree root = new BinarySearchTree(x);

            for (int j = 0; j < n - 1; j++) {
                x = scanner.nextInt();
                root.insert(root, x);
            }

            scanner.nextLine();

            int m = scanner.nextInt();
            for (int j = 0; j < m; j++) {
                x = scanner.nextInt();

                BinarySearchTree parent = findParentTree(root, x);
                BinarySearchTree tree = root.getTree(root, x);
                removeTree(parent, tree, x);
            }
            scanner.nextLine();

            if (root != null) {
                sb.append(root.preOrder(root, new StringBuilder()) + "\n");
            } else {
                sb.append("0\n");
            }
        }

        scanner.close();

        System.out.println(sb);
    }

    static BinarySearchTree findParentTree(BinarySearchTree tree, int x) {
        if ((tree.getLeftTree() != null && tree.getLeftTree().getData() == x)
                || (tree.getRightTree() != null && tree.getRightTree().getData() == x)) {
            return tree;
        } else if (tree.getLeftTree() != null && x < tree.getData()) {
            return findParentTree(tree.getLeftTree(), x);
        } else if (tree.getRightTree() != null && x > tree.getData()) {
            return findParentTree(tree.getRightTree(), x);
        }

        return null;
    }

    static BinarySearchTree findMinTree(BinarySearchTree tree) {
        if (tree.getLeftTree() != null) {
            return findMinTree(tree.getLeftTree());
        } else if (tree.getLeftTree() == null) {
            return tree;
        }

        return null;
    }

    static void removeTree(BinarySearchTree parent, BinarySearchTree tree, int x) {
        System.out.println("Remove : " + x);
        // 자식이 없을 때
        if (tree.getLeftTree() == null && tree.getRightTree() == null) {
            if (parent == null) {
                tree = null;
            } else {
                if (parent.getLeftTree() == tree) {
                    parent.setLeftTree(null);
                } else if (parent.getRightTree() == tree) {
                    parent.setRightTree(null);
                }
            }
        }
        // 자식이 하나일 때
        else if (tree.getLeftTree() != null && tree.getRightTree() == null) {
            if (parent == null) {
                tree = tree.getLeftTree();
            } else {
                if (parent.getLeftTree() == tree) {
                    parent.setLeftTree(tree.getLeftTree());
                } else if (parent.getRightTree() == tree) {
                    parent.setRightTree(tree.getRightTree());
                }
            }
        } else if (tree.getLeftTree() == null && tree.getRightTree() != null) {
            if (parent == null) {
                tree = tree.getRightTree();
            } else {
                if (parent.getLeftTree() == tree) {
                    parent.setLeftTree(tree.getRightTree());
                } else if (parent.getRightTree() == tree) {
                    parent.setRightTree(tree.getRightTree());
                }
            }
        }
        // 자식이 두개일 때
        else if (tree.getLeftTree() != null && tree.getRightTree() != null) {
            // 1. 해당 노드의 오른쪽 노드 중 최소값 노드를 삭제할 노드로 옮긴다
            BinarySearchTree minTree = findMinTree(tree.getRightTree());
            BinarySearchTree minParentTree = findParentTree(tree, minTree.getData());
            tree.setData(minTree.getData());

            // 2. 노드 연결 작업을 해준다
            if (minTree.getRightTree() != null) {
                minParentTree.setRightTree(minTree.getRightTree());
            }
            else {
                
            }
        }
    }

    static class BinarySearchTree {
        private int data;
        private BinarySearchTree leftTree;
        private BinarySearchTree rightTree;

        public BinarySearchTree() {
            data = 0;
            leftTree = null;
            rightTree = null;
        }

        public BinarySearchTree(int x) {
            data = x;
            leftTree = null;
            rightTree = null;
        }

        public int getData() {
            return data;
        }

        public void setData(int x) {
            data = x;
        }

        public BinarySearchTree getLeftTree() {
            return leftTree;
        }

        public void setLeftTree(BinarySearchTree tree) {
            leftTree = tree;
        }

        public BinarySearchTree getRightTree() {
            return rightTree;
        }

        public void setRightTree(BinarySearchTree tree) {
            rightTree = tree;
        }

        public void insert(BinarySearchTree parent, int x) {
            if (x < parent.getData()) {
                if (parent.getLeftTree() == null) {
                    BinarySearchTree tree = new BinarySearchTree(x);
                    parent.setLeftTree(tree);
                } else {
                    insert(parent.getLeftTree(), x);
                }
            } else if (x > parent.getData()) {
                if (parent.getRightTree() == null) {
                    BinarySearchTree tree = new BinarySearchTree(x);
                    parent.setRightTree(tree);
                } else {
                    insert(parent.getRightTree(), x);
                }
            }
        }

        public BinarySearchTree getTree(BinarySearchTree tree, int x) {
            if (tree == null) {
                return null;
            }

            if (tree.getData() == x) {
                return tree;
            } else if (x < tree.getData()) {
                return getTree(tree.getLeftTree(), x);
            } else if (x > tree.getData()) {
                return getTree(tree.getRightTree(), x);
            }

            return null;
        }

        public int getDepth(BinarySearchTree tree, int x) {
            if (tree == null) {
                return -1;
            }

            int depth = -1;

            if (tree.getData() == x) {
                return depth + 1;
            } else if (x < tree.getData()) {
                return getDepth(tree.getLeftTree(), x) + 1;
            } else if (x > tree.getData()) {
                return getDepth(tree.getRightTree(), x) + 1;
            }

            return 0;
        }

        public int getDegree() {
            int result = 0;

            result = leftTree != null ? result + 1 : result;
            result = rightTree != null ? result + 1 : result;

            return result;
        }

        public StringBuilder preOrder(BinarySearchTree tree, StringBuilder result) {
            if (tree == null) {
                return result;
            }

            result.append(tree.getData() + " ");
            preOrder(tree.getLeftTree(), result);
            preOrder(tree.getRightTree(), result);

            return result;
        }
    }
}
