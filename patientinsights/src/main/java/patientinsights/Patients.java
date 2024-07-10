package patientinsights;

public class Patients {
    private String number;
    private String firstName;
    private String lastName;
    private String email;
    private String DOB;
    private String phoneNumber;

    public Patients(){
        number = "";
        firstName = "";
        lastName = "";
        DOB = "";
        email = "";
        phoneNumber = "";
    }

    public Patients(String n, String first, String last, String d, String e, String p){
        number = n;
        firstName = first;
        lastName = last;
        DOB = d;
        email = e;
        phoneNumber = p;
    }
    public String getNumber() {
        return number;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getDOB() {
        return DOB;
    }
    public String getEmail() {
        return email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }


    public void setNumber(String n) {
        number = n;
    }
    public void setFirstName(String first) {
        firstName = first;
    }
    public void setLastName(String last) {
        lastName = last;
    }
    public void setDOB(String d) {
        DOB = d;
    }
    public void setEmail(String e) {
        email = e;
    }
    public void setPhoneNumber(String p) {
        phoneNumber = p;
    }

    public String convertString(){
        return "First Name: " + firstName + ", Last Name: " + lastName + ", DOB: " + DOB + ", Email: " + email + ", Phone Number: " + phoneNumber;
    } 
}
