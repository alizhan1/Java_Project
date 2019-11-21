package BackApp;

public abstract class Person {

    private String firstname;
    private String lastname;
    private String gender;
    private String nationality;
    private String degree;

    public Person(String firstname, String lastname, String gender, String nationality, String degree) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.nationality = nationality;
        this.degree = degree;
    }

    public Person() {}

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getDegree() {
        return degree;
    }

    public String getGender() {
        return gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
