public abstract class Price {
    public abstract int getPriceCode();

    // MUDANÇA: Virou abstrato. O switch sumiu!
    public abstract double getCharge(int daysRented);
}