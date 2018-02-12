package fr.polytech.ihm.Model;

import javafx.beans.property.*;

public class Task {
    private StringProperty title;
    private StringProperty author;
    private StringProperty assignee;
    private StringProperty category;
    private StringProperty date; //TODO : date type en javaFX
    private StringProperty location;
    private StringProperty description;
    private IntegerProperty upvote;
    private IntegerProperty emergencyLvl; //1(easy) to 3(important)
    private BooleanProperty resolved = new SimpleBooleanProperty(false);

    public Task(String title,String author,String assignee,String category,String date,String location,String description,int upvote, int emergency){
        this.title=new SimpleStringProperty(title);
        this.author=new SimpleStringProperty(author);
        this.assignee=new SimpleStringProperty(assignee);
        this.category=new SimpleStringProperty(category);
        this.date=new SimpleStringProperty(date);
        this.location=new SimpleStringProperty(location);
        this.description=new SimpleStringProperty(description);
        this.upvote=new SimpleIntegerProperty(upvote);
        this.emergencyLvl=new SimpleIntegerProperty(emergency);
    }

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public String getAuthor() {
        return author.get();
    }

    public StringProperty authorProperty() {
        return author;
    }

    public String getAssignee() {
        return assignee.get();
    }

    public StringProperty assigneeProperty() {
        return assignee;
    }

    public String getCategory() {
        return category.get();
    }

    public StringProperty categoryProperty() {
        return category;
    }

    public String getDate() {
        return date.get();
    }

    public StringProperty dateProperty() {
        return date;
    }

    public String getLocation() {
        return location.get();
    }

    public StringProperty locationProperty() {
        return location;
    }

    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public int getUpvote() {
        return upvote.get();
    }

    public IntegerProperty upvoteProperty() {
        return upvote;
    }

    public int getEmergencyLvl() {
        return emergencyLvl.get();
    }

    public IntegerProperty emergencyLvlProperty() {
        return emergencyLvl;
    }

    public boolean isResolved() {
        return resolved.get();
    }

    public BooleanProperty resolvedProperty() {
        return resolved;
    }

    public void setResolved(boolean resolved) {
        this.resolved.set(resolved);
    }

    public void upvoteTask(){
        this.upvoteProperty().setValue(this.upvote.getValue()+1);
    }
}
