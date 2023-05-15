package org.hotelmanagementsystem;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@SpringBootTest
class HotelManagementSystemApplicationTests {

    @Test
    void firstTest() {
        String message = "Hello Hotel Mangement System";
        assertEquals("Basic Test", "Hello Hotel Mangement System", message);
    }
}
