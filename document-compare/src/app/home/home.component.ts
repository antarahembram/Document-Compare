import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators} from '@angular/forms';
import {HttpClient} from '@angular/common/http';
import { DocumentcompareService } from '../documentcompare.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  public fileData:any;
  public fileContent:any;
  public fileList1=new Array();
  public fileList2=new Array();
  public files=new Array();
 public showCompare:any;
 public textToShow:any;
 public path:any;
  constructor(private documentcompareservice:DocumentcompareService,private router:Router) { }

  async ngOnInit() {
    this.showCompare=false;
  }
  form = new FormGroup({
    files1: new FormControl(null, Validators.required),
    files2: new FormControl(null, Validators.required)

  });

  // fileInput=new FormControl(null, Validators.required);
  
  get f(){
    return this.form.controls;
  }

  uploadFile(event:any) {
    for(let i=0;i<event.length;i++)
    {
      this.fileList1.push(event[i])
    }
  }
  uploadFile2(event:any) {
    for(let i=0;i<event.length;i++)
    {
      this.fileList2.push(event[i])
    }
  }
  deleteAttachment(index:any) {
    this.files.splice(index, 1)
  }
  
  async onFileChange1(event:any){
    let reader = new FileReader();

    for(let i=0;i<event.target.files.length;i++)
    {
    this.fileList1.push(event.target.files[i])
      
    }
    
    
  }

  async onFileChange2(event:any){
    let reader = new FileReader();

    for(let i=0;i<event.target.files.length;i++)
    {
    this.fileList2.push(event.target.files[i])
    // this.fileData  = event.target.files[i];
    //   reader.onload = () => {
        
    //      this.fileContent = reader.result;
    //   };
    // reader.readAsBinaryString(this.fileData)

    }
    //  this.fileData  = event.target.files[0];
      
    // this.fileList2.push(this.fileData)
        // console.log(event.target.files[0])

    //   reader.onload = () => {
        
    //      this.fileContent = reader.result;
    //   };
    // reader.readAsText(this.fileData)
  }

  submit(){
    if(this.fileList1.length==this.fileList2.length)
    {
      // this.showCompare=true;

      // console.log(this.fileList1)
      // console.log(this.fileList2)
      var fileList=new Array();
      for(var i=0;i<this.fileList1.length;i++)
      {
        var row=new Array();
        row.push(this.fileList1[i].name)
        row.push(this.fileList2[i].name)
        fileList.push(row);
      }
      console.log(fileList)
      this.documentcompareservice.compare(fileList).subscribe((res)=>{
        console.log(res);
        this.router.navigateByUrl('/compareResult')
        

      })
    }
    else{
      alert("Number of Expected PDFs is not same as Actual PDFs")
    }
    // this.documentcompareservice.method().subscribe((res)=>{console.log(res);
    // this.textToShow=res;
    // })

  }

}
