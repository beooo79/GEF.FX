package de.gef.fx.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class GearCategoryTest {

    @Test
    void testEmpty()
    {
          var cat = GearCategory.builder().build();
          assertNotNull(cat);
    }

}