package models;

public class UserGui {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public static class Builder{
        private UserGui newUserGui;

        public Builder(){
            newUserGui = new UserGui();
        }
        public Builder withEmail(String value){
            newUserGui.email = value;

            return this;
        }

        public Builder withFirstName(String value){
            newUserGui.firstName = value;

            return this;
        }

        public Builder withLastName(String value){
            newUserGui.lastName = value;

            return this;
        }
        public Builder withPassword(String value){
            newUserGui.password = value;

            return this;
        }

        public UserGui build(){
            return newUserGui;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
