package com.cognizant.JunitMockito.service;

import org.springframework.stereotype.Service;

@Service
public interface BCLOBDataCleanupService {
    public int calculateSum(int[] data);
    public int calculateSumUsingDataService();
}
