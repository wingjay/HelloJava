package annotation;

/**
 * Created by Jay on 4/21/17.
 */
public class Apple {

    @FruitName("Apple")
    private String appleName;

    @FruitColor(color=FruitColor.Color.GREEN)
    private String appleColor;

    @FruitProvider(id=1, name="xiao wang", address = "beijing")
    private String appleProvider;

    public void setAppleColor(String appleColor) {
        this.appleColor = appleColor;
    }

    public String getAppleColor() {
        return appleColor;
    }

    public void setAppleName(String appleName) {
        this.appleName = appleName;
    }
    public String getAppleName() {
        return appleName;
    }

    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;
    }
    public String getAppleProvider() {
        return appleProvider;
    }

    public void displayName(){
        System.out.println("水果的名字是：苹果");
    }
}
