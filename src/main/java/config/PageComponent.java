package config;


import dagger.Component;
import pages.amazon.AmazonHome;
import pages.amazon.AmazonResults;


@Component(modules = DriverContainer.class)
public interface PageComponent {
    AmazonHome buildAmazonHome();

    AmazonResults buildAmazonResults();


}
