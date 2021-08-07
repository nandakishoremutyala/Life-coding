package effort_2021;

import java.util.*;

public class DeleteDuplicateFolderInSystem {
    Folder root = new Folder("");
    Map<String, Integer> keys = new HashMap<>();

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        for (List<String> path : paths)
            addToTree(path);

        for (Folder f : root.list)
            generateKey(f);

        for (Folder f : root.list) {
            updateDeleteStatus(f);
        }

        List<List<String>> results = new ArrayList<>();

        for (List<String> path : paths) {
            if (isValid(path))
                results.add(path);
        }
        return results;
    }

    private boolean isValid(List<String> path) {

        Folder cur=root;
        for(String f:path){
            cur=cur.map.get(f);
            if(cur.del)return false;
        }
        return true;
    }

    private void updateDeleteStatus(Folder f) {
        if (f.list.size() > 0 && keys.get(f.key) > 1) {
            f.del = true;
            return;
        }
        for (Folder fold : f.list) {
            updateDeleteStatus(fold);
        }
    }

    private String generateKey(Folder folder) {
        StringBuilder sb = new StringBuilder();
        if (folder.list.size() == 0)
            return sb.toString();
        Collections.sort(folder.list, (a, b) -> a.name.compareTo(b.name));

        for (Folder f : folder.list) {
            sb.append("(");
            sb.append(f.name + generateKey(f));
            sb.append(")");
        }
        String key = sb.toString();
        folder.key = key;
        keys.put(key, keys.getOrDefault(key, 0) + 1);
        return key;
    }

    private void addToTree(List<String> path) {
        Folder current = root;

        for (String f : path){
            if (!current.map.containsKey(f)){
                Folder fold = new Folder(f);
                current.map.put(f, fold);
                current.list.add(fold);
            }

            current = current.map.get(f);
        }
    }

    class Folder {
        String name;
        String key;
        Map<String, Folder> map;
        List<Folder> list;
        boolean del;

        public Folder(String name) {
            this.name = name;
            map = new HashMap<>();
            list = new ArrayList<>();
            key = "";
            del = false;
        }
    }
}
