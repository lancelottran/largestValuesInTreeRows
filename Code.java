//
// Definition for binary tree:
// class Tree<T> {
//   Tree(T x) {
//     value = x;
//   }
//   T value;
//   Tree<T> left;
//   Tree<T> right;
// }

int[] largestValuesInTreeRows(Tree<Integer> t) {
    if(t == null)
        return new int[0];
    
    HashMap<Integer,Integer> level = new HashMap<Integer, Integer>();
    int height = find_high(t, level, 0);
    int[] res = new int[height];
    
    for(int i = 0; i < height; i++)
        res[i] = level.get(i);
    
    return res;
}

int find_high(Tree<Integer> t, HashMap<Integer, Integer> level, int h){
    if(t == null)
        return h;
    
    if(level.containsKey(h))
        level.put(h, Math.max(t.value, level.get(h)));
    else
        level.put(h, t.value);
    
    int left = find_high(t.left, level, h+1);
    int right = find_high(t.right, level, h+1);
    
    return Math.max(left, right);
}
