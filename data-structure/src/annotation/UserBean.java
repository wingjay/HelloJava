package annotation;

/**
 * Created by Jay on 4/21/17.
 */
public class UserBean {

    @SerializedName("user_name")
    private String name;

    @SerializedName("user_id")
    private double id;

    @SerializedName("user_birthday")
    private int birthday;

    UserBean(String name, double id, int birthday) {
        this.name = name;
        this.id = id;
        this.birthday = birthday;
    }

    @Test
    public String getName() {
        return name;
    }

    @Test
    public double getId() {
        return id;
    }

    @Test
    public int getBirthday() {
        return birthday;
    }

    @Test
    public void testFailure() {
        throw new RuntimeException("aaa");
    }
}
