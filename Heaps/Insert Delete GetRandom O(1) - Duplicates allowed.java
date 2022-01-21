/*

 Insert Delete GetRandom O(1) - Duplicates allowed

RandomizedCollection is a data structure that contains a collection of numbers, possibly duplicates (i.e., a multiset). It should support inserting and removing specific elements and also removing a random element.

Implement the RandomizedCollection class:

RandomizedCollection() Initializes the empty RandomizedCollection object.
bool insert(int val) Inserts an item val into the multiset, even if the item is already present. Returns true if the item is not present, false otherwise.
bool remove(int val) Removes an item val from the multiset if present. Returns true if the item is present, false otherwise. Note that if val has multiple occurrences in the multiset, we only remove one of them.
int getRandom() Returns a random element from the current multiset of elements. The probability of each element being returned is linearly related to the number of same values the multiset contains.
You must implement the functions of the class such that each function works on average O(1) time complexity.

*/

class RandomizedCollection {
    
    HashMap<Integer, HashSet<Integer>> map; // value, indexes
    List<Integer> list;
    Random random;

    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        
        HashSet<Integer> set;
        boolean flag;
        if(map.containsKey(val)){
            set = map.get(val);
            flag = false;
        }
        else
        {
            set = new HashSet<>();
            flag = true;
        }
        
        set.add(list.size());
        list.add(val);
        map.put(val, set);
        
        return flag;
    }
    
    public boolean remove(int val) {
        
        HashSet<Integer> set;
        if(!map.containsKey(val)){
            return false;
        }
        else
        {
            set = map.get(val);
        }
        int remIdx = -1;
        for(int i : set) // as set stores value randomly therefore take any value from it
        {
            remIdx = i;
            break;
        }
        
        set.remove(remIdx);
        map.put(val, set); 
        if(map.get(val).size() == 0)
                map.remove(val);
        
        if(remIdx == list.size() - 1)
        {
            list.remove(list.size() - 1);
        }
        else
        {
            list.set(remIdx, list.get(list.size() - 1));
            list.remove(list.size() - 1);
            
            int newVal = list.get(remIdx);
            HashSet<Integer> temp = map.get(newVal);
            temp.remove(list.size());
            temp.add(remIdx);
            map.put(newVal, temp);
        }
        return true;
        
    }
    
    public int getRandom() {
        int randomIdx = random.nextInt(list.size());
        return list.get(randomIdx);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
