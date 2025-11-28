import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;
    private Vector _rentals = new Vector();

    public Customer (String name){
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName (){
        return _name;
    }

    // MUDANÇA: Novo método PÚBLICO para expor os aluguéis
    public Enumeration getRentals() {
        return _rentals.elements();
    }

    public String statement() {
        // Delega para a nova classe
        return new TextStatement().value(this);
    }

    public String htmlStatement() {
        // Delega para a nova classe
        return new HtmlStatement().value(this);
    }

    // MUDANÇA: Mudou de 'private' para 'public'
    public double getTotalCharge() {
        double result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    // MUDANÇA: Mudou de 'private' para 'public'
    public int getTotalFrequentRenterPoints(){
        int result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }
}