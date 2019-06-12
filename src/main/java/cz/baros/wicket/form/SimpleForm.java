package cz.baros.wicket.form;

import cz.baros.wicket.model.TodoModel;
import cz.baros.wicket.page.simpleFormExample.SimpleFormPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.validation.validator.StringValidator;

public class SimpleForm extends Form<TodoModel> {

	public SimpleForm(String id) {
		super(id, new CompoundPropertyModel<TodoModel>(new TodoModel()));


		add(new TextField<String>("name").setRequired(true).setLabel(
				new Model<String>("Name")).add(new StringValidator(3,8)));

		add(new TextArea<String>("description").setLabel(
				new Model<String>("Description")));

		add(new Button("saveButton"));

		add(new Button("resetButton")
		{
			@Override
			public void onSubmit()
			{
				// just set a new instance of the page
				setResponsePage(SimpleFormPage.class);
			}
		}.setDefaultFormProcessing(false));

	}

	@Override
	protected void onSubmit() {
		super.onSubmit();

		// Form validation successful. Display message showing edited model.
		info("Saved model " + getDefaultModelObject());
	}
}
