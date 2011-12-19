package de.bruns.example.wiquery.part1;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.odlabs.wiquery.core.events.Event;
import org.odlabs.wiquery.core.events.MouseEvent;
import org.odlabs.wiquery.core.events.WiQueryEventBehavior;
import org.odlabs.wiquery.core.javascript.JsScope;
import org.odlabs.wiquery.ui.accordion.Accordion;
import org.odlabs.wiquery.ui.button.ButtonBehavior;
import org.odlabs.wiquery.ui.dialog.Dialog;

public class OsmPage extends WebPage {

	private static final long serialVersionUID = 1L;

	public OsmPage(final PageParameters parameters) {

		Accordion accordion = new Accordion("action-accordion");
		accordion.setCollapsible(true);
		accordion.setAutoHeight(false);
		add(accordion);

		// Navigation
		accordion.add(createButton("germany-button",
				"centerMap(new OpenLayers.LonLat(10.5, 51.3), 6);"));
		accordion.add(createButton("berlin-button",
				"centerMap(new OpenLayers.LonLat(13.4,52.5), 8);"));
		accordion.add(createButton("hamburg-button",
				"centerMap(new OpenLayers.LonLat(10.1, 53.5), 9);"));
		accordion.add(createButton("muenchen-button",
				"centerMap(new OpenLayers.LonLat(11.6, 48.1), 9);"));
		accordion.add(createButton("sylt-button",
				"centerMap(new OpenLayers.LonLat(8.3, 54.9), 9);"));

		// Switch Layer
		accordion.add(createButton("toggleAkwImageLayer-button", "toggleAkwImageLayer();"));
		accordion.add(createButton("toggleAkwDistanceLayer-button", "toggleAkwDistanceLayer();"));
		
		// Credits Dialog
		final Dialog creditsDialog = new Dialog("credits-dialog");
		creditsDialog.setTitle("Danke");
		creditsDialog.setWidth(550);
		accordion.add(creditsDialog);

		Button showCreditsButton = new Button("showCredits-button");
		showCreditsButton.add(new ButtonBehavior());
		showCreditsButton.add(new WiQueryEventBehavior(
				new Event(MouseEvent.CLICK) {
					private static final long serialVersionUID = 1L;

					@Override
					public JsScope callback() {
						return JsScope.quickScope(creditsDialog.open().render());
					}
				}));
		accordion.add(showCreditsButton);

		// About Dialog
		final Dialog aboutDialog = new Dialog("about-dialog");
		aboutDialog.setTitle("Example WiQuery Part1");
		aboutDialog.setWidth(300);
		accordion.add(aboutDialog);
		
		Button showAboutButton = new Button("showAbout-button");
 		showAboutButton.add(new ButtonBehavior());
		showAboutButton.add(new WiQueryEventBehavior(
				new Event(MouseEvent.CLICK) {
					private static final long serialVersionUID = 1L;
					
					@Override
					public JsScope callback() {
						return JsScope.quickScope(aboutDialog.open().render());
					}
				}));
		accordion.add(showAboutButton);
	}

	private AbstractLink createButton(final String wicketId,
			final String executeJavascript) {
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
