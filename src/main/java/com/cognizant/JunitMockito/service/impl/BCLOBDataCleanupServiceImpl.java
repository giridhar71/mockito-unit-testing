package com.cognizant.JunitMockito.service.impl;

import com.cognizant.JunitMockito.repo.BCLOBDataCleanupRepo;
import com.cognizant.JunitMockito.service.BCLOBDataCleanupService;

public class BCLOBDataCleanupServiceImpl implements BCLOBDataCleanupService {

    private BCLOBDataCleanupRepo bclobDataCleanupRepo;

    public void setBclobDataCleanupRepo(BCLOBDataCleanupRepo bclobDataCleanupRepo) {
        this.bclobDataCleanupRepo = bclobDataCleanupRepo;
    }

    @Override
    public int calculateSum(int[] data) {
        int sum=0;
        for(int value:data){
            sum+=value;
        }
        return sum;
    }

    @Override
    public int calculateSumUsingDataService(){
        int[] result = bclobDataCleanupRepo.retrieveAllData();
        int sum=0;
        for(int value:result){
            sum+=value;
        }
        return sum;

    }
}
