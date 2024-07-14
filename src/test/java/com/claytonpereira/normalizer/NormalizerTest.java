package com.claytonpereira.normalizer;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

    public class NormalizerTest {

        @Test
        public void testNormalise() {
            Normalizer normalizer = new Normalizer();

            assertEquals("Software engineer", normalizer.normalize("Java engineer"));
            assertEquals("Software engineer", normalizer.normalize("C# engineer"));
            assertEquals("Accountant", normalizer.normalize("Accountant"));
            assertEquals("Accountant", normalizer.normalize("Chief Accountant"));
        }
    }

