package annotation;

import reflection.Invoke;

public class UserBean {

    @SerializedName("user_name")
    public String userName;

    @SerializedName("user_id")
    private long userId;

    public UserBean(String userName, long userId) {
        this.userName = userName;
        this.userId = userId;
    }

    public String getName() {
        return userName;
    }

    public long getId() {
        return userId;
    }

    @Invoke
    public static void staticMethod(String devName) {
        System.out.printf("Hi %s, I'm a static method\n", devName);
    }

    @Invoke
    public void publicMethod() {
        System.out.println("I'm a public method\n");
    }

    @Invoke
    private void privateMethod() {
        System.out.println("I'm a private method\n");
    }
}
