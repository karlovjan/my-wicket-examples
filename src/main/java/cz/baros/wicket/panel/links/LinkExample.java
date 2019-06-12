package cz.baros.wicket.panel.links;

import cz.baros.wicket.page.simpleFormExample.SimpleFormPage;
import org.apache.wicket.Session;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.link.StatelessLink;
import org.apache.wicket.markup.html.panel.Panel;

public class LinkExample extends Panel {

	public LinkExample(String id) {
		super(id);


		add(new Link("simpleFormPageLink")
		{
			@Override
			public void onClick()
			{
				setResponsePage(new SimpleFormPage());
			}
		});

		// a normal bookmarkable link (which is stateless by default)
		add(new BookmarkablePageLink<Void>("simpleFormPageLinkBookMarkable", SimpleFormPage.class));

		add(new StatelessLink<Void>("statelessLink")
		{
			@Override
			public void onClick()
			{
				setResponsePage(SimpleFormPage.class);
			}

		});

		add(new StatelessLink<Void>("invalidatesession")
		{
			@Override
			public void onClick()
			{
				Session.get().invalidate();
				setResponsePage(SimpleFormPage.class);
			}

		});
	}
}
