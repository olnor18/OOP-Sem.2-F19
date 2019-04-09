/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.presentation.modules.dashboard;

import java.text.DateFormat;
import java.util.Date;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

/**
 *
 * @author Oliver
 */
public class ActivityEntry extends FlowPane{
    private final String typeOfEntry;
    private final String dateOfEntryString;
    private final String specificsOfEntry;

    public ActivityEntry(String typeOfEntry, Date dateOfEntry, String specificsOfEntry) {
        this.typeOfEntry = typeOfEntry;
        this.dateOfEntryString = dateOfEntry.getHours() + ":" 
                            + dateOfEntry.getMinutes() + ":"
                            + dateOfEntry.getSeconds() + " "
                            + dateOfEntry.getDate() + "/"
                            + dateOfEntry.getMonth() + "/"
                            + dateOfEntry.getYear()+1900;
        this.specificsOfEntry = specificsOfEntry;
        Text typeOfEntryText = new Text(typeOfEntry);
        typeOfEntryText.getStyleClass().add("-fx-font-size : 18; -fx-font-weight : bold;");
        Text specificsOfEntryText = new Text(specificsOfEntry);
        Text dateOfEntryText = new Text(dateOfEntryString);
        getChildren().addAll(typeOfEntryText, specificsOfEntryText, dateOfEntryText);
    }
    
    
    
}
