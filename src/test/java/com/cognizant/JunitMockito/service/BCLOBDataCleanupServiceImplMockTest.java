package com.cognizant.JunitMockito.service;

import com.cognizant.JunitMockito.repo.BCLOBDataCleanupRepo;
import com.cognizant.JunitMockito.service.impl.BCLOBDataCleanupServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BCLOBDataCleanupServiceImplMockTest {

    //BCLOBDataCleanupServiceImpl service = new BCLOBDataCleanupServiceImpl();
    //mocking data service
   // BCLOBDataCleanupRepo repoMock = mock(BCLOBDataCleanupRepo.class);

    @InjectMocks
    BCLOBDataCleanupServiceImpl service;
    @Mock
    BCLOBDataCleanupRepo repoMock;


   /* @BeforeEach
    public void before() {
        service.setBclobDataCleanupRepo(repoMock);
    }*/

    @Test
    public void calculateSumTestUsingDataService() {
        when(repoMock.retrieveAllData()).thenReturn(new int[]{1, 2, 3, 4, 5});
        assertEquals(15, service.calculateSumUsingDataService());

    }

    @Test
    public void calculateSumUsingDataService_empty() {
        when(repoMock.retrieveAllData()).thenReturn(new int[]{});
        assertEquals(0, service.calculateSumUsingDataService());

    }

    @Test
    public void calculateSumUsingDataService_oneValue() {

        when(repoMock.retrieveAllData()).thenReturn(new int[]{6});
        assertEquals(6, service.calculateSumUsingDataService());

    }
}
