package education.ESchool.result;

public class ErrorResult extends Result{
    public ErrorResult(boolean success, String message) {
        super(false, message);
    }

    public ErrorResult(boolean success) {
        super(false);
    }

    public ErrorResult(){
        super(false);
    }
}
