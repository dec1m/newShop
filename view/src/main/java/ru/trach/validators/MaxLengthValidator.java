package ru.trach.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("ru.trach.validators.MaxLengthValidator")
public class MaxLengthValidator implements Validator {
    private final String maxLengthMessage = "Значения поля не может быть больше 100";
    private final int maxLength = 100;
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if(value.toString().trim().length() > maxLength){
            FacesMessage message = new FacesMessage(maxLengthMessage);
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
    }
}
