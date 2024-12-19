public class User {

    final String userId;
    String encryptedPassword, email, companyName;


    public User (String userId, String email, String companyName) {
        this.userId = userId;
        this.email = email;
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
