package models;

public class PaymentData {
    private String firstName;
    private String secondName;
    private String zipCode;

    public static class Builder {
        private PaymentData paymentData;

        public Builder() {
            paymentData = new PaymentData();
        }

        public Builder withFirstName(String firstName) {
            paymentData.firstName = firstName;
            return this;
        }

        public Builder withSecondName(String secondName) {
            paymentData.secondName = secondName;
            return this;
        }

        public Builder withZipCode(String zipCode) {
            paymentData.zipCode = zipCode;
            return this;
        }

        public PaymentData build() {
            return paymentData;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
