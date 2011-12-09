package de.bruns.example.wiquery.part1;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.odlabs.wiquery.ui.button.ButtonBehavior;

public class OsmPage extends WebPage {

	private static final long serialVersionUID = 1L;

	public OsmPage(final PageParameters parameters) {
		add(createButton("germany-button", "centerMap(new OpenLayers.LonLat(10.5, 51.3), 6);"));
		add(createButton("berlin-button", "centerMap(new OpenLayers.LonLat(13.4,52.5), 9);"));
		add(createButton("hamburg-button", "centerMap(new OpenLayers.LonLat(10.1, 53.5), 10);"));
		add(createButton("muenchen-button", "centerMap(new OpenLayers.LonLat(11.6, 48.1), 10);"));
		add(createButton("sylt-button", "centerMap(new OpenLayers.LonLat(8.3, 54.9), 10);"));
	}

	private AbstractLink createButton(final String wicketId, final String executeJavascript) {
		AjaxLink<Void> link = new AjaxLink<Void>(wicketId) {
			private static final long serialVersionUID = 2377762373425585478L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				target.appendJavaScript(executeJavascript);
			}
		};
		link.add(new ButtonBehavior());
		return link;
	}
}
