package de.bruns.example.wiquery.part1;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;


/**
 * Simple test using the WicketTester
 */
public class OsmPageTest
{
	private WicketTester tester;

	@Before
	public void setUp()
	{
		tester = new WicketTester(new WicketApplication());
	}

	@Test
	public void homepageRendersSuccessfully()
	{
		//start and render the test page
		tester.startPage(OsmPage.class);

		//assert rendered page class
		tester.assertRenderedPage(OsmPage.class);
	}
}
