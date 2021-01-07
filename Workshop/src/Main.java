public
class Main {
    public static
    void main (String[] args) {

        Stack stack = new Stack ();

        for (int i = 0; i < 10; i++) {
            stack.push (i + 1);
        }

//        while (!stack.isEmpty ()) {
//            System.out.println (stack.peek ());
//            System.out.println (stack.pop ());
//        }
        stack.forEach (e-> System.out.println (e));
    }
}
