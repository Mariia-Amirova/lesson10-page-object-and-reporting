package net.absoft.data;

public enum Information {

    STANDARD_INFO_USER("Maria", "Test", "6500");

    private String firstName;
    private String lastName;
    private String zip;
    Information(String firstName, String lastName, String zip) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.zip = zip;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getZip() {
        return zip;
    }

    @Override
    public String toString() {
        return "Information{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", zip ='" + zip + '\'' +
                '}';
    }

}
