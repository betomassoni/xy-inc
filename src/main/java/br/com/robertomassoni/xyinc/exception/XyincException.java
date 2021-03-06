package br.com.robertomassoni.xyinc.exception;

import br.com.robertomassoni.xyinc.enumerator.EntityType;
import br.com.robertomassoni.xyinc.enumerator.ExceptionType;


public class XyincException {

    public static RuntimeException throwException(EntityType entityType, ExceptionType exceptionType, String arg) {
        String message = entityType.getValue() + " " + exceptionType.getValue() + " " + arg;
        if (ExceptionType.ENTITY_NOT_FOUND.equals(exceptionType)) {
            return new EntityNotFoundException(message);
        } else if (ExceptionType.ENTITY_EXCEPTION.equals(exceptionType)) {
            return new EntityException(message);
        }
         return new RuntimeException(entityType.getValue() + " " + exceptionType.getValue() + " " + arg);
    }
    
    
    public static class EntityNotFoundException extends RuntimeException {
        public EntityNotFoundException(String message) {
            super(message);
        }
    }

    public static class EntityException extends RuntimeException {
        public EntityException(String message) {
            super(message);
        }
    }
}


