package validators;

import exceptions.BusinessException;

public interface ValidationService {

    void validateAge(int age) throws BusinessException;
}
