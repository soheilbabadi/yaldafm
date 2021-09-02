package cloud.yalda.www.yaldaIdentity.controller;

import com.yaldafm.www.identity.CustomeExceptions.UserException;
import com.yaldafm.www.identity.dto.AuthenticateDto;
import com.yaldafm.www.identity.dto.ProfileUpdateDto;
import com.yaldafm.www.identity.dto.UpdatePassDto;
import com.yaldafm.www.identity.helper.ApiResult;
import com.yaldafm.www.identity.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "person",path = "/identity/person")
public class PersonController {
   @Autowired
    private final PersonService _personService;
    @Autowired
    private final ApiResult _result;

    public PersonController(PersonService personService, ApiResult result) {
        _personService = personService;
        _result = result;
    }

    @GetMapping(name = "get",path = "/{id}")
    public ApiResult get(@PathVariable String id){

        try {
            var result= _personService.getProfile(id);
            _result.setHttpStatus(HttpStatus.OK);
            _result.setData(result);

        } catch (Exception e) {
        _result.setMessage(e.getMessage());
            _result.setSuccess(false);
            _result.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
            _result.setTotalCount(0);
            _result.setCurrentCount(0);
        }
        return _result;
    }

    @PostMapping(name = "post",path = "/{email}")
    public ApiResult post(@PathVariable String email){

        try {
            var result= _personService.register(email);
            _result.setHttpStatus(HttpStatus.OK);
            _result.setData(result);

        } catch (Exception e) {
            _result.setMessage(e.getMessage());
            _result.setSuccess(false);
            _result.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
            _result.setTotalCount(0);
            _result.setCurrentCount(0);
        }
        return _result;
    }
    @PostMapping(name = "authenticate",path = "/authenticate")
    public ApiResult post(@RequestBody AuthenticateDto dto){

        try {
            var result= _personService.authenticate(dto.getEmail(),dto.getPassword());
            _result.setHttpStatus(HttpStatus.OK);
            _result.setData(result);

        } catch (Exception e) {
            _result.setMessage(e.getMessage());
            _result.setSuccess(false);
            _result.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
            _result.setTotalCount(0);
            _result.setCurrentCount(0);
        }
        return _result;
    }
    @PutMapping(name = "putPassword",path = "/put-password")
    public ApiResult putPassword(@RequestBody UpdatePassDto dto){

        try {
            var result= _personService.updatePassword(dto);
            _result.setHttpStatus(HttpStatus.OK);
            _result.setData(result);

        } catch (Exception e) {
            _result.setMessage(e.getMessage());
            _result.setSuccess(false);
            _result.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
            _result.setTotalCount(0);
            _result.setCurrentCount(0);
        }
        return _result;
    }
    @PutMapping(name = "put",path = "/")
    public ApiResult put(@RequestBody ProfileUpdateDto dto){

        try {
            var result= _personService.update(dto);
            _result.setHttpStatus(HttpStatus.OK);
            _result.setData(result);

        } catch (Exception e) {
            _result.setMessage(e.getMessage());
            _result.setSuccess(false);
            _result.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
            _result.setTotalCount(0);
            _result.setCurrentCount(0);
        }
        return _result;
    }
}
