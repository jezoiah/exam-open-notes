// ==== ARRAYLIST BASICS ====
// WHAT: Dynamic array that grows automatically
// WHEN: Don't know size upfront, need to add/remove
// HOW: import java.util.ArrayList;

import java.util.ArrayList;

public class ArrayListQuickRef {
    public static void main(String[] args) {
        
        // ==== DECLARATION AND CREATION ====
        // WHAT: Create empty dynamic list
        // WHEN: Need to add items later
        // HOW: ArrayList<Type> name = new ArrayList<>();
        
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Integer> scores = new ArrayList<>();
        ArrayList<Double> prices = new ArrayList<>();
        
        // ==== ADD ITEMS ====
        // WHAT: Append to end of list
        // WHEN: Building list dynamically
        // HOW: list.add(value);
        
        names.add("Alice");
        names.add("Bob");
        names.add("Carol");
        
        scores.add(85);
        scores.add(92);
        scores.add(78);
        
        // ==== GET ITEM BY INDEX ====
        // WHAT: Access element at position
        // WHEN: Need specific item
        // HOW: Type value = list.get(index);
        
        String first = names.get(0);    // "Alice"
        int secondScore = scores.get(1);  // 92
        
        System.out.println("First: " + first);
        
        // ==== UPDATE ITEM ====
        // WHAT: Change value at index
        // WHEN: Modify existing entry
        // HOW: list.set(index, newValue);
        
        names.set(1, "Robert");  // Bob -> Robert
        scores.set(2, 95);       // 78 -> 95
        
        // ==== REMOVE ITEM ====
        // WHAT: Delete by index or by value
        // WHEN: Deleting entries
        // HOW: list.remove(index) or list.remove(value);
        
        names.remove(2);         // remove index 2 (Carol)
        names.remove("Alice");   // remove by value
        
        // ==== SIZE (NOT LENGTH) ====
        // WHAT: Get current number of elements
        // WHEN: Loop bounds, check empty
        // HOW: int count = list.size();
        
        int count = names.size();
        boolean isEmpty = names.isEmpty();  // true if size == 0
        
        System.out.println("Count: " + count);
        
        // ==== LOOP THROUGH ARRAYLIST ====
        // WHAT: Iterate all elements
        // WHEN: Processing each item
        // HOW: for (Type item : list) or for with index
        
        // For-each (read-only preferred)
        System.out.println("--- Names ---");
        for (String name : names) {
            System.out.println(name);
        }
        
        // Index loop (need index or to modify)
        System.out.println("--- Scores ---");
        for (int i = 0; i < scores.size(); i++) {
            System.out.println("Index " + i + ": " + scores.get(i));
        }
        
        // ==== CONTAINS (SEARCH) ====
        // WHAT: Check if value exists
        // WHEN: Lookup without index
        // HOW: boolean exists = list.contains(value);
        
        boolean hasBob = names.contains("Bob");  // false (removed)
        boolean hasRobert = names.contains("Robert");  // true
        
        // ==== INDEXOF ====
        // WHAT: Find position of value
        // WHEN: Need index of known value
        // HOW: int pos = list.indexOf(value); (-1 if not found)
        
        int robertIndex = names.indexOf("Robert");
        System.out.println("Robert at index: " + robertIndex);
        
        // ==== CLEAR ALL ====
        // WHAT: Remove all elements
        // WHEN: Reset list
        // HOW: list.clear();
        
        scores.clear();
        System.out.println("After clear, size: " + scores.size());
    }
}
