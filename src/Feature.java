import org.jetbrains.annotations.NotNull;

/**
 * Represents a feature/attribute in a record.
 * @param <T> The type of the data this Feature contains.
 */
public class Feature<T extends Comparable<T>> {

    /**
     * Represents a mechanism that generates Feature's'.
     * @param <T> The type of the data the Feature's' of this Generator contain.
     */
    public static class Generator<T extends Comparable<T>> {

        /**
         * The title of the Feature's' this Generator creates.
         */
        private final String TITLE;

        /**
         * The type of the Feature's' this Generator creates.
         */
        private final Type TYPE;

        /**
         * Creates a Generator, given the title and the type of the Feature's'
         * it will create.
         * @param title The title of the Feature's' this Generator creates.
         * @param type The type of the Feature's' this Generator creates.
         */
        public Generator(@NotNull String title, @NotNull Type type) {
            this.TITLE = title;
            this.TYPE = type;
        }

        /**
         * Generates a Feature, given its data.
         * @param data The data of the Feature to generate.
         * @return A Feature, with the title and type of this Generator, and the
         * given data.
         */
        public @NotNull
        Feature<T> generate(@NotNull T data) {
            return new Feature<>(this.getTitle(), data, this.getType());
        }

        /**
         * Gets the title of the Feature's' this Generator creates.
         * @return The title of the Feature's' this Generator creates.
         */
        public @NotNull
        String getTitle() {
            return this.TITLE;
        }

        /**
         * Gets the type of the Feature's' this Generator creates.
         * @return The type of the Feature's' this Generator creates.
         */
        public @NotNull Type getType() {
            return this.TYPE;
        }

    }//end inner class Generator

    /**
     * Represents the TYPE of the data contained by this Feature. Discrete or
     * continuous.
     */
    public enum Type {

        /**
         * A Feature that contains discrete values.
         */
        DISCRETE,

        /**
         * A Feature that contains continuous values.
         */
        CONTINUOUS

    }//end enum Type

    /**
     * The title of this Feature.
     */
    private final String TITLE;

    /**
     * The data of this Feature.
     */
    private final T DATA;

    /**
     * The TYPE of the data this Feature contains.
     */
    private final Type TYPE;

    /**
     * Creates a Feature, given its title and data.
     * @param title The title of this Feature.
     * @param data The data of this Feature.
     * @param type The TYPE of the data this Feature contains.
     */
    public Feature(@NotNull String title, @NotNull T data, @NotNull Type type) {
        this.TITLE = title;
        this.DATA = data;
        this.TYPE = type;
    }

    /**
     * Gets the title of this Feature.
     * @return The title of this Feature.
     */
    public @NotNull
    String getTitle() {
        return this.TITLE;
    }

    /**
     * Gets the data of this Feature.
     * @return The data of this Feature.
     */
    public @NotNull T getData() {
        return this.DATA;
    }

    /**
     * Gets the TYPE of data this Feature contains.
     * @return The TYPE of data this Feature contains.
     */
    public @NotNull Type getType() {
        return this.TYPE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Feature<?> feature = (Feature<?>) o;

        return TITLE.equals(feature.TITLE);

    }

    @Override
    public int hashCode() {
        return TITLE.hashCode();
    }

}//end class Feature