public abstract class Price {
    public abstract int getPriceCode();

    // Já era abstrato desde o passo anterior
    public abstract double getCharge(int daysRented);

    // MUDANÇA (Commit 14): Movemos a lógica do Movie para cá
    public int getFrequentRenterPoints(int daysRented) {
        if ((getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1)
            return 2;
        else
            return 1;
    }
}