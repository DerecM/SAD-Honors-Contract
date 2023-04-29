public class lowerDomainFoundState implements emailState{
    @Override
    public void next(Context c){
        printStatus();
        c.setState(this);
    }

    @Override
    public void prev(Context c)
    {
        System.out.println("Lower Domain not found");
        c.setState(null);
    }

    @Override
    public void printStatus(){
        System.out.println("Email found");
    }

    public String check(Context c, String input){
        if(input.length() > 2 && input.length() < 10)
        {
            for(int i = 0; i< input.length(); i++) {
                if(!Character.isLetterOrDigit(input.charAt(i)))
                {
                    prev(c);
                    return "";
                }
            }
            next(c);
            return input;
        }
        else
            prev(c);
            return "";
    }

    public String toString()
    {
        return "No Lower Domain Found";
    }
}
