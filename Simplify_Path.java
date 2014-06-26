public class Solution {
    public String simplifyPath(String path) {
        LinkedList <String> pathItems = new LinkedList <> ();
        
        String allItems [] = path.split("/");
        for(String s: allItems) {
            switch(s) {
                case "..":
                    if(!pathItems.isEmpty()) {
                        pathItems.removeLast();
                    }
                    break;
                case ".":
                case "":
                    //ignore
                    break;
                default:
                    pathItems.addLast(s);
            }
        }
        
        if(pathItems.isEmpty()) {
            return "/";
        }
        
        StringBuilder retPath = new StringBuilder();
        while(!pathItems.isEmpty()){
            retPath.append("/");
            retPath.append(pathItems.removeFirst());
        }
        
        return retPath.toString();
    }
}
