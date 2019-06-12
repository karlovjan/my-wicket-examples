package cz.baros.wicket;

import cz.baros.wicket.panel.MyExamplesListPanel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		super(parameters);

//		setStatelessHint(true)

		add(new Label("version", getApplication().getFrameworkSettings().getVersion()));

		// Add your page's components here

		add(new MyExamplesListPanel("my-examples-list-panel"));
    }
}


//TODO import to the my public git and open it in eclipse che in cloud