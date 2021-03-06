package example.spring.template;

public interface TemplateViewFactory {

    TemplateView create(String templateName);

    TemplateView create(String groupName, String templateName);
}
