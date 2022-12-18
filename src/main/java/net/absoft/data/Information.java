package net.absoft.data;

public enum Information {

    STANDARD_INFO_USER("Maria", "Test", "6500");

    private String firstName;
    private String lastName;
    private String postalCode;
    Information(String firstName, String lastName, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getPostalCode() {
        return postalCode;
    }

    @Override
    public String toString() {
        return "Information{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", postalCode ='" + postalCode + '\'' +
                '}';
    }

}
