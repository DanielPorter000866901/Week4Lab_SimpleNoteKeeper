package models;

import java.io.Serializable;

/**
 *
 * @author porte
 */
public class Note implements Serializable {
    
//    attributes
    String title;
    String contents;
    
    public Note() {
        
    }
    
//    getters
    public String getTitle() {
        return title;
    }
    public String getContents() {
        return contents;
    }
    
//    setters
    public void setTitle(String title) {
        this.title = title;
    }
    public void setContents(String contents) {
        this.contents = contents;
    }
    
}
