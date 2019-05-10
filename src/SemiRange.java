import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * Represents a semi infinite range of continuous values, in order to reduce
 * continuous values into discrete categories.
 * @param <T> The type of the bound of this SemiRange.
 */
public class SemiRange<T extends Comparable<T>> extends Range<T> {

    /**
     * The lower or upper bound of this SemiRange.
     */
    private T bound;

    /**
     * Indicates if the bound of this SemiRange is a lower or upper one. True
     * if it is a lower bound, otherwise false if it is an upper bound.
     */
    private boolean isBoundLow;

    /**
     * Indicates if the bound of this SemiRange is included. True if it is
     * included, otherwise false.
     */
    private boolean isBoundInc;

    /**
     * Creates a SemiRange, given its bound and if it is a lower or upper one.
     * @param bound The bound of this SemiRange.
     * @param isBoundLow Indicates the type (lower | upper) of this SemiRange.
     * True if it is lower, otherwise false if it is an upper bound.
     * @param isBoundInc Indicates if the bound of this SemiRange is included.
     * True if it is included, otherwise false.
     */
    public SemiRange(@NotNull T bound, boolean isBoundLow, boolean isBoundInc) {
        this.bound = bound;
        this.isBoundLow = isBoundLow;
        this.isBoundInc = isBoundInc;
    }

    /**
     * Indicates if this SemiRange contains the given value.
     * @param value A value to check if it is contained in this SemiRange.
     * @return True if the given value is contained in this SemiRange, otherwise
     * false.
     */
    @Override
    public boolean contains(@NotNull T value) {
        //Checks if the given value is equal to the bound of this SemiRange.
        if (this.bound.compareTo(value) == 0) {
            return this.isBoundInc;
        }//end if

        return this.isBoundLow == this.bound.compareTo(value) < 0;
    }

    /**
     * Indicates if the bound of this SemiRange is included.
     * @return True if the bound of this SemiRange is included, otherwise false.
     */
    public boolean isBoundInc() {
        return this.isBoundInc;
    }

    @Override
    public @NotNull
    String toString() {
        //The output String representation of this SemiRange.
        String out;
        //Checks if the bound of this SemiRange is lower or upper.
        if (this.isBoundLow) {
            out = String.format("%c%s, +inf)", this.isBoundInc ? '[' :
                    '(', this.bound);
        } else {
            out = String.format("(-inf, %s%c", this.bound, this.isBoundInc ? ']'
                    : ')');
        }//end if

        return out;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SemiRange<?> semiRange = (SemiRange<?>) o;
        return isBoundLow == semiRange.isBoundLow && isBoundInc ==
                semiRange.isBoundInc && bound.equals(semiRange.bound);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bound, isBoundLow, isBoundInc);
    }

}//end class SemiRange