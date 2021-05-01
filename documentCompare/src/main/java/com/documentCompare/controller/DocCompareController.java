package com.documentCompare.controller;

import com.documentCompare.backend.pdfComparePOC.TestBase;
import com.documentCompare.domain.Obj;
import com.documentCompare.service.DocCompareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DocCompareController {
    DocCompareService docCompareService;
    @Autowired
    public DocCompareController(DocCompareService docCompareService)
    {
        this.docCompareService = docCompareService;
    }

    @GetMapping("/getString")
    public ResponseEntity<?> interview() {
        return new ResponseEntity<Obj>(docCompareService.function1(), HttpStatus.OK);
    }

    @PostMapping("/compare")
    public ResponseEntity<?> compareResult(@RequestBody Object[][] totalList) throws IOException {
        TestBase testBase=new TestBase();
//        testBase.testPdfCompare;
        testBase.startExtendReports();
//        Object[][] data=testBase.getTwoDymansionObjectArrayData();
        for(int index=0;index<totalList.length;index++)
        {
            String exp= "C:\\Users\\Antara Hembram\\Desktop\\POC_INTEGRation\\PDF\\" + (String)totalList[index][0];
            String act = "C:\\Users\\Antara Hembram\\Desktop\\POC_INTEGRation\\PDF\\" + (String)totalList[index][1];
            testBase.testPdfCompare(exp,act);
        }
        testBase.close();
        String[] htmlPath={"done"};
        System.out.println(htmlPath);
        return new ResponseEntity<String[]>(htmlPath, HttpStatus.OK);
    }


}
