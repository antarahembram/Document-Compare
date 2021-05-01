package com.documentCompare.service;
import com.documentCompare.domain.Obj;
import com.documentCompare.domain.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class DocCompareServiceImpl implements DocCompareService{

    @Autowired
    Test test;
    @Override
    public Obj function1() {
        return test.method1();
    }
}
