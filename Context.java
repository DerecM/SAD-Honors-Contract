public class Context {
    private emailState state;

    public Context()
    {
        state = null;
    }

    public void setState(emailState e){
        this.state = e;
    }

    public emailState getState(){
        return state;
    }

    public String toString()
    {
        return "No Email Found";
    }
}

