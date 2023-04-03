package education.ESchool.result;

public class ErrorDataResult<T> extends DataResult<T>{
    public ErrorDataResult(T data, boolean success, String message) {
        super(data, false, message);
    }

    public ErrorDataResult(T data, boolean success) {
        super(data, false);
    }

    public ErrorDataResult(boolean success, String message) {
        super(false, message);
    }


}
