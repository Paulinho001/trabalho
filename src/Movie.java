public class Movie {

    public static final int  CHILDRENS = 2;
    public static final int  REGULAR = 0;
    public static final int  NEW_RELEASE = 1;

    private String _title;
    private Price _price; // MUDANÇA: Agora é do tipo Price, não int

    public Movie(String title, int priceCode) {
        _title = title;
        // O construtor agora chama o setter para criar o objeto correto
        setPriceCode(priceCode);
    }

    // MUDANÇA: Delega para a classe Price
    public int getPriceCode() {
        return _price.getPriceCode();
    }

    // MUDANÇA: O switch que cria as subclasses (Factory)
    public void setPriceCode(int arg) {
        switch (arg) {
            case REGULAR:
                _price = new RegularPrice();
                break;
            case CHILDRENS:
                _price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                _price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    public String getTitle (){
        return _title;
    }

    // Mantemos a lógica aqui por enquanto (será movida no próximo passo)
    public double getCharge(int daysRented) {
        return _price.getCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
        // Agora delegamos para a classe Price
        return _price.getFrequentRenterPoints(daysRented);

    }
}