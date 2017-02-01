package seedu.addressbook.data.person;
package seedu.addressbook.data.Block;
package seedu.addressbook.data.Unit;
package seedu.addressbook.data.Street;
package seedu.addressbook.data.PostalCode;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, #12-645, some street, 213551";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses should have Block, Unit, Street and Postal Code";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    public final String value;
    private boolean isPrivate;
    private Block block;
    private Unit unit;
    private Street street;
    private PostalCode postalCode;
    private final addressLimit = 4;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        
        String trimmedAddress = address.trim();
        String[] splitAddress = trimmedAddress.split(", ");
        /**
         * Prevent array out of bound when assigning values
         */
        if(splitAddress.length==addressLimit) {
            block = new Block(splitAddress[0]);
            unit = new Unit(splitAddress[1]);
            street = new Street(splitAddress[2]);
            postalCode = new Postalcode(splitAddress[3]);
        }else{
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.value = trimmedAddress;
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                        && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}