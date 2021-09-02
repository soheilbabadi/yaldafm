package cloud.yalda.www.yaldaIdentity.CustomeExceptions;

import java.io.Serial;

public class UserException extends Exception{
    @Serial
    private static final long serialVersionUID = 5158038740488561520L;

    public UserException(String errorMessage) {
        super(errorMessage);
    }
}
