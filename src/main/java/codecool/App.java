package codecool;

import org.json.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static List<JSONObject> parseJson() throws IOException, ParseException{
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader("src\\main\\resources\\vehicles.json");
        List<JSONObject> objectList = new ArrayList<JSONObject>();
        Object object = parser.parse(reader);
        JSONArray objectArray = (JSONArray) object;
        for (int i = 0; i < objectArray.size() ; i++) {
            objectList.add((JSONObject) objectArray.get(i));
        }
        return objectList;
    }

    public static List<TreeNode> createTreeNode(List<JSONObject> objectList){
        List<TreeNode> treeNodes = new ArrayList<TreeNode>();
        for (JSONObject obj: objectList) {
            Object category = obj.get("category");
            Object parent_category = obj.get("parent_category");
            TreeNode treeNode = new TreeNode((String)category, (String)parent_category, null);
            treeNodes.add(treeNode);
        }
        return treeNodes;
    }

    public static void addChild(List<TreeNode> treeNodes){
        for (int i = 0; i < treeNodes.size() ; i++) {
            TreeNode curr = treeNodes.get(i);
            for (int j = 1; j < treeNodes.size() ; j++) {
                TreeNode next = treeNodes.get(j);
                if(next.getParent_category() != null && next.getParent_category().equals(curr.getCategory())){
                    curr.addChild(next);
                }
            }
        }
    }

    public static void run() throws IOException, ParseException{
        List<JSONObject> objectList = parseJson();
        List<TreeNode> treeNodeList = createTreeNode(objectList);
        addChild(treeNodeList);
        for (TreeNode treeNode : treeNodeList) {
            if(treeNode.childNodes.size() != 0){
                System.out.println(treeNode);
            }
        }
    }

    public static void main(String[] args)throws IOException, ParseException{
        run();
    }
}
