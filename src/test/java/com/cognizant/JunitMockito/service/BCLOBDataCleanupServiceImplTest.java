package com.cognizant.JunitMockito.service;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.cognizant.JunitMockito.service.impl.BCLOBDataCleanupServiceImpl;
import org.junit.jupiter.api.Test;


public class BCLOBDataCleanupServiceImplTest {

    @Test
    public void calculateSumTest() {
        BCLOBDataCleanupServiceImpl service = new BCLOBDataCleanupServiceImpl();
        int result = service.calculateSum(new int[]{1, 2, 3, 4, 5});
        int expectedResult = 15;
        assertEquals(expectedResult, result);

    }
}
