public class Property {
    public String string1;
    public String string2;

    public String getString1() {
        return string1;
    }

    public String getString2() {
        return string2;
    }

    Property(String value1, String value2) {

        string1 = value1;
        string2 = value2;
    }

    public void setString1(String value) {
        string1 = value;
    }

    public void setString2(String value){
        string2 = value;
    }
}
