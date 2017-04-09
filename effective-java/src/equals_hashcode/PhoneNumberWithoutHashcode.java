package equals_hashcode;

/**
 * Created by Jay on 3/24/17.
 */
public class PhoneNumberWithoutHashcode {

    protected final short countryCode;
    protected final short number;

    public PhoneNumberWithoutHashcode(int countryCode, int number) {
        this.countryCode = (short) countryCode;
        this.number = (short) number;
    }

    @Override
    public boolean equals(Object obj) {
        // 1. check == reference
        if (this == obj)
            return true;

        // 2. check obj instance
        if (!(obj instanceof PhoneNumberWithoutHashcode))
            return false;

        // 3. check logic value
        PhoneNumberWithoutHashcode target = (PhoneNumberWithoutHashcode) obj;
        return target.number == this.number
                && target.countryCode == this.countryCode;
    }
}