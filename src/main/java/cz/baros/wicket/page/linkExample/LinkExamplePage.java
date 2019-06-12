package cz.baros.wicket.page.linkExample;

import cz.baros.wicket.panel.links.LinkExample;
import org.apache.wicket.markup.html.WebPage;

public class LinkExamplePage extends WebPage {

	public LinkExamplePage() {

		setStatelessHint(true);

		add(new LinkExample("my-link-example-panel"));
	}
}
