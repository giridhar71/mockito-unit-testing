package com.cognizant.JunitMockito.service;

import com.cognizant.JunitMockito.repo.BCLOBDataCleanupRepo;
import com.cognizant.JunitMockito.service.impl.BCLOBDataCleanupServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BCLOBDataCleanupServiceStub implements BCLOBDataCleanupRepo{

    @Override
    public int[] retrieveAllData() {
        return new int[]{1,2,3,4,5};
    }
}

public class BCLOBDataCleanupServiceImplStubTest {

    @Test
    public void calculateSumTest(){
        BCLOBDataCleanupServiceImpl service = new BCLOBDataCleanupServiceImpl();
        service.setBclobDataCleanupRepo(new BCLOBDataCleanupServiceStub());
        int result = service.calculateSumUsingDataService();
        int expectedResult=15;
        assertEquals(expectedResult,result);

    }
}
