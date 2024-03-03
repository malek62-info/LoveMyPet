package com.nanterre.LoveMyPet.service;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ResourceNotFoundExceptionTest {

    @Test
    public void testResourceNotFoundExceptionMessage() {
        // Arrange
        String errorMessage = "Resource not found";

        // Act
        ResourceNotFoundException exception = new ResourceNotFoundException(errorMessage);

        // Assert
        assertEquals(errorMessage, exception.getMessage());
    }
}
