import org.jetbrains.annotations.NotNull;

import java.util.Collection;

/**
 * Represents a model created by the AdaBoost.M1 algorithm.
 * @param <Y> The type of the output variable (class/category) of the Record's',
 * this AdaBoostM1 handles.
 */
public class AdaBoostM1<Y> implements Classifier<Y> {
    private double[] b;
    private Y[] h;

    /**
     * Creates an AdaBoostM1 trained model, given its training Record's', a
     * ClassifierGenerator to generate its weak Classifier's' and the maximum
     * number of weak Classifier's' it will use for prediction.
     * @param records A Collection with all the training data, to construct this
     * AdaBoostM1 model. The type of all the same Feature's' must be the same,
     * otherwise the generated Classifier will have undefined results.
     * @param classifierGen A generator of Classifier's'.
     * @param maxModels The maximum number of weak Classifier's' this AdaBoostM1
     * model, will use for prediction.
     */
    public AdaBoostM1(@NotNull Collection<Record<Y>> records,
                      ClassifierGenerator<Y> classifierGen, int maxModels) {
        int m = records.size();
        double e, Z;
        Record[] temp_records = new Record[m];
        Classifier<Y> classifier = classifierGen.generate(records);

        temp_records = records.toArray(temp_records);

        // Initialize the weights of all the records
        for (int i = 0; i < m; i++)
            temp_records[i].setWeight(1 / m);

        b = new double[maxModels];
        h = new Y[maxModels];

        for (int t = 0; t < maxModels; t++) {
            // Initialize the error variable in each loop
            e = 0.0;
            for (int i = 0; i < m; i++) {
                // Get back a hypothesis h : X --> Y
                h[t] = (Y) classifier.predict(temp_records[i]);
                // Calculate the error of hypothesis
                if (temp_records[i].getTarget() != h[t])
                  e += temp_records[i].getWeight();
                if (e > 0.5) {
                    t = maxModels;
                    return ; // Abort the loop

                }
            }

            b[t] = e / (1 - e);
            Z = 0.0;

            for (int i = 0; i < m; i++) {
                double w = temp_records[i].getWeight() / Z;
                if (h[t][i] == temp_records[i].getTarget())
                    w *= b[t];

            }
        }
    }

    /**
     * Predicts/Classifies the output value of a given Record.
     * @param record A Record to predict its output value.
     * @return The predicted output value of the given Record.
     */
    @Override
    public @NotNull Y predict(@NotNull Record<Y> record) {
        double sum = 0.0;
        Y hfin;

        for (int t = 0; t < h.length; t++) {
            if (h[t] == record.getTarget())
                sum += Math.log(1/b[t]);
        }

        return hfin;
    }

}//end class AdaBoostM1