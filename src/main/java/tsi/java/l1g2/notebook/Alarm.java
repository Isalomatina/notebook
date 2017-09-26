package tsi.java.l1g2.notebook;

import asg.cliche.Command;
import asg.cliche.Param;

/**
 * Created by JavaCourses on 26.09.2017..
 */
public class Alarm extends Note implements Expirable {

    private String time;

    public void setTime(@Param(name= "time")String time) {
        this.time = time;
    }
    @Command
    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Reminder{" +
                "id=" + getId() +
                ", text='" + getText() + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    @Override
    public boolean contains(String str) {
        if (super.contains(str)) {
            return true;
        }else if( time.contains(str)){
            return true;}
        return false;
    }

    @Override
    public boolean isExpired() {
        return false;
    }


}
