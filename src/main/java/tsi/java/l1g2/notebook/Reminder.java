package tsi.java.l1g2.notebook;

import asg.cliche.Command;
import asg.cliche.Param;

public class Reminder extends Note implements Expirable {
    private String time;

    @Command
    public String getTime() {
        return time;
    }

    @Command
    public void setTime(@Param(name = "time") String time) {
        this.time = time;
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

