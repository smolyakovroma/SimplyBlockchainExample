package transaction;

public class Transaction {
    private Address sender;
    private Address recipient;
    private float sum;
    private String comment;

    public Transaction(Address sender, Address recipient, float sum, String comment) {
        this.sender = sender;
        this.recipient = recipient;
        this.sum = sum;
        this.comment = comment;
    }

    public Address getSender() {
        return sender;
    }

    public void setSender(Address sender) {
        this.sender = sender;
    }

    public Address getRecipient() {
        return recipient;
    }

    public void setRecipient(Address recipient) {
        this.recipient = recipient;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "sender=" + sender +
                ", recipient=" + recipient +
                ", sum=" + sum +
                ", comment='" + comment + '\'' +
                '}';
    }
}
