package com.documentCompare.backend.pdfComparePOC;
import com.aventstack.extentreports.markuputils.Markup;

/**
 * Class that represents Hyper link
 */
class ExtentLink implements Markup {
	
 private String linkUrl;
 private String linkText;
 
 public String getLinkUrl() {
  return this.linkUrl;
 }
 
 public void setLinkUrl(String linkUrl) {
  this.linkUrl = linkUrl;
 }
 
 public String getLinkText() {
  return this.linkText;
 }
 
 public void setLinkText(String linkText) {
  this.linkText = linkText;
 }
 
 @Override
 public String getMarkup() {
   	final String htmlTag = "<a target=\"_blank\" href='"+this.linkUrl+"'>"+this.linkText+"</a>"; //changed by Antara
    return htmlTag;
 }
 @Override
 public String toString() {
  return this.linkText;
 }

}