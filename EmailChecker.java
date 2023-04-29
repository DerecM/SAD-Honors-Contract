import java.util.Scanner;
import java.util.LinkedList;


public class EmailChecker {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int emailIndex = 0;
        int charcount = 0;
        String input;
        LinkedList<String> emails = new LinkedList<String>();
        String cont = "Y";
        String username = "";
        String upperDomain = "";
        String lowerDomain = "";
        boolean usernameFound = false;
        boolean upperDomainFound = false;
        boolean lowerDomainFound = false;

        Context c = new Context();
        String potentEmail = "";
        usernameFoundState UN = new usernameFoundState();
        while(!cont.equals("N") ){
            emails = new LinkedList<String>();
            System.out.print("Enter string to check for emails: ");
            input = scan.nextLine();
            int letterCount = 0;
            int i = 0;

            while(i < input.length())
            { if(Character.isLetterOrDigit(input.charAt(i)) || input.charAt(i) == '.' || input.charAt(i) == '-')
            {
              letterCount++;
              i++;
            }
            else
            {
             if(input.charAt(i) == ' ')
             {
                 letterCount = 0;
                 i++;
             }
             else if(input.charAt(i) == '@')
             {
                 emailIndex = i - letterCount;
                 potentEmail = UN.check(c, input.substring(emailIndex));

                 if(!potentEmail.equals(""))
                 {
                     emails.add(potentEmail + ", " + emailIndex);
                     i++;
                 }
                 else
                     i++;
             }
             else
             {
                 i++;
             }
            }
            }

            /*if(i == input.length())
            {
                potentEmail = UN.check(c,input.substring(i - letterCount, i));
                if(!potentEmail.equals(""))
                {
                    emailIndex = i - letterCount;
                    emails.add(potentEmail + ", " + emailIndex);
                }
            }*/




            System.out.println("Found " + emails.size() + " email addresses.");
            int emailNumber = 1;
            for(String e : emails){
                System.out.println(emailNumber + ". " + e);
                emailNumber++;
            }

            System.out.print("Run again? (Y/N?) ");
            cont = scan.nextLine();
        }
    }

}
