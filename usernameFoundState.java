public class usernameFoundState implements emailState{
    @Override
    public void next(Context c){
        printStatus();
        c.setState(this);

    }

    @Override
    public void prev(Context c)
    {
        System.out.println("Username not found");
    }

    @Override
    public void printStatus(){
        System.out.println("Username found");
    }

    @Override
    public String check(Context c, String input)
    {
        upperDomainFoundState UD = new upperDomainFoundState();
        int charcount = 0;
        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '@')
            {
                String username = input.substring(i-charcount,i);
                next(c);
                String SecondHalf = UD.check(c, input.substring(i + 1, input.length()));
                if(!SecondHalf.equals(""))
                {
                    return username + "@" + SecondHalf;
                }
                else
                {
                    return "";
                }
            }
            else if(Character.isLetterOrDigit(input.charAt(i)) || input.charAt(i) == '.' || input.charAt(i) == '-'){
                charcount++;
                continue;
            }
            else
            {
                return "";
            }
        }

        prev(c);
        return "";
    }

    public String toString()
    {
        return "Username Found";
    }
}
