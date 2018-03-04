package fr.polytech.ihm.Model;

import javafx.beans.property.*;

public class Task {
    private int id;
    private StringProperty title;
    private StringProperty author;
    private StringProperty assignee;
    private StringProperty category;
    private StringProperty date; //TODO : date type en javaFX
    private StringProperty location;
    private StringProperty description;
    private IntegerProperty upvote;
    private IntegerProperty emergencyLvl; //1(easy) to 3(important)
    private IntegerProperty resolvedLvl = new SimpleIntegerProperty(1); //1: To do, 2: In progress, 3: Done
    private boolean disabled = false;

    public Task(int id, String title, String author, String assignee, String category, String date, String location, String description, int upvote, int emergency) {
        this.id = id;
        this.title = new SimpleStringProperty(title);
        this.author = new SimpleStringProperty(author);
        this.assignee = new SimpleStringProperty(assignee);
        this.category = new SimpleStringProperty(category);
        this.date = new SimpleStringProperty(date);
        this.location = new SimpleStringProperty(location);
        this.description = new SimpleStringProperty(description);
        this.upvote = new SimpleIntegerProperty(upvote);
        this.emergencyLvl = new SimpleIntegerProperty(emergency);
    }

    public Task(int id, String title, String author, String assignee, String category, String date, String location, String description, int upvote, int emergency, int resolvedLvl) {
        this.id = id;
        this.title = new SimpleStringProperty(title);
        this.author = new SimpleStringProperty(author);
        this.assignee = new SimpleStringProperty(assignee);
        this.category = new SimpleStringProperty(category);
        this.date = new SimpleStringProperty(date);
        this.location = new SimpleStringProperty(location);
        this.description = new SimpleStringProperty(description);
        this.upvote = new SimpleIntegerProperty(upvote);
        this.emergencyLvl = new SimpleIntegerProperty(emergency);
        if (resolvedLvl < 4 && resolvedLvl >= 0)
            this.resolvedLvl = new SimpleIntegerProperty(resolvedLvl);
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

    public int getResolvedLvl() {
        return resolvedLvl.get();
    }

    public IntegerProperty emergencyLvlProperty() {
        return emergencyLvl;
    }

    public boolean isToDo() {
        return (resolvedLvl.get() == 1);
    }

    public boolean isInProgress() {
        return (resolvedLvl.get() == 2);
    }

    public boolean isResolved() {
        return (resolvedLvl.get() == 3);
    }

    public IntegerProperty resolvedProperty() {
        return resolvedLvl;
    }

    public void setResolved(int resolved) {
        if (this.resolvedLvl.get() <= 3) {
            this.resolvedLvl.set(resolved);
        } else {
            this.disabled = true;
        }
    }

    public void incrementResolved() {
        if ((this.resolvedLvl.get() + 1) <= 3) {
            this.resolvedLvl.set(this.resolvedLvl.get() + 1);
        } else {
            this.disabled = true;
        }
    }

    public void decrementResolved() {
        if ((this.resolvedLvl.get()) > 1) {
            this.resolvedLvl.set(this.resolvedLvl.get() - 1);
        }
    }

    public void upvoteTask() {
        this.upvoteProperty().setValue(this.upvote.getValue() + 1);
    }

    public void downvoteTask() {
        if (this.upvote.get() > 0) {
            this.upvoteProperty().setValue(this.upvote.getValue() - 1);
        }
    }

    public void deleteTask() {
        this.disabled = true;
    }

    public int getId() {
        return id;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setNewDescription(String newDescription) {
        this.description = new SimpleStringProperty(newDescription);
    }

    public void reassign(String who) {
        this.assignee = new SimpleStringProperty(who);
    }
}
