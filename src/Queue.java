public class Queue {
    Tree[] element = new Tree[32];
    int lastIndex=0;

    public Queue() {
        for (int i = 0; i < 30; i++) {
            element[i] = new Tree();
        }
    }

    public void enqueue(Tree tree){
       element[lastIndex] = tree;
       lastIndex++;
        insertionSort();
   }
   public Tree dequeue(){
       Tree res = element[lastIndex - 1];
       element[lastIndex - 1] = null;
       lastIndex--;
       return res;
   }
   private void insertionSort(){
       int n = lastIndex;
       for (int i = 1; i < n; ++i) {
           Tree key = element[i];
           int j = i - 1;
           while (j >= 0 && element[j].root.count < key.root.count) {
               element[j + 1] = element[j];
               j = j - 1;
           }
           element[j + 1] = key;
       }
   }
}
