/**
 * Created by Jay on 3/24/17.
 */
public class HelloBuilder {

    public static void main(String[] args) {
        Person person = new Person.Builder("Jay", 1).age(20).school("sjtu").sex(1).build();
        Person person2 = new Person.Builder("lulu", 10).age(18).sex(0).build();

        System.out.println("person: " + person.toString() + "\n");
        System.out.println("person2: " + person2.toString() + "\n");
    }

    static class Person {
        private long id; // must larget than 0
        private String name; // must not be null
        private int age;
        private int sex;
        private String school;

        private Person(Builder builder) {
            if (builder.name == null || builder.name.length() == 0) {
                throw new IllegalArgumentException("name should be null or empty");
            }
            if (builder.id <= 0) {
                throw new IllegalArgumentException("id must be larger zero");
            }
            this.name = builder.name;
            this.age = builder.age;
            this.sex = builder.sex;
            this.school = builder.school;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder(100);
            sb.append("name: ");
            sb.append(name);
            sb.append("; age: ");
            sb.append(age);
            sb.append("; id: ");
            sb.append(id);
            sb.append("; sex: ");
            sb.append(sex);
            return sb.toString();
        }

        static class Builder {
            private String name;
            private int age = 18;
            private long id;
            private int sex = 1;
            private String school;

            public Builder(String name, int id) {
                this.name = name;
                this.id = id;
            }

            public Builder age(int age) {
                this.age = age;
                return this;
            }

            public Builder sex(int sex) {
                this.sex = sex;
                return this;
            }

            public Builder school(String school) {
                this.school = school;
                return this;
            }

            public Person build() {
                return new Person(this);
            }
        }
    }


}