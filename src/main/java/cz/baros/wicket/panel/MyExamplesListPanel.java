package cz.baros.wicket.panel;

import cz.baros.wicket.page.ajax.AjaxExamplePage;
import cz.baros.wicket.page.linkExample.LinkExamplePage;
import cz.baros.wicket.page.simpleFormExample.SimpleFormPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;

public class MyExamplesListPanel extends Panel {
	public MyExamplesListPanel(String id) {
		super(id);

		/*
		add(new Link("simpleFormPageLink")

			@Override
			public void onClick()

				setResponsePage(new SimpleFormPage())

		)*/

		add(new BookmarkablePageLink<Void>("linkPageLink", LinkExamplePage.class));
		add(new BookmarkablePageLink<Void>("simpleFormPageLinkBookMarkable", SimpleFormPage.class));

		add(new BookmarkablePageLink<Void>("ajaxFormLink", AjaxExamplePage.class));

	}
}
