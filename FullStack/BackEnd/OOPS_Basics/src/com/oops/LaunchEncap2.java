package com.oops;

class Books
{
    int pageNum;
    void setPageNum(int x){
        pageNum = x;
    }
    int getPageName(){
        return pageNum;
    }
}


public class LaunchEncap2 {
 public static void main(String[] args) {
    Books book = new Books();
    book.setPageNum(10);
    System.out.println(book.getPageName());
 }
}
