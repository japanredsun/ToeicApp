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
}
