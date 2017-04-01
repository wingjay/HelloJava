package effectiveJava.equalsHashcode;

/**
 * Created by Jay on 3/24/17.
 */
public class PhoneNumber implements Comparable {
    protected final short countryCode;
    protected final short number;

    public PhoneNumber(int countryCode, int number) {
        this.countryCode = (short) countryCode;
        this.number = (short) number;
    }

    @Override
    public boolean equals(Object obj) {
        // 1. check == reference
        if (this == obj)
            return true;

        // 2. check obj instance
        if (!(obj instanceof PhoneNumber))
            return false;

        // 3. check logic value
        PhoneNumber target = (PhoneNumber) obj;
        return target.number == this.number
                && target.countryCode == this.countryCode;
    }

    @Override
    public int hashCode() {
        return (31 * this.countryCode) + this.number;
    }

    @Override
    public int compareTo(Object o) {
        if (this == o) {
            return 0;
        }

        if (!(o instanceof PhoneNumber)) {
            throw new IllegalArgumentException("o must be instance of PhoneNumber");
        }

        PhoneNumber target = (PhoneNumber) o;
        if (countryCode < target.countryCode)
            return -1;
        if (countryCode > target.countryCode)
            return 1;

        if (number < target.number)
            return -1;
        if (number > target.number)
            return 1;

        return 0;
    }
}
