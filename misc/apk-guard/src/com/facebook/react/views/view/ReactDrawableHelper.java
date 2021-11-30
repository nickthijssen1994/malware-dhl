package com.facebook.react.views.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.util.TypedValue;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.SoftAssertions;

public class ReactDrawableHelper
{
  private static final TypedValue sResolveOutValue = new TypedValue();
  
  public ReactDrawableHelper() {}
  
  public static Drawable createDrawableFromJSDescription(Context paramContext, ReadableMap paramReadableMap)
  {
    String str = paramReadableMap.getString("type");
    int i;
    if ("ThemeAttrAndroid".equals(str))
    {
      paramReadableMap = paramReadableMap.getString("attribute");
      SoftAssertions.assertNotNull(paramReadableMap);
      i = paramContext.getResources().getIdentifier(paramReadableMap, "attr", "android");
      if (i != 0)
      {
        if (paramContext.getTheme().resolveAttribute(i, sResolveOutValue, true))
        {
          if (Build.VERSION.SDK_INT >= 21) {
            return paramContext.getResources().getDrawable(sResolveOutValueresourceId, paramContext.getTheme());
          }
          return paramContext.getResources().getDrawable(sResolveOutValueresourceId);
        }
        paramContext = new StringBuilder();
        paramContext.append("Attribute ");
        paramContext.append(paramReadableMap);
        paramContext.append(" couldn't be resolved into a drawable");
        throw new JSApplicationIllegalArgumentException(paramContext.toString());
      }
      paramContext = new StringBuilder();
      paramContext.append("Attribute ");
      paramContext.append(paramReadableMap);
      paramContext.append(" couldn't be found in the resource list");
      throw new JSApplicationIllegalArgumentException(paramContext.toString());
    }
    if ("RippleAndroid".equals(str))
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        if ((paramReadableMap.hasKey("color")) && (!paramReadableMap.isNull("color")))
        {
          i = paramReadableMap.getInt("color");
        }
        else
        {
          if (!paramContext.getTheme().resolveAttribute(16843820, sResolveOutValue, true)) {
            break label349;
          }
          i = paramContext.getResources().getColor(sResolveOutValueresourceId);
        }
        if ((paramReadableMap.hasKey("borderless")) && (!paramReadableMap.isNull("borderless")) && (paramReadableMap.getBoolean("borderless"))) {
          paramContext = null;
        } else {
          paramContext = new ColorDrawable(-1);
        }
        return new RippleDrawable(new ColorStateList(new int[][] { new int[0] }, new int[] { i }), null, paramContext);
        label349:
        throw new JSApplicationIllegalArgumentException("Attribute colorControlHighlight couldn't be resolved into a drawable");
      }
      throw new JSApplicationIllegalArgumentException("Ripple drawable is not available on android API <21");
    }
    paramContext = new StringBuilder();
    paramContext.append("Invalid type for android drawable: ");
    paramContext.append(str);
    throw new JSApplicationIllegalArgumentException(paramContext.toString());
  }
}
