public class User {

    private String name;
    private String password;
    private String phoneNumber;
    private boolean isRealEstateAgentOrRegular;

    public User(String userName, String password, String phoneNumber, boolean isRealEstateAgentOrRegular) {
        this.name = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.isRealEstateAgentOrRegular = isRealEstateAgentOrRegular;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isRealEstateAgentOrRegular() {
        return isRealEstateAgentOrRegular;
    }

    public void setRealEstateAgentOrRegular(boolean realEstateAgentOrRegular) {
        isRealEstateAgentOrRegular = realEstateAgentOrRegular;
    }
}
