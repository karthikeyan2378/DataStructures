package DesignPatterns;

class User{

    private final String lName;
    private final String fName;
    private final int age;

    @Override
    public String toString() {
        return "User{" +
                "lName='" + lName + '\'' +
                ", fName='" + fName + '\'' +
                ", age=" + age +
                ", pNum=" + pNum +
                '}';
    }

    private final int pNum;
    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public int getAge() {
        return age;
    }

    public int getpNum() {
        return pNum;
    }


    private User(UserBuilder builder){
        this.fName = builder.fName;
        this.lName = builder.lName;
        this.age = builder.age;
        this.pNum = builder.pNum;
    }
    public static class UserBuilder{
        private final String lName;
        private int age;
        
        private int pNum;

        private final String fName;

        public UserBuilder(String lName, String fName) {
            this.lName = lName;
            this.fName = fName;
        }

        public UserBuilder age(int age)
        {
            this.age = age;
            return this;
        }
        
        public  UserBuilder pNum(int pNum)
        {
            this.pNum = pNum;
            return this;
        }
        public User build() {
            User user =  new User(this);
            //validateUserObject(user);
            return user;
        }

        private void validateUserObject(User user) {
            //Do some basic validations to check
            //if user object douser4es not break any assumption of system
            System.out.println("user = " + user);
        }

    }

    public static void main(String[] args)
    {
        User user1 = new User.UserBuilder("Lokesh", "Gupta")
                .age(30)
                .build();

        System.out.println("user1 = " + user1);

        User user2 = new User.UserBuilder("Jack", "Reacher")
                .age(40)
                //no address
                .build();

        System.out.println("user2 = " + user2);

        User user3 = new User.UserBuilder("Super", "Man")
                .build();

        System.out.println("user3 = " + user3);
        User user4 = new User.UserBuilder("234", "Man").age(32).pNum(12).build();
        System.out.println("user4 = " + user4);

        User user5 = new User.UserBuilder("234", "Man").pNum(12).build();
        System.out.println("user5 = " + user5);
    }
}

