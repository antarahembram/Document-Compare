package com.documentCompare.backend.pdfComparePOC;

import de.redsix.pdfcompare.DiffImage;


public class CompareResultWithPageOverflow extends Compare2PDFs{

	
	private final int maxPages;
	
	/**
    * Defaults to swap to disk, when more than 10 pages are stored.
    */
   public CompareResultWithPageOverflow() {
       this.maxPages = 10;
   }
   
   /**
    * Swaps to disk, when more than the given pages are in memory.
    *
    * @param maxPages the maximum amount of pages to keep in memory
    */
   public CompareResultWithPageOverflow(final int maxPages) {
       this.maxPages = maxPages;
   }

//Commented out by Antara
//   @Override
//   protected synchronized boolean needToSwap() {
//       return DiffImage.siz() >= maxPages;
//   }
//
}
