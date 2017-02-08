package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Contact {

    public final String value;
    private boolean isPrivate;
    
    /**
     * Validates given contact information
     *Value can be email/phone/address
     * @throws IllegalValueException if given contact string is invalid.
     */
    
    
    public Contact(String value, boolean isPrivate, String regex, String messageConstraints) throws IllegalValueException {
        this.isPrivate = isPrivate;
        String trimmedValue = value.trim();
        
        if(!isValid(trimmedValue, regex)) {
            throw new IllegalValueException(messageConstraints);
        }
        
        this.value = trimmedValue;
    }
    
    @Override
    public String toString() {
        return value;
    }
    
    @Override
    public int hashCode() {
        return value.hashCode();
    }
    
  
    public boolean isPrivate() {
        return isPrivate;
    }
    
    /**
     * Checks if a given string is a valid contact information
     */
    
    public static boolean isValid(String test, String regex) {
        return test.matches(regex);
    }
    }
