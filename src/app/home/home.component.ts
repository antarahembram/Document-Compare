import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators} from '@angular/forms';
import {HttpClient} from '@angular/common/http';
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
  constructor() { }

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
    this.showCompare=true;
    console.log(this.fileList1)
    console.log(this.fileList2)

  }

  gotoHome()
  {
    this.showCompare=false;
    this.fileList1=[]
    this.fileList2=[]
  }
}
