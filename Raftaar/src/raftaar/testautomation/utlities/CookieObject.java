package raftaar.testautomation.utlities;

/**
 * This class will encapsulate the jsession id and path set in the server's response cookie
 * 
 * @author anil.kumar1@hcentive.com
 */
public class CookieObject
{
	private String jSessionId;
	private String path;

	public CookieObject(String jSessionId, String path)
	{
		this.jSessionId = jSessionId;
		this.path = path;
	}

	public String getjSessionId()
	{
		return jSessionId;
	}

	public void setjSessionId(String jSessionId)
	{
		this.jSessionId = jSessionId;
	}

	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}

}
