package ml.sadriev.orm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ml.sadriev.orm.command.AbstractCommand;
import ml.sadriev.orm.controller.Bootstrap;

public class App {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);
        Bootstrap bootstrap = context.getBean(Bootstrap.class);
        Map<String, AbstractCommand> classMap = context.getBeansOfType(AbstractCommand.class);
        List<AbstractCommand> commandList = new ArrayList<>(classMap.values());
        bootstrap.init(commandList);
    }
}
