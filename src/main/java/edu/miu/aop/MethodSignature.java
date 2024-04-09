package edu.miu.aop;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Data
@RequiredArgsConstructor
public class MethodSignature {
    private String methodName;
    private String returnType;
    private String[] parameterTypes;

    private final Method method;

//    public MethodSignature(String methodName, String returnType, String[] parameterTypes) {
//        this.methodName = methodName;
//        this.returnType = returnType;
//        this.parameterTypes = parameterTypes;
//    }
    public void populateMethodObject(){
        method.addMethod(methodName, returnType, parameterTypes);
    }

    public Method getMethod() {
       this.populateMethodObject();
        return method;
    }
}
