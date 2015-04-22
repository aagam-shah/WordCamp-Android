package org.wordcamp.objects;

/**
 * Created by aagam on 14/4/15.
 */
public class Notif {

    public String type,title,descr,link;
    public int read;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getRead() {
        return read;
    }

    public void setRead(int read) {
        this.read = read;
    }

    public Notif(String type, String title, String descr, String link, int read) {
        this.type = type;
        this.title = title;
        this.descr = descr;
        this.link = link;
        this.read = read;
    }
}
