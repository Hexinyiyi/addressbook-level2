package seedu.addressbook.data.person;

public abstract class Contact {

    public String value;
    private boolean isPrivate;


    public Contact(String contact, boolean isPrivate) {
        this.isPrivate = isPrivate;
        this.value = contact.trim();
    }

    public static boolean isValid(String test) {
        return true;
    }

    public String toString() {
        return value;
    }

    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Contact // instanceof handles nulls
                && this.value.equals(((Contact) other).value)); // state check
    }

    public int hashCode() {
        return value.hashCode();
    }


    public boolean isPrivate() {
        return isPrivate;
    }
}
