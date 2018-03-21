package ru.trach.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("ru.trach.validators.MinLengthValidator")
public class MinLengthValidator implements Validator {
    private final String minLengthMessage = "Значения поля не может быть меньше 5";
    private final int minLength = 5;
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if(value.toString().trim().length() < minLength){
            FacesMessage message = new FacesMessage(minLengthMessage);
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
    }
}
