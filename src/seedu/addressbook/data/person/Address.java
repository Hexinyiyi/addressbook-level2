package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address extends Contact{

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    private Block block;
    private Street street = new Street("");
    private Unit unit = new Unit("");
    private Postal postal = new Postal("");

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        super(address, isPrivate);
        String trimmedAddress = address.trim();
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        String[] parts = trimmedAddress.split(",");
        this.block = new Block(parts[0].trim());
        if (parts.length > 1) {
            this.street = new Street(parts[1].trim());
        }
        if (parts.length > 2) {
            this.unit = new Unit(parts[2].trim());
        }
        if (parts.length > 3) {
            this.postal = new Postal(parts[3].trim());
        }

        String result = block.toString();
        if (!street.toString().equals("")) {
            result += ", " + street.toString();
        }
        if (!unit.toString().equals("")) {
            result += ", " + unit.toString();
        }
        if (!postal.toString().equals("")) {
            result += ", " + postal.toString();
        }
        this.value = result;
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }



    public class Block {
        private String blockNumber;

        public Block(String blockNumber) {
            this.blockNumber = blockNumber;
        }

        public String getBlockNumber() {
            return blockNumber;
        }

        @Override
        public String toString() {
            return blockNumber;
        }

        @Override
        public boolean equals(Object other) {
            return other == this ||
                    (other instanceof Block && this.blockNumber.equals(((Block) other).getBlockNumber()));
        }
    }

    public class Street {
        private String street;

        public Street(String street) {
            this.street = street;
        }

        public String getStreet() {
            return street;
        }

        @Override
        public String toString() {
            return street;
        }

        @Override
        public boolean equals(Object other) {
            return other == this ||
                    (other instanceof Street && this.street.equals(((Street) other).getStreet()));
        }
    }

    public class Unit {
        private String unit;

        public Unit(String unit) {
            this.unit = unit;
        }

        public String getUnit() {
            return unit;
        }

        @Override
        public String toString() {
            return unit;
        }

        @Override
        public boolean equals(Object other) {
            return other == this ||
                    (other instanceof Unit && this.unit.equals(((Unit) other).getUnit()));
        }
    }

    public class Postal {
        private String postalCode;

        public Postal(String postalCode) {
            this.postalCode = postalCode;
        }

        public String getPostalCode() {
            return postalCode;
        }

        @Override
        public String toString() {
            return postalCode;
        }

        @Override
        public boolean equals(Object other) {
            return other == this ||
                    (other instanceof Postal && this.postalCode.equals(((Postal) other).getPostalCode()));
        }
    }
}
