package com.claytonpereira.normalizer;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

    public class NormalizerTest {

        @Test
        public void testNormalise() {
            Normalizer normalizer = new Normalizer();

            assertEquals("Software engineer", normalizer.normalise("Java engineer"));
            assertEquals("Software engineer", normalizer.normalise("C# engineer"));
            assertEquals("Accountant", normalizer.normalise("Accountant"));
            assertEquals("Accountant", normalizer.normalise("Chief Accountant"));
        }
    }

