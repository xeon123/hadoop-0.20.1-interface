package org.apache.hadoop.mapred.comm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class JSONUtils  {
	public static JSONObject jsonfy(String jobid, Map<String, List<String>> digests, boolean isMap) {
		JSONObject obj=new JSONObject();

		obj.put("jobid",jobid);
		obj.put("isMap", "" + isMap);
		obj.putAll(digests);

		return obj;
	}

	public static String jsonfyFailedTasks(String jobid, String taskid, boolean isMap) {
		JSONObject obj=new JSONObject();

		if(isMap) {
			// get failed map tasks
			obj.put("jobid",jobid);
			obj.put("taskid", "" + taskid);
			obj.put("isMap", "" + isMap);
		} else {
			// nothing
		}

		return obj.toJSONString();
	}

	public static List<String> getActiveClusters(String json) {
		Object obj=JSONValue.parse(json);
		JSONArray array=(JSONArray)obj;

		System.out.println(array.get(0));
		return new ArrayList<String>();
	}


}
