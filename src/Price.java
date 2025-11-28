public abstract class Price {
    public abstract int getPriceCode();

    public abstract double getCharge(int daysRented);

    // MUDANÇA (Commit 15): Implementação padrão (Default)
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}