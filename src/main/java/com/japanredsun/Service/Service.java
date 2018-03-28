package com.japanredsun.Service;

import com.japanredsun.Model.Status;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Service {
    public  ObservableList<Status> getStatus(){
        Status active = new Status(1,"Active");
        Status inactive = new Status(0,"Inactive");
        return FXCollections.observableArrayList(active,inactive);
    }
    public ObservableList<String> getTypes(){
        String type1 = "Listening - Part 1";
        String type2 = "Listening - Part 2";
        String type3 = "Listening - Part 3";
        String type4 = "Listening - Part 4";
        String type5 = "Reading - Part 5";
        String type6 = "Reading - Part 6";
        String type7 = "Reading - Part 7";
        return FXCollections.observableArrayList(type1,type2,type3,type4,type5,type6,type7);
    }
}
