package education.ESchool.dtos.requests;

import lombok.Data;

@Data
public class UpdateLessonRequest {

    private int lessonId;
    private String lessonName;


}
