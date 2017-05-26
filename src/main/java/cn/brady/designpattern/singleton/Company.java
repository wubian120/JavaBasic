package cn.brady.designpattern.singleton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brady on 2017/5/23.
 */
public class Company {

    private List<Staff> staff = new ArrayList<Staff>();

    public void addStaff(Staff person){

        staff.add(person);
    }

    public void showStaffs(){

        for(Staff sta : staff){

            sta.work();
            System.out.println(sta.toString());

        }

    }


}
