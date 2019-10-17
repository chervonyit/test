package net.data.model;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "mybook")
public class MyBook {

    private int pageAmount;
    private String title;

    public MyBook(int pageAmount, String title) {
        this.pageAmount = pageAmount;
        this.title = title;
    }

    public MyBook() {
    }

    public int getPageAmount() {
        return pageAmount;
    }

    @XmlElement(name = "amount")
    public void setPageAmount(int pageAmount) {
        this.pageAmount = pageAmount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "MyBook{" +
                "pageAmount=" + pageAmount +
                ", title='" + title + '\'' +
                '}';
    }
}
