package use_case.login;

public class LoginOutputData {
    private final String first_name;
    private final String last_name;

    public LoginOutputData(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public String getName() {return first_name + last_name;}
}
