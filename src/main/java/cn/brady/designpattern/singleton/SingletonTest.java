package cn.brady.designpattern.singleton;

/**
 * Created by Brady on 2017/5/23.
 */
public class SingletonTest {

    public static void main(String[] args){

        Company company = new Company();

        Staff ceo   = CEO.getCEO();
        Staff ceo1  = CEO.getCEO();

        company.addStaff(ceo);
        company.addStaff(ceo1);

        Staff vp   = new VP();
        Staff vp1   = new VP();

        Staff staff1 = new Staff();
        Staff staff2 = new Staff();

        company.addStaff(vp);
        company.addStaff(vp1);
        company.addStaff(staff1);
        company.addStaff(staff2);


        company.showStaffs();


    }

}
