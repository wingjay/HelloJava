package annotation.compile;

import com.google.auto.service.AutoService;

import javax.annotation.processing.*;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

/**
 * Created by Jay on 5/3/17.
 */
@AutoService(Generator.class)
@SupportedAnnotationTypes("annotation.compile.Generator")
public class GeneratorProcessor extends AbstractProcessor {
    Messager messager;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        messager = processingEnv.getMessager();
        super.init(processingEnv);
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (TypeElement typeElement : annotations) {
            for (Element e : roundEnv.getElementsAnnotatedWith(typeElement)) {
                messager.printMessage(Diagnostic.Kind.NOTE, "printing: " + e.toString());
            }
        }
        return true;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return super.getSupportedAnnotationTypes();
    }
}
