package mk.ukim.finki.emtlab193270.Model.Exceptions;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException() {
        super("Category not found exception");
    }
}
