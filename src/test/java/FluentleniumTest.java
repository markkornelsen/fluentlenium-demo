package test.java;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.TimeUnit;

import org.fluentlenium.adapter.junit.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Test;

import test.java.pages.DuckDuckGoHomePage;
import test.java.pages.DuckDuckGoResultsPage;

public class FluentleniumTest extends FluentTest {

    @Page
    private DuckDuckGoHomePage homePage;
    @Page
    private DuckDuckGoResultsPage resultsPage;

    @Test
    public void titleOfDuckDuckGoShouldContainSearchQueryName() {
        this.setRemoteUrl("http://localhost:9515");
        goTo("https://duckduckgo.com");
        $("#search_form_input_homepage").fill().with("FluentLenium");
        $("#search_button_homepage").submit();
        await().atMost(2, TimeUnit.SECONDS).until(el("#search_form_homepage")).not().present();
        assertThat(window().title().contains("Fluentlenium"));
    }

    @Test
    public void searchWithPageObjectTest() {
        goTo(homePage);
        homePage.isAt();
        homePage.submitSearch("howdy");
        resultsPage.isAt();
    }
}