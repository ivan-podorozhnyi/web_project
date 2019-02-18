package validators;

import exceptions.BusinessException;

public interface ValidationService {

    void validateAge(int age) throws BusinessException;
    void validatePhone(String phone) throws BusinessException;
    void validateEmail(String email) throws BusinessException;

}
