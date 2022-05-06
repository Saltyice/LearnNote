package generic;

import java.util.*;

/**
 *
 * 泛型的应用
 */
public class DAO<E> {

    private Map<String,E> map= new HashMap<>();

    public void save(String id,E entry){
        map.put(id,entry);
    }

    public E get(String id){
        return map.get(id);
    }

    public void update(String id,E entry){
        if(map.containsKey(id)){
            map.put(id,entry);
        }
    }

    public List<E> list(){
        ArrayList<E> list = new ArrayList<>();
        Collection<E> value = map.values();
        for (E values: value){
            list.add(values);
        }
        return list;
    };

    public void delete(String id){
        map.remove(id);
    }


}
