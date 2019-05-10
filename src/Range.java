import org.jetbrains.annotations.NotNull;

/**
 * Represents a range of continuous values, in order to reduce continuous values
 * into discrete categories.
 * @param <T> The type of the bounds of this Range.
 */
public abstract class Range<T extends Comparable<T>> {

    /**
     * Indicates if this Range contains the given value.
     * @param value A value to check if it is contained in this Range.
     * @return True if the given value is contained in this Range, otherwise
     * false.
     */
    public abstract boolean contains(@NotNull T value);

}//end if