package baseFunc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class Helpers {
    private BaseFunc baseFunc;
    private final By FILTERS = By.xpath(".//div[@class='spodb-page-content__aside']/div/fieldset");

    public Helpers(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void selectFilters(List<String> filterNames) {
        List<WebElement> filters = baseFunc.getAllElements(FILTERS);

        for (int i = 0; i < filters.size(); i++) {
            for (int j = 0; j < filterNames.size(); i++) {
                if (filters.get(i).getText().contains(filterNames.get(j))) {
                    filters.get(i).click();
                    break;
                }
            }
        }
    }
}

