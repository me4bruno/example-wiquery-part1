package de.bruns.example.wiquery.part1;

import org.apache.wicket.protocol.http.WebApplication;


/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 * 
 * @see de.bruns.example.wiquery.part1.Start#main(String[])
 */
public class WicketApplication extends WebApplication
{    	
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<OsmPage> getHomePage()
	{
		return OsmPage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{
		super.init();

		// add your configuration here
	}
}
