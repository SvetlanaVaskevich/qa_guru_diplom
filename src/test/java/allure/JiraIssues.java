package allure;

import java.lang.annotation.*;

    @Documented
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.METHOD, ElementType.TYPE})
    public @interface JiraIssues {

        JiraIssue[] value();
}