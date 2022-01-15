public class Queue {
    Tree[] queue = new Tree[10];
    int lastIndex=0;

   public void enqueue(Tree tree){
       queue[lastIndex] = tree;
       lastIndex++;
        sort();
   }
   public Tree dequeue(){
       Tree res = queue[lastIndex - 1];
       queue[lastIndex - 1] = null;
       lastIndex--;
       return res;
   }
   private void sort(){
       int n = queue.length;
       for (int i = 1; i < n; ++i) {
           Tree key = queue[i];
           int j = i - 1;
           while (j >= 0 && queue[j].root.count > key.root.count) {
               queue[j + 1] = queue[j];
               j = j - 1;
           }
           queue[j + 1] = key;
       }
   }
}
