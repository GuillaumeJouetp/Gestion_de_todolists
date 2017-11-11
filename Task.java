package Seance2;

public class Task
{
    private String Name;
    private String Description;
    private String Deadline;

    public Task(String name, String description, String deadline)
    {
        Name = name;
        Description = description;
        Deadline = deadline;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDeadline() {
        return Deadline;
    }

    public void setDeadline(String deadline) {
        Deadline = deadline;
    }
}
