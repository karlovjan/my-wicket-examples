package cz.baros.wicket.page.ajax;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormSubmitBehavior;
import org.apache.wicket.extensions.ajax.markup.html.autocomplete.AutoCompleteTextField;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.MultiLineLabel;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.util.string.Strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class AjaxExamplePage extends WebPage {

	private StringBuilder values = new StringBuilder();



	//AjaxFormValidatingBehavior.addToAllFormComponents(form, "keydown", Duration.ONE_SECOND)

	public AjaxExamplePage() {

		Form<Void> form = new Form<Void>("form");
		add(form);






		final IModel<String> model = new IModel<String>()
		{
			private String value = null;

			@Override
			public String getObject()
			{
				return value;
			}

			@Override
			public void setObject(String object)
			{
				value = object;

				values.append("\n");
				values.append(value);
			}

			@Override
			public void detach()
			{
				//i dont want to detach
			}
		};

		final AutoCompleteTextField<String> field = new AutoCompleteTextField<String>("ac", model)
		{
			@Override
			protected Iterator<String> getChoices(String input)
			{
				if (Strings.isEmpty(input))
				{
					List<String> emptyList = Collections.emptyList();
					return emptyList.iterator();
				}

				List<String> choices = new ArrayList<String>(10);

				Locale[] locales = Locale.getAvailableLocales();

				for (final Locale locale : locales)
				{
					final String country = locale.getDisplayCountry();

					if (country.toUpperCase().startsWith(input.toUpperCase()))
					{
						choices.add(country);
						if (choices.size() == 10)
						{
							break;
						}
					}
				}

				return choices.iterator();
			}
		};
		form.add(field);

		final MultiLineLabel label = new MultiLineLabel("history", new PropertyModel<String>(this,
				"values"));
		label.setOutputMarkupId(true);
		form.add(label);

		field.add(new AjaxFormSubmitBehavior(form, "change")
		{
			@Override
			protected void onSubmit(AjaxRequestTarget target)
			{
				target.add(label);
			}

			@Override
			protected void onError(AjaxRequestTarget target)
			{
				//error doesnt happen
			}
		});



	}
}
