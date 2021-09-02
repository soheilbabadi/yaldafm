package cloud.yalda.www.yaldaIdentity.helper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ApiResultImp implements ApiResult {
    private Object data = null;
    private long totalCount = 1;
    private long currentCount = 1;
    private String message = "done successful!";
    private String errorMessage = "";
    private HttpStatus httpStatus = HttpStatus.OK;
    private boolean isSuccess=true;

    @Override
    public ApiResultImp saved() {
        this.data = null;
        this.totalCount = 1;
        this.currentCount = 1;
        this.message = "done successful!";
        this.errorMessage = "";
        this.httpStatus = HttpStatus.ACCEPTED;
        this.isSuccess=true;
        return this;
    }

    @Override
    public ApiResultImp fatalError(Exception ex) {
        this.data = null;
        this.totalCount = 0;
        this.currentCount = 0;
        this.message = "an error occurred";
        this.errorMessage = ex.getMessage();
        this.httpStatus = HttpStatus.EXPECTATION_FAILED;
        this.isSuccess=false;
        return this;
    }

    @Override
    public ApiResultImp notFound() {
        this.data = null;
        this.totalCount = 0;
        this.currentCount = 0;
        this.message = "an error occurred";
        this.errorMessage = "Item not found";
        this.httpStatus = HttpStatus.NOT_FOUND;
        this.isSuccess=false;
        return this;
    }
}
