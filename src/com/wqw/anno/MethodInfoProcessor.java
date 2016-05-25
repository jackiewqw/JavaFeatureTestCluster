package com.wqw.anno;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

@SupportedAnnotationTypes({"com.wqw.anno.MethodInfo"})
public class MethodInfoProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> paramSet, RoundEnvironment paramRoundEnvironment) {
        HashMap<String, String> map = new HashMap<String, String>();
        for (TypeElement te : paramSet) {
            for (Element element : paramRoundEnvironment.getElementsAnnotatedWith(te)) {
                MethodInfo methodInfo = element.getAnnotation(MethodInfo.class);
                map.put(element.getEnclosingElement().toString(), methodInfo.author());
            }
        }
        
        for(Entry<String, String> entry :map.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        return false;
    }

}
