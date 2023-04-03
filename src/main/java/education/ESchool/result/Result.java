package education.ESchool.result;

public class Result {

    public boolean success;

    public String message;

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
    public Result(boolean success) {
        this.success = success;
    }
    public boolean isSuccess(){
        return this.success=success;
    }

   public String getMessage(String message){
      return this.message=message;
   }

}
