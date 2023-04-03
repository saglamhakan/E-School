package education.ESchool.result;

import java.util.Optional;

public class SuccessDataResult<T> extends DataResult<T>{
    public SuccessDataResult(T data, boolean success, String message) {
        super(data, true, message);
    }

    public SuccessDataResult(T data, boolean success) {
        super(data, true);
    }

    public SuccessDataResult(boolean success, String message) {
        super(true, message);
    }


}
