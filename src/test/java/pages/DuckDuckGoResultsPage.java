package test.java.pages;

import static org.assertj.core.api.Assertions.assertThat;

import org.fluentlenium.core.FluentPage;

@SuppressWarnings("rawtypes")
public class DuckDuckGoResultsPage extends FluentPage {
    
    @Override
    public void isAt() {
        assertThat(window().title().matches(".*at DuckDuckGo"));
    }
}
