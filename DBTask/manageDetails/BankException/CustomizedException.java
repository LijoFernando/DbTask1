package manageDetails.manageDetails.BankException;


public class CustomizedException extends Exception {
    public CustomizedException() {
        super();
    }

    public CustomizedException(String msg){
            super(msg);
        }

        public CustomizedException(String s,Throwable error) {
            super(s, error);

        }
}
