package test.java.pages;

import static org.assertj.core.api.Assertions.assertThat;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;

@PageUrl("https://duckduckgo.com")
@SuppressWarnings("rawtypes")
public class DuckDuckGoHomePage extends FluentPage {
    
    @Override
    public void isAt() {
        assertThat(window().title()).isEqualTo("DuckDuckGo");
    }
    
    public void submitSearch(String searchTerm) {
        $("#search_form_input_homepage").fill().with(searchTerm);
        $("#search_button_homepage").submit();
    }
}
