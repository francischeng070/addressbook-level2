package seedu.addressbook.data.person;

public class PostalCode {
    
    private String postalCode;
    
    public postalCode(String postalCode) {
        this.postalCode = postalCode.trim();
    }
    
    public getPostalCode() {
        return postalCode;
    }
}