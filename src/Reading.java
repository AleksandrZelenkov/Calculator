class Reading {
    private String aString;
    private String bString;
    private String action;
    private String input;

    Reading(String input){this.input = input;}

    protected void split() throws CalculatorException{
        String[] strings = input.split(" ");

        if(strings.length == 3){
            aString = strings[0];
            bString = strings[2];
            action = strings[1];
        } else {throw new CalculatorException("Вы ввели какую-то чушь.");}
    }

    protected String getA(){return aString;}
    protected String getB(){return bString;}
    protected String getAction(){return action;}
}