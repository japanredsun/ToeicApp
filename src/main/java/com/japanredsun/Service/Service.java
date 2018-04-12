package com.japanredsun.Service;

import com.japanredsun.Model.Badge;
import com.japanredsun.Model.Status;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public interface Service {
     ObservableList<Status> getStatuses();

     ObservableList<String> getTypes();

     Badge evaluate(int point);

     Double calculatePb(Badge badge, Integer Point);
}
