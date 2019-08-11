package cn.dhbin.minion.core.restful.spring.validator;

import org.springframework.util.Assert;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import javax.validation.executable.ExecutableValidator;
import javax.validation.metadata.BeanDescriptor;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * 拓展SpringValidatorAdapter以便于校验List<T>类型数据
 * {@link org.springframework.validation.beanvalidation.SpringValidatorAdapter
 *
 * @author donghaibin
 * @date 2019-08-10
 */
public class ValidatorCollectionImpl implements Validator {

    private final javax.validation.Validator targetValidator = Validation.buildDefaultValidatorFactory().getValidator();

    //---------------------------------------------------------------------
    // Implementation of JSR-303 Validator interface
    //---------------------------------------------------------------------

    @Override
    @SuppressWarnings("unchecked")
    public <T> Set<ConstraintViolation<T>> validate(T object, Class<?>... groups) {
        Assert.state(this.targetValidator != null, "No target Validator set");
        if (object instanceof Collection) {
            Set<ConstraintViolation<T>> constraintViolations = new HashSet<>();
            Collection collection = (Collection) object;
            for (Object aCollection : collection) {
                constraintViolations.addAll(this.targetValidator.validate((T) aCollection, groups));
            }
            return constraintViolations;
        }
        return this.targetValidator.validate(object, groups);
    }

    @Override
    public <T> Set<ConstraintViolation<T>> validateProperty(T object, String propertyName, Class<?>... groups) {
        Assert.state(this.targetValidator != null, "No target Validator set");
        return this.targetValidator.validateProperty(object, propertyName, groups);
    }

    @Override
    public <T> Set<ConstraintViolation<T>> validateValue(
            Class<T> beanType, String propertyName, Object value, Class<?>... groups) {
        Assert.state(this.targetValidator != null, "No target Validator set");
        return this.targetValidator.validateValue(beanType, propertyName, value, groups);
    }

    @Override
    public BeanDescriptor getConstraintsForClass(Class<?> clazz) {
        Assert.state(this.targetValidator != null, "No target Validator set");
        return this.targetValidator.getConstraintsForClass(clazz);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T unwrap(Class<T> type) {
        Assert.state(this.targetValidator != null, "No target Validator set");
        try {
            return (type != null ? this.targetValidator.unwrap(type) : (T) this.targetValidator);
        } catch (ValidationException ex) {
            // ignore if just being asked for plain Validator
            if (javax.validation.Validator.class == type) {
                return (T) this.targetValidator;
            }
            throw ex;
        }
    }

    @Override
    public ExecutableValidator forExecutables() {
        return targetValidator.forExecutables();
    }

}
