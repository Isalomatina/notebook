package tsi.java.l1g2.notebook;

import asg.cliche.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Notebook implements ShellDependent {
    private final List<Record> records = new ArrayList<>();
    private Shell parentShell; // need for cliche to allow subshells

    @Command
    public void createPerson(@Param(name = "first name") String firstName,
                             @Param(name = "last name") String lastName,
                             @Param(name = "email") String email,
                             @Param(name = "phones") String... phones) {
        Person r = new Person();
        r.setFirstName(firstName);
        r.setLastName(lastName);
        r.addPhones(phones);
        r.setEmail(email);
        records.add(r);
    }

    @Command
    public void createNote(@Param(name = "text") String text) {
        Note n = new Note();
        n.setText(text);
        records.add(n);
    }

    @Command
    public void createReminder(@Param(name = "text") String text,
                               @Param(name = "time") String time) {
        Reminder r = new Reminder();
        r.setText(text);
        r.setTime(time);
        records.add(r);
    }

    @Command
    public void remove(@Param(name = "id") int id) {
        for (int i = 0; i < records.size(); i++) {
            Record r = records.get(i);
            if (r.getId() == id) {
                records.remove(i);
                break;
            }
        }
    }

    @Command
    public void edit(@Param(name = "id") int id) throws IOException {
        for (int i = 0; i < records.size(); i++) {
            Record r = records.get(i);
            if (r.getId() == id) {
                Shell shell = ShellFactory.createSubshell("#" + id, parentShell,
                        "editing\n\t" + r.toString() + "\ntype 'exit' to return to main menu", r);
                shell.commandLoop();
                break;
            }
        }
    }

    @Command
    public List<Record> list() {
        return records;
    }


    // need for cliche to allow subshells
    @Override
    public void cliSetShell(Shell theShell) {
        this.parentShell = theShell;
    }
}
