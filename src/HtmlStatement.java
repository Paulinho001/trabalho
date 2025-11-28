package trabalho;

import java.util.Enumeration;

public class HtmlStatement extends Statement {

    public String value(Customer aCustomer) {
        Enumeration rentals = aCustomer.getRentals();
        String result = headerString(aCustomer); // A estrutura agora é IDÊNTICA
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += eachRentalString(each);     // A estrutura agora é IDÊNTICA
        }
        result += footerString(aCustomer);       // A estrutura agora é IDÊNTICA
        return result;
    }

    // Métodos auxiliares com a lógica de HTML
    String headerString(Customer aCustomer) {
        return "<H1>Rentals for <EM>" + aCustomer.getName() + "</EM></H1><P>\n";
    }

    String eachRentalString(Rental aRental) {
        return aRental.getMovie().getTitle()+ ": " +
                String.valueOf(aRental.getCharge()) + "<BR>\n";
    }

    String footerString(Customer aCustomer) {
        return "<P>You owe <EM>" +
                String.valueOf(aCustomer.getTotalCharge()) + "</EM><P>\n" +
                "On this rental you earned <EM>" +
                String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
                "</EM> frequent renter points<P>";
    }
}