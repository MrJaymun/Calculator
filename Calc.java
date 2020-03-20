//Калькулятор арифметических формул.
public class Calc extends Compf{
    private StackInt s;

    private static int char2int(char c){
        return(int)c - (int)'0';
    }

    @Override
    protected int symOther(char c){
        int n = 0;
        if(c < '0' || c > '9' && c < 'a' || c > 'f'){
            System.out.println("Недопустимый символ: " + c);

            System.exit(0);
        }


        return SYM_OTHER;
    }

    @Override
    protected void nextOper(char c){
        int second = s.pop();
        int first = s.pop();

        switch(c){
            
            case '+':
                s.push(first + second);
                break;
            case '-':
                s.push(first - second);
                break;
            case '*':
                s.push(first*second);
                break;
            case'/':
                s.push(first/second);
                break;
        }
    }

    @Override
    protected void nextOther(char c){
        if(c >= '0' && c<='9') {
            if (count == 1) {
                s.push(char2int(c));
                //s.push(Character.getNumericValue(c));
            }
            if (count == 0) {
                s.push(s.pop() * 16 + char2int(c));
            }

        }

        if(c == 'a'){
            if (count == 1) {
                s.push(10);
                //s.push(Character.getNumericValue(c));
            }
            if (count == 0) {
                s.push(s.pop() * 16 + 10);
            }
        }
        if(c == 'b'){
            if (count == 1) {
                s.push(11);
                //s.push(Character.getNumericValue(c));
            }
            if (count == 0) {
                s.push(s.pop() * 16 + 11);
            }
        }
        if(c == 'c'){
            if (count == 1) {
                s.push(12);
                //s.push(Character.getNumericValue(c));
            }
            if (count == 0) {
                s.push(s.pop() * 16 + 12);
            }
        }
        if(c == 'd'){
            if (count == 1) {
                s.push(13);
                //s.push(Character.getNumericValue(c));
            }
            if (count == 0) {
                s.push(s.pop() * 16 + 13);
            }
        }
        if(c == 'e'){
            if (count == 1) {
                s.push(14);
                //s.push(Character.getNumericValue(c));
            }
            if (count == 0) {
                s.push(s.pop() * 16 + 14);
            }
        }
        if(c == 'f'){
            if (count == 1) {
                s.push(15);
                //s.push(Character.getNumericValue(c));
            }
            if (count == 0) {
                s.push(s.pop() * 16 + 15);
            }
        }
    }

    public Calc(){
        s = new StackInt();
    }
    @Override
    public final void compile(char[] str){
        super.compile(str);
        System.out.println("" + s.top());
    }
    @Override
    public void D(){
        int n = s.pop();
        s.push(n);
        s.push(n);
        push('*');
    }
}
