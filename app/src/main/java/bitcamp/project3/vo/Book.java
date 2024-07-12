package bitcamp.project3.vo;

import bitcamp.project3.BookCode.mainCategory;
import bitcamp.project3.BookCode.subCategory;

public class Book {
    private static int seqBookId;
    private int bookCode;
    private String bookTitle;
    private String[] bookContents;
    private boolean loneBook;
//    List<User>
    private String category;

    public static int getSeqBookId() {
        return ++seqBookId;
    }


    public int getBookCode() {
        return bookCode;
    }

    private void setBookCode(String[] categorys) {
        int bookCode = 0;
        for(String category : categorys){
            switch (category){
                case "한국 서적": bookCode += mainCategory.KOREAN; break;
                case "외국 서적": bookCode += mainCategory.OTHER; break;
                case "미디어": bookCode += mainCategory.MEDIA; break;
                case "경제": bookCode += subCategory.ECONOMY; break;
                case "인문학": bookCode += subCategory.HUMAN;
                case "과학": bookCode += subCategory.SCIENCE;
                case "자기계발": bookCode += subCategory.SELF_HELP;
            }
        }
        this.bookCode = bookCode + getSeqBookId();
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String[] getBookContents() {
        return bookContents;
    }

    public void setBookContents(String[] bookContents) {
        this.bookContents = bookContents;
    }

    public boolean isLoneBook() {
        return loneBook;
    }

    public void setLoneBook(boolean loneBook) {
        this.loneBook = loneBook;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
        String[] categorys = category.split(" ");
        setBookCode(categorys);
    }
}
