package com.claytonpereira.normalizer;

import org.apache.commons.text.similarity.LevenshteinDistance;

import java.util.HashMap;
import java.util.Map;


public class Normalizer {
    private static final Map<String, String> NORMALIZED_TITLES = new HashMap<>();

    static {
        NORMALIZED_TITLES.put("Architect", "Architect");
        NORMALIZED_TITLES.put("Software engineer", "Software engineer");
        NORMALIZED_TITLES.put("Quantity surveyor", "Quantity surveyor");
        NORMALIZED_TITLES.put("Accountant", "Accountant");
    }

    private final LevenshteinDistance levenshtein = new LevenshteinDistance();

    public String normalise(String jobTitle) {
        String normalizedTitle = null;
        double highestScore = 0.0;

        for (String key : NORMALIZED_TITLES.keySet()) {
            double score = calculateSimilarity(jobTitle, key);
            if (score > highestScore) {
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

    public static void main(String[] args) {
        Normalizer normalizer = new Normalizer();
        String[] jobTitles = {"Java engineer", "C# engineer", "Chief Accountant"};

        for (String jt : jobTitles) {
            System.out.println("Input: " + jt + " => Normalized: " + normalizer.normalise(jt));
        }
    }
}
