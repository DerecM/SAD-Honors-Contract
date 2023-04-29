public class upperDomainFoundState implements emailState{
        @Override
        public void next(Context c){
            printStatus();
            c.setState(this);

        }

        @Override
        public void prev(Context c)
        {
            System.out.println("Upper Domain not found");
            c.setState(null);

        }

        @Override
        public void printStatus(){System.out.println("UpperDomain found");
        }
        @Override
        public String check(Context c, String input){
            lowerDomainFoundState LD = new lowerDomainFoundState();
            for(int i = 0; i < input.length(); i++)
            {
                if(Character.isLetterOrDigit(input.charAt(i))){
                    continue;
                }
                else if(input.charAt(i) == '.')
                {
                    String upperDomain = input.substring(0, i);
                    next(c);
                    int spacePresent = input.indexOf(" ");
                    String lowerDomain = "";
                    if(spacePresent != -1) {
                        lowerDomain = LD.check(c, input.substring(i+1, spacePresent));
                    }
                    else {
                        lowerDomain = LD.check(c, input.substring(i + 1));
                    }

                    if(!lowerDomain.equals(""))
                    {
                        return upperDomain + "." + lowerDomain;
                    }
                    else
                        return "";
                }
                else
                    prev(c);
                    return ""; //Invalid character detected
            }
            return "";
        }

    public String toString()
    {
        return "Upper Domain Found";
    }
}
