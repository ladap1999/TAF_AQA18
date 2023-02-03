package models;

public class User {
    private String userName;
    private String userPassword;

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public User(String userName, String userPassword) {

        this.userName = userName;
        this.userPassword = userPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!userName.equals(user.userName)) return false;
        return userPassword.equals(user.userPassword);
    }

    @Override
    public int hashCode() {
        int result = userName.hashCode();
        result = 31 * result + userPassword.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
}
