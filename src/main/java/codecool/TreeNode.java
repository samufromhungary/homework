package codecool;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

    public String category;
    public String parent_category;
    public List<TreeNode> childNodes;

    public TreeNode(String category, String parent_category, List<TreeNode> childNodes) {
        this.category = category;
        this.parent_category = parent_category;
        this.childNodes = new ArrayList<>();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getParent_category() {
        return parent_category;
    }

    public void setParent_category(String parent_category) {
        this.parent_category = parent_category;
    }

    public List<TreeNode> getChildNodes() {
        return childNodes;
    }

    public void setChildNodes(List<TreeNode> childNodes) {
        this.childNodes = childNodes;
    }

    public void addChild(TreeNode treeNode){
        this.childNodes.add(treeNode);
    }

    @Override
    public String toString() {
        return "TreeNode{" +
            "parent= " + parent_category +
            " | category= " + category +
            " | children= " + childNodes +
            "}";
    }
}
