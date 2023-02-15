package config;


import dagger.BindsInstance;
import dagger.Component;
import elements.Button;
import elements.Element;
import elements.Input;
import org.openqa.selenium.By;


@Component(modules = DriverContainer.class)
public interface ElementComponent {

    Button button();

    Input input();

    Element element();

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder locator(By locator);

        ElementComponent build();
    }
}
