package com.example.ap;

import org.mapstruct.ap.spi.DefaultAccessorNamingStrategy;

import javax.lang.model.element.ExecutableElement;
import java.util.regex.Pattern;


public class AdderSupportNamingStrategy extends DefaultAccessorNamingStrategy {
    private static final Pattern JAVA_JAVAX_PACKAGE = Pattern.compile( "^javax?\\..*" );

    @Override
    protected boolean isBuilderSetter(final ExecutableElement method) {
        return method.getParameters().size() == 1
                && ! JAVA_JAVAX_PACKAGE.matcher(method.getEnclosingElement().asType().toString()).matches()
                && ! this.isAdderMethod(method)
                //TODO The Types need to be compared with Types#isSameType(TypeMirror, TypeMirror)
                &&  method.getReturnType().toString().equals(method.getEnclosingElement().asType().toString());
    }
}