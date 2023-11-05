package paterns;

public interface Iter<T> {
    boolean hasNext();
    T next() throws Exception;
}
