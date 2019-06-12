package cz.baros.wicket.page.simpleFormExample;

import cz.baros.wicket.form.SimpleForm;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.panel.FeedbackPanel;

public class SimpleFormPage extends WebPage {

	public SimpleFormPage(){


		add(new SimpleForm("inputForm"));

		// Construct form and feedback panel and hook them up
		final FeedbackPanel feedback = new FeedbackPanel("feedback");
		add(feedback);
	}
}
