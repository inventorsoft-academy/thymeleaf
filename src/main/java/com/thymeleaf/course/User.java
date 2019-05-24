package hello;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

    @NotNull
    @Size(min=2,max=40,message="first name invalid")
    private String firstName;

    @NotNull
    @Size(min=2,max=40,message="last name invalid")
    private String lastName;
    @Email
    private String email;
    @NotNull
    @Size(min=4,max=15,message="password invalid")
    private String password;

    public User(){}

    public User(String firsName, String lastName, String email, String password) {
        this.firstName = firsName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setFirstName(String firsName) {
        this.firstName = firsName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
