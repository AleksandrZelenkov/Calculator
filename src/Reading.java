public class Reading {
    private String a;
    private String b;
    private String action;

    Reading(String input){
        input = input;

        String[] strings = input.split(" ");
        this.a = strings[0];
        this.b = strings[2];
        this.action = strings[1];
    }

    protected String getA(){return a;}
    protected String getB(){return b;}
    protected String getAction(){return action;}


}
