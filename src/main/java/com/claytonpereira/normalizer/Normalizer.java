package com.claytonpereira.normalizer;

import org.apache.commons.text.similarity.LevenshteinDistance;

import java.util.HashMap;
import java.util.Map;

/**
 * Normalizer class, that has the method normalize to normalize the given Job title
 */
public class Normalizer {
    private static final Map<String, String> NORMALIZED_TITLES = new HashMap<>();
    private static final double THRESHOLD = 0.5;

    static {
        NORMALIZED_TITLES.put("Architect", "Architect");
        NORMALIZED_TITLES.put("Software engineer", "Software engineer");
        NORMALIZED_TITLES.put("Quantity surveyor", "Quantity surveyor");
        NORMALIZED_TITLES.put("Accountant", "Accountant");
    }

    private final LevenshteinDistance levenshtein = new LevenshteinDistance();

    /**
     *
     * @param jobTitle job title to be normalized
     * @return String with normalized title
     */
    public String normalize(String jobTitle) {
        String normalizedTitle = "No close match found";
        double highestScore = 0.0;

        for (String key : NORMALIZED_TITLES.keySet()) {
            double score = calculateSimilarity(jobTitle, key);
            if (score > THRESHOLD) {
                highestScore = score;
                normalizedTitle = NORMALIZED_TITLES.get(key);
            }
        }

        return normalizedTitle;
    }

    private double calculateSimilarity(String s1, String s2) {
        int maxLen = Math.max(s1.length(), s2.length());
        int levenshteinDist = levenshtein.apply(s1, s2);
        return 1.0 - ((double) levenshteinDist / maxLen);
    }

    // TODO: This main method is for demonstration and testing purposes.
    // It shows how to use the Normaliser class to normalize job titles.
    // You can uncomment and run this method to see how the normalization works.
    // Remove or comment out this method if not needed in the final library.
   /* public static void main(String[] args) {
        Normalizer normalizer = new Normalizer();
        String[] jobTitles = {"Java engineer", "C# engineer", "Chief Accountant"};

        for (String jt : jobTitles) {
            System.out.println("Input: " + jt + " => Normalized: " + normalizer.normalize(jt));
        }
    }*/
}
