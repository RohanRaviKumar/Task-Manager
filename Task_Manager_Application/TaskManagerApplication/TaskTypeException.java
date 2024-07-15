package TaskManagerApplication;

public class TaskTypeException extends Exception {
    public String msg;

    public TaskTypeException(String m) {
        super(m);
        this.msg = m;
    }
}
