public class Pr1TracingPolymorphism {
    /* Output:
       Second2
       Third2
       Fourth2
       Third2
       error: compilation error
       error: compilation error
       Second2
       Third2
       Fourth2
       Third2
       error: compilation error
       error: compilation error
       error: compilation error
       Third1/Second2
       error: runtime error
       Fourth2
       error: runtime error
       Second2
       error: compilation error
       Second2
    */
    public static void main(String[] args){
        First var1 = new Second();
        First var2 = new Third();
        First var3 = new Fourth();
        Second var4 = new Third();
        Object var5 = new Fourth();
        Object var6 = new Second();
       // ((Second)var5).method2();
        var2.method2();
    }
}
