package com.facebook.react.uimanager;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.bridge.UiThreadUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ViewHierarchyDumper
{
  public ViewHierarchyDumper() {}
  
  public static JSONObject toJSON(View paramView)
    throws JSONException
  {
    UiThreadUtil.assertOnUiThread();
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("n", paramView.getClass().getName());
    localJSONObject.put("i", System.identityHashCode(paramView));
    Object localObject = paramView.getTag();
    if ((localObject != null) && ((localObject instanceof String))) {
      localJSONObject.put("t", localObject);
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      if (paramView.getChildCount() > 0)
      {
        localObject = new JSONArray();
        int i = 0;
        while (i < paramView.getChildCount())
        {
          ((JSONArray)localObject).put(i, toJSON(paramView.getChildAt(i)));
          i += 1;
        }
        localJSONObject.put("c", localObject);
      }
    }
    return localJSONObject;
  }
}
