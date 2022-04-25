package mk.ukim.finki.emtlab193270.Model.Exceptions;

public class AuthorNotFoundException extends RuntimeException{
    public AuthorNotFoundException(){
        super(String.format("The author was not found"));
    }
}
