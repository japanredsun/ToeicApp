package com.japanredsun.Service.Implement;

import com.japanredsun.Model.Badge;
import com.japanredsun.Model.Status;
import com.japanredsun.Service.Service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ServiceImp  implements Service {

    private ObservableList<Status> statuses;

    private ObservableList<String> types;

    private List<Badge> badges;

    public ServiceImp() {
        badges = createBadges();
        statuses = createStatus();
        types = createType();
    }


    public ObservableList<Status> getStatuses() {
        return statuses;
    }

    public ObservableList<String> getTypes() {
        return types;
    }

    @Override
    public Badge evaluate(int point) {
        Badge badge = null;
        if(point == 0 || point < 25){
            badge = badges.get(0);
        }else if(point == 25 || point < 50){
            badge = badges.get(1);
        }else if(point == 50 || point < 100){
            badge = badges.get(2);
        }else if(point > 100){
            badge = badges.get(3);
        }
        return badge;
    }

    public Double calculatePb(Badge badge, Integer myPoint){
        double pb = 0;
        Badge nextBadge = null;
        for(int i = 0; i < badges.size(); i++){
            nextBadge = badges.get(i);
            if(badge.equals(nextBadge)){
                nextBadge = badges.get(i+1);
                break;
            }else if(badge.equals(badges.get(badges.size() - 1))){
                break;
            }
        }
        if(nextBadge != null && myPoint > 0){
            pb = (double) myPoint / nextBadge.getPoint();
        }
        return pb;
    }

    private List<Badge> createBadges(){
        List<Badge> list = new ArrayList<>();
        Badge badge1 = new Badge("Noob",0,"");
        Badge badge2 = new Badge("Beginner",25,"");
        Badge badge3 = new Badge("Intermediate",50,"");
        Badge badge4 = new Badge("Advanced",100,"");
        Collections.addAll(list,badge1,badge2,badge3,badge4);
        Collections.sort(list);
        return list;
    }

    private   ObservableList<Status> createStatus(){
        Status active = new Status(1,"Active");
        Status inactive = new Status(0,"Inactive");
        return FXCollections.observableArrayList(active,inactive);
    }
    private ObservableList<String> createType(){
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
