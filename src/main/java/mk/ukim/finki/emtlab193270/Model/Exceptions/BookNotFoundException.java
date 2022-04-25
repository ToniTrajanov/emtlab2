package mk.ukim.finki.emtlab193270.Model.Exceptions;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(){
        super(String.format("The book was not found"));
    }
}
