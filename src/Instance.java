import java.util.List;

/**
 * Represents an instance in a training set. Contains the
 * weight and list of string tokens.
 */
public class Instance {
    /**
     * The weight of each training instance.
     */
    private double weight;
    /**
     * The list of string tokens of each training instance.
     */
    private List<String> tokens;

    /**
     * Initializes the local variables.
     */
    public Instance() {
        weight = 0.0;
        tokens = null;
    }

    /**
     * Specifies the weight of a specific instance.
     * @param weight the weight of instance
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Specifies the list of string tokens of a
     * specific instance.
     * @param tokens the list of string tokens
     */
    public void setTokens(List<String> tokens) {
        this.tokens = tokens;
    }

    /**
     * Returns the weight of a specific instance.
     * @return the weight of instance
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Returns the list of string tokens of a
     * specific instance.
     * @return the list of string tokens of
     * instance
     */
    public List<String> getTokens() {
        return tokens;
    }
}
